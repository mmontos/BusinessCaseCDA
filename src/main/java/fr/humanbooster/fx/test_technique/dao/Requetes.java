package fr.humanbooster.fx.test_technique.dao;

public class Requetes {

	// UTILISATEUR
	public static final String AJOUT_UTILISATEUR = "INSERT INTO utilisateur (nom, prenom, email, motDePasseSHA) VALUES (?, ?, ?, ?)";
	public static final String UTILISATEUR_PAR_ID = "SELECT id, utilisateur_id FROM utilisateur WHERE id=?";
	public static final String TOUS_LES_UTILISATEURS = "SELECT id, nom, prenom, email, motDePasseSHA FROM utilisateur";
	public static final String UPDATE_UTILISATEUR_MOT_DE_PASSE = "UPDATE utilisateur SET motDePasse=? WHERE id=?";
	public static final String SUPPRESSION_UTILISATEUR = "DELETE FROM utilisateur WHERE id=?";

	public static final String AJOUT_FORMATION = "INSERT INTO formation (intitule, description) VALUES (?, ?)";
	public static final String FORMATION_PAR_ID = "SELECT id, intitule, description FROM formation WHERE id=?";
	public static final String TOUTES_LES_FORMATIONS = "SELECT id, intitule, description FROM utilisateur";
	public static final String SUPPRESSION_FORMATION = "DELETE FROM formation WHERE id=?";

	public static final String AJOUT_STAGIAIRE = "INSERT INTO stagiaire (dateNaissance, numPoleEmploi, estHandicape, idUtilisateur) VALUES (?, ?, ?, ?)";
	public static final String STAGIAIRE_PAR_ID = "SELECT id, dateNaissance, numPoleEmploi, estHandicape FROM stagiaire WHERE id=?";
	public static final String TOUS_LES_STAGIAIRES = "SELECT id, dateNaissance, numPoleEmploi, estHandicape FROM stagiaire";
	public static final String SUPPRESSION_STAGIAIRE = "DELETE FROM stagiaire WHERE id=?";

	public static final String AJOUT_CHEF_PROJET = null;

}
