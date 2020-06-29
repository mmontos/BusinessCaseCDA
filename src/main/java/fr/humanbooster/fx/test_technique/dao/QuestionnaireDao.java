package fr.humanbooster.fx.test_technique.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.test_technique.business.Questionnaire;

public interface QuestionnaireDao {

	Questionnaire create(Questionnaire questionnaire) throws SQLException;

	Questionnaire findOne(Long id) throws SQLException;

	List<Questionnaire> findAll() throws SQLException;

	Questionnaire update(Questionnaire questionnaire) throws SQLException;

	boolean delete(Long idNiveau) throws SQLException;

}
