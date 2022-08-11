package reader;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Exercise 47: Flexible Filtering Criteria
public class GutenbergReader {
	private List<String> lines;
	
	public GutenbergReader(String address) throws IllegalArgumentException {
		lines = new ArrayList<String>();
        try {
            URL url = new URL(address);
            Scanner reader = new Scanner(url.openStream());
            while (reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public List<String> linesWhichComplyWith(Criterion c){
        List<String> complyingLines = new ArrayList<String>();

        for (String line : lines) {
            if (c.complies(line)) {
                complyingLines.add(line);
            }
        }

        return complyingLines;
    }
}
