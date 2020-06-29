package fr.humanbooster.fx.test_technique.business;

public class Repondre {
	private boolean estSelectionne;
	private Convocation convocation;
	private Reponse reponse;

	public Repondre() {
	}

	public Repondre(boolean estSelectionne, Convocation convocation, Reponse reponse) {
		this.estSelectionne = estSelectionne;
		this.convocation = convocation;
		this.reponse = reponse;
	}

	public boolean isEstSelectionne() {
		return estSelectionne;
	}

	public Convocation getConvocation() {
		return convocation;
	}

	public Reponse getReponse() {
		return reponse;
	}

	public void setEstSelectionne(boolean estSelectionne) {
		this.estSelectionne = estSelectionne;
	}

	public void setConvocation(Convocation convocation) {
		this.convocation = convocation;
	}

	public void setReponse(Reponse reponse) {
		this.reponse = reponse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((convocation == null) ? 0 : convocation.hashCode());
		result = prime * result + (estSelectionne ? 1231 : 1237);
		result = prime * result + ((reponse == null) ? 0 : reponse.hashCode());
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
		Repondre other = (Repondre) obj;
		if (convocation == null) {
			if (other.convocation != null)
				return false;
		} else if (!convocation.equals(other.convocation))
			return false;
		if (estSelectionne != other.estSelectionne)
			return false;
		if (reponse == null) {
			if (other.reponse != null)
				return false;
		} else if (!reponse.equals(other.reponse))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Repondre [estSelectionne=" + estSelectionne + ", convocation=" + convocation + ", reponse=" + reponse
				+ "]";
	}
}
