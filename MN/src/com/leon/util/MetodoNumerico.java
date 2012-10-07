package com.leon.util;

/**
 * @author German Santos / Leonel Mendez Jimenez
 * 
 */
public class MetodoNumerico {

	/**
	 * Metodo de Gauss
	 * 
	 * @param matriz
	 * @param vector
	 * 
	 */
	public void eliminacionGaussiana(Matriz matriz, Matriz vector) {
		int k, i, j;
		float cte = 0, temp;
		for (i = 0; i < matriz.getCol(); i++) {
			for (j = i + 1; j < matriz.getCol(); j++) {

				cte = matriz.getValor(j, i) / matriz.getValor(i, i);

				for (k = i; k < matriz.getRen(); k++) {
					temp = matriz.getValor(j, k) - cte * matriz.getValor(i, k);
					matriz.setValor(j, k, temp);
				}
				temp = vector.getValor(0, j) - cte * vector.getValor(0, i);
				vector.setValor(0, j, temp);
			}
		}
	}

	/**
	 * Método de Gauss-Seidel
	 * 
	 * @param matriz
	 * @param vector
	 */
	public void gaussJordan(Matriz matriz, Matriz vector) {
		int i, j, k;
		float cte = 0, temp = 0, temp2 = 0;

		for (i = 0; i < matriz.getCol(); i++) {
			cte = matriz.getValor(i, i);
			for (j = 0; j < matriz.getCol(); j++) {
				temp = matriz.getValor(i, j) / cte;
				matriz.setValor(i, j, temp);
			}

			temp = vector.getValor(0, i) / cte;
			vector.setValor(0, i, temp);

			for (j = i + 1; j < matriz.getCol(); j++) {
				cte = matriz.getValor(j, i);

				for (k = 0; k < matriz.getRen(); k++) {
					temp = matriz.getValor(j, k) - cte * matriz.getValor(i, k);
					matriz.setValor(j, k, temp);
				}
				temp = vector.getValor(0, j) - cte * vector.getValor(0, i);
				vector.setValor(0, j, temp);
			}
		}

		for (i = matriz.getCol() - 1; i >= 0; i--) {

			for (j = i - 1; j >= 0; j--) {
				cte = matriz.getValor(j, i);
				temp = matriz.getValor(j, i) - cte * matriz.getValor(i, i);
				matriz.setValor(j, i, temp);
				temp2 = vector.getValor(0, j) - cte * vector.getValor(0, i);
				vector.setValor(0, j, temp2);

			}
		}
	}

	/**
	 * Método de Gauss-Seidel
	 * 
	 * @param matriz
	 * @param vector
	 * @param resultado
	 */
	public void gaussSeidel(Matriz matriz, Matriz vector, Matriz resultado) {

		int i, j, k;
		boolean bandera;
		float suma, cte, xAnterior, ea, temp, vecTemp;
		for (i = 0; i < matriz.getCol(); i++) {
			cte = matriz.getValor(i, i);
			for (j = 0; j < matriz.getCol(); j++) {
				temp = matriz.getValor(i, j) / cte;
				matriz.setValor(i, j, temp);
			}
			vecTemp = vector.getValor(0, i) / cte;
			vector.setValor(0, i, vecTemp);
		}
		for (i = 0; i < matriz.getCol(); i++) {
			suma = vector.getValor(0, i);
			for (j = 0; j < matriz.getCol(); j++) {
				if (i != j) {
					suma -= matriz.getValor(i, j) * resultado.getValor(0, j);
				}
				resultado.setValor(0, i, suma);
			}
		}
		for (i = 0; i <= matriz.getCol() + 5; i++) {
			bandera = true;
			for (j = 0; j < matriz.getCol(); j++) {
				xAnterior = resultado.getValor(0, j);
				suma = vector.getValor(0, j);

				for (k = 0; k < matriz.getCol(); k++) {
					if (j != k) {
						suma -= matriz.getValor(j, k)
								* resultado.getValor(0, k);
					}
				}
				resultado.setValor(0, j, suma);
				if (resultado.getValor(0, j) != 0 && bandera == true) {
					ea = Math.abs((resultado.getValor(0, j) - xAnterior)
							/ resultado.getValor(0, j) * 1000);
					if (ea > 0.0001) {
						bandera = false;
					}
				}
			}
			if (bandera == true) {
				break;
			}
		}

	}
}