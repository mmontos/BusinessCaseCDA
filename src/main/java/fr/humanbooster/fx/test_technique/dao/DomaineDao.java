package fr.humanbooster.fx.test_technique.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.test_technique.business.Domaine;

public interface DomaineDao {

	Domaine create(Domaine domaine) throws SQLException;

	Domaine findOne(Long id) throws SQLException;

	List<Domaine> findAll() throws SQLException;

	Domaine update(Domaine domaine) throws SQLException;

	boolean delete(Long id) throws SQLException;

}