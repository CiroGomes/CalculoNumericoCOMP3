package m�todoNewtonRaphson;

import java.util.Scanner;

public class NewtonRaphson_Raiz80 {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);

		double novoIntervalo;
		int numeroIteracoes = 5;

		System.out.println("Digite o valor do x0: ");
		double x0 = leitor.nextDouble();// 9

		System.out.println("Intervalo: " + x0);
		System.out.println("1� Derivada: " + primeiraDerivada(x0));
		novoIntervalo = calcular(x0, numeroIteracoes);

		leitor.close();
	}

	private static double calcular(double x0, int iteracoes) {
		double novaImagem = x0;
		double novoIntervalo = 0;
		int i = 0;
		while (i++ < iteracoes) {
			novoIntervalo = novaImagem - (funcaoOriginal(novaImagem) / primeiraDerivada(novaImagem));
			System.out.println("\n"+i+"�Intervalo: " + novoIntervalo);
			System.out.println("Fun��o Original: " + funcaoOriginal(novoIntervalo));
			System.out.println("1� Derivada: " + primeiraDerivada(novoIntervalo));
			novaImagem = novoIntervalo;
		}

		double ultimoIntervalo = novaImagem - (funcaoOriginal(novaImagem) / primeiraDerivada(novaImagem));
		System.out.println("\n�ltimo Intervalo: " + ultimoIntervalo);
		System.out.println("Fun��o Original com o �ltimo intervalo: " + funcaoOriginal(ultimoIntervalo));
		return novoIntervalo;
	}

	private static double funcaoOriginal(double x) {
		return Math.pow(x, 2) - 80;
	}

	private static double primeiraDerivada(double x) {
		return 2 * x;
	}
}