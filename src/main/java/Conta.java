
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contas")
public class Conta {
    
    @Id
    private String numero;
    
    private Double saldo = 0.0;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "conta_numero")
    private Collection<Movimento> movimentacao = new ArrayList<Movimento>();
    
    @Deprecated
    protected Conta(){
    }
    
    public Conta(String numero, Double valor){
        this(valor);
        this.numero = numero;
    }
    
    public Conta(Double saldo){
        this.depositar(saldo);
    }
    
    public Double getSaldo(){
        return saldo;
    }
    
    public void depositar(Double valor){
        saldo += valor;
        Movimento movimento = new Movimento(LocalDateTime.now(), valor);
        movimentacao.add(movimento);
    }
    
    public void sacar(Double valor){
        if(valor > saldo){
            throw new RuntimeException("Valor maior que saldo");
        }
        Movimento movimento = new Movimento(LocalDateTime.now(), valor);
        movimentacao.add(movimento);
        saldo -= valor;
    }
    
    public Collection<Movimento> getMovimentacao(){
        return movimentacao;
    }

    void transferir(Conta conta, Double valor) {
        conta.depositar(valor);
        try{
            sacar(valor);
        } catch(RuntimeException e){
            conta.sacar(valor);
            throw e;
        }
    }
}
