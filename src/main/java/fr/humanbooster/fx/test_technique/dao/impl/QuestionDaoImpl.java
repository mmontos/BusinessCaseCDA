package fr.humanbooster.fx.test_technique.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.test_technique.business.Domaine;
import fr.humanbooster.fx.test_technique.business.Niveau;
import fr.humanbooster.fx.test_technique.business.Question;
import fr.humanbooster.fx.test_technique.business.Questionnaire;
import fr.humanbooster.fx.test_technique.dao.ConnexionBdd;
import fr.humanbooster.fx.test_technique.dao.DomaineDao;
import fr.humanbooster.fx.test_technique.dao.NiveauDao;
import fr.humanbooster.fx.test_technique.dao.QuestionDao;
import fr.humanbooster.fx.test_technique.dao.QuestionnaireDao;
import fr.humanbooster.fx.test_technique.dao.Requetes;

public class QuestionDaoImpl implements QuestionDao {

	private NiveauDao niveauDao;
	private DomaineDao domaineDao;
	private QuestionnaireDao questionnaireDao;
	private AdministrateurDao administrateurDao;

	private Connection connexion;

	public QuestionDaoImpl() {
		try {
			connexion = ConnexionBdd.getConnection();
			niveauDao = new NiveauDaoImpl();
			domaineDao = new DomaineDaoImpl();
			questionnaireDao = new QuestionnaireDaoImpl();
			administrateurDao = new AdministrateurDaoImpl();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Question create(Question question) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.AJOUT_QUESTION, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, question.getEnonce());
		ps.setString(2, question.getLienMedia());
		ps.setBoolean(3, question.isEstChoixMultiples());
		ps.setBoolean(4, question.isEstElminatoire());
		ps.setLong(5, question.getNiveau().getIdNiveau());
		ps.setLong(6, question.getDomaine().getIdDomaine());
		ps.setLong(7, question.getQuestionnaire().getIdQuestionnaire());
		ps.setLong(8, question.getAdministrateur().getIdUtilisateur());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		question.setIdQuestion(rs.getLong(1));
		return question;
	}

