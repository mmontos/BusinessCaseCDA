package fr.humanbooster.fx.test_technique.business;

import java.util.Date;

public class Recrutement {
	private Long idRecrutement;
	private String lieu;
	private Date dateHeureDebut;
	private int duree;
	private int nbPlaces;
	private Session session;
	private Questionnaire questionnaire;

	public Recrutement() {
	}

	public Recrutement(String lieu, Date dateHeureDebut, int duree, int nbPlaces, Session session,
			Questionnaire questionnaire) {
		this.lieu = lieu;
		this.dateHeureDebut = dateHeureDebut;
		this.duree = duree;
		this.nbPlaces = nbPlaces;
		this.session = session;
		this.questionnaire = questionnaire;
	}

	public Recrutement(Long idRecrutement, String lieu, Date dateHeureDebut, int duree, int nbPlaces, Session session,
			Questionnaire questionnaire) {
		this.idRecrutement = idRecrutement;
		this.lieu = lieu;
		this.dateHeureDebut = dateHeureDebut;
		this.duree = duree;
		this.nbPlaces = nbPlaces;
		this.session = session;
		this.questionnaire = questionnaire;
	}

	public Long getIdRecrutement() {
		return idRecrutement;
	}

	public String getLieu() {
		return lieu;
	}

	public Date getDateHeureDebut() {
		return dateHeureDebut;
	}

	public int getDuree() {
		return duree;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public Session getSession() {
		return session;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setIdRecrutement(Long idRecrutement) {
		this.idRecrutement = idRecrutement;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public void setDateHeureDebut(Date dateHeureDebut) {
		this.dateHeureDebut = dateHeureDebut;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateHeureDebut == null) ? 0 : dateHeureDebut.hashCode());
		result = prime * result + duree;
		result = prime * result + ((idRecrutement == null) ? 0 : idRecrutement.hashCode());
		result = prime * result + ((lieu == null) ? 0 : lieu.hashCode());
		result = prime * result + nbPlaces;
		result = prime * result + ((questionnaire == null) ? 0 : questionnaire.hashCode());
		result = prime * result + ((session == null) ? 0 : session.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recrutement other = (Recrutement) obj;
		if (dateHeureDebut == null) {
			if (other.dateHeureDebut != null)
				return false;
		} else if (!dateHeureDebut.equals(other.dateHeureDebut))
			return false;
		if (duree != other.duree)
			return false;
		if (idRecrutement == null) {
			if (other.idRecrutement != null)
				return false;
		} else if (!idRecrutement.equals(other.idRecrutement))
			return false;
		if (lieu == null) {
			if (other.lieu != null)
				return false;
		} else if (!lieu.equals(other.lieu))
			return false;
		if (nbPlaces != other.nbPlaces)
			return false;
		if (questionnaire == null) {
			if (other.questionnaire != null)
				return false;
		} else if (!questionnaire.equals(other.questionnaire))
			return false;
		if (session == null) {
			if (other.session != null)
				return false;
		} else if (!session.equals(other.session))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Recrutement [idRecrutement=" + idRecrutement + ", lieu=" + lieu + ", dateHeureDebut=" + dateHeureDebut
				+ ", duree=" + duree + ", nbPlaces=" + nbPlaces + ", session=" + session + ", questionnaire="
				+ questionnaire + "]";
	}
}
