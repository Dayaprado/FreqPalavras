/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author dayprado
 */
public class ArvoreBinaria {

    No raiz;
    
    public ArvoreBinaria(No raiz) {
        this.raiz = raiz;
    }

    public No getRaiz() {
        return raiz;
    }
    
    public No getNo(String valor){
        return getNo(new No(valor));
    }    
    public No getNo(No no){
        No atual = this.raiz;
        
        No encontrado = null;
        while (true) {
            int resultado = atual.comparar(no);
            
            // Nó igual
            if (resultado == 0) {
                encontrado = atual;
                break;
            }
            
            // Verifica próximo nó
            else if(atual.getProximoNo(no) == null){
                break;
            }
            
            // Percorre próximo nó
            atual = atual.getProximoNo(no);
        }        
        
        return encontrado;
    }        

    public void novoNo(String novoValor) {
        novoNo(new No(novoValor));
    }

    public void novoNo(No novoNo) {
        No atual = this.raiz;
        boolean encontrado = false;
        while (true) {
            int resultado = atual.comparar(novoNo);
            
            // Nó igual
            if (resultado == 0) {
                encontrado = true;
                atual.acumular();
                break;
            }
            
            // Verifica próximo nó
            else if(atual.getProximoNo(novoNo) == null){
                break;
            }
            
            // Percorre próximo nó
            atual = atual.getProximoNo(novoNo);
        }

        // Caso não exista na árvore
        if (!encontrado) {
            atual.adicionar(novoNo);
        }
    }
}
