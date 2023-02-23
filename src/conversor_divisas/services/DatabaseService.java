package conversor_divisas.services;

import conversor_divisas.model.Database;
import conversor_divisas.model.Divisa;
import java.io.Closeable;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Esau Montiel
 */
public class DatabaseService extends Database implements Closeable{
 
    public DatabaseService () throws ClassNotFoundException, SQLException {
        super();
    }
    
    /**
     * 
     * Actualiza los valores de cambio en la base de datos.
     * 
     * @param divisas: ArrayList que contiene los nuevos valores de cambio para cada una de las divisas.
     * @param fecha: Fecha en que fueorn obtenidos estos valores de cambio.
     * 
     * @throws SQLException 
     */
    public void setNewEquivalencias(ArrayList<Divisa> divisas, LocalDate fecha) throws SQLException {
        
        for(Divisa divisa : divisas) {
            super.ejecutarUpdate("UPDATE divisa SET valor_de_cambio = " + divisa.getEquivalencia() + " WHERE clave = '" + divisa.getClave() + "'");
        }
        
        super.ejecutarUpdate("UPDATE divisa_base SET fecha = '" + fecha.toString() + "'");
    }
 
    /**
     * 
     * Obtiene los datos de las divisas de la base de datos.
     * 
     * @return un ArrayList con las divisas obtenidas.
     * @throws SQLException 
     */
    public ArrayList<Divisa> getDivisas() throws SQLException {

        ArrayList<Divisa> divisasObj = new ArrayList<>(163);
        ArrayList<String[]> divisasString = super.ejecutarQuery("SELECT * FROM divisa ORDER BY valor_de_cambio ASC", 3, 163);

        divisasString.forEach( divisa -> {

            divisasObj.add(new Divisa(divisa[0], divisa[1], Float.parseFloat(divisa[2])));

        });
        
        return divisasObj;
    }
    
    /**
     * 
     * Obtiene la fecha en que se obtuvieron las tazas de cambio desde la base de datos.
     * 
     * @return LocalDate con la fecha en que se registro en la base de datos.
     * @throws SQLException 
     */
    public LocalDate getFecha() throws SQLException {
        
        String fecha = super.ejecutarQuery("SELECT fecha FROM divisa_base", "fecha");
        fecha = fecha.substring(0, fecha.indexOf(' '));
        
        return LocalDate.parse(fecha);
        
    }
    
}
