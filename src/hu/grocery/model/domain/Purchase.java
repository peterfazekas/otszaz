package hu.grocery.model.domain;

import java.util.Map;

public class Purchase {

	private final int id;
	private final long totalPrice;
	private final Map<String, Long> goodsMap;
	
	public Purchase(int id, long totalPrice, Map<String, Long> goodsMap) {
		this.id = id;
		this.totalPrice = totalPrice;
		this.goodsMap = goodsMap;
	}

	public int getId() {
		return id;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public Map<String, Long> getGoodsMap() {
		return goodsMap;
	}

	@Override
	public String toString() {
		return id + ": " + totalPrice;
	}
	
		
}
