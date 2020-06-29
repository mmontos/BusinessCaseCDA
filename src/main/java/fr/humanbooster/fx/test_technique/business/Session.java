package fr.humanbooster.fx.test_technique.business;

public class Session {
	private Long idSession;
	private int nbPlaces;
	private int numero;
	private Formation formation;

	public Session() {
	}

	public Session(int nbPlaces, int numero, Formation formation) {
		this.nbPlaces = nbPlaces;
		this.numero = numero;
		this.formation = formation;
	}

	public Session(Long idSession, int nbPlaces, int numero, Formation formation) {
		this.idSession = idSession;
		this.nbPlaces = nbPlaces;
		this.numero = numero;
		this.formation = formation;
	}

	public Long getIdSession() {
		return idSession;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public int getNumero() {
		return numero;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setIdSession(Long idSession) {
		this.idSession = idSession;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((formation == null) ? 0 : formation.hashCode());
		result = prime * result + ((idSession == null) ? 0 : idSession.hashCode());
		result = prime * result + nbPlaces;
		result = prime * result + numero;
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
		Session other = (Session) obj;
		if (formation == null) {
			if (other.formation != null)
				return false;
		} else if (!formation.equals(other.formation))
			return false;
		if (idSession == null) {
			if (other.idSession != null)
				return false;
		} else if (!idSession.equals(other.idSession))
			return false;
		if (nbPlaces != other.nbPlaces)
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Session [idSession=" + idSession + ", nbPlaces=" + nbPlaces + ", numero=" + numero + ", formation="
				+ formation + "]";
	}
}
