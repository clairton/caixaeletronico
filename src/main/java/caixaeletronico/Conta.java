package caixaeletronico;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "contas")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Conta implements Serializable {
	private static final long serialVersionUID = 1L;
    
    @Id
    private String numero;
    
    private Double saldo = 0.0;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "conta_numero")
    private Collection<Movimento> movimentacao = new ArrayList<Movimento>();
    
    @Deprecated
    protected Conta(){
    }
    
    public Conta(Double valor){
        this(valor, LocalDateTime.now());
    }
    
    public Conta(String numero, Double valor){
        this(valor, LocalDateTime.now());
        this.numero = numero;
    }
    
    public Conta(String numero, Double valor, LocalDateTime ocorridoEm){
        this(valor, ocorridoEm);
        this.numero = numero;
    }
    
    public Conta(Double saldo, LocalDateTime ocorridoEm){
        this.depositar(saldo, ocorridoEm);
    }
    
    public Double getSaldo(){
        return saldo;
    }
    
    public void depositar(Double valor){
        depositar(valor, LocalDateTime.now());
    }
    
    public void depositar(Double valor, LocalDateTime ocorridoEm){
        saldo += valor;
        Movimento movimento = new Movimento(ocorridoEm, valor);
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
