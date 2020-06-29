package fr.humanbooster.fx.test_technique.business;

public class Reponse {
	private Long idReponse;
	private String libelle;
	private boolean estCorrecte;
	private Question question;

	public Reponse() {
	}

	public Reponse(String libelle, boolean estCorrecte, Question question) {
		this.libelle = libelle;
		this.estCorrecte = estCorrecte;
		this.question = question;
	}

	public Reponse(Long idReponse, String libelle, boolean estCorrecte, Question question) {
		this.idReponse = idReponse;
		this.libelle = libelle;
		this.estCorrecte = estCorrecte;
		this.question = question;
	}

	public Long getIdReponse() {
		return idReponse;
	}

	public String getLibelle() {
		return libelle;
	}

	public boolean isEstCorrecte() {
		return estCorrecte;
	}

	public Question getQuestion() {
		return question;
	}

	public void setIdReponse(Long idReponse) {
		this.idReponse = idReponse;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setEstCorrecte(boolean estCorrecte) {
		this.estCorrecte = estCorrecte;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (estCorrecte ? 1231 : 1237);
		result = prime * result + ((idReponse == null) ? 0 : idReponse.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
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
		Reponse other = (Reponse) obj;
		if (estCorrecte != other.estCorrecte)
			return false;
		if (idReponse == null) {
			if (other.idReponse != null)
				return false;
		} else if (!idReponse.equals(other.idReponse))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reponse [idReponse=" + idReponse + ", libelle=" + libelle + ", estCorrecte=" + estCorrecte
				+ ", question=" + question + "]";
	}
}
