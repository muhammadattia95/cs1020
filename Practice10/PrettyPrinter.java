import java.util.*;

public class PrettyPrinter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a line below:");
		String line = sc.nextLine();
		String newLine = line.trim().replaceAll("\\s+", " ");


		System.out.println("Pretty-printed line:");
		System.out.println("|" + newLine + "|");
	}
}


