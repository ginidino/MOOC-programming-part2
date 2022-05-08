package TEST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestGeneric {
	public static void main(String[] args) {
		List<ClubMember> clubMembers = new ArrayList<ClubMember>();
	    clubMembers.add(new ClubMember("mikael", 182));
	    clubMembers.add(new ClubMember("matti", 187));
	    clubMembers.add(new ClubMember("joel", 184));

	    System.out.println(clubMembers);
	    Collections.sort(clubMembers);
	    System.out.println(clubMembers);
	}
}
