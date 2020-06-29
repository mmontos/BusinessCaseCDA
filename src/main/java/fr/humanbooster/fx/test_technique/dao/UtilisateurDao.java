package fr.humanbooster.fx.test_technique.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.test_technique.business.Utilisateur;

public interface UtilisateurDao {

	Utilisateur create(Utilisateur utilisateur) throws SQLException;

	Utilisateur findOne(Long id) throws SQLException;

	List<Utilisateur> findAll() throws SQLException;

	Utilisateur update(Utilisateur utilisateur) throws SQLException;

	boolean delete(Long id) throws SQLException;

}
