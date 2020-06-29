package fr.humanbooster.fx.test_technique.business;

public class Domaine {

	private long idDomaine;
	private String nom;

	public Domaine() {
	}

	public Domaine(long idDomaine, String nom) {
		this();
		this.idDomaine = idDomaine;
		this.nom = nom;
	}

	public Domaine(String nom) {
		this();
		this.nom = nom;
	}

	public long getIdDomaine() {
		return idDomaine;
	}

	public String getNom() {
		return nom;
	}

	public void setIdDomaine(long idDomaine) {
		this.idDomaine = idDomaine;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idDomaine ^ (idDomaine >>> 32));
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
		Domaine other = (Domaine) obj;
		if (idDomaine != other.idDomaine)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Domaine [idDomaine=" + idDomaine + ", nom=" + nom + "]";
	}

}
