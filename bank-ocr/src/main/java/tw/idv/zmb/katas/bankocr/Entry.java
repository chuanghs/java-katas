package tw.idv.zmb.katas.bankocr;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Entry {
	private List<String> input;

	public Entry(List<String> input) {
		this.input = input;
	}
	
	public boolean isValid() {
		if (input.size() != 4) {
			return false;
		} 
		
		boolean valid = true;
		
		Pattern pattern = Pattern.compile("[|_ ]{27}");
		for (int i=0; i < 3; i++) {
			Matcher matcher = pattern.matcher(input.get(i));
			valid = valid && matcher.matches();
		}
		
		Pattern blankLinePattern = Pattern.compile("( ){27}");
		Matcher blankLineMatcher = blankLinePattern.matcher(input.get(3));
		valid = valid && blankLineMatcher.matches();
		
		return valid;
	}
}
