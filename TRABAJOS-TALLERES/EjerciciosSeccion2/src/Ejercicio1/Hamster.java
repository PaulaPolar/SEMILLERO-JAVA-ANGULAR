package Ejercicio1;

public class Hamster implements Roedores  {

	@Override
	public String obtenerNombreRoedor() {
		// TODO Auto-generated method stub
		return "Hamster";
	}

	@Override
	public int obtenerAñosDeVida() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public String obtenerAlimentacion() {
		// TODO Auto-generated method stub
		return "semillas y cereales";
	}

	@Override
	public String obtenerNecesidades() {
		// TODO Auto-generated method stub
		return "casita para refugiarse, cama, bebedero, comedero, ruedas, juguetes "
				+ "para roer, trepar";
	}

}
