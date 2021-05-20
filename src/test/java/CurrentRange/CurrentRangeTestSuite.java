package test.java.CurrentRange;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import main.java.CurrentRange.CurrentRange;

public class CurrentRangeTestSuite 
{
	List<Integer> listReadings;
	Map<String,String> expectedValues = new HashMap<>();
	
	@Before
	public void executedBeforeEach() {
		listReadings = Arrays.asList(3, 3, 5, 4, 10, 11, 12);
		
		expectedValues.put("Range", "Reading");
		expectedValues.put("1-3","4");
		expectedValues.put("6-8","3");
	}
	
	@Test
	public void givenList_whenEmpty_thenReturnTrue() 
	{
		listReadings = new ArrayList<Integer>();
		boolean actualValue = new CurrentRange(listReadings).isEmpty();
		assertTrue(actualValue);
	}
	
	
	  @Test public void givenList_whenNull_thenReturnTrue() 
	  { 
		  listReadings = null;
		  boolean actualValue = new CurrentRange(listReadings).isRangeNull();
		  assertTrue(actualValue);
	  }
	  
	  @Test public void givenList_whenContainsNull_thenReturnTrue() 
	  { 
		  listReadings = Arrays.asList(3, null, 5, 4, 10, 11, 12);
		  boolean actualValue = new CurrentRange(listReadings).isRangeContainsNull();
		  assertTrue(actualValue);
	  }
	 
	  @Test 
	  public void givenList_whenContainsValues_thenReturnRangeAndCount() 
	  {
	   List<Integer> currentSampleList = Arrays.asList(3, 3, 5, 4, 10, 11, 12);
		 CurrentRange rangeList = new CurrentRange(currentSampleList);
		 rangeList.detectRange();
		 assertEquals(expectedValues, rangeList.detectedRange);
		}
	
}
