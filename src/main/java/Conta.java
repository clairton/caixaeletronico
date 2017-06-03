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
    
    public Conta(Double saldo){
        this.depositar(saldo);
    }
    
    public Double getSaldo(){
        return saldo;
    }
    
    public void depositar(Double valor){
        saldo += valor;
    }
    
    public void sacar(Double valor){
        if(valor > saldo){
            throw new RuntimeException("Valor maior que saldo");
        }
        saldo -= valor;
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
