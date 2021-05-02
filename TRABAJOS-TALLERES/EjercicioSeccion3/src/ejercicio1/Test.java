package ejercicio1;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		/*Cree una tabla llamada PERSONA, campos:
		Nombres -- varchar2, apellidos -- varchar2, sexo –- Varchar2, fecha nacimiento -- Date, salario -- NUMBER(8,2)
		- Inserte 10 registros diferentes.
		- Desde JAVA, muestre una lista de los nombres y apellidos de las personas concatenados, con la primera letra en mayúscula, además, muestre la longitud total de los apellidos.
		- Desde java, muestre los nombres de las personas en mayúscula cuya fecha de nacimiento sea mayor a 01/01/2010
		- Desde java, muestre el salario promedio (AVG) de las personas agrupadas por sexo.
		- Del grupo anterior excluya los grupos cuyo promedio es menor a 1000*/
		
		PersonaDAO e = new PersonaDAO();
		
		//para insertar los 10 datos - primer punto
		/*e.insper(1000354465,"Luisa Maria","Ramos Peña","Femenino","2009-5-01",1000.12);
		e.insper(1000365598,"carlos antonio","colmenares azar","Masculino","2010-5-20",600.298);
		e.insper(1059659626,"laura sofia","murcia lopez","femenino","2012-11-16",1599.0);
		e.insper(1125463569,"maira carolina","gutierrez","Femenino","2006-3-3",2566.0);
		e.insper(1025666956,"juan diego","muñoz muñoz","masculino","2002-8-2",650.0);
		e.insper(66613522,"marta","angarita collares","femenino","1990-5-1",956.0);
		e.insper(26459471,"samuel ronaldo","quiza","masculino","1985-2-25",240.8);
		e.insper(26598748,"jesus alberto","tovar marquin","masculino","1975-1-18",510.0);
		e.insper(26895124,"carolina","maztiza","femenino","1986-7-9",1980.0);
		e.insper(10254625,"nancy","ninco","femenino","2011-12-6",1375.9);*/
		 
        //e.Crear();
        //e.Borrar(2);
        //e.Actualizar(1000365598,"carlos antonio","colmenares azar","Masculino","2010-5-20",600.298);
		System.out.println("Punto 1: las 10 personas regstradas son: ");
		ArrayList<Persona> personas, spunto,tpunto,cpunto,qpunto =new ArrayList();
		personas=e.lisper();
		for(int i=0;i<personas.size();i++) {
			System.out.println("Persona No. "+(i+1));
			System.out.println("Cedula: "+personas.get(i).getCedula()+"\tNombres:"+personas.get(i).getNombres()+"\tApellidos:"+ personas.get(i).getApellidos()+"\tSexo: "+personas.get(i).getSexo()+"\tFecha de nacimiento:"+personas.get(i).getFechaDeNacimiento()+"\tSalario: $"+ personas.get(i).getSalario());
		}	
		System.out.println();
		System.out.println("------------------------------------------------------------------");
		//segundo punto
		System.out.println("Punto 2: Los nombres completos concatenados con su primera letra en mayuscula y con su respectiva longitud de apellidos: "); 
		spunto=e.funcion1();
		for(int i=0;i<spunto.size();i++) {
			System.out.println("Persona No. "+(i+1));
			System.out.println("Nombres: "+spunto.get(i).getNombres()+"\tLongitud de apellidos:"+spunto.get(i).getLongitud());
		}
		System.out.println();
		System.out.println("------------------------------------------------------------------");
		//tercer punto
		System.out.println("Punto 3: Los nombres de las personas en mayúscula cuya fecha de nacimiento es mayor a 01/01/2010 son: ");
		tpunto=e.funcion2();
		for(int i=0;i<tpunto.size();i++) {
			System.out.println("Persona No. "+(i+1));
			System.out.println("Nombres: "+tpunto.get(i).getNombres()+"\tFecha de nacimiento:"+ tpunto.get(i).getFechaDeNacimiento());
		}
		System.out.println();
		System.out.println("------------------------------------------------------------------");
		//cuarto punto
		System.out.println("Punto 4: El promedio de los salarios de las personas agrupadas por sexo son: ");
		cpunto=e.funcion3();
		for(int i=0;i<cpunto.size();i++) {
			System.out.println("Sexo: "+cpunto.get(i).getSexo()+"\tPromedio: $"+cpunto.get(i).getPromSalarioSexo());
		}
		System.out.println();
		System.out.println("------------------------------------------------------------------");
		//quinto punto
		System.out.println("Punto 5: Del grupo anterior excluyendo el(los) grupo(s) cuyo promedio es menor a 1000 es(son): ");
        qpunto=e.funcion4();
        for(int i=0;i<qpunto.size();i++) {
			System.out.println("Sexo: "+qpunto.get(i).getSexo()+"\tPromedio: $"+qpunto.get(i).getPromSalarioSexo());
		}
	}

}
