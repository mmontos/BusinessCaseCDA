package fr.humanbooster.fx.test_technique.dao;

public class Requetes {

	// UTILISATEUR
	public static final String AJOUT_UTILISATEUR = "INSERT INTO utilisateur (nom, prenom, email, motDePasseSHA) VALUES (?, ?, ?, ?)";
	public static final String UTILISATEUR_PAR_ID = "SELECT id, utilisateur_id FROM utilisateur WHERE id=?";
	public static final String TOUS_LES_UTILISATEURS = "SELECT id, nom, prenom, email, motDePasseSHA FROM utilisateur";
	public static final String UPDATE_UTILISATEUR_MOT_DE_PASSE = "UPDATE utilisateur SET motDePasse=? WHERE id=?";
	public static final String SUPPRESSION_UTILISATEUR = "DELETE FROM utilisateur WHERE id=?";

	// FORMATION
	public static final String AJOUT_FORMATION = "INSERT INTO formation (intitule, description) VALUES (?, ?)";
	public static final String FORMATION_PAR_ID = "SELECT id, intitule, description FROM formation WHERE id=?";
	public static final String TOUTES_LES_FORMATIONS = "SELECT id, intitule, description FROM utilisateur";
	public static final String SUPPRESSION_FORMATION = "DELETE FROM formation WHERE id=?";

	// STAGIAIRE
	public static final String AJOUT_STAGIAIRE = "INSERT INTO stagiaire (dateNaissance, numPoleEmploi, estHandicape, idUtilisateur) VALUES (?, ?, ?, ?)";
	public static final String STAGIAIRE_PAR_ID = "SELECT id, dateNaissance, numPoleEmploi, estHandicape FROM stagiaire WHERE id=?";
	public static final String TOUS_LES_STAGIAIRES = "SELECT id, dateNaissance, numPoleEmploi, estHandicape FROM stagiaire";
	public static final String SUPPRESSION_STAGIAIRE = "DELETE FROM stagiaire WHERE id=?";

	// CHEF DE PROJET
	public static final String AJOUT_CHEF_PROJET = null;

	// DOMAINE
	public static final String AJOUT_DOMAINE = "INSERT INTO domaine (nom) VALUES (?)";
	public static final String DOMAINE_PAR_ID = "SELECT idDOMAINE, nom FROM domaine WHERE idDOMAINE=?";
	public static final String TOUS_LES_DOMAINES = "SELECT idDOMAINE, nom FROM domaine";
	public static final String UPDATE_DOMAINE_PAR_NOM = "UPDATE domaine SET nom=? WHERE idDOMAINE=?";
	public static final String SUPPRESSION_DOMAINE = "DELETE FROM domaine WHERE idDOMAINE=?";

	// NIVEAU
	public static final String AJOUT_NIVEAU = "INSERT INTO Niveau (nom) VALUES (?)";
	public static final String TOUS_LES_NIVEAUX = "SELECT idNIVEAU, nom FROM Niveau";
	public static final String NIVEAU_PAR_ID = "SELECT idNIVEAU, nom FROM Niveau WHERE idNIVEAU=?";
	public static final String MODIFICATION_NIVEAU = "UPDATE Niveau SET nom=? WHERE idNIVEAU=?";
	public static final String SUPPRESSION_NIVEAU = "DELETE FROM Niveau WHERE idNIVEAU=?";

	// QUESTIONNAIRE
	public static final String AJOUT_QUESTIONNAIRE = "INSERT INTO questionnaire () VALUES ()";
	public static final String TOUS_LES_QUESTIONNAIRES = "SELECT idQUESTIONNAIRE FROM questionnaire";
	public static final String QUESTIONNAIRE_PAR_ID = "SELECT idNIVEAU FROM questionnaire WHERE idQUESTIONNAIRE=?";
	public static final String SUPPRESSION_QUESTIONNAIRE = "DELETE FROM questionnaire WHERE idQUESTIONNAIRE=?";

	// QUESTION
	public static final String AJOUT_QUESTION = "INSERT INTO question (enonce, lienMedia, estChoixMultiples, estEliminatoire, idUTILISATEUR, idQUESTIONNAIRE, idDOMAINE, idNIVEAU) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String QUESTION_PAR_ID = "SELECT idQUESTION, enonce, lienMedia, estChoixMultiples, estEliminatoire, idUTILISATEUR, idQUESTIONNAIRE, idDOMAINE, idNIVEAU FROM question WHERE id=?";
    public static final String QUESTIONS_PAR_QUESTIONNAIRE_ET_DOMAINE = "SELECT idQUESTION, enonce, lienMedia, estChoixMultiples, estEliminatoire, idUTILISATEUR, idNIVEAU FROM question WHERE idQUESTIONNAIRE=? AND idDOMAINE=?";
    public static final String QUESTIONS_PAR_DOMAINE = "SELECT idQUESTION, enonce, lienMedia, estChoixMultiples, estEliminatoire, idUTILISATEUR, idQUESTIONNAIRE, idNIVEAU FROM question WHERE idDOMAINE=?";
    public static final String QUESTIONS_PAR_QUESTIONNAIRE = "SELECT idQUESTION, enonce, lienMedia, estChoixMultiples, estEliminatoire, idUTILISATEUR, idDOMAINE, idNIVEAU FROM question WHERE idQUESTIONNAIRE=?";
    public static final String QUESTIONS_PAR_NIVEAU = "SELECT idQUESTION, enonce, lienMedia, estChoixMultiples, estEliminatoire, idUTILISATEUR, idQUESTIONNAIRE, idDOMAINE FROM question WHERE idNIVEAU=?";
    public static final String UPDATE_QUESTION = "UPDATE question SET enonce=?, lienMedia=?, estChoixMultiples=?, estEliminatoire=?, idUTILISATEUR=?, idQUESTIONNAIRE=?, idDOMAINE=?, idNIVEAU=? WHERE idQUESTION=?";
    public static final String SUPPRESSION_QUESTION = "DELETE FROM question WHERE idQUESTION=?";
    
}
