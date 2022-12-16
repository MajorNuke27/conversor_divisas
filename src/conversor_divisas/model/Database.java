package conversor_divisas.model;

import java.io.Closeable;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yoshi
 */
public abstract class Database implements Closeable{

    private Connection conexion = null;
    
    public Database() throws ClassNotFoundException, SQLException {
        
        this.createConexion();

    }
    
    /**
     * Establece la conexion con a base de datos
     */
    private void createConexion() throws ClassNotFoundException, SQLException {//Establece la conexion con la base de datos
        
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");            
        this.conexion = DriverManager.getConnection("jdbc:ucanaccess://assets\\Divisas.accdb");
        
    }
    
    /**
     * Ejecuta un query que puede retornar mas de un registro.
     * 
     * @param query Query que se desea ejecutar en la base de datos.
     * @param nAtributos Numero de atributos que se desean obtener con el query.
     * @param expectedRegisters Numero aproximado de registros que se espera obtener.
     * @return Un ArrayList con los registros obtenidos por el query.
     * 
     * @throws SQLException
     */
    protected ArrayList<String[]> ejecutarQuery(String query, int nAtributos, int expectedRegisters) throws SQLException {//Ejecuta un query en la base de datos (este puede obtener multiples registros)
              
        ArrayList datos = new ArrayList<String[]>(expectedRegisters);//Almacena todos los registros obtenidos
        String registro [] = new String[nAtributos];//Almacena un registro
        
        Statement stment = this.conexion.createStatement();

        //Ejecutar Query (sentencia SQL)
        ResultSet rs = stment.executeQuery(query);

        while(rs.next()) {//Obtener los datos recibidos de la base de datos

            for(int i=0 ; i<nAtributos ; i++){

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
    
    /**
     * 
     * Ejecuta un query que puede obtener solo un registro.
     * 
     * @param query Query que se desea ejecutar en la base de datos.
     * @param nAtributos Numero de atributos que se desean obtener con el query.
     * 
     * @return Un array de String con los datos obtenidos por el query.
     * 
     * @throws SQLException 
     */
    protected String[] ejecutarQuery(String query, int nAtributos) throws SQLException {
        String registro [] = new String[nAtributos];//Almacena un registro
        
        Statement stment = this.conexion.createStatement();

        //Ejecutar Query (sentencia SQL)
        ResultSet rs = stment.executeQuery(query);
        rs.next();
        
        for(int i=0 ; i<nAtributos ; i++){
            registro[i] = rs.getString(i+1);
        }
        
        rs.close();
        stment.close();
        
        return registro;
    }
    
    /**
     * 
     * Ejecuta un query con el cual se desea obtener un solo dato o atributo de una tabla.
     * 
     * @param query Query que se desea ejecutar en la base de datos.
     * @param atributo Nombre del atributo que se desea obtener.
     * 
     * @return Un String que contiene el dato o atributo que se obtuvo con el query.
     * 
     * @throws SQLException 
     */
    protected String ejecutarQuery(String query, String atributo) throws SQLException {//Ejecuta un query en la base de datos (Este metodo obtiene un solo dato)
        
        String dato;//Almacena todos los registros obtenidos
        
        Statement stment = this.conexion.createStatement();

        //Ejecutar Query (sentencia SQL)
        ResultSet rs = stment.executeQuery(query);
        
        rs.next();
        dato = rs.getString(atributo);
        
        rs.close();
        stment.close();
        
        return dato;
        
    }
    
    /**
     * 
     * Ejecuta un update (sentencia SQL con las palabras INSERT, ALTER, UPDATE) en la base de datos.
     * 
     * @param query Sentencia SQL que se desea ejecutar en la base de datos.
     * 
     * @throws SQLException
     * @throws SQLIntegrityConstraintViolationException 
     */
    protected void ejecutarUpdate(String query) throws SQLException, SQLIntegrityConstraintViolationException{
            
            Statement stment = this.conexion.createStatement();
            
            //Ejecutar Query (sentencia SQL)
            stment.executeUpdate(query);
            stment.close();
        
    }

    @Override
    public void close() throws IOException {
        try {
            this.conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
