//hello

package fr.humanbooster.fx.test_technique.business;

public class Administrateur extends Utilisateur {

	public Administrateur() {
		super();
	}

	public Administrateur(Long idUtilisateur, String nom, String prenom, String email, String motDePasse) {
		super(idUtilisateur, nom, prenom, email, motDePasse);
	}

	public Administrateur(String nom, String prenom, String email, String motDePasse) {
		super(nom, prenom, email, motDePasse);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Administrateur [idUtilisateur=" + getIdUtilisateur() + ", nom=" + getNom() + ", prenom=" + getPrenom()
				+ ", email=" + getEmail() + "]";
	}
}