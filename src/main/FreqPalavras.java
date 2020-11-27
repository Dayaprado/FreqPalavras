package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author dayprado
 */
public final class FreqPalavras {

    ArvoreBinaria arvore;
    List<String> palavras = new ArrayList<>();

    public FreqPalavras(ArvoreBinaria arvore) {
        this.arvore = arvore;
    }

    public void imprimir(){
        arvore.inOrdem();
    }
}
