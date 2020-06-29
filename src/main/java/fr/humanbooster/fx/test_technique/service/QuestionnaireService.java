package fr.humanbooster.fx.test_technique.service;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.test_technique.business.Questionnaire;

public interface QuestionnaireService {

	Questionnaire ajouterQuestionnaire(Questionnaire questionnaire) throws SQLException;

	Questionnaire recupererQuestionnaire(Long id) throws SQLException;

	List<Questionnaire> recupererQuestionnaires() throws SQLException;

	boolean supprimerQuestionnaire(Long id) throws SQLException;

}
