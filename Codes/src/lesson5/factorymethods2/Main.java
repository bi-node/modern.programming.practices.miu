package lesson5.factorymethods2;

import lesson5.factorymethods2.windows.AddressWindow;
import lesson5.factorymethods2.windows.CustomerProfileWindow;

public class Main {

	public static void main(String[] args) {
		AddressWindow addWin = new AddressWindow();	
		addWin.setVisible(true);
		CustomerProfileWindow custWin = new CustomerProfileWindow();	
		custWin.setVisible(true);

	}

}
