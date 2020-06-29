package fr.humanbooster.fx.test_technique.service;

import java.util.List;

import fr.humanbooster.fx.test_technique.business.Niveau;

public interface NiveauService {

	Niveau ajouterNiveau(String nom);

	void ajouterNiveauxInitiaux();

	Niveau recupererNiveau(Long id);

	List<Niveau> recupererNiveaux();

	Niveau majNiveau(Long id, String nom);

	boolean supprimerNiveau(Long id);

}