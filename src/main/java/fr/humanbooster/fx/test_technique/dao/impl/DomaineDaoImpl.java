package fr.humanbooster.fx.test_technique.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.test_technique.business.Domaine;
import fr.humanbooster.fx.test_technique.business.Stagiaire;
import fr.humanbooster.fx.test_technique.dao.ConnexionBdd;
import fr.humanbooster.fx.test_technique.dao.DomaineDao;
import fr.humanbooster.fx.test_technique.dao.Requetes;

public class DomaineDaoImpl implements DomaineDao {

	private Connection connexion;

	public DomaineDaoImpl() {
		try {
			connexion = ConnexionBdd.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	// public static final String AJOUT_DOMAINE = "INSERT INTO domaine (nom) VALUES
	// (?)";
	public Domaine create(Domaine domaine) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	// public static final String DOMAINE_PAR_ID = "SELECT idDOMAINE, nom FROM
	// domaine WHERE idDOMAINE=?";
	public Domaine findOne(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	// public static final String TOUS_LES_DOMAINES = "SELECT idDOMAINE, nom FROM
	// domaine";
	public List<Domaine> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	// public static final String UPDATE_DOMAINE_PAR_NOM = "UPDATE domaine SET nom=?
	// WHERE idDOMAINE=?";
	public Domaine update(Domaine domaine) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.UPDATE_UTILISATEUR_MOT_DE_PASSE);
		ps.setString(1, domaine.getNom());
		ps.executeUpdate();
		return findOne(domaine.getIdDomaine());
	}

	@Override
	// public static final String SUPPRESSION_DOMAINE = "DELETE FROM domaine WHERE
	// idDOMAINE=?";
	public boolean delete(Long id) throws SQLException {
		Domaine domaine = findOne(id);
		boolean estEfface = false;
		if (domaine != null) {
			PreparedStatement ps = connexion.prepareStatement(Requetes.SUPPRESSION_DOMAINE);
			ps.setLong(1, id);
			ps.executeUpdate();
			estEfface = true;
		}
		return estEfface;
	}

}
