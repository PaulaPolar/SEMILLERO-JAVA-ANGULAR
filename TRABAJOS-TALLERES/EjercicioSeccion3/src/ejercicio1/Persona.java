package ejercicio1;

public class Persona {
	private int cedula;
    private String nombres;
    private String apellidos;
    private String sexo;
    private String fechaDeNacimiento;
    private Double salario;
    private int longitud;
    private Double promSalarioSexo;

    public Persona() {
    	
    }

    
    public int getLongitud() {
		return longitud;
	}


	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}


	public Double getPromSalarioSexo() {
		return promSalarioSexo;
	}


	public void setPromSalarioSexo(Double promSalarioSexo) {
		this.promSalarioSexo = promSalarioSexo;
	}


	public int getCedula() {
		return cedula;
	}
    
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

}
