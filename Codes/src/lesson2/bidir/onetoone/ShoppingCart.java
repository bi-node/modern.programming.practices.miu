package lesson2.bidir.onetoone;import java.util.*;

public class ShoppingCart {
	private Customer owner;
	private List<Item> items = new ArrayList<>();;
	public void addItem(Item item) {
		items.add(item);
	}
	//package level
	ShoppingCart(Customer cust) {
		owner = cust;
	}
	public List<Item> getItems() {
		return items;
	}
	public Customer getOwner() {
		return owner;
	}
	
}
