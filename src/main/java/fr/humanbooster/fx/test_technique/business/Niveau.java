package fr.humanbooster.fx.test_technique.business;

public class Niveau {
	private Long idNiveau;
	private String nom;

	public Niveau() {
	}

	public Niveau(String nom) {
		this.nom = nom;
	}

	public Niveau(Long idNiveau, String nom) {
		this.idNiveau = idNiveau;
		this.nom = nom;
	}

	public Long getIdNiveau() {
		return idNiveau;
	}

	public String getNom() {
		return nom;
	}

	public void setIdNiveau(Long idNiveau) {
		this.idNiveau = idNiveau;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idNiveau == null) ? 0 : idNiveau.hashCode());
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
		Niveau other = (Niveau) obj;
		if (idNiveau == null) {
			if (other.idNiveau != null)
				return false;
		} else if (!idNiveau.equals(other.idNiveau))
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
		return "Niveau [idNiveau=" + idNiveau + ", nom=" + nom + "]";
	}
}
