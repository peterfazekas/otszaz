package hu.grocery.model.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import hu.grocery.model.domain.Purchase;

public class DataApi {

	private static final String SEPARATOR = ",";
	private static final String PURCHASE_SEPARATOR = ",F,";
	private final PriceCalculator priceCalculator = new PriceCalculator();
	private int id;
	
	public List<Purchase> getData(String fileName) {
		return parse(read(fileName));
	}
	
	private String read(String fileName) {
		String text = "";
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			text = br.lines().collect(Collectors.joining(SEPARATOR));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}
	
	private List<Purchase> parse(String text) {
		String[] split = text.split(PURCHASE_SEPARATOR);
		return Arrays.stream(split).map(this::purchaseParse).collect(Collectors.toList());
	}
	
	private Purchase purchaseParse(String text) {
		Map<String, Long> goodsMap = getGoodsMap(text);
		return new Purchase(++id, priceCalculator.getTotalValue(goodsMap), goodsMap);
	}
	
	private Map<String, Long> getGoodsMap(String text) {
		return Arrays.stream(text.split(SEPARATOR)).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}
	
}
