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
		boolean valid = true;
		if (input.size() != 4) {
			valid = false;
		}
		Pattern pattern = Pattern.compile("(||_| )*");
		for (int i=0; i < 3; i++) {
			Matcher matcher = pattern.matcher(input.get(i));
			valid = valid && matcher.matches();
		}
		return valid;
	}
}
