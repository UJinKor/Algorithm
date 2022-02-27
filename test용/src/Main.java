import java.io.IOException;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int dir = 3;
		for (int i = 0; i < 4; i++) {
			dir = ++dir%4;
			System.out.println(dir);
		}
	}
}
