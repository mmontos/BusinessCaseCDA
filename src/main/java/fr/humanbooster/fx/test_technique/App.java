package fr.humanbooster.fx.test_technique;

import java.util.Date;

import fr.humanbooster.fx.test_technique.business.Administrateur;
import fr.humanbooster.fx.test_technique.business.Bareme;
import fr.humanbooster.fx.test_technique.business.ChefDeProjet;
import fr.humanbooster.fx.test_technique.business.Convocation;
import fr.humanbooster.fx.test_technique.business.Domaine;
import fr.humanbooster.fx.test_technique.business.Enseignant;
import fr.humanbooster.fx.test_technique.business.Entretien;
import fr.humanbooster.fx.test_technique.business.Formation;
import fr.humanbooster.fx.test_technique.business.Niveau;
import fr.humanbooster.fx.test_technique.business.Question;
import fr.humanbooster.fx.test_technique.business.Questionnaire;
import fr.humanbooster.fx.test_technique.business.Recrutement;
import fr.humanbooster.fx.test_technique.business.Repondre;
import fr.humanbooster.fx.test_technique.business.Reponse;
import fr.humanbooster.fx.test_technique.business.Session;
import fr.humanbooster.fx.test_technique.business.Stagiaire;

public class App {

	public static void main(String[] args) {
		Administrateur administrateur = new Administrateur(1l, "nom", "prénom", "email", "mot de passe");
		Bareme bareme = new Bareme();
		ChefDeProjet chefDeProjet = new ChefDeProjet(1l, "nom", "prénom", "email", "mot de passe", new Date());
		Stagiaire stagiaire = new Stagiaire(1l, "nom", "prénom", "email", "mot de passe", new Date(), "numéro PE",
				false);
		Domaine domaine = new Domaine(1l, "nom");
		Enseignant enseignant = new Enseignant(1l, "nom", "prénom");
		Formation formation = new Formation(1l, "intitulé", "déscription");
		Session session = new Session(1l, 10, 17, formation);
		Questionnaire questionnaire = new Questionnaire(1l);
		Recrutement recrutement = new Recrutement(1l, "lieu", new Date(), 10, 30, session, questionnaire);
		Convocation convocation = new Convocation(1l, false, false, "lienSignature", stagiaire, null, recrutement);
		Entretien entretien = new Entretien(1l, "notes", new Date(), enseignant, chefDeProjet, convocation);
		convocation.setEntretien(entretien);
		Niveau niveau = new Niveau(1l, "niveau");
		Question question = new Question(1l, "énoncé", "lien média", false, false, niveau, domaine, questionnaire,
				administrateur);
		Reponse reponse = new Reponse(1l, "libellé", true, question);
		Repondre repondre = new Repondre(true, convocation, reponse);

		System.out.println(administrateur);
		System.out.println(bareme);
		System.out.println(chefDeProjet);
		System.out.println(stagiaire);
		System.out.println(domaine);
		System.out.println(enseignant);
		System.out.println(formation);
		System.out.println(session);
		System.out.println(questionnaire);
		System.out.println(recrutement);
		System.out.println(convocation);
		System.out.println(entretien);
		System.out.println(niveau);
		System.out.println(question);
		System.out.println(reponse);
		System.out.println(repondre);
	}
}
