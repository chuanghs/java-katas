package tw.idv.zmb.katas.bankocr;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Getter;

public class Entry {
	private List<String> input;
	@Getter
	private boolean valid;
	@Getter
	private String accountNumber = "";
	@Getter
	private int checkSum;

	public Entry(List<String> input) {
		this.input = input;
		valid = validate();
		
		if (isValid()) {
			parseAccountNumber();
		}
	}
	
	private void parseAccountNumber() {
		StringBuilder accountNumberBuilder = new StringBuilder(9);
		for (int i=0; i < 9; i++) {
			String topLine = input.get(0).substring(i * 3, (i+1) * 3);
			String middleLine = input.get(1).substring(i * 3, (i+1) * 3);
			String bottomLine = input.get(2).substring(i*3 , (i+1) * 3);
			String checkLine = input.get(3).substring(i*3, (i+1) * 3);
			accountNumberBuilder.append(convertLinesToCharacter(topLine, middleLine, bottomLine, checkLine));
		}
		accountNumber = accountNumberBuilder.toString();
		checkSum = computeChecksum();
		if (getCheckSum() != 0) {
			accountNumber = "";
			valid = false;
		}
	}
	
	private String convertLinesToCharacter(String topLine, String middleLine, String bottomLine, String checkLine) {
		String line = topLine + middleLine + bottomLine + checkLine;
		switch (line) {
		case "     |  |   ":
			return "1";
		case " _  _||_    ":
			return "2";
		case " _  _| _|   ":
			return "3";
		case "   |_|  |   ":
			return "4";
		case " _ |_  _|   ":
			return "5";
		case " _ |_ |_|   ":
			return "6";
		case " _   |  |   ":
			return "7";
		case " _ |_||_|   ":
			return "8";
		case " _ |_| _|   ":
			return "9";
		case " _ | ||_|   ":
			return "0";
		default:
			return "";
		}
	}

	private boolean validate() {
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

	public int computeChecksum() {
		int checksum = 0;
		for (int i=0; i < accountNumber.length(); i++) {
			int digit = Integer.parseInt("" + accountNumber.charAt(i));
			checksum += digit * (9-i);
		}
		checksum %= 11;
		return checksum;
	}

}
