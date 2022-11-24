package com.example.securite.Contoller;

import com.example.securite.Repository.FileRepository;
import com.example.securite.Repository.UserRepository;
import com.example.securite.Service.FilesStorageService;
import com.example.securite.Service.UserService;
import com.example.securite.message.ResponseMessage;
import com.example.securite.model.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin
public class FilesController {
  /*  @Autowired
    FilesStorageService storageService;

    @Autowired
    UserService userService;
    @Autowired
    private FileRepository fileRepository;
    @PostMapping("/upload/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') ")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file , @PathVariable String id) {
        String message = "";

        try {
            storageService.save(file);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            if (userService.getUser(id)!=null){
                FileInfo fileInfo=new FileInfo();
                fileInfo.setUser(userService.getUser(id));
                fileInfo.setName(file.getOriginalFilename());
                fileInfo.setUrl(file.getName());
                fileRepository.save(fileInfo);
            }
            else {
                message = "Could not find user with id =: "+id+"!";
            }

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
    @GetMapping("/files")
    @PreAuthorize("hasRole('ROLE_ADMIN') ")
    public ResponseEntity<List<FileInfo>> getListFiles() {
        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();
            return new FileInfo(filename, url);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping(value="/files/{filename:.+}",
            produces = {MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_GIF_VALUE,MediaType.IMAGE_PNG_VALUE})
    @PreAuthorize("hasRole('ROLE_ADMIN') ")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping(value="user/files/{id:.+}",
            produces = {MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_GIF_VALUE,MediaType.IMAGE_PNG_VALUE})
    @PreAuthorize("hasRole('ROLE_ADMIN') ")
    @ResponseBody
    public ResponseEntity<Resource>  loadFileByid(@PathVariable String id) {
        Resource file = storageService.loadFileByid(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
 *//*@GetMapping(value="/files/{filename:.+}",
         produces = {MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_GIF_VALUE,MediaType.IMAGE_PNG_VALUE})
 @PreAuthorize("hasRole('ROLE_ADMIN') ")
 @ResponseBody
 public byte[] getFile(@PathVariable String filename) throws IOException {
     Resource file = storageService.load(filename);
     Path destination = null;
     try {
         destination = file.getFile().toPath();
     } catch (IOException e) {
         e.printStackTrace();
     }
     assert destination != null;
     return IOUtils.toByteArray(destination.toUri());

 }*//*
*/
}
