
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movimentos")
public class Movimento {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    
    @Column(name = "ocorrido_em")
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
