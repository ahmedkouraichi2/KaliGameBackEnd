package com.example.securite.Service;

import com.example.securite.model.Planification;

import java.util.List;

import org.springframework.stereotype.Service;
@Service

public interface PlanificationService {

    Planification updatePlanification(Planification planification, Long id);


    void deletePlanification(Long id);

    List<Planification> allPlanifications();
}
