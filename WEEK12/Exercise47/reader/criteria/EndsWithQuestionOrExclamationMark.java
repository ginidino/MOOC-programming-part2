package reader.criteria;

import reader.Criterion;

// Exercise 47: Flexible Filtering Criteria
// Exercise 47.2: Ends with Question or Exclamation Mark
public class EndsWithQuestionOrExclamationMark implements Criterion {

	@Override
	public boolean complies(String line) {
		if (line.isEmpty()) {
			return false;
		}
		
		char lastCharacter = line.charAt(line.length() - 1);
		
		return lastCharacter == '?' || lastCharacter == '!';
	}
}