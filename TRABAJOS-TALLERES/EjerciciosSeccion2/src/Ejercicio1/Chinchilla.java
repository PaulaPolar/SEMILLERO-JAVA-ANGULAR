package Ejercicio1;

public class Chinchilla implements Roedores {
	private String nombre = "Chinchilla";

	@Override
	public String obtenerNombreRoedor() {
		// TODO Auto-generated method stub
		return nombre;
	}

	@Override
	public int obtenerA�osDeVida() {
		
		return 20;
	}

	@Override
	public String obtenerAlimentacion() {
		// TODO Auto-generated method stub
		return "frutas y verduras";
	}

	@Override
	public String obtenerNecesidades() {
		// TODO Auto-generated method stub
		return "jaula de varios pisos, comedero, bebedero, tuneles,"
				+ "ba�os de arena";
	}
	
}
