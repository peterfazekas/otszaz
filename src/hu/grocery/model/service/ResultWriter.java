package hu.grocery.model.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import hu.grocery.model.domain.Purchase;

public class ResultWriter {

	public void printAll(String fileName, List<Purchase> purchases) {
		try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
			purchases.forEach(pw::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
