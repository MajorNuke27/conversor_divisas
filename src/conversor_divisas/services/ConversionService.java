package conversor_divisas.services;

import conversor_divisas.model.Divisa;

/**
 *
 * @author Esau Montiel
 */
public class ConversionService {

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
        
        /*

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

        return ( (1/divisaInicial.getEquivalencia()) / (1/divisaObjetivo.getEquivalencia())) * cantidad;
        
    }
    
}
