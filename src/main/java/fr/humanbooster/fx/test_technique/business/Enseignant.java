package fr.humanbooster.fx.test_technique.business;

public class Enseignant {
	private Long idEnseignant;
	private String nom;
	private String prenom;

	public Enseignant() {
	}

	public Enseignant(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public Enseignant(Long idEnseignant, String nom, String prenom) {
		this.idEnseignant = idEnseignant;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Long getIdEnseignant() {
		return idEnseignant;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setIdEnseignant(Long idEnseignant) {
		this.idEnseignant = idEnseignant;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEnseignant == null) ? 0 : idEnseignant.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
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
		Enseignant other = (Enseignant) obj;
		if (idEnseignant == null) {
			if (other.idEnseignant != null)
				return false;
		} else if (!idEnseignant.equals(other.idEnseignant))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Enseignant [idEnseignant=" + idEnseignant + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

}
