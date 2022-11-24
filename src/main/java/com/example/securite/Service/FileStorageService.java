package com.example.securite.Service;

import com.example.securite.Repository.FileDBRepository;
import com.example.securite.Repository.UserRepository;
import com.example.securite.model.FileDB;
import com.example.securite.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class FileStorageService {
    @Autowired
    private FileDBRepository fileDBRepository;

    @Autowired
    private UserRepository userRepository;

    public FileDB store(MultipartFile file,String id) throws IOException {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileDB fileDB= userRepository.findById(id).get().getFileDB();
       /* User user = userRepository.findById(id).get();
        FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes(),user);*/
        fileDB.setName(fileName);
        fileDB.setType(file.getContentType());
        fileDB.setData(file.getBytes());
        return fileDBRepository.save(fileDB);
    }
    public FileDB getFile(String id) {
        String idFILe=userRepository.findById(id).get().getFileDB().getId();
        return fileDBRepository.findById(idFILe).get();
    }

    public Stream<FileDB> getAllFiles() {
        return fileDBRepository.findAll().stream();
    }



    public void deleteUserFile(String id) {
        String idFile =userRepository.findById(id).get().getFileDB().getId();
        fileDBRepository.deleteById(idFile);
    }
}
