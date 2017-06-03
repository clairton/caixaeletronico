
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author clairton
 */
public class Conta {
    
    private Double saldo = 0.0;
    
    private Collection<Movimento> movimentacao = new ArrayList<Movimento>();
    
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
