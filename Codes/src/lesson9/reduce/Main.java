package lesson9.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class Main {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2, 1, 4, 3);
		Main m = new Main();
	/*	m.printSum(list);
		m.printProduct(list);
		m.printDifference(list);*/
		
		// Optional<T> reduce(BinaryOperator<T> accumulator); No need of seed if it return optional
		Optional<Integer> sum = list.stream().reduce((a,b)->(a+b));
		System.out.println("Sum = " + sum.get());
		
		Optional<Integer> prd = list.stream().reduce((a,b)->(a*b));
		System.out.println("Product = " + prd.get());
		
		
	}
	public void printSum(List<Integer> list) {
		//  T reduce(T identity, BinaryOperator<T> accumulator); It accepts seed
		int sum1 = list.stream().reduce(0, (a,b) -> a + b);
		System.out.println("sum1 = " + sum1);
		int sum2 = list.parallelStream().reduce(0, (a,b) -> a + b);
		System.out.println("sum2 = " + sum2);
	}
	
	public void printProduct(List<Integer> list) {
		int prod1 = list.stream().reduce(1, (a,b) -> a * b);
		System.out.println("prod1 = " + prod1);
		int prod2 = list.parallelStream().reduce(1, (a,b) -> a * b);
		System.out.println("prod2 = " + prod2);
	}
	
	public void printDifference(List<Integer> list) {
		int diff1 = list.stream().reduce(0, (a,b) -> a - b);
		System.out.println("diff1 = " + diff1);
		int diff2 = list.parallelStream().reduce(0, (a,b) -> a - b);
		System.out.println("diff2 = " + diff2);
		
	}

}
