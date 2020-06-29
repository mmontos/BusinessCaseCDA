package fr.humanbooster.fx.test_technique.business;

public class Convocation {
	private Long idConvocation;
	private boolean acceptation;
	private boolean presence;
	private String lienSignature;
	private Stagiaire stagiaire;
	private Entretien entretien;
	private Recrutement recrutement;

	public Convocation() {
	}

	public Convocation(boolean acceptation, boolean presence, String lienSignature, Stagiaire stagiaire,
			Entretien entretien, Recrutement recrutement) {
		this.acceptation = acceptation;
		this.presence = presence;
		this.lienSignature = lienSignature;
		this.stagiaire = stagiaire;
		this.entretien = entretien;
		this.recrutement = recrutement;
	}

	public Convocation(Long idConvocation, boolean acceptation, boolean presence, String lienSignature,
			Stagiaire stagiaire, Entretien entretien, Recrutement recrutement) {
		this.idConvocation = idConvocation;
		this.acceptation = acceptation;
		this.presence = presence;
		this.lienSignature = lienSignature;
		this.stagiaire = stagiaire;
		this.entretien = entretien;
		this.recrutement = recrutement;
	}

	public Long getIdConvocation() {
		return idConvocation;
	}

	public boolean isAcceptation() {
		return acceptation;
	}

	public boolean isPresence() {
		return presence;
	}

	public String getLienSignature() {
		return lienSignature;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public Entretien getEntretien() {
		return entretien;
	}

	public Recrutement getRecrutement() {
		return recrutement;
	}

	public void setIdConvocation(Long idConvocation) {
		this.idConvocation = idConvocation;
	}

	public void setAcceptation(boolean acceptation) {
		this.acceptation = acceptation;
	}

	public void setPresence(boolean presence) {
		this.presence = presence;
	}

	public void setLienSignature(String lienSignature) {
		this.lienSignature = lienSignature;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	public void setEntretien(Entretien entretien) {
		this.entretien = entretien;
	}

	public void setRecrutement(Recrutement recrutement) {
		this.recrutement = recrutement;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (acceptation ? 1231 : 1237);
		result = prime * result + ((idConvocation == null) ? 0 : idConvocation.hashCode());
		result = prime * result + ((lienSignature == null) ? 0 : lienSignature.hashCode());
		result = prime * result + (presence ? 1231 : 1237);
		result = prime * result + ((recrutement == null) ? 0 : recrutement.hashCode());
		result = prime * result + ((stagiaire == null) ? 0 : stagiaire.hashCode());
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
		Convocation other = (Convocation) obj;
		if (acceptation != other.acceptation)
			return false;
		if (idConvocation == null) {
			if (other.idConvocation != null)
				return false;
		} else if (!idConvocation.equals(other.idConvocation))
			return false;
		if (lienSignature == null) {
			if (other.lienSignature != null)
				return false;
		} else if (!lienSignature.equals(other.lienSignature))
			return false;
		if (presence != other.presence)
			return false;
		if (recrutement == null) {
			if (other.recrutement != null)
				return false;
		} else if (!recrutement.equals(other.recrutement))
			return false;
		if (stagiaire == null) {
			if (other.stagiaire != null)
				return false;
		} else if (!stagiaire.equals(other.stagiaire))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Convocation [idConvocation=" + idConvocation + ", acceptation=" + acceptation + ", presence=" + presence
				+ ", lienSignature=" + lienSignature + ", stagiaire=" + stagiaire + ", recrutement=" + recrutement
				+ "]";
	}

}
