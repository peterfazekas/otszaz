package hu.grocery.model.service;

import java.util.Map;

public class PriceCalculator {

	private static final Integer[] VALUES = {0, 500, 950, 1350};
	
	public long getTotalValue(Map<String, Long> goodsMap) {
		return goodsMap.entrySet().stream().mapToLong(i -> i.getValue()).map(this::getValue).sum();
	}
	
	public long getValue(long count) {
		return ertek(count);
	}
	
	private long ertek(long count) {
		return count < 4 ? VALUES[(int) count] : VALUES[3] + (count - 3) * 400;
	}
}
