package tw.idv.zmb.katas.bankocr;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class StoryThree {

	@Test
	public void illegibleCharacterShowAsQuestionMark() {
		List<String> input = Arrays.asList(new String[] {
				" _  _  _  _  _  _  _  _  _ ",
				" _||_||_ |_||_| _||_||_ |_ ",
				" _|  | _||_||_||_||_||_| _|",
				"                           "
		});
		Entry entry = new Entry(input);
		assertThat(entry.isValid(), is(false));
		assertThat(entry.getAccountNumber(), equalTo("3?588?865"));
		assertThat(entry.getCheckSum(), equalTo(-1));
		assertThat(entry.toString(), equalTo("3?588?865 ILL"));
	}
	
	@Test
	public void validAccountNumber() {
		List<String> input = Arrays.asList(new String[] {
				" _     _  _  _  _  _  _  _ ",
				" _||_||_ |_||_| _||_||_ |_ ",
				" _|  | _||_||_||_ |_||_| _|",
				"                           "
		});
		Entry entry = new Entry(input);
		assertThat(entry.toString(), equalTo("345882865"));
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
		assertThat(entry.toString(), equalTo("245882865 ERR"));
	}
}
