package model;

import java.util.Random;

public class Calcular {
	private int dificuldade;
	private int valor1;
	private int valor2;
	private int operacao;
	private int resultado;
	
	public Calcular(int dificuldade) {
		
		Random rand = new Random();
		
		this.operacao = rand.nextInt(3);//0 - somar, 1 - subtrair, 2 - multiplicar
		this.dificuldade = dificuldade;
		
		switch(dificuldade) {
		case 1: this.valor1 = rand.nextInt(10);//0 a 9
				this.valor2 = rand.nextInt(10);//0 a 9
				break;
		case 2: this.valor1 = rand.nextInt(100);//0 a 99
				this.valor2 = rand.nextInt(100);//0 a 99
				break;
		case 3: this.valor1 = rand.nextInt(1000);//0 a 999
				this.valor2 = rand.nextInt(1000);//0 a 999
				break;
		case 4: this.valor1 = rand.nextInt(10000);//0 a 9999
				this.valor2 = rand.nextInt(10000);//0 a 9999
				break;
		}
		
	}

	public int getValor1() {
		return valor1;
	}
	
	public int getValor2() {
		return valor2;
	}
	
	public int getOperacao() {
		return operacao;
	}
	
	public int getResultado() {
		return resultado;
	}
	
	public String operacaoString(int operacao) {
		String ret = "";
		
		switch(operacao) {
		case 0: ret = "+";
				break;
		case 1: ret = "-";
				break;
		case 2: ret = "*";
				break;
		}
		
		return ret;
	}
	
	@Override
	public String toString() {
		
		String calculo = this.getValor1() + " " + operacaoString(this.getOperacao()) + " " + this.getValor2() + " = ";
		return calculo;
	}
	
	public void calculo(int resposta) {
		
		String opera = "";
		
		switch(this.getOperacao()) {
		case 0: this.resultado = this.valor1 + this.valor2;
				opera=operacaoString(0);
				break;
		case 1: this.resultado = this.valor1 - this.valor2;
				opera=operacaoString(1);
				break;
		case 2: this.resultado = this.valor1 * this.valor2;
				opera=operacaoString(2);
				break;
		}
		
		if(resposta == getResultado()) {
			System.out.println("Resposta correta!");
		}else {
			System.out.println("Resposta incorreta!");
		}
		
		System.out.println(this.getValor1() + " " + opera + " " + this.getValor2() + " = " + this.getResultado());
		
	}
	

}
