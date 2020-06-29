package fr.humanbooster.fx.test_technique.business;

public class Bareme {
	private int minimum;
	private Questionnaire questionnaire;
	private Domaine domaine;

	public Bareme() {
	}

	public Bareme(int minimum) {
		this.minimum = minimum;
	}

	public Bareme(int minimum, Questionnaire questionnaire, Domaine domaine) {
		this.minimum = minimum;
		this.questionnaire = questionnaire;
		this.domaine = domaine;
	}

	public int getMinimum() {
		return minimum;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public Domaine getDomaine() {
		return domaine;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domaine == null) ? 0 : domaine.hashCode());
		result = prime * result + minimum;
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
		Bareme other = (Bareme) obj;
		if (domaine == null) {
			if (other.domaine != null)
				return false;
		} else if (!domaine.equals(other.domaine))
			return false;
		if (minimum != other.minimum)
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
		return "Bareme [minimum=" + minimum + ", questionnaire=" + questionnaire + ", domaine=" + domaine + "]";
	}
}
