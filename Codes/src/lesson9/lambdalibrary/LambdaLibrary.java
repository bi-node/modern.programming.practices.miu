package lesson9.lambdalibrary;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class LambdaLibrary {
	 /**
	  * Accepts list of customers and a search string <code>searchStr</code>.
	  * 
	  * Returns the names of those customers whose name begins with <code>searchStr</code>,
	  * in sorted order.
	  */
	 public static final BiFunction<List<Customer>, String, List<String>> NAMES_IN_CITY 
	  		= (list, searchStr) 
	  		     -> list.stream()
				        .filter(cust -> cust.getCity().startsWith(searchStr))
                        .map(cust -> cust.getName())
                        .sorted()
                        .collect(Collectors.toList());
	 
}
