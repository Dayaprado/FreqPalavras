
package main;

/**
 *
 * @author dayprado
 */
public class No {

    int freq;
    public String valor;
    
    public No esquerda;
    public No direita;
    No pai;
    
    public No(String valor) {
        this.freq = 1;
        this.valor = valor;
    } 

    public void adicionar(String valor) {
        this.adicionar(new No(valor));
    }

    public void adicionar(No subNo) {
        subNo.adicionarPai(this);
        if(this.comparar(subNo) > 0) {
            this.esquerda = subNo;
        } else {
            this.direita = subNo;
        }
    }
    
    public void adicionarPai(No pai) {
        this.pai = pai;
    }
    
    public void acumular(){
        this.freq++;
    }
    
    public int comparar(No no){
        return comparar(no.valor);
    }
    
    public int comparar(String valor){
        // Numeric Fix
        if(isNumeric(this.valor) && isNumeric(valor)){
            Integer a = Integer.parseInt(this.valor);
            Integer b = Integer.parseInt(valor);            
            return a.compareTo(b);
        }
        
        return this.valor.compareToIgnoreCase(valor);
    }

    public int getFreq(){
        return freq;
    }
    
    
    public No getPai(){
        return this.pai;
    }
    
    public No getProximoNo(No no){
        if(comparar(no) > 0) {
            return esquerda;
        }else{
            return direita;
        }
    }
    
    public boolean possuiSubNos() {
        return this.esquerda != null || this.direita != null;
    }
    
    private boolean isNumeric(String s) {  
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
    }  
}
