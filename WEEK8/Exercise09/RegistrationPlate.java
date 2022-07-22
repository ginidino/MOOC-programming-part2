package Week08;

// Exercise 9: Car Registration Centre
// Exercise 9.1: Registration Plate Equals and HashCode
public class RegistrationPlate {
	// ATTENTION: the object variable types are final, meaning that their value cannot be changed!
    private final String regCode;
    private final String country;

    
    public RegistrationPlate(String regCode, String country) {
       this.regCode = regCode;
       this.country = country;
    }
    
    public String toString(){
        return country +  " " + regCode;
    }
    
    public boolean equals(Object object) {
    	if (object == null) {
    		return false;
    	}
    	if (this.getClass() != object.getClass()) {
    		return false;
    	}
    	
    	RegistrationPlate compared = (RegistrationPlate) object;
    	
    	if (this.regCode != compared.regCode || this.country != compared.country) {
    		return false;
    	}
    	return true;
    }
    
    public int hashCode() {
    	if (this.regCode == null) {
    		return 7;
    	}
    	return this.country.hashCode() + this.regCode.hashCode();
    }
}
