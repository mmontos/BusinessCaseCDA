package fr.humanbooster.fx.test_technique.business;

public class Questionnaire {
	private Long idQuestionnaire;

	public Questionnaire() {
	}

	public Questionnaire(Long idQuestionnaire) {
		this.idQuestionnaire = idQuestionnaire;
	}

	public Long getIdQuestionnaire() {
		return idQuestionnaire;
	}

	public void setIdQuestionnaire(Long idQuestionnaire) {
		this.idQuestionnaire = idQuestionnaire;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idQuestionnaire == null) ? 0 : idQuestionnaire.hashCode());
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
		Questionnaire other = (Questionnaire) obj;
		if (idQuestionnaire == null) {
			if (other.idQuestionnaire != null)
				return false;
		} else if (!idQuestionnaire.equals(other.idQuestionnaire))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Questionnaire [idQuestionnaire=" + idQuestionnaire + "]";
	}
}
