package com.abakar.primefaces.repository;

import com.abakar.primefaces.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    public Utilisateur findByLogin(String login);

    public Utilisateur findByEmail(String email);

    public Optional<Utilisateur> findById(Integer id);

    public Utilisateur findByMatricule(String matricule);
}
