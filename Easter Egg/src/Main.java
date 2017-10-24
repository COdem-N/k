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
}
