package lesson7.interfacestatic;

import java.time.LocalDate;
import java.util.List;

public class ShoppingCartOrdinary implements ShoppingCart {
	private String name;
	private List<Item> items;
	private LocalDate dateOfPurchase;
	public ShoppingCartOrdinary(String n, List<Item> items, 
		LocalDate d) {
		name = n;
		this.items = items;
		dateOfPurchase = d;
	}
	public String getName() { 
		return name;
	}
	public List<Item> getItems() {
		return items;
	}
	public LocalDate getDateOfPurchase() {
		return dateOfPurchase;
	}
	
}
