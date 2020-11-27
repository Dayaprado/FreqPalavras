package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author dayana
 */
public class Principal {
    
    //carrega o arquivo, adiciona as palavras na arvore e imprime

    public static void main(String[] args) {
        String arquivo = "./src/arquivos/palavras.txt";
        List<String> palavras = carregarPalavras(arquivo);

        ArvoreBinaria arvore = new ArvoreBinaria(new No(palavras.get(0)));
        for (String palavra : palavras.subList(1, palavras.size())) {
            arvore.novoNo(palavra);
        }

        FreqPalavras freq = new FreqPalavras(arvore);
        freq.imprimir();
    }

    private static List<String> carregarPalavras(String arquivo) {
        List<String> carregadas = new ArrayList<>();

        BufferedReader reader = null;
        try {
            String linha;
            reader = new BufferedReader(new FileReader(arquivo));
            while ((linha = reader.readLine()) != null) {
                String[] palavras = linha.split("\\s+");
                for (String palavra : palavras) {
                    carregadas.add(palavra);
                }
            }
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }

        return carregadas;
    }
}
