package hu.grocery.controller;

import java.util.List;

import hu.grocery.model.domain.Purchase;
import hu.grocery.model.service.PriceCalculator;
import hu.grocery.model.service.ResultWriter;

public class PurchaseFacade {

	private final List<Purchase> purchases;

	public PurchaseFacade(List<Purchase> purchases) {
		this.purchases = purchases;
	}
	
	public int getPurchaseCount() {
		return purchases.size();
	}
	
	public long getGoodsCount(int id) {
		return getPurchaseById(id).getGoodsMap().entrySet().stream().mapToLong(i -> i.getValue()).sum();
	}
	
	private Purchase getPurchaseById(int id) {
		return purchases.stream().filter(i -> i.getId() == id).findAny().get();
	}
	
	public long getValue(int count) {
		PriceCalculator priceCalculator = new PriceCalculator();
		return priceCalculator.getValue(count);
	}
	
	public void printResult(String fileName) {
		ResultWriter writer = new ResultWriter();
		writer.printAll(fileName, purchases);
	}
}
