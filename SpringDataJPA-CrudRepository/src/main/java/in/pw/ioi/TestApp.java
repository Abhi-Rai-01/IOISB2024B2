package in.pw.ioi;

import java.util.Optional;
import java.util.function.Supplier;

public class TestApp {

	public static Optional<String> findUserById(Integer id){
		if (id == 10) {
			return Optional.of("sachin");
		} else {
			return Optional.empty();
		}
	}
	
	public static String defaultData() {
		System.out.println("Getting Called");
		return "Kholi";
	}
	
	public static Optional<String> findUserCityById(Integer id){
		String city = null;
		if (id == 10) {
			city = "Mumbai";
		}
		return Optional.ofNullable(city);
	}
	
	public static void main(String[] args) {
//		Optional<String> optional = findUserById(100);
//		if (optional.isPresent()) {
//			String userName = optional.get(); // sachin
//			System.out.println(userName);
//		} else {
//			String userName = optional.get(); // NoSuchElementException
//			System.out.println("Username not found..." + userName);
//		}
		
		
//		Optional<String> optional = findUserById(10);
//		Optional<String> optional = findUserById(100);
//		using orElse()
//		String result = optional.orElse(defaultData());
//		System.out.println(result);
		
		
//		Optional<String> optional = findUserById(10);
//		Optional<String> optional = findUserById(100);
//		using orElseGet(Supplier T)
//		String result = optional.orElseGet(() -> defaultData());
//		System.out.println(result);

		
//		Optional<String> optional = findUserById(10);
//		using orElseGet(Supplier T)
//		String result = optional.orElseThrow(() -> new RuntimeException("Username not found...."));
//		System.out.println(result);

//		Anonymous inner class implementation for an interface
//		Optional<String> optional = findUserById(10);
//		Optional<String> optional = findUserById(100);
//		String result = optional.orElseThrow(new Supplier<>() {
//			@Override
//			public RuntimeException get() {
//				// TODO Auto-generated method stub
//				return new RuntimeException("Record not found for the supplied id....");
//			}
//		});
//		System.out.println(result);	
		
		
		// using ifPresentOrElse(Consumer T)
//		Optional<String> optCity = findUserCityById(100);
		Optional<String> optCity = findUserCityById(10);
		optCity.ifPresentOrElse(city -> System.out.println(city),
							    () -> System.out.println("Default City"));
				
		
		
//		Anonymous inner class implementation for an interface after the extraction
//		Optional<String> optional = findUserById(10);
//		Optional<String> optional = findUserById(100);
//		String result = optional.orElseThrow(extracted());
//		System.out.println(result);
	}

	@SuppressWarnings("unused")
	private static Supplier<RuntimeException> extracted() {
		return new Supplier<>() {
			@Override
			public RuntimeException get() {
				// TODO Auto-generated method stub
				return new RuntimeException("Record not found for the supplied id....");
			}
		};
	}
}
