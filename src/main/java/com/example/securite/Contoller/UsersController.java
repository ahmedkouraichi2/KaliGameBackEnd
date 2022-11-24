package com.example.securite.Contoller;

import com.example.securite.Repository.ConfirmationTokenRepository;
import com.example.securite.Repository.RoleRepository;
import com.example.securite.Repository.UserRepository;
import com.example.securite.Security.Jwt.JwtUtils;
import com.example.securite.Service.EmailSenderService;
import com.example.securite.Service.Impl.UserServiceImp;
import com.example.securite.model.ConfirmationToken;
import com.example.securite.model.ERole;
import com.example.securite.model.Role;
import com.example.securite.model.User;
import com.example.securite.model.request.UserRequest;
import com.example.securite.model.response.MessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Random;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UsersController {
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
    private UserServiceImp userServiceImp;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

    @GetMapping("/{id}")
   
    public ResponseEntity<User> getUser(@PathVariable String id) {
        return ResponseEntity.ok(userServiceImp.getUser(id));
    }

    @GetMapping

    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userServiceImp.getAllUser());
    }

    @PostMapping("/add")
  
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRequest userRequest) {
      /*  if (userRepository.existsByEmail(userRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }*/
            String pwd=   encoder.encode(alphaNumericString(10));
        // Create new user's account
        User user = new User(userRequest.getEmail(),pwd );

        ERole strRole = userRequest.getRole();

       /* Role userRole = roleRepository.findByName(strRole)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
*/
        Role userRole = new Role();
        userRole.setName(strRole);
        userRole.setName(ERole.valueOf(strRole.toString()));
        user.setRole(userRole);
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());

        final var id = userRepository.save(user).getId();

        //notify admin send email?

        ConfirmationToken confirmationToken= new ConfirmationToken(user);
        confirmationTokenRepository.save(confirmationToken);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject(" Registration new user");
        mailMessage.setFrom("moh.charguia@gmail.com");
        mailMessage.setText("you has registered in our website \n \n  " +
                "User login: "+alphaNumericString(10)+"\n\n"+
                "User email: "+user.getEmail()+"\n\n"+
                "User role: "+user.getRole().getName()+"\n\n"/*+
                "you can:#APPROVE or #REJECT that registration"*/);

        emailSenderService.sendEmail(mailMessage);

        return ResponseEntity.ok(new MessageResponse(id));
    }

    @PutMapping
  
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userServiceImp.updateUser(user));
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void> deleteUserById(@PathVariable String id) {
        logger.trace(id);
        userServiceImp.deleteUser(id);
        return ResponseEntity.noContent().build();

}

    public static String alphaNumericString(int len) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();

        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }
}
