package hu.grocery.model.service;

import java.util.Scanner;

public class Console {
	
	private final Scanner scanner = new Scanner(System.in);
	
	public int readInt(String text) {
		System.out.print(text);
		return scanner.nextInt();
	}

	public String read(String text) {
		System.out.print(text);
		return scanner.next();
	}
}
