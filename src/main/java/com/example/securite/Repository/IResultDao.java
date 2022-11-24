package com.example.securite.Repository;

import org.springframework.stereotype.Repository;

import com.example.securite.model.Exam.Result;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface IResultDao extends JpaRepository<Result, Long> {

}
