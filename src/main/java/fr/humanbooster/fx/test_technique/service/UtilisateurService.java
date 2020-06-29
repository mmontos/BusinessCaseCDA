package fr.humanbooster.fx.test_technique.service;

import java.util.Date;
import java.util.List;

import fr.humanbooster.fx.test_technique.business.Utilisateur;

public interface UtilisateurService {

	Utilisateur ajouterStagiaire(String nom, String prenom, String email, String motDePasse, Date dateNaissance, String numPoleEmploi, boolean estHandicape);
	
	Utilisateur ajouterAdministrateur(String nom, String prenom, String email, String motDePasse);
	
	Utilisateur ajouterChefDeProjet(String nom, String prenom, String email, String motDePasse, Date dateEmbauche);
	
	Utilisateur recupererUtilisateur(Long id);
	
	List<Utilisateur> recupererUtilisateurs();
	
	Utilisateur majUtilisateur(Long id, String nom, String prenom, String email, String motDePasse);
	
}