	@Override
	public Question findOne(Long id) throws SQLException {
		Question question = null;
		PreparedStatement ps = connexion.prepareStatement(Requetes.QUESTION_PAR_ID);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			question = new Question();
			question.setIdQuestion(rs.getLong("idQUESTION"));
			question.setEnonce(rs.getString("enonce"));
			question.setLienMedia(rs.getString("lienMedia"));
			question.setEstChoixMultiples(rs.getBoolean("estChoixMultiples"));
			question.setEstElminatoire(rs.getBoolean("estEliminatoire"));
			question.setNiveau(niveauDao.findOne(rs.getLong("idNIVEAU")));
			question.setDomaine(domaineDao.findOne(rs.getLong("idDOMAINE")));
			question.setQuestionnaire(questionnaireDao.findOne(rs.getLong("idQUESTIONNAIRE")));
			question.setAdministrateur(administrateurDao.findOne(rs.getLong("idADMINISTRATEUR")));

		}
		return question;
	}

	@Override
	public List<Question> findByQuestionnaireAndByDomaine(Questionnaire questionnaire, Domaine domaine) {
		List<Question> questions = new ArrayList<>();
		PreparedStatement ps = connexion.prepareStatement(Requetes.QUESTIONS_PAR_QUESTIONNAIRE_ET_DOMAINE);
		ps.setLong(1, questionnaire.getIdQuestionnaire());
		ps.setLong(2, domaine.getIdDomaine());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Question question = new Question();
			question.setIdQuestion(rs.getLong("idQUESTION"));
			question.setEnonce(rs.getString("enonce"));
			question.setLienMedia(rs.getString("lienMedia"));
			question.setEstChoixMultiples(rs.getBoolean("estChoixMultiples"));
			question.setEstElminatoire(rs.getBoolean("estEliminatoire"));
			question.setNiveau(niveauDao.findOne(rs.getLong("idNIVEAU")));
			question.setDomaine(domaineDao.findOne(rs.getLong("idDOMAINE")));
			question.setQuestionnaire(questionnaireDao.findOne(rs.getLong("idQUESTIONNAIRE")));
			question.setAdministrateur(administrateurDao.findOne(rs.getLong("idADMINISTRATEUR")));
			questions.add(question);
		}
		return questions;
	}

	@Override
	public List<Question> findByQuestionnaire(Questionnaire questionnaire) throws SQLException {
		List<Question> questions = new ArrayList<>();
		PreparedStatement ps = connexion.prepareStatement(Requetes.QUESTIONS_PAR_QUESTIONNAIRE);
		ps.setLong(1, questionnaire.getIdQuestionnaire());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Question question = new Question();
			question.setIdQuestion(rs.getLong("idQUESTION"));
			question.setEnonce(rs.getString("enonce"));
			question.setLienMedia(rs.getString("lienMedia"));
			question.setEstChoixMultiples(rs.getBoolean("estChoixMultiples"));
			question.setEstElminatoire(rs.getBoolean("estEliminatoire"));
			question.setNiveau(niveauDao.findOne(rs.getLong("idNIVEAU")));
			question.setDomaine(domaineDao.findOne(rs.getLong("idDOMAINE")));
			question.setQuestionnaire(questionnaireDao.findOne(rs.getLong("idQUESTIONNAIRE")));
			question.setAdministrateur(administrateurDao.findOne(rs.getLong("idADMINISTRATEUR")));
			questions.add(question);
		}
		return questions;
	}

	@Override
	public List<Question> findByDomaine(Domaine domaine) throws SQLException {
		List<Question> questions = new ArrayList<>();
		PreparedStatement ps = connexion.prepareStatement(Requetes.QUESTIONS_PAR_DOMAINE);
		ps.setLong(1, domaine.getIdDomaine());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Question question = new Question();
			question.setIdQuestion(rs.getLong("idQUESTION"));
			question.setEnonce(rs.getString("enonce"));
			question.setLienMedia(rs.getString("lienMedia"));
			question.setEstChoixMultiples(rs.getBoolean("estChoixMultiples"));
			question.setEstElminatoire(rs.getBoolean("estEliminatoire"));
			question.setNiveau(niveauDao.findOne(rs.getLong("idNIVEAU")));
			question.setDomaine(domaineDao.findOne(rs.getLong("idDOMAINE")));
			question.setQuestionnaire(questionnaireDao.findOne(rs.getLong("idQUESTIONNAIRE")));
			question.setAdministrateur(administrateurDao.findOne(rs.getLong("idADMINISTRATEUR")));
			questions.add(question);
		}
		return questions;
	}

	@Override
	public List<Question> findByNiveau(Niveau niveau) throws SQLException {
		List<Question> questions = new ArrayList<>();
		PreparedStatement ps = connexion.prepareStatement(Requetes.QUESTIONS_PAR_NIVEAU);
		ps.setLong(1, niveau.getIdNiveau());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Question question = new Question();
			question.setIdQuestion(rs.getLong("idQUESTION"));
			question.setEnonce(rs.getString("enonce"));
			question.setLienMedia(rs.getString("lienMedia"));
			question.setEstChoixMultiples(rs.getBoolean("estChoixMultiples"));
			question.setEstElminatoire(rs.getBoolean("estEliminatoire"));
			question.setNiveau(niveauDao.findOne(rs.getLong("idNIVEAU")));
			question.setDomaine(domaineDao.findOne(rs.getLong("idDOMAINE")));
			question.setQuestionnaire(questionnaireDao.findOne(rs.getLong("idQUESTIONNAIRE")));
			question.setAdministrateur(administrateurDao.findOne(rs.getLong("idADMINISTRATEUR")));
			questions.add(question);
		}
		return questions;
	}

	@Override
	public Question update(Question question) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.UPDATE_QUESTION);
		ps.setString(1, question.getEnonce());
		ps.setString(2, question.getLienMedia());
		ps.setBoolean(3, question.isEstChoixMultiples());
		ps.setBoolean(4, question.isEstElminatoire());
		ps.setLong(5, question.getNiveau().getIdNiveau());
		ps.setLong(6, question.getDomaine().getIdDomaine());
		ps.setLong(7, question.getQuestionnaire().getIdQuestionnaire());
		ps.setLong(8, question.getAdministrateur().getIdUtilisateur());
		ps.setLong(9, question.getIdQuestion());
		ps.executeUpdate();
		return question;
	}

	@Override
	public boolean delete(Long id) throws SQLException {
		if (findOne(id) == null) {
			return false;
			}
		PreparedStatement ps = connexion.prepareStatement(Requetes.SUPPRESSION_QUESTION);
		ps.setLong(1, id);
		ps.executeUpdate();
		return true;
	}

	@Override
	protected void finalize() throws Throwable {
		connexion.close();
	}

}
