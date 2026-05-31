package in.pw.ioi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestApp2 {

	public static void main(String[] args) {
//		//List -----> Iterable
//		List<Integer> list = List.of(1,2,3);
//		list.add(0, 4);// UnsupportedOperation
//		System.out.println(list);
//		list.add(4);// UnsupportedOperation
//		System.out.println(list);

		
		
		Integer[] arr = {1,2,3};
		List<Integer> list = Arrays.asList(arr);
		arr[0] = 100;
//		list.add(4); // UnsupportedOperation
		System.out.println(list);
		System.out.println(list.getClass().getName());
		list.forEach(data -> System.out.println(data));
		
		ArrayList<Object> al = new ArrayList<>();
		al.add(null);
		System.out.println(al);
		
		List<Integer> data = List.of(1,2,null,3);
		System.out.println(data);
	}
}
