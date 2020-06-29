package fr.humanbooster.fx.test_technique.dao.impl;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.test_technique.business.Domaine;
import fr.humanbooster.fx.test_technique.business.Niveau;
import fr.humanbooster.fx.test_technique.business.Question;
import fr.humanbooster.fx.test_technique.business.Questionnaire;
import fr.humanbooster.fx.test_technique.dao.QuestionDao;
import fr.humanbooster.fx.test_technique.dao.QuestionnaireDao;

public class QuestionnaireDaoImpl implements QuestionnaireDao {

	@Override
	// public static final String AJOUT_QUESTIONNAIRE = "INSERT INTO questionnaire
	// () VALUES ()";
	public Questionnaire create(Questionnaire questionnaire) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	// public static final String QUESTIONNAIRE_PAR_ID = "SELECT idNIVEAU FROM
	// questionnaire WHERE idQUESTIONNAIRE=?";
	public Questionnaire findOne(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	// public static final String TOUS_LES_QUESTIONNAIRES = "SELECT idQUESTIONNAIRE
	// FROM questionnaire";
	public List<Questionnaire> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	// public static final String SUPPRESSION_QUESTIONNAIRE = "DELETE FROM
	// questionnaire WHERE idQUESTIONNAIRE=?";
	public boolean delete(Long idNiveau) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}