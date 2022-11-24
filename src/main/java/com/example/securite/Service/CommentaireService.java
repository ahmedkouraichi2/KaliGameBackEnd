package com.example.securite.Service;

import com.example.securite.model.Commentaire;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface CommentaireService {

    Commentaire updateCommentaire(Commentaire commentaire, Long id);


    void deleteCommentaire(Long id);

    List<Commentaire> allCommentaires();
}
