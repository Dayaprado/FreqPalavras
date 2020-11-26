/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import main.No;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dayprado
 */
public class NoTest {
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void todoNoDevePossuirUmValor() {
        No no = new No("Teste");
        assertNotNull(no.valor);
    }
    
    @Test
    public void todoNoDevePossuirFrequencia() {
        No no = new No("Teste");
        assertEquals(1, no.getFreq());
    }    
    
    @Test
    public void permitirAdicionarUmValorDentroNo() {
        No no = new No("A");    
        no.adicionar("B");
    
        assertTrue(no.possuiSubNos());
    }
    
    @Test
    public void permitirAdicionarUmNoDentroNo() {
        No no = new No("A");
        No outro = new No("B");
        no.adicionar(outro);
        
        assertTrue(no.possuiSubNos());
    }
    
    @Test
    public void valoresMenoresSempreAEsquerda() {
        No no = new No("B");
        No outro = new No("A");
        
        no.adicionar(outro);
        
        assertTrue(no.possuiSubNos());
        assertNotNull(no.esquerda);
    } 
    
    @Test
    public void valoresMaioresSempreADireita() {
        No no = new No("A");
        No outro = new No("B");
        
        no.adicionar(outro);
        
        assertTrue(no.possuiSubNos());
        assertNotNull(no.direita);
    } 
}
