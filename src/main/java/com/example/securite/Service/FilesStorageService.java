package com.example.securite.Service;


import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

@Service

public interface FilesStorageService {
    public void init();
    public void save(MultipartFile file);
    public Resource load(String filename);
    public Resource loadFileByid(String id);
    public void deleteAll();
    public Stream<Path> loadAll();

}
