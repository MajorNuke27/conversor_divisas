package conversor_divisas.services;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author yoshi
 */
public class DatabaseConnection {

    private Connection conexion = null;
    
    public DatabaseConnection() {
        
        this.conexion();
        
    }
    
    
    private void conexion() {//Establece la conexion con la base de datos
        
        try {
            //Conectar base de datos
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");            
            this.conexion = DriverManager.getConnection("jdbc:ucanaccess://src\\Archivos\\PuntoVenta.accdb");
            
            //System.out.println("Conexión con la base de datos establecida\n");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        
    }
    
    public ArrayList<String[]> ejecutarQuery(String query, int nAtributos) throws SQLException {//Ejecuta un query en la base de datos (este puede obtener multiples resgistros)
        
        ArrayList datos = new ArrayList<String[]>();//Almacena todos los registros obtenidos
        String registro [] = new String[nAtributos];//Almacena un registro
        
        Statement stment = this.conexion.createStatement();

        //Ejecutar Query (sentencia SQL)
        ResultSet rs = stment.executeQuery(query);

        while(rs.next()) {//Obtener los datos recibidos de la base de datos

            for(int i=0 ; i<nAtributos; i++){

//                if (i>=0&&i<(nAtributos-1)) registro[(i+1)] = rs.getString((i+1));
//                else registro[0] = rs.getString((i+1));

                registro[i] = rs.getString(i+1);

            }

            datos.add(registro);
            
            registro = new String[nAtributos];

        }//fin while
        
        rs.close();
        stment.close();
        
        return datos;
    }
    
    public String ejecutarQuery(String query, String atributo) throws SQLException {//Ejecuta un query en la base de datos (Este metodo obtiene un solo dato)
        
        String dato = "";//Almacena todos los registros obtenidos
        
        Statement stment = this.conexion.createStatement();

        //Ejecutar Query (sentencia SQL)
        ResultSet rs = stment.executeQuery(query);
        
        rs.next();
        dato = rs.getString(atributo);
        
        rs.close();
        stment.close();
        
        return dato;
        
    }
    
    public void ejecutarUpdate(String query) throws SQLException, SQLIntegrityConstraintViolationException{
            
            Statement stment = this.conexion.createStatement();
            
            //Ejecutar Query (sentencia SQL)
            stment.executeUpdate(query);
            stment.close();
        
    }
    
}
