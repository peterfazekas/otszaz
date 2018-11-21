package hu.grocery;

import hu.grocery.controller.PurchaseFacade;
import hu.grocery.model.service.Console;
import hu.grocery.model.service.DataApi;

public class App {
	
	private final PurchaseFacade purchaseFacade;
	private final Console console;
	
	public App() {
		DataApi data = new DataApi();
		purchaseFacade = new PurchaseFacade(data.getData("penztar.txt"));
		console = new Console();
	}

	public static void main(String[] args) {
		new App().run();
	}

	private void run() {
		System.out.println("2. feladat: A fizetések száma: " + purchaseFacade.getPurchaseCount());
		System.out.println("3. feladat: Az első vásárló " + purchaseFacade.getGoodsCount(1) + 
				           " darab árucikket vásárolt.");
		System.out.println("4. feladat");
		int id = console.readInt("Adja meg egy vásárlás sorszámát: ");
		String goods = console.read("Adja meg egy árucikk nevét: ");
		int count = console.readInt("Adja meg a vásárolt darabszámot: ");
		System.out.println("5. feladat: " + purchaseFacade.getGoodsDetails(goods));
		System.out.println("6. feladat: " + count + " darab vételekor a fizetendő: " + purchaseFacade.getValue(count));
		System.out.println("7. fleadat: \r\n" + purchaseFacade.getGoodsByPurchaseId(id));
		purchaseFacade.printResult("osszeg.txt");
	}
}
