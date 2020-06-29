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
import fr.humanbooster.fx.test_technique.business.Utilisateur;
import fr.humanbooster.fx.test_technique.dao.StagiaireDao;

public class StagiaireDaoImpl implements StagiaireDao {

	private Connection connexion;
	private UtilisateurDao utilisateurDao;

	public StagiaireDaoImpl() {
		try {
			connexion = ConnexionBdd.getConnection();
			utilisateurDao = new UtilisateurDaoImpl();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// "INSERT INTO stagiaire (dateNaissance, numPoleEmploi, estHandicape,
	// idUtilisateur) VALUES (?, ?, ?, ?)";
	public Stagiaire create(Stagiaire stagiaire) throws SQLException {
		Utilisateur utilisateur = null;
		utilisateur = utilisateurDao.create(utilisateur);
		PreparedStatement ps = connexion.prepareStatement(Requetes.AJOUT_STAGIAIRE, Statement.RETURN_GENERATED_KEYS);
		ps.setTimestamp(1, new Timestamp(stagiaire.getDateNaissance().getTime()));
		ps.setString(2, stagiaire.getNumPoleEmploi());
		ps.setBoolean(3, stagiaire.isEstHandicape());
		ps.setLong(4, stagiaire.getIdUtilisateur());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		stagiaire.setIdUtilisateur(rs.getLong(1));
		return stagiaire;
	}

	// "SELECT id, dateNaissance, numPoleEmploi, estHandicape, lienJustifHAndicap
	// FROM stagiaire WHERE id="SELECT id, dateNaissance, numPoleEmploi,
	// estHandicape FROM stagiaire";
	public Stagiaire findOne(Long id) throws SQLException {
		Stagiaire stagiaire = null;
		PreparedStatement ps = connexion.prepareStatement(Requetes.STAGIAIRE_PAR_ID);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			stagiaire = new Stagiaire();
			stagiaire.setIdUtilisateur(rs.getLong("id"));
			stagiaire.setDateNaissance(rs.getTimestamp("dateDeNaissance"));
			stagiaire.setNumPoleEmploi(rs.getString("numPolEmploi"));
			stagiaire.setEstHandicape(rs.getBoolean("estHandicape"));
		}
		return stagiaire;
	}

	// "SELECT id, dateNaissance, numPoleEmploi, estHandicape, lienJustifHAndicap
	// FROM stagiaire";
	public List<Stagiaire> findAll() throws SQLException {
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
		PreparedStatement ps = connexion.prepareStatement(Requetes.TOUS_LES_STAGIAIRES);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			stagiaires.add(findOne(rs.getLong("id")));
		}
		return stagiaires;
	}

	// "DELETE FROM stagiaire WHERE id=?";
	public boolean delete(Long id) throws SQLException {
		Stagiaire stagiaire = findOne(id);
		boolean estEfface = false;
		if (stagiaire != null) {
			PreparedStatement ps = connexion.prepareStatement(Requetes.SUPPRESSION_STAGIAIRE);
			ps.setLong(1, id);
			ps.executeUpdate();
			estEfface = true;
		}
		return estEfface;
	}

}
