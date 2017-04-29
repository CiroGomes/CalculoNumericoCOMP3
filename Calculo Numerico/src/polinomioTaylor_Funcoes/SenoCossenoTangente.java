package polinomioTaylor_Funcoes;

import java.math.BigDecimal;
import java.util.Scanner;

public class SenoCossenoTangente {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		
		int opcao;
		int n;
		int x0;
		double x;
		double x0Radiano;
		double xRadiano;
		double calculoRadiano;

		do {
			do{
				System.out.println("Escolha uma opção:" + "\n1 - Seno \n2 - Cosseno \n3 - Tangente \n0 - Sair");
				opcao = leitor.nextInt();
			}while(opcao < 0 || opcao > 3);
			
			if(opcao != 0){
				do {
					System.out.println("Digite o valor do ângulo: ");
					x = leitor.nextDouble();
				} while (x < 0 || x > 90);

				do {
					System.out.println("Digite o valor do Grau(n): ");
					n = leitor.nextInt();
				} while (n < 2 || n > 4);
				
				if (x > 0 && x <= 37) 
					x0 = 30;
				else if (x <= 52) 
					x0 = 45;
				else if (x <= 75) 
					x0 = 60;
				else 
					x0 = 90;

				x0Radiano = (x0 * Math.PI) / 180;
				xRadiano = (x * Math.PI) / 180;

				calculoRadiano = (xRadiano - x0Radiano);
				double valorReal = obterValorReal(xRadiano, opcao);
				System.out.println("Valor Real: " + valorReal);
				System.out.println("Valor Estimado: "+ obterValorEstimado(x0Radiano, calculoRadiano, n, opcao));
				System.out.println("Erro Absoluto: " + new BigDecimal(Math.abs(obterValorEstimado(x0Radiano, calculoRadiano, n, opcao)-valorReal)));
			}
		} while (opcao != 0);
		leitor.close();
	}
	
	public static double obterValorReal(double xRadiano, int opcao){
		if(opcao == 1)
			return Math.sin(xRadiano);
		else if(opcao == 2)
			return Math.cos(xRadiano);
		else
			return Math.tan(xRadiano);
	}
	
	public static double obterValorEstimado(double x0Radiano, double calcRad, int n, int opcao){
		double valorEstimado = 0;
		if(opcao == 1){
			if(n == 2){
				valorEstimado = Math.sin(x0Radiano) + (Math.cos(x0Radiano) * calcRad) + (-Math.sin(x0Radiano) * (Math.pow(calcRad, 2)) / 2.0);
			}else if(n == 3){
				valorEstimado = Math.sin(x0Radiano) + (Math.cos(x0Radiano) * calcRad) + (-Math.sin(x0Radiano) * (Math.pow(calcRad, 2)) / 2.0) + 
						(-Math.cos(x0Radiano) * (Math.pow(calcRad, 3)) / 6.0);
			}else{
				valorEstimado = Math.sin(x0Radiano) + (Math.cos(x0Radiano) * calcRad) + (-Math.sin(x0Radiano) * (Math.pow(calcRad, 2)) / 2.0) + 
						(-Math.cos(x0Radiano) * (Math.pow(calcRad, 3)) / 6.0) + 
						(Math.sin(x0Radiano) * (Math.pow(calcRad, 4)) / 24.0);
			}
		}else if(opcao == 2){
			if(n == 2){	
				valorEstimado = Math.cos(x0Radiano) + (-Math.sin(x0Radiano) * calcRad) + (-Math.cos(x0Radiano) * (Math.pow(calcRad, 2)) / 2.0);
			}else if(n == 3){
				valorEstimado = Math.cos(x0Radiano) + (-Math.sin(x0Radiano) * calcRad) + (-Math.cos(x0Radiano) * (Math.pow(calcRad, 2)) / 2.0)+
						(Math.sin(x0Radiano) * (Math.pow(calcRad, 3)) / 6.0);
			}else{
				valorEstimado = Math.cos(x0Radiano) + (-Math.sin(x0Radiano) * calcRad) + (-Math.cos(x0Radiano) * (Math.pow(calcRad, 2)) / 2.0)+
						(Math.sin(x0Radiano) * (Math.pow(calcRad, 3)) / 6.0) +
						(Math.cos(x0Radiano) * (Math.pow(calcRad, 4)) / 24.0);
			}
		}else{
			double tangente = Math.tan(x0Radiano); 
			double derivada1Tan = Math.pow( (1.0/Math.cos(x0Radiano)), 2);
			double derivada2Tan = (2.0 * Math.tan(x0Radiano) * derivada1Tan);
			double derivada3Tan = (-4.0 * derivada1Tan) + (6.0 * (derivada1Tan * derivada1Tan));
			double derivada4Tan = (-8.0 * derivada1Tan * Math.tan(x0Radiano)) + (24.0 * (derivada1Tan * derivada1Tan) * Math.tan(x0Radiano));
			
			if(n == 2){
				valorEstimado = tangente + (derivada1Tan * calcRad) + (derivada2Tan * (Math.pow(calcRad, 2)) / 2.0);
			}else if(n == 3){
				valorEstimado = tangente + (derivada1Tan * calcRad) + (derivada2Tan * (Math.pow(calcRad, 2)) / 2.0) + 
				(derivada3Tan * (Math.pow(calcRad, 3)) / 6.0);
			}else{
				valorEstimado = tangente + (derivada1Tan * calcRad) + (derivada2Tan * (Math.pow(calcRad, 2)) / 2.0) + 
						(derivada3Tan * (Math.pow(calcRad, 3)) / 6.0) + (derivada4Tan * (Math.pow(calcRad, 4)) / 24.0);
			}
		}
		return valorEstimado;
	}
}