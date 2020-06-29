package fr.humanbooster.fx.test_technique.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.test_technique.business.Domaine;
import fr.humanbooster.fx.test_technique.business.Niveau;
import fr.humanbooster.fx.test_technique.business.Question;
import fr.humanbooster.fx.test_technique.business.Questionnaire;

public interface QuestionDao {
	
	Question create(Question question) throws SQLException;

	Question findOne(Long id) throws SQLException;

	List<Question> findByQuestionnaireAndByDomaine(Questionnaire questionnaire, Domaine domaine) throws SQLException;
	
	List<Question> findByQuestionnaire(Questionnaire questionnaire) throws SQLException;
	
	List<Question> findByDomaine(Domaine domaine) throws SQLException;
	
	List<Question> findByNiveau(Niveau niveau) throws SQLException;

	Question update(Question question) throws SQLException;

	boolean delete(Long id) throws SQLException;

}
