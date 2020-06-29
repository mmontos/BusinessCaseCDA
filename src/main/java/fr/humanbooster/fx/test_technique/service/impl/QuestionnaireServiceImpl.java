package fr.humanbooster.fx.test_technique.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.test_technique.business.Questionnaire;
import fr.humanbooster.fx.test_technique.dao.QuestionnaireDao;
import fr.humanbooster.fx.test_technique.dao.impl.QuestionnaireDaoImpl;
import fr.humanbooster.fx.test_technique.service.QuestionnaireService;

public class QuestionnaireServiceImpl implements QuestionnaireService {

	private QuestionnaireDao questionnaireDao = new QuestionnaireDaoImpl();

	@Override
	public Questionnaire ajouterQuestionnaire(Questionnaire questionnaire) throws SQLException {
		try {
			return questionnaireDao.create(questionnaire);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Questionnaire recupererQuestionnaire(Long id) throws SQLException {
		try {
			return questionnaireDao.findOne(id);
		} catch (SQLException e) {
		}
		return null;
	}

	@Override
	public List<Questionnaire> recupererQuestionnaires() throws SQLException {
		try {
			return questionnaireDao.findAll();
		} catch (SQLException e) {
		}
		return null;
	}

	@Override
	public boolean supprimerQuestionnaire(Long id) throws SQLException {
		try {
			return questionnaireDao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
