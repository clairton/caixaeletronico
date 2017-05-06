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
    
    private Double saldo;
    
    public Conta(Double saldo){
        this.saldo = saldo;
    }
    
    public Double getSaldo(){
        return saldo;
    }
    
    public void depositar(Double valor){
        saldo += valor;
    }
}
