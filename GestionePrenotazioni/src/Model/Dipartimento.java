package Model;

public class Dipartimento {
	public Dipartimento() {
		
	}
	@Override
	public String toString() {
		return "Dipartimento [dip=" + dip + ", ammDip=" + ammDip + "]";
	}
	public String getDip() {
		return dip;
	}
	public void setDip(String dip) {
		this.dip = dip;
	}
	public String getAmmDip() {
		return ammDip;
	}
	public void setAmmDip(String ammDip) {
		this.ammDip = ammDip;
	}
	private String dip;
	private String ammDip;
}
