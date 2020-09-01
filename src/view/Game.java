package view;

import java.util.InputMismatchException;
import java.util.Scanner;
import model.Calcular;

public class Game {
	
	static Scanner teclado = new Scanner(System.in);
	static Calcular calc;
	static int dificuldade = 0;
	static int opcao = 0;

	public static void main(String[] args) {
		Game.menuPrincipal();
	}
	
	public static void jogo() {
		
		System.out.println("A dificuldade selecionada foi " + Game.dificuldade);
		Game.calc = new Calcular(Game.dificuldade);
		
		System.out.println("======= Game Matemático =======");
		System.out.println("Informe o resultados para a seguinte operação: ");
		System.out.println(Game.calc);
		System.out.println("Resultado do jogador: ");
		try{
			Game.calc.calculo(Game.teclado.nextInt());
		}catch(InputMismatchException e) {
			System.out.println("Resposta incorreta!!");
			teclado.nextLine();
		}finally {
			Game.menuJogo();
			switch(Game.opcao) {
			case 1: Game.jogo();
					break;
			case 2: Game.menuPrincipal();
					break;
			case 3: System.out.println("Espero que tenha se divertido, encerrando o jogo!"); 
			break;
			}
		}
		
	}
	
	public static void menuPrincipal() {
		
		boolean controle = false;

		do {
			if(controle) {
				System.out.println("Opção inválida");
			}
			try {
				System.out.println("======= Game Matemático =======");
				System.out.println("Níveis de Jogos: \n1 - Fácil \n2 - Médio\n3 - Difícil\n4 - Insano");
				System.out.println("Informe o nível de dificuldade que você quer jogar: ");
				Game.dificuldade = Game.teclado.nextInt();
				controle = true;
			}catch(InputMismatchException e){
				System.out.println("Tipo de dado inválido!!");
				controle = false;
				teclado.nextLine();
			}
						
		}while(Game.dificuldade < 1 || Game.dificuldade > 4);
		
		controle = false;
		Game.jogo();
	}
	
	public static void menuJogo() {

		do {
			try {
				System.out.println("======= Game Matemático =======");
				System.out.println("Opções: \n1 - Continuar Jogando \n2 - Mudar dificuldade \n3 - Encerrar Jogo");
				System.out.println("Informe a opção desejada ");
				Game.opcao = Game.teclado.nextInt();
			}catch(InputMismatchException e){
				System.out.println("Tipo de dado inválido!!");
				teclado.nextLine();
			}
		}while(Game.opcao < 1 || Game.opcao > 4);
	}

}
