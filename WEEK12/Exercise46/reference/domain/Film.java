package reference.domain;

// Exercise 46: Film Reference
// Exercise 46.1: Person and Film
public class Film {
	private String name;

	public Film(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == null) {
    		return false;
    	}
		
		if (this.getClass() != object.getClass()) {
    		return false;
    	}
		
		Film compared = (Film) object;
		
		if (this.name != compared.name) {
			return false;
		}
		
		/*if ((this.name == null) ? (compared.name != null) : !this.name.equals(compared.name)) {
    		return false;
    	}*/
    	return true;
	}
	
	@Override
    public int hashCode() {
		if (this.name == null) {
            return 7;
        }
		return this.name.hashCode();
	}
}