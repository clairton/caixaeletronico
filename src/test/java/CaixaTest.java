
import static junit.framework.TestCase.assertEquals;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author clairton
 */
public class CaixaTest {
    
    @Test
    public void testDepositar(){
        Conta conta = new Conta(5.0);
        conta.getSaldo();
        conta.depositar(1.3);
        assertEquals(conta.getSaldo(), 6.3);
    }
    
}
