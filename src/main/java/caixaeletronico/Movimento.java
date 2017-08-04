package caixaeletronico;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Entity
@Table(name = "movimentos")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Movimento  implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    
    @Column(name = "ocorrido_em")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime ocorridoEm;
    
    private Double valor;
    
    @Deprecated
    protected Movimento(){}
    
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
