package hu.grocery.model.domain;

import java.util.Map;
import java.util.stream.Collectors;

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
	
	public boolean hasGoods(String goods) {
		return goodsMap.containsKey(goods);
	}
	
	public String printGoods() {
		return goodsMap.entrySet().stream().map(i -> i.getValue() + " " + i.getKey()).collect(Collectors.joining("\r\n"));
	}

	@Override
	public String toString() {
		return id + ": " + totalPrice;
	}
	
		
}
