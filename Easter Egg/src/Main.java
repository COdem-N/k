import java.util.Scanner;

public class Main {
	
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
	
	public static void karan() {
		System.out.println("Karan Singla who codes for passion.");
	}
}
