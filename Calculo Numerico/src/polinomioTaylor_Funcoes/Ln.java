package polinomioTaylor_Funcoes;

import java.util.Scanner;
//to aki hein?!
public class Ln {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		int x;
		int x0;
		int n;
		
		System.out.println("Digite o valor de X: ");
		x = leitor.nextInt();

		System.out.println("Digite o valor de X0: ");
		x0 = leitor.nextInt(); 
		
		System.out.println("Digite o valor do Grau(n): ");
		n = leitor.nextInt(); 
		
		int multiplicaFuncao = 1;
		double polinomioTaylor = Math.log(x0);
		for (int i = 0; i < n; i++) {
			if(i != 0)
				multiplicaFuncao*=-i;
			polinomioTaylor+=(multiplicaFuncao * Math.pow(x0, -i-1) * (Math.pow((x-x0), i+1) / fatorial(i+1)));
		}
		System.out.println("Valor Real: "+Math.log(x));
		System.out.println("Valor Estimado: " + polinomioTaylor);
		System.out.println("Erro Absoluto: "+ Math.abs(((Math.log(x)) - polinomioTaylor)));
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
}
