package métodoNewtonRaphson;
import java.util.Scanner;

public class NewtonRaphson_Raiz80_V2 {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		
		double novoIntervalo;
		
		System.out.println("Digite o valor do x: ");
		double x = leitor.nextDouble();
		
		System.out.println("Digite o valor do x0: ");
		double x0 = leitor.nextDouble();//9

		System.out.println("Intervalo: " + x0);
		System.out.println("1ª Derivada: " + primeiraDerivada(x0));
		System.out.println("2ª Derivada: " + segundaDerivada(x0));
		novoIntervalo = calcular(x0, x, 5);
		
		leitor.close();
	}
	
	private static double calcular(double x0, double x, int iteracoes){
		double novaImagem = x0;
		double novoIntervalo = 0;
		int i = 0;
		while(i++ < iteracoes){
			novoIntervalo = (Math.pow(novaImagem, 2) + x)/(2.0 * novaImagem);
			System.out.println("\nNovo Intervalo: " + novoIntervalo);
			System.out.println("Função Original: " + funcaoOriginal(novoIntervalo));
			System.out.println("1ª Derivada: " + primeiraDerivada(novoIntervalo));
			novaImagem = novoIntervalo;
		}

		double ultimoIntervalo = (Math.pow(novaImagem, 2) + x)/(2.0 * novaImagem);
		System.out.println("\nÚltimo Intervalo: " + ultimoIntervalo);
		System.out.println("Função Original: " + funcaoOriginal(ultimoIntervalo));
		return novoIntervalo;
	}
	
	private static double funcaoOriginal(double x){
		return Math.sqrt(x);
	}
	
	private static double primeiraDerivada(double x){
		return 1.0/(2.0*Math.sqrt(x));
	}
	
	private static double segundaDerivada(double x){
		return -1.0/(4.0*Math.pow(x, 1.5));
	}
}