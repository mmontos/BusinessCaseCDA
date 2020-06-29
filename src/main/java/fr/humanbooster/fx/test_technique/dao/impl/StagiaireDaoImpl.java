package fr.humanbooster.fx.test_technique.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.test_technique.business.Stagiaire;
import fr.humanbooster.fx.test_technique.dao.ConnexionBdd;
import fr.humanbooster.fx.test_technique.dao.Requetes;
import fr.humanbooster.fx.test_technique.dao.StagiaireDao;

public class StagiaireDaoImpl implements StagiaireDao {

	private Connection connexion;

	public StagiaireDaoImpl() {
		try {
			connexion = ConnexionBdd.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// "INSERT INTO stagiaire (dateNaissance, numPoleEmploi, estHandicape,
	// idUtilisateur) VALUES (?, ?, ?, ?)";
	public Stagiaire create(Stagiaire stagiaire) throws SQLException {
		try {
			PreparedStatement psUtilisateur = connexion.prepareStatement(Requetes.AJOUT_UTILISATEUR, Statement.RETURN_GENERATED_KEYS);
			psUtilisateur.setString(1, stagiaire.getNom());
			psUtilisateur.setString(2, stagiaire.getPrenom());
			psUtilisateur.setString(3, stagiaire.getEmail());
			psUtilisateur.setString(4, stagiaire.getMotDePasseSHA());
			psUtilisateur.executeUpdate();
			ResultSet rs = psUtilisateur.getGeneratedKeys();
			rs.next();
			stagiaire.setIdUtilisateur(rs.getLong(1));
			PreparedStatement psStagiaire = connexion.prepareStatement(Requetes.AJOUT_STAGIAIRE);
			psStagiaire.setTimestamp(1, new Timestamp(stagiaire.getDateNaissance().getTime()));
			psStagiaire.setString(2, stagiaire.getNumPoleEmploi());
			psStagiaire.setBoolean(3, stagiaire.getEstHandicape());
			psStagiaire.setLong(4, stagiaire.getIdUtilisateur());
			psStagiaire.executeUpdate();
			return stagiaire;
		} catch (Exception e) {
			connexion.rollback();
		}
		return null;
	}

	// "SELECT id, dateNaissance, numPoleEmploi, estHandicape, lienJustifHAndicap
	// FROM stagiaire WHERE id="SELECT id, dateNaissance, numPoleEmploi,
	// estHandicape FROM stagiaire";
	public Stagiaire findOne(Long id) throws SQLException {
		Stagiaire stagiaire = null;
		PreparedStatement psUtilisateur = connexion.prepareStatement(Requetes.UTILISATEUR_PAR_ID);
		psUtilisateur.setLong(1, id);
		ResultSet rsUtilisateur = psUtilisateur.executeQuery();
		if (rsUtilisateur.next()) {
			stagiaire = new Stagiaire();
			stagiaire.setNom(rsUtilisateur.getString("nom"));
			stagiaire.setNom(rsUtilisateur.getString("prenom"));
			stagiaire.setNom(rsUtilisateur.getString("email"));
			stagiaire.setNom(rsUtilisateur.getString("motDePasseSHA"));
		}
		PreparedStatement psStagiaire = connexion.prepareStatement(Requetes.STAGIAIRE_PAR_ID);
		psStagiaire.setLong(1, id);
		ResultSet rsStagiaire = psStagiaire.executeQuery();
		if (rsStagiaire.next()) {
			stagiaire.setIdUtilisateur(rsStagiaire.getLong("id"));
			stagiaire.setDateNaissance(rsStagiaire.getTimestamp("dateDeNaissance"));
			stagiaire.setNumPoleEmploi(rsStagiaire.getString("numPolEmploi"));
			stagiaire.setEstHandicape(rsStagiaire.getBoolean("estHandicape"));
		}
		return stagiaire;
	}

	// "SELECT id, dateNaissance, numPoleEmploi, estHandicape, lienJustifHAndicap
	// FROM stagiaire";
	public List<Stagiaire> findAll() throws SQLException {
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
		Stagiaire stagiaire = null;
		PreparedStatement psUtilisateur = connexion.prepareStatement(Requetes.UTILISATEUR_PAR_ID);
		ResultSet rsUtilisateur = psUtilisateur.executeQuery();
		while (rsUtilisateur.next()) {
			stagiaire = new Stagiaire();
			stagiaire.setNom(rsUtilisateur.getString("nom"));
			stagiaire.setNom(rsUtilisateur.getString("prenom"));
			stagiaire.setNom(rsUtilisateur.getString("email"));
			stagiaire.setNom(rsUtilisateur.getString("motDePasseSHA"));
		}
		PreparedStatement psStagiaire = connexion.prepareStatement(Requetes.STAGIAIRE_PAR_ID);
		ResultSet rsStagiaire = psStagiaire.executeQuery();
		while (rsStagiaire.next()) {
			stagiaire.setIdUtilisateur(rsStagiaire.getLong("id"));
			stagiaire.setDateNaissance(rsStagiaire.getTimestamp("dateDeNaissance"));
			stagiaire.setNumPoleEmploi(rsStagiaire.getString("numPolEmploi"));
			stagiaire.setEstHandicape(rsStagiaire.getBoolean("estHandicape"));
			stagiaires.add(stagiaire);
		}
		return stagiaires;
	}

}
