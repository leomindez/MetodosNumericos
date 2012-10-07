package com.leon.util;

import java.util.Scanner;

/**
 * Clase que controla el menu de opciones
 * 
 * @author leon
 * 
 */
public class Menu {

	/**
	 * Menu de opciones
	 */
	public static void menu() {

		Matriz matriz, vector, resultado;
		MetodoNumerico metodoNumerico;

		System.out.println("Escoge el método que quieres emplear: " + "\n"
				+ "1.- Gauss" + "\n" + "2.- Gauss-Jordan" + "\n"
				+ "3.- Gauss-Seidel");
		int opcion = 0;
		Scanner scanner = new Scanner(System.in);
		opcion = scanner.nextInt();

		switch (opcion) {
		case 1:
			matriz = new Matriz(3, 3);
			vector = new Matriz(1, 3);

			matriz.capturaValor();
			matriz.imprimeMatriz("Matriz");

			vector.capturaValor();
			vector.imprimeMatriz("Vector");

			metodoNumerico = new MetodoNumerico();
			metodoNumerico.eliminacionGaussiana(matriz, vector);
			System.out.println("---------------------------------------------");

			matriz.imprimeMatriz("Matriz resuelta.");
			vector.imprimeMatriz("Vector resultado.");

			break;
		case 2:

			matriz = new Matriz(3, 3);
			vector = new Matriz(1, 3);

			matriz.capturaValor();
			matriz.imprimeMatriz("Matriz");

			vector.capturaValor();
			vector.imprimeMatriz("Vector");

			metodoNumerico = new MetodoNumerico();
			metodoNumerico.gaussJordan(matriz, vector);
			System.out.println("---------------------------------------------");

			matriz.imprimeMatriz("Matriz resuelta.");
			vector.imprimeMatriz("Vector resultado.");

			break;

		case 3:

			matriz = new Matriz(3, 3);
			vector = new Matriz(1, 3);
			resultado = new Matriz(1, 3);

			matriz.capturaValor();
			matriz.imprimeMatriz("Matriz");

			vector.capturaValor();
			vector.imprimeMatriz("Vector");

			metodoNumerico = new MetodoNumerico();
			metodoNumerico.gaussSeidel(matriz, vector, resultado);
			System.out.println("---------------------------------------------");

			resultado.imprimeMatriz("Vector resultado");

			break;

		default:
			System.out.println("Elige una opción correcta.");
			break;
		}
	}
}
