package Ejercicio2;

import java.util.Scanner;

public class SolucionTresEjercicios {
	
	
	/*--Dada una cadena compuesta por “dd/MM/YYYY”, cree tres nuevos elementos que separen los valores 
	para día, mes y año. Ejemplo: 01/03/2018  Imprimir en tres valores variables independientes. 01   03   2018.
	--Crear un arreglos de 5 enteros y sumar sus valores.
	--Crear una aplicación que lea 5 precio y sumarlo y si se pasa de 300 agregarle 10% del precio final sino 
	solo el 7% y decir cual de todos fue el precio mas alto. */

	public static void main(String[] args) {
		System.out.println("SOLUCION DEL PRIMER EJERCICIO:  ");
		String fecha="01/03/2018";
		String[] valores = fecha.split("/");
		String valor1 = valores[0]; 
		String valor2 = valores[1]; 
		String valor3 = valores[2];
		System.out.println("Los tres valores variables independientes son: " +  valor1 + "  " + valor2 + "  " + valor3);
		System.out.println();
		
		
		System.out.println("SOLUCION DEL SEGUNDO EJERCICIO:  ");
		int [] enteros= {23, 45, 89, 2, 1000};
		int suma=0;
		for(int i=0;i<enteros.length;i++) {
			suma=suma+enteros[i];
		}
		System.out.println("La suma de los 5 enteros del vector es: "+suma);
		System.out.println();
		
		
		System.out.println("SOLUCION DEL TERCER EJERCICIO:  ");
		double valor,suma2=0,valorMayor=0;
		Scanner leer=new Scanner(System.in);
		double precios[] = new double[5];
		for(int i=0;i<precios.length;i++) {
			System.out.println("Escriba el precio #"+(i+1)+": ");
			valor=leer.nextDouble();
			suma2=suma2+valor;	
			if(valor>valorMayor) {
				valorMayor=valor;
			}
		}
		System.out.println("El total de los precios es: "+ suma2);
		if(suma2>300) {
			suma2 = suma2+((suma2*10)/100);
			System.out.println("Se le agrego el 10% al total quedando en: " + suma2);
		}else {
			suma2 = suma2+((suma2*7)/100);
			System.out.println("Se le agrego el 7% al total quedando en: " + suma2);
		}	
		System.out.println("El precio mas alto fue de: $" + valorMayor);

	}

}
