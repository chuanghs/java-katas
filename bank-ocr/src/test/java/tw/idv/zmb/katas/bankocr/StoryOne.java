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
				"                           ",
				"                           ",
				"                           ",
				"                           "
		}, true);
	}
	
	private void validateInputWithResult(String[] lines, boolean result) {
		List<String> input = Arrays.asList(lines);
		Entry entry = new Entry(input);
		assertThat(entry.isValid(), is(result));
	}
	
	@Test
	public void otherLineNumberIsInvalid()  {
		validateInputWithResult(new String[] {
				"                           ",
				"                           ",
				"                           "
		}, false);		
	}
	
	@Test
	public void firstThreeLineContainsOnlyPipeAndUnderScores() {
		validateInputWithResult(new String[] {
				"                           ",
				"  a                   kadf ",
				"                           ",
				"                           "
		}, false);		
	}
}
