package conversor_divisas.test;

import conversor_divisas.model.Divisa;
import conversor_divisas.services.ConversionService;

/**
 *
 * @author Esau Montiel
 */
public class ConversorDivisasTest {

    public static void main(String[] args) {
        
        Divisa a = new Divisa("A", "USD");
        Divisa b = new Divisa("B", "MXN");
        Divisa c = new Divisa("C", "ARS");
        
        a.addEquivalencia(b.getClave(), 20);
        a.addEquivalencia(c.getClave(), 10);
        
        ConversionService conversor = new ConversionService(a);
        
        System.out.println(conversor.convertir(c, b, 1));
        System.out.println(conversor.convertir(c, b, 1));
    }
    
}
