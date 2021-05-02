package ejercicio1;

import java.sql.*;
import java.util.ArrayList;

public class PersonaDAO {

	Conexion conexion;
    
    public PersonaDAO(){
        conexion=new Conexion();
    }
    
    //insertar datos
    public String insper(int cedula,String nombres, String apellidos, String sexo, String fechaDeNacimiento, Double salario){
    String rpta=null;
        try {
            Connection acceso=conexion.getConexion();
            PreparedStatement ps = acceso.prepareStatement(

            "insert into persona (`CEDULA`,`NOMBRES`,`APELLIDOS`,`SEXO`,`FECHA_DE_NACIMIENTO`,`SALARIO`) values(?,?,?,?,?,?)");
            ps.setInt(1, cedula);
            ps.setString(2, nombres);
            ps.setString(3, apellidos);
            ps.setString(4, sexo);
            ps.setString(5, fechaDeNacimiento);
            ps.setDouble(6, salario);
            if(ps.executeUpdate()>0)
                rpta="Registro exitoso";
            ps.close();
            acceso.close();
        } catch (Exception e) {
            rpta="El registro ya existe";
        }
    return rpta;
    }
    
    //mostrar datos
    public ArrayList<Persona> lisper(){
    ArrayList listaper = new ArrayList();
    Persona per;
        try {
            Connection acceso=conexion.getConexion();
            PreparedStatement ps = acceso.prepareStatement("select * from persona order by `NOMBRES` asc;");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                per=new Persona();
                per.setCedula(rs.getInt(1));
                per.setNombres(rs.getString(2));
                per.setApellidos(rs.getString(3));
                per.setSexo(rs.getString(4));
                per.setFechaDeNacimiento(rs.getString(5));
                per.setSalario(rs.getDouble(6));
                
                listaper.add(per);
            }
            rs.close();
            ps.close();
            acceso.close();
        } catch (Exception e) {
        }
    return listaper;
    }
    
    //editar persona
    public int ediper(int cedula,String nombres, String apellidos, String sexo, String fechaDeNacimiento, Double salario){
    int rpta=0;
        try {
            Connection acceso=conexion.getConexion();
            PreparedStatement ps =  acceso.prepareStatement(
            "update persona set NOMBRES=?, APELLIDOS=?, SEXO=?, FECHA_DE_NACIMIENTO=?, SALARIO=? where CEDULA=?");
            ps.setString(1, nombres);
            ps.setString(2, apellidos);
            ps.setString(3, sexo);
            ps.setString(4, fechaDeNacimiento);
            ps.setDouble(5, salario);
            
            rpta=ps.executeUpdate();
            ps.close();
            acceso.close();
        } catch (Exception e) {
        }
    return rpta;
    }
    
    //eliminar persona
    public int eliper(int ced) {
    int rpta=0;
        try {
            Connection acceso=conexion.getConexion();
            PreparedStatement ps =  acceso.prepareStatement(
            "delete from persona where CEDULA=?");
            ps.setInt(1, ced);
            rpta=ps.executeUpdate();
            ps.close();
            acceso.close();
        } catch (Exception e) {
        }
    return rpta;
    }
 
    //filtro por el apellido
    public ArrayList<Persona> busape(String apellidos){
    ArrayList<Persona> listaper=new ArrayList();
    Persona per;
        try {
            Connection acceso=conexion.getConexion();
            PreparedStatement ps = acceso.prepareStatement(
            "select * from persona where APELLIDOS like concat(?,'%')");
            ps.setString(1, apellidos);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                per = new Persona();
                per.setCedula(rs.getInt("CEDULA"));
                per.setNombres(rs.getString("NOMBRES"));
                per.setApellidos(rs.getString("APELLIDOS"));
                per.setSexo(rs.getString("SEXO"));
                per.setFechaDeNacimiento(rs.getString("FECHA_DE_NACIMIENTO"));
                per.setSalario(rs.getDouble("SALARIO"));
                listaper.add(per);
            }
            rs.close();
            ps.close();
            acceso.close();
        } catch (Exception e) {
        }
    return listaper;
    }
 
    //Para colocarle a cada primera letra de los nombres y apellidos en mayusculas, 
    //concatear estas dos columnas y agregarle la longitud total de sus apellidos
    //organizado de forma ascendente
    
    public ArrayList<Persona> funcion1(){
        ArrayList listaper = new ArrayList();
        Persona per;
            try {
                Connection acceso=conexion.getConexion();
                PreparedStatement ps = acceso.prepareStatement("SELECT concat(upper(left(SUBSTRING_INDEX(NOMBRES, ' ', 1),1)), lower(substring(SUBSTRING_INDEX(NOMBRES, ' ', 1),2)),' ', upper(left(SUBSTR(NOMBRES, LENGTH( SUBSTRING_INDEX(NOMBRES, ' ', 1) ) + 2 ),1)), lower(substring(SUBSTR(NOMBRES, LENGTH( SUBSTRING_INDEX(NOMBRES, ' ', 1) ) + 2 ),2)),' ', upper(left(SUBSTRING_INDEX(APELLIDOS, ' ', 1),1)), lower(substring(SUBSTRING_INDEX(APELLIDOS, ' ', 1),2)),' ', upper(left(SUBSTR( APELLIDOS, LENGTH( SUBSTRING_INDEX(APELLIDOS, ' ', 1) ) + 2 ),1)), lower(substring(SUBSTR( APELLIDOS, LENGTH( SUBSTRING_INDEX(APELLIDOS, ' ', 1) ) + 2 ),2))) AS NOMBRE, char_length(APELLIDOS) AS LONGITUD FROM persona order by NOMBRES asc;");
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
                    per=new Persona();
                    per.setNombres(rs.getString(1)); 
                    per.setLongitud(rs.getInt(2)); 
                    listaper.add(per);
                }
                rs.close();
                ps.close();
                acceso.close();
            } catch (Exception e) {
            }
        return listaper;
        }
    
    

    
    /*Para pasar los nombres a mayuscula de las personas quien nacieron despues de 2010-01-01*/
    public ArrayList<Persona> funcion2(){
        ArrayList listaper = new ArrayList();
        Persona per;
            try {
                Connection acceso=conexion.getConexion();
                PreparedStatement ps = acceso.prepareStatement("SELECT upper(NOMBRES), FECHA_DE_NACIMIENTO FROM persona WHERE FECHA_DE_NACIMIENTO>\"2010-01-01\" ;");
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
                    per=new Persona();
                    per.setNombres(rs.getString(1));
                    per.setFechaDeNacimiento(rs.getString(2));
                    
                    listaper.add(per);
                }
                rs.close();
                ps.close();
                acceso.close();
            } catch (Exception e) {
            }
        return listaper;
        }

    /*Para mostrar el promedio de los salarios de hombre y mujeres */
    public ArrayList<Persona> funcion3(){
        ArrayList listaper = new ArrayList();
        Persona per;
            try {
                Connection acceso=conexion.getConexion();
                PreparedStatement ps = acceso.prepareStatement("select upper(SEXO), AVG(SALARIO)  from persona group by `SEXO`;");
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
                    per=new Persona();
                    per.setSexo(rs.getString(1));
                    per.setPromSalarioSexo(rs.getDouble(2));
                    
                    listaper.add(per);
                }
                rs.close();
                ps.close();
                acceso.close();
            } catch (Exception e) {
            }
        return listaper;
        }
    

    /*Para mostrar el promedio de los salarios pero que son mayores a 1000 agrupados por sexo*/
    public ArrayList<Persona> funcion4(){
        ArrayList listaper = new ArrayList();
        Persona per;
            try {
                Connection acceso=conexion.getConexion();
                PreparedStatement ps = acceso.prepareStatement("select upper(SEXO),(select AVG(SALARIO) from persona per WHERE per.SEXO=por.SEXO ) as Sala from persona por  group by SEXO HAVING Sala >1000;");
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
                    per=new Persona();
                    per.setSexo(rs.getString(1));
                    per.setPromSalarioSexo(rs.getDouble(2));
                    
                    listaper.add(per);
                }
                rs.close();
                ps.close();
                acceso.close();
            } catch (Exception e) {
            }
        return listaper;
        }
    	
}
