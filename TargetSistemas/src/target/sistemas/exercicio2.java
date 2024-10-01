package target.sistemas;

import java.util.Scanner;

public class exercicio2 {
	
	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Escolha um número desejado:");
		int numeroEscolhido = scan.nextInt();

		if (fibonacci(numeroEscolhido)) {
			System.out.println("O número " + numeroEscolhido + " pertence à sequência de Fibonacci.");
		} else {
			System.out.println("O número " + numeroEscolhido + " não pertence à sequência de Fibonacci.");
		}
		scan.close();
	}

	public static boolean fibonacci(int num) {
		if (num == 0 || num == 1) {
			return true;
		}

		int a = 0, b = 1;
		int fib = a + b;

		while (fib <= num) {
			if (fib == num) {
				return true;
			}
			a = b;
			b = fib;
			fib = a + b;
		}
		return false;
	}
}
