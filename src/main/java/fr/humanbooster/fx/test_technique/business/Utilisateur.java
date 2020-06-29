package fr.humanbooster.fx.test_technique.business;

import org.apache.commons.codec.digest.DigestUtils;

public abstract class Utilisateur {

	private Long idUtilisateur;
	private String nom;
	private String prenom;
	private String email;
	private String motDePasseSHA;

	public Utilisateur() {

	}

	public Utilisateur(Long idUtilisateur, String nom, String prenom, String email, String motDePasse) {
		this.idUtilisateur = idUtilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		setMotDePasseSHA(motDePasse);
	}

	public Utilisateur(String nom, String prenom, String email, String motDePasse) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		setMotDePasseSHA(motDePasse);
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getEmail() {
		return email;
	}

	public String getMotDePasseSHA() {
		return motDePasseSHA;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMotDePasseSHA(String motDePasse) {
		this.motDePasseSHA = DigestUtils.sha256Hex(motDePasse);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((idUtilisateur == null) ? 0 : idUtilisateur.hashCode());
		result = prime * result + ((motDePasseSHA == null) ? 0 : motDePasseSHA.hashCode());
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
		Utilisateur other = (Utilisateur) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idUtilisateur == null) {
			if (other.idUtilisateur != null)
				return false;
		} else if (!idUtilisateur.equals(other.idUtilisateur))
			return false;
		if (motDePasseSHA == null) {
			if (other.motDePasseSHA != null)
				return false;
		} else if (!motDePasseSHA.equals(other.motDePasseSHA))
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
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", email="
				+ email + "]";
	}
}
