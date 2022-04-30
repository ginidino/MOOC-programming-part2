package Week08;

// Exercise 10: NationalService
public interface NationalService {
	int getDaysLeft(); // returns the number of days left on service
    void work(); // reduces the working days by one. The working days number can not become negative
}
