package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
		Connection con;
	    
	    public Conexion(){
	    
	    }
	    
	    public Connection getConexion(){
	    con=null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	            con=DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/mydb", "root", "vida..12");
	            
	        } catch (Exception e) {
	        	System.out.println(e.getMessage());
	        }
	    return con;
	    }
}
