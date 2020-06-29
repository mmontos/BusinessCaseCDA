package fr.humanbooster.fx.test_technique.service;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.test_technique.business.Domaine;

public interface DomaineService {

	Domaine ajouterDomaine(Domaine domaine) throws SQLException;

	Domaine recupererDomaine(Long id) throws SQLException;

	List<Domaine> recupererDomaines() throws SQLException;

	Domaine majDomaine(Domaine domaine) throws SQLException;

	boolean supprimerDomaine(Long id) throws SQLException;

}
