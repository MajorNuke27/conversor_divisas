package conversor_divisas;

import com.fasterxml.jackson.core.JsonProcessingException;
import conversor_divisas.model.Divisa;
import conversor_divisas.services.APIService;
import conversor_divisas.services.DatabaseService;
import conversor_divisas.services.DeserializationService;
import conversor_divisas.view.Principal;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Esau Montiel
 */
public class Conversor_divisas {

    public static void main(String[] args) {
        
        try (DatabaseService bd = new DatabaseService()) { 
            
            ArrayList<Divisa> divisas;
            LocalDate fecha;
            
            if(!bd.getFecha().equals(LocalDate.now())) {
                String response = new APIService().getEquivalencias();
                
                divisas = DeserializationService.buildDivisasList(response);
                fecha = DeserializationService.getFecha(response);
                
                bd.setNewEquivalencias(divisas, fecha);
            }
            
            else {
                divisas = bd.getDivisas();
                fecha = bd.getFecha();
            }
            
            Principal view = new Principal(divisas, fecha);
            view.setVisible(true);
            bd.close();
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un problema con la base de datos, por favor reinicie el programa", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (JsonProcessingException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un problema al obtener las tazas de cambio.\n" + ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            System.out.println("error = " + ex.toString());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un problema con la base de datos, por favor reinicie el programa", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
