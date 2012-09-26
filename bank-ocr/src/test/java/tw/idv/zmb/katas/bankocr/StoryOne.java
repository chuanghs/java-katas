package tw.idv.zmb.katas.bankocr;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class StoryOne {
	@Test
	public void validateFourLines() {
		List<String> input = Arrays.asList(new String[] {
				"",
				"",
				"",
				""
		});
		Entry entry = new Entry(input);
		assertThat(entry.isValid(), is(true));
	}
}
