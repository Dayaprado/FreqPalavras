/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

import main.*;

/**
 *
 * @author crisdut
 */
public class FreqPalavrasTest {
    
    public FreqPalavrasTest() {
    }
    
    @Test
    public void permiteOrdernarPalavras() {
        ArvoreBinaria arvore = new ArvoreBinaria(new No("50"));
       
        arvore.novoNo("80");
        arvore.novoNo("60");
        arvore.novoNo("90");
        arvore.novoNo("89");
        arvore.novoNo("100");         
        
        arvore.novoNo("30");
        arvore.novoNo("20");
        arvore.novoNo("10");
        arvore.novoNo("21");        
        arvore.novoNo("40");
        arvore.novoNo("39");
        arvore.novoNo("45");
        arvore.novoNo("100");        
        
        
        FreqPalavras freq = new FreqPalavras(arvore);
        
        assertEquals("10 1", freq.getPalavras().get(0));
        assertEquals("100 2", freq.getPalavras().get(11));        
    }
}
