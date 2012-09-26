package tw.idv.zmb.katas.bankocr;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class StoryOne {
	@Test
	public void validateFourLinesWith27Characters() {
		validateInputWithResult(new String[] {
				string(' ', 27),
				string(' ', 27),
				string(' ', 27),
				string(' ', 27)
		}, true);
	}
	
	private void validateInputWithResult(String[] lines, boolean result) {
		List<String> input = Arrays.asList(lines);
		Entry entry = new Entry(input);
		assertThat(entry.isValid(), is(result));
	}
	
	private String string(char c, int length) {
		StringBuilder b = new StringBuilder(length);
		for(int i = 0; i < length; i++)
			b.append(c);
		return b.toString();
	}
	
	@Test
	public void otherLineNumberIsInvalid()  {
		validateInputWithResult(new String[] {
				string(' ', 27),
				string(' ', 27),
				string(' ', 27)
		}, false);		
	}
	
	@Test
	public void firstThreeLineContainsOnlyPipeAndUnderScores() {
		validateInputWithResult(new String[] {
				string(' ', 27),
				"  a                   kadf ",
				string(' ', 27),
				string(' ', 27)
		}, false);		
	}
	
	@Test
	public void lastLineMustBeBlank() {
		validateInputWithResult(new String[] {
				string(' ', 27),
				string(' ', 27),
				string(' ', 27),
				"     kadfewqrl2k3          "
		}, false);
	}
}
