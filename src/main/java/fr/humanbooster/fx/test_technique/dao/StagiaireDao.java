package fr.humanbooster.fx.test_technique.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.test_technique.business.Stagiaire;

public interface StagiaireDao {

	Stagiaire create(Stagiaire stagiaire) throws SQLException;

	Stagiaire findOne(Long id) throws SQLException;

	List<Stagiaire> findAll() throws SQLException;

}
