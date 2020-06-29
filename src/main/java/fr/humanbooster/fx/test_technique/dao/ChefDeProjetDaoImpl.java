package fr.humanbooster.fx.test_technique.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.test_technique.business.ChefDeProjet;
import fr.humanbooster.fx.test_technique.business.Utilisateur;

public class ChefDeProjetDaoImpl implements ChefDeProjetDao {

	// La DAO a besoin d'une connexion à la base
	private Connection connexion;
	private UtilisateurDao utilisateurDao;

	public ChefDeProjetDaoImpl() {

		try {
			connexion = ConnexionBdd.getConnection();
			utilisateurDao = new UtilisateurDaoImpl();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ChefDeProjet create(ChefDeProjet chefDeProjet) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public ChefDeProjet findOne(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ChefDeProjet> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
}