package fr.humanbooster.fx.test_technique.business;

public class Formation {
	private Long idFormation;
	private String intitule;
	private String description;

	public Formation() {
	}

	public Formation(String intitule, String description) {
		this.intitule = intitule;
		this.description = description;
	}

	public Formation(Long idFormation, String intitule, String description) {
		this.idFormation = idFormation;
		this.intitule = intitule;
		this.description = description;
	}

	public Long getIdFormation() {
		return idFormation;
	}

	public String getIntitule() {
		return intitule;
	}

	public String getDescription() {
		return description;
	}

	public void setIdFormation(Long idFormation) {
		this.idFormation = idFormation;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((idFormation == null) ? 0 : idFormation.hashCode());
		result = prime * result + ((intitule == null) ? 0 : intitule.hashCode());
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
		Formation other = (Formation) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idFormation == null) {
			if (other.idFormation != null)
				return false;
		} else if (!idFormation.equals(other.idFormation))
			return false;
		if (intitule == null) {
			if (other.intitule != null)
				return false;
		} else if (!intitule.equals(other.intitule))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Formation [idFormation=" + idFormation + ", intitule=" + intitule + ", description=" + description
				+ "]";
	}
}
