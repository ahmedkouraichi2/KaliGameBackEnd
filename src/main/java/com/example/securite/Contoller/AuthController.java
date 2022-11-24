package com.example.securite.Contoller;

import com.example.securite.Repository.ConfirmationTokenRepository;
import com.example.securite.Repository.RoleRepository;
import com.example.securite.Repository.UserRepository;
import com.example.securite.Security.Jwt.JwtUtils;
import com.example.securite.Security.Service.UserDetailsImpl;
import com.example.securite.Service.EmailSenderService;
import com.example.securite.model.*;
import com.example.securite.model.request.LoginRequest;
import com.example.securite.model.request.ResetPasswordRequest;
import com.example.securite.model.request.ResetRoleRequest;
import com.example.securite.model.request.SignupRequest;
import com.example.securite.model.response.JwtResponse;
import com.example.securite.model.response.MessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(), //username <=> email
                userDetails.getPassword(),
                roles));
    }
    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    /*    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }*/

        // Create new user's account
        User user = new User(signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        /*ERole strRole = signUpRequest.getRole();*/

       /* Role userRole = roleRepository.findByName(strRole)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
*/
        Role userRole = new Role();
        FileDB fileDB =new FileDB();
        fileDB.setUser(user);
        /*userRole.setName(strRole);*/
        userRole.setName(ERole.valueOf("ROLE_ADMIN"));
        user.setRole(userRole);
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setFileDB(fileDB);
        final var id = userRepository.save(user).getId();

        //notify admin send email?

        ConfirmationToken confirmationToken= new ConfirmationToken(user);
        confirmationTokenRepository.save(confirmationToken);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setFrom("moh.charguia@gmail.com");
        mailMessage.setText("To confirm you account, please click here : " +
                "http://localhost:8081/api/auth/confirm-account?token="+confirmationToken.getConfirmationToken());

        emailSenderService.sendEmail(mailMessage);


        return ResponseEntity.ok(new MessageResponse(id));
    }

    @PostMapping("/resetpassword")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<?> updatePassword(@Valid @RequestBody ResetPasswordRequest resetPasswordRequest) {
        if (!userRepository.existsByEmail(resetPasswordRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is not Correct!"));
        }

        final User user = userRepository.findByEmail(resetPasswordRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Error: User not Found!"));


        String encodedNewPassword = encoder.encode(resetPasswordRequest.getNewPassword());

        if (encoder.matches(resetPasswordRequest.getOldPassword(), user.getPassword())) {
            User updatedUser = new User();
            updatedUser.setId(user.getId());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPassword(encodedNewPassword);
            updatedUser.setRole(user.getRole());
            userRepository.save(updatedUser);
            return ResponseEntity.ok(new MessageResponse("Password updated successfully!"));
        } else {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Old password is not Correct!"));
        }
    }

    @PostMapping("/resetrole")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> updateRole(@Valid @RequestBody ResetRoleRequest resetRoleRequest) {
        if (!userRepository.existsByEmail(resetRoleRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is not Correct!"));
        }

        final User user = userRepository.findByEmail(resetRoleRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Error: User not Found!"));

            Role role=new Role();
            role.setName(resetRoleRequest.getNewRole());
        if (resetRoleRequest.getOldRole().name()==user.getRole().getName().name()) {
            User updatedUser = new User();
            updatedUser.setId(user.getId());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setRole(role);
            userRepository.save(updatedUser);
            return ResponseEntity.ok(new MessageResponse("Role updated successfully!"));
        } else {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Old role is not Correct!"));
        }
    }
    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<?> confirmUserAccount( @RequestParam("token")String confirmationToken) {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        User user = null;
        if (token != null) {
            user = userRepository.findByEmail(token.getUser().getEmail()).get();
            user.setEnabled(true);
            userRepository.save(user);
        }
        ;


        return ResponseEntity.ok(new MessageResponse("account Verified with email:" + token.getUser().getEmail()));
    }
}
