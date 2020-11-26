
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

import main.*;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author dayprado
 */
public class ArvoreBinariaTest {
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void todaArvoreDevePossuirUmaRaiz() {
        No no = new No("Teste");
        ArvoreBinaria arvore = new ArvoreBinaria(no);
        
        assertNotNull(arvore.getRaiz());
    }
    
    @Test
    public void permitirAdicionarNovoNoNaArvore() {
        ArvoreBinaria arvore = new ArvoreBinaria(new No("Teste"));
        
        arvore.novoNo("B");
        arvore.novoNo(new No("B"));      
        
        assertNotNull(arvore.getRaiz());
        assertNotNull(arvore.getRaiz().possuiSubNos());
    }
    
    @Test
    public void permitirContarFreqDoValorNaArvore() {
        ArvoreBinaria arvore = new ArvoreBinaria(new No("B"));
        
        arvore.novoNo("A");
        arvore.novoNo(new No("A"));        
        
        assertNotNull(arvore.getRaiz());
        assertNotNull(arvore.getRaiz().esquerda);
        assertEquals(2, arvore.getRaiz().esquerda.getFreq());        
    }
    
    @Test
    public void permitirAdicionarNoDescendenteNaArvore() {
        ArvoreBinaria arvore = new ArvoreBinaria(new No("B"));
        
        arvore.novoNo("A");
        arvore.novoNo(new No("C"));
        arvore.novoNo(new No("D"));        
        
        assertNotNull(arvore.getRaiz());
        assertEquals("B", arvore.getRaiz().valor);
        assertEquals("A", arvore.getRaiz().esquerda.valor);
        assertEquals("C", arvore.getRaiz().direita.valor);        
        assertEquals("D", arvore.getRaiz().direita.direita.valor);        
    }
    
    @Test
    public void permitirPesquisarNoNaArvore() {
        ArvoreBinaria arvore = new ArvoreBinaria(new No("B"));
        
        arvore.novoNo("A");
        arvore.novoNo(new No("C"));
        arvore.novoNo(new No("D"));        
        
        No encontrado = arvore.getNo("D");
        No naoEncontrado = arvore.getNo("F");        
        
        assertNotNull(encontrado);
        assertEquals(null, naoEncontrado);        
        assertEquals("D", encontrado.valor);
    }
}
