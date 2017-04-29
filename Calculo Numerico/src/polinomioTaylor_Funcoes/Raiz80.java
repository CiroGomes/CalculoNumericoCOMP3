package polinomioTaylor_Funcoes;

import java.util.Scanner;

public class Raiz80 {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		int x;
		int x0;
		int n = 5;
		
		System.out.println("Digite o valor de X: ");
		x = leitor.nextInt();//80

		System.out.println("Digite o valor de X0: ");
		x0 = leitor.nextInt(); 
		
		double poliTaylor80 = Math.sqrt(x0) + (primeiraDerivada(x0) * (x-x0)) + (segundaDerivada(x0) * (Math.pow((x-x0), 2) / fatorial(2))) + 
				(terceiraDerivada(x0) * (Math.pow((x-x0), 3) / fatorial(3))) + (quartaDerivada(x0) * (Math.pow((x-x0), 4) / fatorial(4))) + 
				(quintaDerivada(x0) * (Math.pow((x-x0), 5) / fatorial(5)));   
		
		System.out.println("Valor Real: "+ Math.sqrt(x));
		System.out.println("Valor Estimado: " + poliTaylor80);
		System.out.println("Erro Absoluto: "+ Math.abs(((Math.sqrt(x)) - poliTaylor80)));
		
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
	
	private static double primeiraDerivada(double x){
		return 1.0/(2.0 * Math.sqrt(x));
	}
	
	private static double segundaDerivada(double x){
		return -1.0/(4.0*Math.pow(x, 1.5));
	}
	
	private static double terceiraDerivada(double x){
		return 3.0/(8.0*Math.pow(x, 2.5));
	}

	private static double quartaDerivada(double x){
		return -15.0/(16.0*Math.pow(x, 3.5));
	}
	
	private static double quintaDerivada(double x){
		return 105.0/(32.0*Math.pow(x, 4.5));
	}
}
