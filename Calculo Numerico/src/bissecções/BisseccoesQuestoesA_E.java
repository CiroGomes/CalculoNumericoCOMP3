package bissecções;

import java.math.BigDecimal;
import java.util.Scanner;

public class BisseccoesQuestoesA_E {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);

		double intervaloA;
		double intervaloB;
		double imagemA;
		double imagemB;
		double erro = Math.pow(10, -3);

		int opcao;
		do {
			do {
				System.out.println("Digite a opção desejada: " 
						+ "\n1: e^x - ln(x) - 1" 
						+ "\n2: x * e^x + x^2 - 1"
						+ "\n3: e^-x - 1 / x + 2	Com x != -2" 
						+ "\n4: e^-2x - x / x + 2	Com x != -2" 
						+ "\n5: e^x - x^3 + 3x" 
						+ "\n0: SAIR");
				opcao = leitor.nextInt();
			} while (opcao < 0 || opcao > 5);

			if (opcao != 0) {
				System.out.println("Digite o valor de x para f(a): ");
				intervaloA = leitor.nextDouble();

				System.out.println("Digite o valor de x para f(b): ");
				intervaloB = leitor.nextDouble();
				
				if((opcao == 3 || opcao == 4) && (intervaloA == -2 || intervaloB == -2)){
					System.out.println("Digite valores diferentes de 2 para essa questão!");
					while(intervaloA == -2 || intervaloB == -2){
						System.out.println("Digite o valor de x para f(a): ");
						intervaloA = leitor.nextDouble();

						System.out.println("Digite o valor de x para f(b): ");
						intervaloB = leitor.nextDouble();
					}
				}
				imagemA = calcularFx(intervaloA, opcao);
				imagemB = calcularFx(intervaloB, opcao);

				if ((imagemA * imagemB) < 0) {
					double k = ((Math.log((intervaloB - intervaloA)) - Math.log(erro)) / Math.log(2));
					int kInteiro = (int)(k);
					k = k > kInteiro ? ++kInteiro : kInteiro; 
					
					int i = 0;
					double novoIntervalo;
					double novaImagem;
					double erroIntervalo = 0;

					while (i++ < k) {
						novoIntervalo = (intervaloA + intervaloB) / 2.0;
						novaImagem = calcularFx(novoIntervalo, opcao);
						System.out.println("Resultado Nova Imagem: " + new BigDecimal(novaImagem));
						
						if((imagemA < 0 && novaImagem < 0) || (imagemA > 0 && novaImagem > 0))
							intervaloA = novoIntervalo;
						else if((imagemB < 0 && novaImagem < 0) || (imagemB > 0 && novaImagem > 0))
							intervaloB = novoIntervalo;
						
						erroIntervalo = Math.abs(intervaloB - intervaloA);
						System.out.println("Valor Intervalo A: "+new BigDecimal(intervaloA));
						System.out.println("Valor Intervalo B: "+new BigDecimal(intervaloB)+"\n");
						if (Math.abs(erroIntervalo) < erro){ 
							System.out.println("*Erro Informado: " + erro);
							System.out.println("*Aproximação Erro: " + new BigDecimal(erroIntervalo)+"\n");
						}
						erroIntervalo = 0;
						novaImagem = 0;
					}
				}
			}
		} while (opcao != 0);
		leitor.close();
	}

	public static double calcularFx(double x, int opcao) {
		if (opcao == 1)
			return (Math.pow(Math.E, x)) - (Math.log(x)) - 1;
		if (opcao == 2)
			return x * Math.pow(Math.E, x) + Math.pow(x, 2) - 1;
		if (opcao == 3)
			return (Math.pow(Math.E, -x) - 1) / (x + 2);
		if (opcao == 4)
			return (Math.pow(Math.E, -2 * x) - x) / (x + 2);
		if (opcao == 5)
			return Math.pow(Math.E, x) - Math.pow(x, 3) + 3 * x;
		else
			return (Math.pow(Math.E, x) - Math.pow(x, 2));
	}
}