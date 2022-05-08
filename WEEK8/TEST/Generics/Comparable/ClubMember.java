package TEST;

public class ClubMember implements Comparable<ClubMember>{
	private String name;
    private int height;

    public ClubMember(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return this.name;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public String toString() {
        return this.getName() + " (" + this.getHeight() + ")";
    }

    @Override
    public int compareTo(ClubMember clubMember) {
        if(this.height == clubMember.getHeight()) {
            return 0;
        } else if (this.height > clubMember.getHeight()) {
            return 1;
        } else {
            return -1;
        }
    }
    
    /*@Override
    public int compareTo(ClubMember clubMember) {
        return this.height - clubMember.getHeight();
    }*/
}
