package conversor_divisas;

import com.fasterxml.jackson.core.JsonProcessingException;
import conversor_divisas.model.Divisa;
import conversor_divisas.model.DivisaBase;
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
            
            ArrayList<Divisa> divisas = bd.getDivisas();
            DivisaBase base = (DivisaBase) divisas.get(DatabaseService.INDEX_OF_BASE);
            
            if(!base.getFecha().equals(LocalDate.now())) {
                String reponse = new APIService().getEquivalencias();
                
                divisas = DeserializationService.buildDivisasList(reponse);
                base = (DivisaBase) divisas.get(DeserializationService.INDEX_OF_BASE);
                
                bd.setNewEquivalencias(base.getEquivalenciasMap(), base.getFecha());
            }
            
            Principal view = new Principal(divisas, base.getFecha());
            view.setVisible(true);
            
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
