package fr.humanbooster.fx.test_technique.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.test_technique.business.Stagiaire;
import fr.humanbooster.fx.test_technique.business.Utilisateur;
import fr.humanbooster.fx.test_technique.dao.UtilisateurDao;
import fr.humanbooster.fx.test_technique.dao.impl.UtilisateurDaoImpl;
import fr.humanbooster.fx.test_technique.service.UtilisateurService;

public class UtilisateurServiceImpl implements UtilisateurService {

	private UtilisateurDao utilisateurDao;
	
	public UtilisateurServiceImpl() {
		utilisateurDao = new UtilisateurDaoImpl();
	}
	
	@Override
	public Utilisateur ajouterStagiaire(String nom, String prenom, String email, String motDePasse) {
		Utilisateur utilisateur = new Stagiaire();
		utilisateur.setNom(nom);
		try {
			return utilisateurDao.create(utilisateur);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Utilisateur recupererUtilisateur(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> recupererUtilisateurs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur majUtilisateur(Long id, String nom, String prenom, String email, String motDePasse) {
		// TODO Auto-generated method stub
		return null;
	}


}
