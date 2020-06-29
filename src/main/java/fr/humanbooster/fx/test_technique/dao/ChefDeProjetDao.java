package fr.humanbooster.fx.test_technique.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.test_technique.business.ChefDeProjet;
import fr.humanbooster.fx.test_technique.business.ChefProjet;

public interface ChefDeProjetDao {

	ChefDeProjet create(ChefDeProjet chefDeProjet) throws SQLException;

	ChefDeProjet findOne(Long id) throws SQLException;

	List<ChefDeProjet> findAll() throws SQLException;

	boolean delete(Long id) throws SQLException;

}
