package tw.idv.zmb.katas.bankocr;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


public class StoryTwo {
	@Test
	public void validAccountNumber() {
		List<String> input = Arrays.asList(new String[] {
				" _     _  _  _  _  _  _  _ ",
				" _||_||_ |_||_| _||_||_ |_ ",
				" _|  | _||_||_||_ |_||_| _|",
				"                           "
		});
		Entry entry = new Entry(input);
		assertThat(entry.isValid(), is(true));
		assertThat(entry.getAccountNumber(), equalTo("345882865"));
		assertThat(entry.getCheckSum(), equalTo(0));
	}
	
	@Test
	public void invalidAccountNumber() {
		List<String> input = Arrays.asList(new String[] {
				" _     _  _  _  _  _  _  _ ",
				" _||_||_ |_||_| _||_||_ |_ ",
				"|_   | _||_||_||_ |_||_| _|",
				"                           "
		});		
		Entry entry = new Entry(input);
		assertThat(entry.isValid(), is(false));
		assertThat(entry.getCheckSum(), equalTo(2));
		assertThat(entry.getAccountNumber(), equalTo(""));
	}
}
