package fr.humanbooster.fx.test_technique.business;

import java.util.Date;

public class Stagiaire extends Utilisateur {
	private Date dateNaissance;
	private String numPoleEmploi;
	private boolean estHandicape;

	public Stagiaire() {
		super();
	}

	public Stagiaire(Long idUtilisateur, String nom, String prenom, String email, String motDePasse, Date dateNaissance,
			String numPoleEmploi, boolean estHandicape) {
		super(idUtilisateur, nom, prenom, email, motDePasse);
		this.dateNaissance = dateNaissance;
		this.numPoleEmploi = numPoleEmploi;
		this.estHandicape = estHandicape;
	}

	public Stagiaire(String nom, String prenom, String email, String motDePasse, Date dateNaissance,
			String numPoleEmploi, boolean estHandicape) {
		super(nom, prenom, email, motDePasse);
		this.dateNaissance = dateNaissance;
		this.numPoleEmploi = numPoleEmploi;
		this.estHandicape = estHandicape;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public String getNumPoleEmploi() {
		return numPoleEmploi;
	}

	public boolean getEstHandicape() {
		return estHandicape;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public void setNumPoleEmploi(String numPoleEmploi) {
		this.numPoleEmploi = numPoleEmploi;
	}

	public void setEstHandicape(boolean estHandicape) {
		this.estHandicape = estHandicape;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
		result = prime * result + (estHandicape ? 1231 : 1237);
		result = prime * result + ((numPoleEmploi == null) ? 0 : numPoleEmploi.hashCode());
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
		Stagiaire other = (Stagiaire) obj;
		if (dateNaissance == null) {
			if (other.dateNaissance != null)
				return false;
		} else if (!dateNaissance.equals(other.dateNaissance))
			return false;
		if (estHandicape != other.estHandicape)
			return false;
		if (numPoleEmploi == null) {
			if (other.numPoleEmploi != null)
				return false;
		} else if (!numPoleEmploi.equals(other.numPoleEmploi))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Stagiaire [" + super.toString() + "dateNaissance=" + dateNaissance + ", numPoleEmploi=" + numPoleEmploi
				+ ", estHandicape=" + estHandicape + "]";
	}

}
