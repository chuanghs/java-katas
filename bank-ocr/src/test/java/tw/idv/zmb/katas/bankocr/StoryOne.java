package tw.idv.zmb.katas.bankocr;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class StoryOne {
	@Test
	public void validateFourLinesWith27Characters() {
		List<String> input = Arrays.asList(new String[] {
				"                           ",
				"                           ",
				"                           ",
				"                           "
		});
		Entry entry = new Entry(input);
		assertThat(entry.isValid(), is(true));
	}
	
	@Test
	public void otherLineNumberIsInvalid()  {
		List<String> input = Arrays.asList(new String[] {
				"                           ",
				"                           ",
				"                           "
		});		
		Entry entry = new Entry(input);
		assertThat(entry.isValid(), is(false));
	}
	
	@Test
	public void firstThreeLineContainsOnlyPipeAndUnderScores() {
		List<String> input = Arrays.asList(new String[] {
				"                           ",
				"  a                   kadf ",
				"                           ",
				"                           "
		});		
		Entry entry = new Entry(input);
		assertThat(entry.isValid(), is(false));
	}
}
