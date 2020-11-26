package main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dayprado
 */
public final class FreqPalavras {

    ArvoreBinaria arvore;
    String delimitador = " ";
    List<String> palavras = new ArrayList<>();

    public FreqPalavras(ArvoreBinaria arvore) {
        this.arvore = arvore;
        this.processar();
    }

    public List<String> getPalavras() {
        return this.palavras;
    }

    private void processar() {
        String ultimaPalavra = "";

        // Obtém o primeiro mais a esquerda
        No atual = arvore.getRaiz();
        while (atual != null) {

            // Step 1
            No ultimo = ultimoAEsquerda(atual);
            if(ultimo.comparar(arvore.raiz) != 0){
                atual = ultimo.getPai();            
            }
            
            // Step 2
            ultimaPalavra = adicionarValoresNaLista(atual);
            atual = proximoNo(atual, ultimaPalavra);

        }
    }

    private No proximoNo(No no, String valor) {
        if (no == null) {
            return no;
        }
        
        if (no.comparar(arvore.raiz) == 0) {
            this.adicionarRaizNaLista();
        }
        
        if (no.esquerda != null && no.esquerda.comparar(valor) > 0) {
            return no.esquerda;
        }

        if (no.direita != null && no.direita.comparar(valor) > 0) {
            return no.direita;
        }

        return proximoNo(no.getPai(), valor);
    }

    private No ultimoAEsquerda(No no) {
        No ultimo = no;
        while (ultimo.esquerda != null) {
            ultimo = ultimo.esquerda;
        }

        return ultimo;
    }
    
    private void adicionarRaizNaLista(){
        if(!palavras.contains(arvore.raiz.valor + delimitador + Integer.toString(arvore.raiz.freq)))
            palavras.add(arvore.raiz.valor + delimitador + Integer.toString(arvore.raiz.freq));
    }

    private String adicionarValoresNaLista(No sub) {
        String ultimaPalavra;

        if (sub.esquerda != null) {
            palavras.add(sub.esquerda.valor + delimitador + Integer.toString(sub.esquerda.freq));
            ultimaPalavra = sub.esquerda.valor;
        }

        palavras.add(sub.valor + delimitador + Integer.toString(sub.freq));
        ultimaPalavra = sub.valor;

        if (sub.direita != null && !sub.direita.possuiSubNos()) {
            palavras.add(sub.direita.valor + delimitador + Integer.toString(sub.direita.freq));
            ultimaPalavra = sub.direita.valor;
        }

        return ultimaPalavra;
    }
}
