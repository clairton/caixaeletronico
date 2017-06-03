
import java.time.LocalDateTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author clairton
 */
public class Movimento {
    private LocalDateTime ocorridoEm;
    
    private Double valor;
    
    public Movimento(LocalDateTime ocorridoEm, Double valor){
        this.ocorridoEm = ocorridoEm;
        this.valor = valor;
    }
    
    public Double getValor(){
        return valor;
    }
    
    public LocalDateTime getOcorridoEm(){
        return ocorridoEm;
    }
}
