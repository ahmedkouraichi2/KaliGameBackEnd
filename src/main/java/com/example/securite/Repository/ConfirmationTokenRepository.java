package com.example.securite.Repository;

import com.example.securite.model.ConfirmationToken;
import org.springframework.data.repository.CrudRepository;


public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, String> {
        ConfirmationToken findByConfirmationToken(String confirmationToken);
    }




