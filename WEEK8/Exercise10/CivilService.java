package Week08;

// Exercise 10: NationalService
// Exercise 10.1: CivilService
public class CivilService implements NationalService {
	private int dayLeft;

	public CivilService() {
		this.dayLeft = 362;
	}
	
	@Override
	public int getDaysLeft() {
		// returns the number of days left on service
		return this.dayLeft;
	}

	@Override
	public void work() {
		// reduces the working days by one. The working days number can not become negative
		if (this.dayLeft > 0) {
			this.dayLeft--;
		}
	}
}
