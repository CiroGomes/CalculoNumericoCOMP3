package polinomioTaylor_Funcoes;

import java.util.Scanner;
//ALTEREI PAE
//de novo
public class Euler {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		int x0;
		int n;
		double x;

		System.out.println("Digite o valor de x0: ");
		x0 = leitor.nextInt(); // x0 = 0;

		do {
			System.out.println("Digite o valor do Grau(n): ");
			n = leitor.nextInt(); // n = 10;
		} while (n < 0 || n > 10);

		System.out.println("Digite o valor de x para Polinômio e Somatório: ");
		x = leitor.nextDouble();

		double somatorio = 0;
		for (int k = 0; k < n; k++) {
			somatorio += ((Math.pow(x, k)) / fatorial(k));
		}

		double polinomioTaylor = Math.pow(Math.E, x0);// Refere-se ao f(x0);
		for (int i = 1; i <= n; i++) {
			polinomioTaylor += (Math.pow(Math.E, x0) * (Math.pow((x - x0), i)) / fatorial(i));
		}

		System.out.println("Valor Real: " + Math.pow(Math.E, x));
		System.out.println("Valor Estimado: " + polinomioTaylor);
		System.out.println("Valor Somatório: " + somatorio);
		System.out.println("Erro Absoluto: " + Math.abs((Math.pow(Math.E, x)) - polinomioTaylor));
		leitor.close();
	}

	private static int fatorial(int valor) {
		int fatorial = 1;
		while (valor >= 1) {
			fatorial *= valor;
			valor--;
		}
		return fatorial;
	}
}
