package com.leon.util;

import java.util.Scanner;

/**
 * @author German Santos / Leonel Mendez Jimenez
 * 
 */
public class Matriz {

	private float arreglo[][];
	private int col;
	private int ren;

	/**
	 * Constructor
	 * 
	 * @param col
	 * @param ren
	 * 
	 */
	public Matriz(int col, int ren) {
		int i, j;
		this.col = col;
		this.ren = ren;
		arreglo = new float[col][ren];
		for (i = 0; i < col; i++) {
			for (j = 0; j < ren; j++) {
				arreglo[i][j] = 0;
			}
		}
	}

	/**
	 * Getter
	 * 
	 * @param col
	 * @param ren
	 * @return Valor de [col][ren]
	 */
	public float getValor(int col, int ren) {
		return arreglo[col][ren];
	}

	/**
	 * Setter Establece un valor en [col][ren]
	 * 
	 * @param col
	 * @param ren
	 * @param valor
	 */
	public void setValor(int col, int ren, float valor) {
		arreglo[col][ren] = valor;
	}

	/**
	 * Imprime la matriz
	 */
	public void imprimeMatriz() {
		int i, j;
		for (i = 0; i < col; i++) {
			for (j = 0; j < ren; j++) {
				System.out.print(arreglo[i][j] + " ");
			}
			System.out.println("");
		}

	}

	/**
	 * Imprime la matriz con un mensaje
	 * 
	 * @param mensaje
	 */
	public void imprimeMatriz(String mensaje) {
		System.out.println(mensaje);
		int i, j;
		for (i = 0; i < col; i++) {
			for (j = 0; j < ren; j++) {
				System.out.print(arreglo[i][j] + " ");
			}
			System.out.println("");
		}

	}

	/**
	 * Getter
	 * 
	 * @return Numero de columnas
	 */
	public int getCol() {
		return col;
	}

	/**
	 * Getter
	 * 
	 * @return Numero de renglones
	 */
	public int getRen() {
		return ren;
	}

	/**
	 * Captura los valores para la matriz
	 */
	public void capturaValor() {
		Scanner entrada = new Scanner(System.in);
		int i, j;

		for (i = 0; i < col; i++) {
			for (j = 0; j < ren; j++) {
				System.out.print("Valor de la matriz[" + i + "][" + j + "]");
				arreglo[i][j] = entrada.nextFloat();
			}

		}

	}

}
