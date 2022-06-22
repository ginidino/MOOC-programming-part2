package Week10;

// Exercise 27: The Finnish Ringing Centre
// Exercise 27.1: Bird equals and toString
public class Bird {
	private String name;
    private String latinName;
    private int ringingYear;
    
	public Bird(String name, String latinName, int ringingYear) {
		this.name = name;
		this.latinName = latinName;
		this.ringingYear = ringingYear;
	}
	
	@Override
    public String toString() {
        return this.latinName + "(" + this.ringingYear + ")";
    }
	
	public int hashCode() {
		if(this.latinName == null){
            return 7;
        }
        
        return this.ringingYear + this.latinName.hashCode();
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		if (this.getClass() != other.getClass()) {
			return false;
		}
		
		Bird compared = (Bird) other;
		if (this.latinName == null || !this.latinName.equals(compared.latinName)) {
			return false;
		}
		if (this.ringingYear != compared.ringingYear) {
			return false;
		}
		return true;
	}
}
