import java.util.*;

public class App {
    public static void main(String[] args) {
        ArvoreBinariaDeBusca arvore = new ArvoreBinariaDeBusca();
        Random rand = new Random();

        // Sorteando e inserindo 20 números aleatórios
        Set<Integer> numeros = new HashSet<>();
        while (numeros.size() < 20) {
            int numero = rand.nextInt(101);
            if (!numeros.contains(numero)) {
                numeros.add(numero);
                arvore.inserir(numero);
            }
        }

        System.out.println("Números sorteados: " + numeros);

        // Impressões nas diferentes ordens
        System.out.println("Pré-ordem:");
        arvore.imprimirPreOrdem();

        System.out.println("Em ordem:");
        arvore.imprimirEmOrdem();

        System.out.println("Pós-ordem:");
        arvore.imprimirPosOrdem();

        System.out.println("Em nível:");
        arvore.imprimirNivelOrdem();

        // Removendo 5 elementos
        List<Integer> listaNumeros = new ArrayList<>(numeros);
        Collections.shuffle(listaNumeros);
        for (int i = 0; i < 5; i++) {
            arvore.removerChave(listaNumeros.get(i));
        }

        System.out.println("\nNúmeros restantes após remoção: " + listaNumeros.subList(5, listaNumeros.size()));

        // Impressões após remoções
        System.out.println("Pré-ordem após remoções:");
        arvore.imprimirPreOrdem();

        System.out.println("Em ordem após remoções:");
        arvore.imprimirEmOrdem();

        System.out.println("Pós-ordem após remoções:");
        arvore.imprimirPosOrdem();

        System.out.println("Em nível após remoções:");
        arvore.imprimirNivelOrdem();
    }
}
