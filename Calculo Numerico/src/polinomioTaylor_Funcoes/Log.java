package polinomioTaylor_Funcoes;

import java.util.Scanner;

public class Log {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		int x0;
		int x;
		int n;
		
		System.out.println("Digite o valor de x: ");
		x = leitor.nextInt();
		
		System.out.println("Digite o valor de x0: ");
		x0 = leitor.nextInt();//X0 -> 0, 1 e 10; 
		
		System.out.println("Digite o valor do Grau(n): ");
		n = leitor.nextInt(); //n = 5;
		
		double formula = Math.log10(x0);
		double constante = Math.pow(Math.log(10), -1); //ln
//		double valorProximoReal = 0;
//		double valorReal = calcularValorReal(x);
		
		int multiplicaFuncao = 1;
		for (int i = 0; i < n; i++) {
			if(i != 0){
				multiplicaFuncao*=-i;
			}
			formula+=(multiplicaFuncao * Math.pow(x0, -i-1) * constante * (Math.pow((x-x0), i+1) / fatorial(i+1)));
		}
		
		System.out.println("Valor Real: "+ Math.log10(x));
		System.out.println("Valor Estimado: " + formula);
		System.out.println("Erro Absoluto: "+ Math.abs(((Math.log10(x)) - formula)));
//		System.out.println("Valor Próximo do Real: " + valorProximoReal);
//		System.out.println("Valor Real: "+ valorReal);
		
//			FUNCIONA! 		
		
//		double deriv1 = (Math.pow(x0, -1) * constante);		double deriv2 = (-1.0 * Math.pow(x0, -2) * constante);  double deriv3 = (2.0 * Math.pow(x0, -3) * constante);
//		double deriv4 = (-6.0 * Math.pow(x0, -4) * constante);
//		double deriv5 = (24.0 * Math.pow(x0, -5) * constante);
//		
//		double formula = Math.log10(x0) + (deriv1 * (x-x0)) + (deriv2 * (Math.pow((x-x0), 2) / fatorial(2))) + 
//				(deriv3 * (Math.pow((x-x0), 3) / fatorial(3))) + (deriv4 * (Math.pow((x-x0), 4) / fatorial(4))) + 
//				(deriv5 * (Math.pow((x-x0), 5) / fatorial(5)));
		leitor.close();
	}
	
	private static int fatorial(int valor){
		int fatorial = 1;
		while(valor >= 1){
			fatorial*=valor;
			valor--;
		}
		return fatorial;
	}
	
//	private static double calcularValorReal(double x){
//		return Math.log10(x);
//	}
}
