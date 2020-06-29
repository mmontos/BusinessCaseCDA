package fr.humanbooster.fx.test_technique.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.test_technique.business.Questionnaire;
import fr.humanbooster.fx.test_technique.dao.ConnexionBdd;
import fr.humanbooster.fx.test_technique.dao.QuestionnaireDao;
import fr.humanbooster.fx.test_technique.dao.Requetes;

public class QuestionnaireDaoImpl implements QuestionnaireDao {

	private Connection connexion;

	public QuestionnaireDaoImpl() {
		try {
			connexion = ConnexionBdd.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	// "INSERT INTO questionnaire () VALUES ()";
	public Questionnaire create(Questionnaire questionnaire) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.AJOUT_QUESTIONNAIRE,
				Statement.RETURN_GENERATED_KEYS);
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		questionnaire.setIdQuestionnaire(rs.getLong(1));
		return questionnaire;
	}

	@Override
	// SELECT idNIVEAU FROM questionnaire WHERE idQUESTIONNAIRE=?";
	public Questionnaire findOne(Long id) throws SQLException {
		Questionnaire questionnaire = null;
		PreparedStatement ps = connexion.prepareStatement(Requetes.QUESTIONNAIRE_PAR_ID);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			questionnaire = new Questionnaire(rs.getLong("idQUESTIONNAIRE"));
		}
		return questionnaire;
	}

	@Override
	// "SELECT idQUESTIONNAIRE FROM questionnaire";
	public List<Questionnaire> findAll() throws SQLException {
		List<Questionnaire> questionnaires = new ArrayList<>();
		PreparedStatement ps = connexion.prepareStatement(Requetes.TOUS_LES_QUESTIONNAIRES);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Questionnaire questionnaire = new Questionnaire();
			questionnaire.setIdQuestionnaire(rs.getLong("idQUESTIONNAIRE"));
			questionnaires.add(questionnaire);
		}
		return questionnaires;
	}

	@Override
	// "DELETE FROM questionnaire WHERE idQUESTIONNAIRE=?";
	public boolean delete(Long id) throws SQLException {
		Questionnaire questionnaire = findOne(id);
		boolean estEfface = false;
		if (questionnaire != null) {
			PreparedStatement ps = connexion.prepareStatement(Requetes.SUPPRESSION_QUESTIONNAIRE);
			ps.setLong(1, id);
			ps.executeUpdate();
			estEfface = true;
		}
		return estEfface;
	}
}