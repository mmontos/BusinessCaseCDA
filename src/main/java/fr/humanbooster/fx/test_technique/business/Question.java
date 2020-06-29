package fr.humanbooster.fx.test_technique.business;

public class Question {
	private Long idQuestion;
	private String enonce;
	private String lienMedia;
	private boolean estChoixMultiples;
	private boolean estElminatoire;
	private Niveau niveau;
	private Domaine domaine;
	private Questionnaire questionnaire;
	private Administrateur administrateur;

	public Question() {
	}

	public Question(String enonce, String lienMedia, boolean estChoixMultiples, boolean estElminatoire, Niveau niveau,
			Domaine domaine, Questionnaire questionnaire, Administrateur administrateur) {
		this.enonce = enonce;
		this.lienMedia = lienMedia;
		this.estChoixMultiples = estChoixMultiples;
		this.estElminatoire = estElminatoire;
		this.niveau = niveau;
		this.domaine = domaine;
		this.questionnaire = questionnaire;
		this.administrateur = administrateur;
	}

	public Question(Long idQuestion, String enonce, String lienMedia, boolean estChoixMultiples, boolean estElminatoire,
			Niveau niveau, Domaine domaine, Questionnaire questionnaire, Administrateur administrateur) {
		this.idQuestion = idQuestion;
		this.enonce = enonce;
		this.lienMedia = lienMedia;
		this.estChoixMultiples = estChoixMultiples;
		this.estElminatoire = estElminatoire;
		this.niveau = niveau;
		this.domaine = domaine;
		this.questionnaire = questionnaire;
		this.administrateur = administrateur;
	}

	public Long getIdQuestion() {
		return idQuestion;
	}

	public String getEnonce() {
		return enonce;
	}

	public String getLienMedia() {
		return lienMedia;
	}

	public boolean isEstChoixMultiples() {
		return estChoixMultiples;
	}

	public boolean isEstElminatoire() {
		return estElminatoire;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public Domaine getDomaine() {
		return domaine;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public Administrateur getAdministrateur() {
		return administrateur;
	}

	public void setIdQuestion(Long idQuestion) {
		this.idQuestion = idQuestion;
	}

	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}

	public void setLienMedia(String lienMedia) {
		this.lienMedia = lienMedia;
	}

	public void setEstChoixMultiples(boolean estChoixMultiples) {
		this.estChoixMultiples = estChoixMultiples;
	}

	public void setEstElminatoire(boolean estElminatoire) {
		this.estElminatoire = estElminatoire;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((administrateur == null) ? 0 : administrateur.hashCode());
		result = prime * result + ((domaine == null) ? 0 : domaine.hashCode());
		result = prime * result + ((enonce == null) ? 0 : enonce.hashCode());
		result = prime * result + (estChoixMultiples ? 1231 : 1237);
		result = prime * result + (estElminatoire ? 1231 : 1237);
		result = prime * result + ((idQuestion == null) ? 0 : idQuestion.hashCode());
		result = prime * result + ((lienMedia == null) ? 0 : lienMedia.hashCode());
		result = prime * result + ((niveau == null) ? 0 : niveau.hashCode());
		result = prime * result + ((questionnaire == null) ? 0 : questionnaire.hashCode());
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
		Question other = (Question) obj;
		if (administrateur == null) {
			if (other.administrateur != null)
				return false;
		} else if (!administrateur.equals(other.administrateur))
			return false;
		if (domaine == null) {
			if (other.domaine != null)
				return false;
		} else if (!domaine.equals(other.domaine))
			return false;
		if (enonce == null) {
			if (other.enonce != null)
				return false;
		} else if (!enonce.equals(other.enonce))
			return false;
		if (estChoixMultiples != other.estChoixMultiples)
			return false;
		if (estElminatoire != other.estElminatoire)
			return false;
		if (idQuestion == null) {
			if (other.idQuestion != null)
				return false;
		} else if (!idQuestion.equals(other.idQuestion))
			return false;
		if (lienMedia == null) {
			if (other.lienMedia != null)
				return false;
		} else if (!lienMedia.equals(other.lienMedia))
			return false;
		if (niveau == null) {
			if (other.niveau != null)
				return false;
		} else if (!niveau.equals(other.niveau))
			return false;
		if (questionnaire == null) {
			if (other.questionnaire != null)
				return false;
		} else if (!questionnaire.equals(other.questionnaire))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Question [idQuestion=" + idQuestion + ", enonce=" + enonce + ", lienMedia=" + lienMedia
				+ ", estChoixMultiples=" + estChoixMultiples + ", estElminatoire=" + estElminatoire + ", niveau="
				+ niveau + ", domaine=" + domaine + ", questionnaire=" + questionnaire + ", administrateur="
				+ administrateur + "]";
	}
}
