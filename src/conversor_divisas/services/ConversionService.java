package conversor_divisas.services;

import conversor_divisas.model.Divisa;

/**
 *
 * @author Esau Montiel
 */
public class ConversionService {
    
    private final Divisa divisaBase;
    private final String claveBase;
    
    public ConversionService(Divisa base) {
        this.divisaBase = base;
        this.claveBase = this.divisaBase.getClave();
    }
    
    /**
     * 
     * Verifica si la divisa recibida ya contiene su equivalenca en divisa base. De no ser asi la obtiene
     * y la almacena en divisa.equivalencias;
     * 
     * @param divisa Divisa de la cual se quiere revisar si ya contiene su equivalencia en divisa base
     */
    private void checkEquivalenciaBase(Divisa divisa) {
        
        //Si no contiene la equivalencia de 1 divisa en this.base
        if(!divisa.containsEquivalencia(this.divisaBase.getClave())) {
            
            float conversion = this.divisaBase.getEquivalencia(divisa.getClave());
            conversion = 1/conversion;
            divisa.addEquivalencia(this.divisaBase.getClave(), conversion);
            
        }//fin if
        
    }
    
    /**
     * 
     * Convierta la cantidad ingresada divisaInicial en divisaObjetivo.
     * 
     * @param divisaInicial Divisa a partir de la cual se desea convertir hacia divisaObjetivo.
     * @param divisaObjetivo Divisa hacia la cual se desea convertir a partir de la divisaInicial.
     * @param cantidad Cantidad de divisaInicial que se desea convertir hacia divisaObjetivo.
     * @return La equivalencia de 1 divisaInicial en divisaObjetivo, multiplicado por la cantidad.
     */
    
    public float convertir(Divisa divisaInicial, Divisa divisaObjetivo, float cantidad) {
        
        this.checkEquivalenciaBase(divisaInicial);
        this.checkEquivalenciaBase(divisaObjetivo);
        
        if(!divisaInicial.containsEquivalencia(divisaObjetivo.getClave())) {
            
            /*
            
                1 divisaInicial = X divisa(s)Objetivo = equivalencia
                *NOTA: Todas las conversiones se realizan utilizando como referencia la divisa base
            
                Ejemplo: 
                    
                divisaBase = USD
                divisaInicial = MXN
                divisaObjetivo = ARS
                
                1USD = 20MXN
                0.05USD = 1MXN
            
                1USD = 10ARS
                0.1USD = 1ARS
            
                0.1USD = 1ARS
                0.05USD = ? ARS
            
                (0.05USD * 1ARS) / 0.1USD = 0.5ARS
            
                0.05USD = 0.5ARS = 1MXN
            
                conversion = 0.5ARS
            
            */ 
            float equivalencia = divisaInicial.getEquivalencia(this.claveBase) / divisaObjetivo.getEquivalencia(this.claveBase);
            
            divisaInicial.addEquivalencia(divisaObjetivo.getClave(), equivalencia);
            
            return equivalencia * cantidad;
            
        }
        
        return divisaInicial.getEquivalencia(divisaObjetivo.getClave()) * cantidad;
    }
    
}
