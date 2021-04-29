package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		/*Cree una jerarquía de herencia de Roedores: Raton, Gerbo, Hamster, etc. 
		En la clase base, proporcione los métodos que son comunes a todos los roedores, 
		y redefina aquellos en las clases derivadas para que tengan diferentes comportamientos 
		dependiendo del tipo específico de roedor. Cree un array de punteros a Roedor, rellenelo 
		con distintos tipos de roedores y llame a los métodos de la clase base para ver lo que ocurre*/
		
		List<Roedores> roedores = new ArrayList<>();
		
		Roedores primero = new Chinchilla();
		Roedores segundo = new Cobaya();
		Roedores tercero = new Degu();
		Roedores cuarto = new Hamster();
		
		roedores.add(primero);
		roedores.add(segundo);
		roedores.add(tercero);
		roedores.add(cuarto);
		
		for (Roedores roedor : roedores) {
			System.out.println("Soy: " + roedor.obtenerNombreRoedor());
			System.out.println("Vivo aproximadamente: " + roedor.obtenerAñosDeVida() + " años");
			System.out.println("Mi alimentacion es: " + roedor.obtenerAlimentacion());
			System.out.println("Mis necesidades son: " + roedor.obtenerNecesidades());
			System.out.println("");
		}
		
		
	}

}
