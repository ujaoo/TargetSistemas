package target.sistemas;

import java.util.Scanner;

public class exercicio5 {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Escolha uma palavra para inverter os caracteres:");
		String original = scan.nextLine();

		String invertida = "";
		for (int i = original.length() - 1; i >= 0; i--) {
			invertida += original.charAt(i);
		}

		System.out.println("Texto original: " + original);
		System.out.println("Texto invertido: " + invertida);

		scan.close();
	}
}
