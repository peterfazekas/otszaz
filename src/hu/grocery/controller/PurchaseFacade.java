package hu.grocery.controller;

import java.util.List;
import java.util.stream.Collectors;

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
	
	
	public String getGoodsDetails(String goods) {
		List<Purchase> purchasesByGoods = getPurchasesByGoods(goods);
		int size = purchasesByGoods.size();
		return String.format("%nAz első vásárlás sorszáma: %d%nAz utolsó vásárlás sorszáma: %d%n%d vásárlás során vettek belőle", 
				             purchasesByGoods.get(0).getId(), purchasesByGoods.get(size - 1).getId(), size);
	}
	
	private List<Purchase> getPurchasesByGoods(String goods) {
		return purchases.stream().filter(i -> i.hasGoods(goods)).collect(Collectors.toList());
	}
	
	public long getValue(int count) {
		PriceCalculator priceCalculator = new PriceCalculator();
		return priceCalculator.getValue(count);
	}
	
	public String getGoodsByPurchaseId(int id) {
		return getPurchaseById(id).printGoods();
	}
	
	public void printResult(String fileName) {
		ResultWriter writer = new ResultWriter();
		writer.printAll(fileName, purchases);
	}
}
