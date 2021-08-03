package main.java.CurrentRange;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrentRange {
	private List<Integer> currentSampleList;
	Map<String, Integer> ranges = new HashMap<>();

	public CurrentRange(List<Integer> currentSampleList) {
		this.currentSampleList = currentSampleList;
	}

	public List<Integer> getSortedRanges() {
		Collections.sort(currentSampleList);
		return currentSampleList;
	}

	public boolean isEmpty() {
		return currentSampleList.isEmpty();
	}

	public boolean isRangeContainsNull() {
		return currentSampleList.contains(null);
	}

	public boolean isRangeNull() {
		return this.currentSampleList == null;
	}

	public Map<String, Integer> detectRange() {
		List<Integer> sortedList = getSortedRanges();

		if (isRangeNull() && isRangeContainsNull())
			return null;

		int count = 1;
		int minRange = sortedList.get(0);
		int maxRange = sortedList.get(0);

		for (int i = 1; i < sortedList.size(); ++i) {
			if ((sortedList.get(i) - sortedList.get(i - 1)) < 2) {
				++count;
			}

			else {
				ranges.put(minRange + "-" + maxRange, count);
				minRange = maxRange = sortedList.get(i);
				count = 1;

			}
			maxRange = sortedList.get(i);
		}
		ranges.put(minRange + "-" + maxRange, count);
		return ranges;
	}
}
