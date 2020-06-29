package fr.humanbooster.fx.test_technique.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.test_technique.business.Niveau;
import fr.humanbooster.fx.test_technique.dao.ConnexionBdd;
import fr.humanbooster.fx.test_technique.dao.NiveauDao;
import fr.humanbooster.fx.test_technique.dao.Requetes;

public class NiveauDaoImpl implements NiveauDao {

	private Connection connexion;

	public NiveauDaoImpl() {
		try {
			connexion = ConnexionBdd.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	// "INSERT INTO Niveau (nom) VALUES (?)"
	public Niveau create(Niveau niveau) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.AJOUT_NIVEAU, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, niveau.getNom());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		niveau.setIdNiveau(rs.getLong(1));
		return niveau;
	}

	@Override
	// SELECT idNIVEAU, nom FROM Niveau WHERE idNIVEAU=?
	public Niveau findOne(Long id) throws SQLException {
		Niveau niveau = null;
		PreparedStatement ps = connexion.prepareStatement(Requetes.NIVEAU_PAR_ID);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			niveau = new Niveau(rs.getString("nom"));
			niveau.setIdNiveau(rs.getLong("id"));
		}
		return niveau;
	}

	@Override
	// SELECT idNIVEAU, nom FROM Niveau
	public List<Niveau> findAll() throws SQLException {
		List<Niveau> niveaux = new ArrayList<>();
		PreparedStatement ps = connexion.prepareStatement(Requetes.TOUS_LES_NIVEAUX);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Niveau niveau = new Niveau(rs.getString("nom"));
			niveau.setIdNiveau(rs.getLong("id"));
			niveaux.add(niveau);
		}
		return niveaux;
	}

	@Override
	// UPDATE Niveau SET nom=? WHERE idNIVEAU=?
	public Niveau update(Niveau niveau) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.MODIFICATION_NIVEAU);
		ps.setString(1, niveau.getNom());
		ps.setLong(2, niveau.getIdNiveau());
		ps.executeUpdate();
		return niveau;
	}

	@Override
	// DELETE FROM Niveau WHERE idNIVEAU=?
	public boolean delete(Long idNiveau) throws SQLException {
		if (findOne(idNiveau) == null)
			return false;
		PreparedStatement ps = connexion.prepareStatement(Requetes.SUPPRESSION_NIVEAU);
		ps.setLong(1, idNiveau);
		ps.executeUpdate();
		return true;
	}

}
