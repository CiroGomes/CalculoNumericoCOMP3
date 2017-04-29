package falsePosicao;

import java.math.BigDecimal;
import java.util.Scanner;

public class MainFalsaPosicao {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		double intervaloA;
		double intervaloB;
		double imagemA;
		double imagemB;

		int escolha;
		do{
			do{
				System.out.println("\nDigite a opção desejada: "
						+"\n1: e^x - ln(x) - 1"
						+"\n2: x * e^x + x^2 - 1"
						+"\n3: e^-x - 1 / x + 2	Com x != -2"
						+"\n4: e^-2x - x / x + 2	Com x != -2"
						+"\n5: e^x - x^3 + 3x"
						+"\n6: e^x - x^2"
						+"\n0: SAIR");
				escolha = leitor.nextInt();
				if(escolha != 0){
					System.out.println("Digite o valor de x para f(a): ");
					intervaloA = leitor.nextDouble();
					
					System.out.println("Digite o valor de x para f(b): ");
					intervaloB = leitor.nextDouble();
					
					if((escolha == 3 || escolha == 4) && (intervaloA == -2 || intervaloB == -2)){
						System.out.println("Digite valores diferentes de 2 para essa questão!");
						while(intervaloA == -2 || intervaloB == -2){
							System.out.println("Digite o valor de x para f(a): ");
							intervaloA = leitor.nextDouble();
	
							System.out.println("Digite o valor de x para f(b): ");
							intervaloB = leitor.nextDouble();
						}
					}
					
	//				System.out.println("Digite o valor do Erro(Decimal): ");
					double erro = Math.pow(10, -19);//leitor.nextDouble();
					
					imagemA = calcularFx(intervaloA, escolha);
					imagemB = calcularFx(intervaloB, escolha);
					
					double novoIntervalo;
					double novaImagem;
					do {
						novoIntervalo = (intervaloA * calcularFx(intervaloB, escolha) - intervaloB * calcularFx(intervaloA, escolha))
								/ (calcularFx(intervaloB, escolha) - calcularFx(intervaloA, escolha));
						novaImagem = calcularFx(novoIntervalo, escolha);
						System.out.println("**Resultado Nova Imagem: " + new BigDecimal(novaImagem));
						if((imagemA < 0 && novaImagem < 0) || (imagemA > 0 && novaImagem > 0))
							intervaloA = novoIntervalo;
						else if((imagemB < 0 && novaImagem < 0) || (imagemB > 0 && novaImagem > 0))
							intervaloB = novoIntervalo;
						System.out.println("Valor Intervalo A: " + intervaloA + "\nf("+intervaloA+") = " +calcularFx(intervaloA, escolha));
						System.out.println("Valor Intervalo B: " + intervaloB + "\nf("+intervaloB+") = " +calcularFx(intervaloB, escolha));
					} while (Math.abs(novaImagem) > erro);
				}
			}while(escolha < 0 || escolha > 6);
		}while(escolha != 0);
		leitor.close();
	}

	public static double calcularFx(double x, int escolha) {
		if(escolha == 1)
			return (Math.pow(Math.E, x)) - (Math.log(x)) - 1;
		if(escolha == 2)
			return x * Math.pow(Math.E, x) + Math.pow(x, 2) - 1; 
		if(escolha == 3)
			return (Math.pow(Math.E, -x) - 1) / (x+2); 
		if(escolha == 4)
			return (Math.pow(Math.E, -2*x) - x) / (x+2); 
		if(escolha == 5)
			return Math.pow(Math.E, x) - Math.pow(x, 3) + 3*x;
		else
			return (Math.pow(Math.E, x) - Math.pow(x, 2)); 
	}
}