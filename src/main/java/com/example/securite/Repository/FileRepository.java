package com.example.securite.Repository;

import com.example.securite.model.FileInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileInfo,String> {

    FileInfo findUserById(String id);
}
