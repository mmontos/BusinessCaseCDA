package fr.humanbooster.fx.test_technique.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.test_technique.business.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao {

	private Connection connexion;

	public UtilisateurDaoImpl() {
		try {
			connexion = ConnexionBdd.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Utilisateur create(Utilisateur utilisateur) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.AJOUT_UTILISATEUR, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, utilisateur.getNom());
		ps.setString(2, utilisateur.getPrenom());
		ps.setString(3, utilisateur.getEmail());
		ps.setString(4, utilisateur.getMotDePasseSHA());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		utilisateur.setIdUtilisateur(rs.getLong(1));

		return utilisateur;
	}

	public Utilisateur findOne(Long id) throws SQLException {
		Utilisateur utilisateur = null;
		PreparedStatement ps = connexion.prepareStatement(Requetes.UTILISATEUR_PAR_ID);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			utilisateur = new Utilisateur();
			utilisateur.setIdUtilisateur(rs.getLong("id"));
			utilisateur.setNom(rs.getString("nom"));
			utilisateur.setPrenom(rs.getString("prenom"));
			utilisateur.setEmail(rs.getString("email"));
			utilisateur.setMotDePasseSHA(rs.getString("motDePasseSHA256"));
		}
		return utilisateur;
	}

	public List<Utilisateur> findAll() throws SQLException {
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		PreparedStatement ps = connexion.prepareStatement(Requetes.TOUS_LES_UTILISATEURS);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			utilisateurs.add(findOne(rs.getLong("id")));
		}
		return utilisateurs;
	}

	public Utilisateur update(Utilisateur utilisateur) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.UPDATE_UTILISATEUR_MOT_DE_PASSE);
		ps.setString(1, utilisateur.getMotDePasseSHA256());
		ps.setLong(2, utilisateur.getIdUtilisateur());
		ps.executeUpdate();
		return findOne(utilisateur.getIdUtilisateur());
	}

	public boolean delete(Long id) throws SQLException {
		Utilisateur utilisateur = findOne(id);
		boolean estEfface = false;
		if (utilisateur != null) {
			PreparedStatement ps = connexion.prepareStatement(Requetes.SUPPRESSION_UTILISATEUR);
			ps.setLong(1, id);
			ps.executeUpdate();
			estEfface = true;
		}
		return estEfface;
	}

}
