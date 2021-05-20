package main.java.CurrentRange;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrentRange
{
  private List<Integer> currentSampleList;
  public Map<String, String> detectedRange;

  public CurrentRange(List<Integer> currentSampleList)
  {
    this.currentSampleList = currentSampleList;
  }

  public List<Integer> getSortedRanges()
  {
    Collections.sort(this.currentSampleList);
    return this.currentSampleList;
  }

  public boolean isEmpty()
  {
    return this.currentSampleList.isEmpty();
  }
  
  public boolean isRangeContainsNull()
  {
	  return this.currentSampleList.contains(null);
  }
  
  public boolean isRangeNull()
  {
	  return this.currentSampleList == null;
  }

  public void detectRange()
  {
	int start=0;
    int readings = 0;
    List<Integer> sortedList = getSortedRanges();
    Map<String,String> ranges = new HashMap<>();
    if(!isRangeNull() && !isRangeContainsNull())
    {
    	ranges.put("Range", "Reading");
		for (int i = 1; i < sortedList.size(); i++) {
			readings++;
			if (sortedList.get(i - 1) + 1 != sortedList.get(i) && sortedList.get(i - 1) != sortedList.get(i)) {
				ranges.put(String.valueOf(sortedList.get(start) - sortedList.get(i - 1)), String.valueOf(readings));
				readings = 0;
				start = i;
			}
		}
		ranges.put(String.valueOf(sortedList.get(start) - sortedList.get(sortedList.size() - 1)), String.valueOf(readings));
		this.detectedRange = ranges;
	}
  }
}
