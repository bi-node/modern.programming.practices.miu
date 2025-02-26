package lesson9.streamreuse;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Illustrates one workaround for limitation on stream reuse -- place
//stream pipeline creation in a separate method.
public class Good {
	public static void main(String[] args) {
		  Good g = new Good();
		  Stream<String> res = g.listStartsWith(Folks.friends, "N");
		  List<String> out = res.collect(Collectors.toList());
		  System.out.println(out);
		  
		  Stream<String> res1 = g.listStartsWith(Folks.editors, "N");
		  List<String> out1 = res1.collect(Collectors.toList());
		  System.out.println(out1);
		  
		  System.out.println(g.countNumberFriendsStartingWithB("B"));
		  System.out.println(g.listEditorsNamesStartingWithNUpperCase("N"));
	  }
	
	public Stream<String> listStartsWith(List<String> list, String letter) {
		return 
		     list.stream()   
         	     .filter(name -> name.startsWith(letter));
         	     
	}
	
	public int countNumberFriendsStartingWithB(String letter) {
		  return (int) listStartsWith(Folks.friends, letter).count();
	  }
	public List<String> listEditorsNamesStartingWithNUpperCase(String letter) {
		  return listStartsWith(Folks.editors, letter).collect(Collectors.toList());
	  }
}
