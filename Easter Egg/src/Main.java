import java.util.Scanner;

public class Main {
	
	private static int count;
	
	public Main() {
		count = 0;
	}
	public static void main(String[] args) {
		System.out.println("Welcome to K Team's Easter Egg");
		System.out.println();
		System.out.print("Press 1 to hatch the egg ");
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		if(num == 1) {
			System.out.println("We are Team K and comprises of");
			karan();
			peter();
			carter();
			logan();
			alex();
		}
		scanner.close();
	}
	
	/**
	 * 
	 * @return the total count of the names at a certain time. 
	 */
	public int getCount() {
		return count;
	}
	
	
	/**
	 * pre: none
	 * post: prints the name of the team member and returns his name.
	 * @return the name of the team member. In this case "Karan Singla"
	 */
	public static String karan() {
		System.out.println("Karan Singla who codes for passion.");
		count++;
		return "Karan Singla";
	}
	
	/**
	 * author: Peter Bae
	 * Prints my name.
	 * @return string containing my full name.
	 */
	public static String peter() {
		System.out.println("		PETER PETER PETER.");
		count++;
		return "Peter Bae";
	}

	/**
	 * author: Carter Odem
	 * Prints my name.
	 * @return string containing my full name.
	 */
		public static String carter() {
		System.out.println("			Carter Oh damn");
		count++;
		return "Carter Oh damn";
	}
	
	/**
	 * author: Logan Stafford
	 * Prints my name.
	 * @return string containing my full name.
	 */	
	public static String logan() {
		System.out.println("				Logan Stafford WICKA WOCKA WICKETY WOO.");
		count++;
		return "Logan Stafford";
	}
	
	/**
	 * author: Alex Merk
	 * Prints my name.
	 * @return string containing my full name.
	 */
	public static String alex() {
		System.out.println("						alex");
		count++;
		return "Alex Merk";
	}
}
