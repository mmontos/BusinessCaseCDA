package fr.humanbooster.fx.test_technique.business;

import java.util.Date;

public class ChefDeProjet extends Utilisateur {
	private Date dateEmbauche;

	public ChefDeProjet() {
		super();
	}

	public ChefDeProjet(Long idUtilisateur, String nom, String prenom, String email, String motDePasse,
			Date dateEmbauche) {
		super(idUtilisateur, nom, prenom, email, motDePasse);
		this.dateEmbauche = dateEmbauche;
	}

	public ChefDeProjet(String nom, String prenom, String email, String motDePasse, Date dateEmbauche) {
		super(nom, prenom, email, motDePasse);
		this.dateEmbauche = dateEmbauche;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateEmbauche == null) ? 0 : dateEmbauche.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChefDeProjet other = (ChefDeProjet) obj;
		if (dateEmbauche == null) {
			if (other.dateEmbauche != null)
				return false;
		} else if (!dateEmbauche.equals(other.dateEmbauche))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ChefDeProjet [idUtilisateur=" + getIdUtilisateur() + ", nom=" + getNom() + ", prenom=" + getPrenom()
				+ ", email=" + getEmail() + "dateEmbauche=" + dateEmbauche + "]";
	}
}
