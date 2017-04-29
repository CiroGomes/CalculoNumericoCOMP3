package bissecções;

import java.util.Scanner;

public class Q1 {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);

		double valorFa;
		double valorFb;
		double resultadoA;
		double resultadoB;

		do {
			System.out.println("Digite o valor de x para f(a): ");
			valorFa = leitor.nextDouble();
		} while (valorFa >= 0);
		resultadoA = calcularFx(valorFa);

		do {
			System.out.println("Digite o valor de x para f(b): ");
			valorFb = leitor.nextDouble();
		} while (valorFb >= 0);
		resultadoB = calcularFx(valorFb);

		System.out.println("Digite o valor do Erro");
		double erro = leitor.nextDouble();

		if ((resultadoA * resultadoB) < 0) {
			double intervaloA = valorFa;
			double intervaloB = valorFb;

			int k = 0; //Obter iterações...
			// k > (ln [b-a] - ln[ERRO]) / ln[2];
			k = (int)( (Math.log((intervaloB - intervaloA)) - Math.log(erro)) / Math.log(2) );
			k++;

			int i = 0;
			double novoIntervalo;
			double calculoIntervalo;
			double erroIntervalo=0;
			while (i < k) {
				novoIntervalo = (intervaloA + intervaloB) / 2.0;
				calculoIntervalo = calcularFx(novoIntervalo);
				System.out.println("Resultado: " + calculoIntervalo);//
				if(calculoIntervalo < resultadoA){
					intervaloA = novoIntervalo;
					erroIntervalo = novoIntervalo - intervaloB;
					if(erroIntervalo < 0){
						erroIntervalo*=(-1);//Dst pra não ficar negativo
					}
				}else if(calculoIntervalo < resultadoB){
					intervaloB = novoIntervalo;
					erroIntervalo = novoIntervalo - intervaloA;
					if(erroIntervalo < 0){
						erroIntervalo*=(-1);//Dst pra não ficar negativo
					}
				}
				if(erroIntervalo < erro){
					System.out.println("Aproximação: " + erroIntervalo);
				}
				erroIntervalo = 0;
				calculoIntervalo = 0;
				i++;
			}
		} else {
			System.out.println("Não é possível resolver pelo Bolzano-Weitrass");
		}
		leitor.close();
	}

	public static double calcularFx(double x) {
		return Math.pow(x, 2) - (Math.pow(Math.E, x));
	}
}