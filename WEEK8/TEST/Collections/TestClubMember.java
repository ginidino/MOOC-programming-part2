package TEST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestClubMember {
	public static void main(String[] args) {
		List<ClubMember> clubMembers = new ArrayList<ClubMember>();
	    clubMembers.add(new ClubMember("mikael", 182));
	    clubMembers.add(new ClubMember("matti", 187));
	    clubMembers.add(new ClubMember("joel", 184));

	    System.out.println(clubMembers);
	    Collections.sort(clubMembers);
	    System.out.println(clubMembers);
	    System.out.println();
	    
	    // Collections - search
	    List<ClubMember> clubMember = new ArrayList<ClubMember>();
	    clubMember.add(new ClubMember("mikael", 182));
	    clubMember.add(new ClubMember("matti", 187));
	    clubMember.add(new ClubMember("joel", 184));

	    Collections.sort(clubMember);

	    ClubMember wanted = new ClubMember("Name", 180);
	    int index = Collections.binarySearch(clubMember, wanted);
	    if (index >= 0) {
	        System.out.println("A person who is 180 centimeters tall was found at index " + index);
	        System.out.println("name: " + clubMember.get(index).getName());
	    }

	    wanted = new ClubMember("Name", 187);
	    index = Collections.binarySearch(clubMember, wanted);
	    if (index >= 0) {
	        System.out.println("A person who is 187 centimeters tall was found at index " + index);
	        System.out.println("name: " + clubMember.get(index).getName());
	    }
	}
}
