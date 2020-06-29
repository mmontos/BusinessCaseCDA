package fr.humanbooster.fx.test_technique.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.test_technique.business.Formation;
import fr.humanbooster.fx.test_technique.dao.FormationDao;

public class FormationDaoImpl implements FormationDao {

	private Connection connexion;

	public FormationDaoImpl() {
		try {
			connexion = ConnexionBdd.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Formation create(Formation formation) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.AJOUT_FORMATION, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, formation.getIntitule());
		ps.setString(2, formation.getDescription());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		formation.setId(rs.getLong(1));
		return null;
	}

	public Formation findOne(Long id) throws SQLException {
		Formation formation = null;
		PreparedStatement ps = connexion.prepareStatement(Requetes.FORMATION_PAR_ID);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			formation = new Formation();
			formation.setId(rs.getLong("id"));
			formation.setIntitule(rs.getString("intitule"));
			formation.setDescription(rs.getString("description"));
		}
		return formation;
	}

	public List<Formation> findAll() throws SQLException {
		List<Formation> formations = new ArrayList<Formation>();
		PreparedStatement ps = connexion.prepareStatement(Requetes.TOUTES_LES_FORMATIONS);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			formations.add(findOne(rs.getLong("id")));
		}
		return formations;
	}

	public boolean delete(Long id) throws SQLException {
		Formation formation = findOne(id);
		boolean estEfface = false;
		if (formation != null) {
			PreparedStatement ps = connexion.prepareStatement(Requetes.SUPPRESSION_FORMATION);
			ps.setLong(1, id);
			ps.executeUpdate();
			estEfface = true;
		}
		return estEfface;
	}
}
