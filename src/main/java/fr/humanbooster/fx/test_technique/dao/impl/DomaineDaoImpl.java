package fr.humanbooster.fx.test_technique.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.test_technique.business.Domaine;
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
		PreparedStatement ps = connexion.prepareStatement(Requetes.AJOUT_DOMAINE, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, domaine.getNom());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		domaine.setIdDomaine(rs.getLong(1));
		return domaine;
	}

	@Override
	// public static final String DOMAINE_PAR_ID = "SELECT idDOMAINE, nom FROM
	// domaine WHERE idDOMAINE=?";
	public Domaine findOne(Long id) throws SQLException {
		Domaine domaine = null;
		PreparedStatement ps = connexion.prepareStatement(Requetes.DOMAINE_PAR_ID);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			domaine = new Domaine(rs.getString("nom"));
			domaine.setIdDomaine(rs.getLong("idDOMAINE"));
		}
		return domaine;
	}

	@Override
	// public static final String TOUS_LES_DOMAINES = "SELECT idDOMAINE, nom FROM
	// domaine";
	public List<Domaine> findAll() throws SQLException {
		List<Domaine> domaines = new ArrayList<>();
		PreparedStatement ps = connexion.prepareStatement(Requetes.TOUS_LES_DOMAINES);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Domaine domaine = new Domaine(rs.getString("nom"));
			domaine.setIdDomaine(rs.getLong("idDOMAINE"));
			domaines.add(domaine);
		}
		return domaines;
	}

	@Override
	// public static final String UPDATE_DOMAINE_PAR_NOM = "UPDATE domaine SET nom=?
	// WHERE idDOMAINE=?";
	public Domaine update(Domaine domaine) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.UPDATE_DOMAINE_PAR_NOM);
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
