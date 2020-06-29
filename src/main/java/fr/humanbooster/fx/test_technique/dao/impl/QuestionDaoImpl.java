package fr.humanbooster.fx.test_technique.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.humanbooster.fx.test_technique.business.Administrateur;
import fr.humanbooster.fx.test_technique.business.Domaine;
import fr.humanbooster.fx.test_technique.business.Niveau;
import fr.humanbooster.fx.test_technique.business.Question;
import fr.humanbooster.fx.test_technique.business.Questionnaire;
import fr.humanbooster.fx.test_technique.dao.AdministrateurDao;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

			Long idNiveau = rs.getLong("idNIVEAU");
			Niveau niveau = niveauDao.findOne(idNiveau);
			question.setNiveau(niveau);

			Long idDomaine = rs.getLong("idDOMAINE");
			Domaine domaine = domaineDao.findOne(idDomaine);
			question.setDomaine(domaine);

			Long idQuestionnaire = rs.getLong("idQUESTIONNAIRE");
			Questionnaire questionnaire = questionnaireDao.findOne(idQuestionnaire);
			question.setQuestionnaire(questionnaire);

			Long idAdministrateur = rs.getLong("idADMINISTRATEUR");
			Administrateur administrateur = administrateurDao.findOne(idAdministrateur);
			question.setAdministrateur(administrateur);

		}
		return question;
	}

	@Override
	public List<Question> findByQuestionnaireAndByDomaine(Questionnaire questionnaire, Domaine domaine)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> findByQuestionnaire(Questionnaire questionnaire) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> findByDomaine(Domaine domaine) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> findByNiveau(Niveau niveau) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question update(Question question) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
