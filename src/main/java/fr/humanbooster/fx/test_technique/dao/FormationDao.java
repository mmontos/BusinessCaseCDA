package fr.humanbooster.fx.test_technique.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.test_technique.business.Formation;

public interface FormationDao {

	Formation create(Formation formation) throws SQLException;

	Formation findOne(Long id) throws SQLException;

	List<Formation> findAll() throws SQLException;

	boolean delete(Long id) throws SQLException;

}
