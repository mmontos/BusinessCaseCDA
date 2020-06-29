package fr.humanbooster.fx.test_technique.business;

import java.util.Date;

public class Entretien {
	private Long idEntretien;
	private String notes;
	private Date horairePassage;
	private Enseignant enseignant;
	private ChefDeProjet chefDeProjet;
	private Convocation convocation;

	public Entretien() {
	}

	public Entretien(String notes, Date horairePassage, Enseignant enseignant, ChefDeProjet chefDeProjet,
			Convocation convocation) {
		this.notes = notes;
		this.horairePassage = horairePassage;
		this.enseignant = enseignant;
		this.chefDeProjet = chefDeProjet;
		this.convocation = convocation;
	}

	public Entretien(Long idEntretien, String notes, Date horairePassage, Enseignant enseignant,
			ChefDeProjet chefDeProjet, Convocation convocation) {
		this.idEntretien = idEntretien;
		this.notes = notes;
		this.horairePassage = horairePassage;
		this.enseignant = enseignant;
		this.chefDeProjet = chefDeProjet;
		this.convocation = convocation;
	}

	public Long getIdEntretien() {
		return idEntretien;
	}

	public String getNotes() {
		return notes;
	}

	public Date getHorairePassage() {
		return horairePassage;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public ChefDeProjet getChefDeProjet() {
		return chefDeProjet;
	}

	public Convocation getConvocation() {
		return convocation;
	}

	public void setIdEntretien(Long idEntretien) {
		this.idEntretien = idEntretien;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setHorairePassage(Date horairePassage) {
		this.horairePassage = horairePassage;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public void setChefDeProjet(ChefDeProjet chefDeProjet) {
		this.chefDeProjet = chefDeProjet;
	}

	public void setConvocation(Convocation convocation) {
		this.convocation = convocation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chefDeProjet == null) ? 0 : chefDeProjet.hashCode());
		result = prime * result + ((convocation == null) ? 0 : convocation.hashCode());
		result = prime * result + ((enseignant == null) ? 0 : enseignant.hashCode());
		result = prime * result + ((horairePassage == null) ? 0 : horairePassage.hashCode());
		result = prime * result + ((idEntretien == null) ? 0 : idEntretien.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
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
		Entretien other = (Entretien) obj;
		if (chefDeProjet == null) {
			if (other.chefDeProjet != null)
				return false;
		} else if (!chefDeProjet.equals(other.chefDeProjet))
			return false;
		if (convocation == null) {
			if (other.convocation != null)
				return false;
		} else if (!convocation.equals(other.convocation))
			return false;
		if (enseignant == null) {
			if (other.enseignant != null)
				return false;
		} else if (!enseignant.equals(other.enseignant))
			return false;
		if (horairePassage == null) {
			if (other.horairePassage != null)
				return false;
		} else if (!horairePassage.equals(other.horairePassage))
			return false;
		if (idEntretien == null) {
			if (other.idEntretien != null)
				return false;
		} else if (!idEntretien.equals(other.idEntretien))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Entretien [idEntretien=" + idEntretien + ", notes=" + notes + ", horairePassage=" + horairePassage
				+ ", enseignant=" + enseignant + ", chefDeProjet=" + chefDeProjet + ", convocation=" + convocation
				+ "]";
	}
}
