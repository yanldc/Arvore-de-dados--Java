import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinariaDeBusca {
    No raiz;

    ArvoreBinariaDeBusca() {
        raiz = null;
    }

    void inserir(int dado) {
        raiz = inserirRec(raiz, dado);
    }

    No inserirRec(No raiz, int dado) {
        if (raiz == null) {
            raiz = new No(dado);
            return raiz;
        }

        if (dado < raiz.dado)
            raiz.esquerdo = inserirRec(raiz.esquerdo, dado);
        else if (dado > raiz.dado)
            raiz.direito = inserirRec(raiz.direito, dado);

        return raiz;
    }

    void removerChave(int dado) {
        raiz = removerRec(raiz, dado);
    }

    No removerRec(No raiz, int dado) {
        if (raiz == null) return raiz;

        if (dado < raiz.dado)
            raiz.esquerdo = removerRec(raiz.esquerdo, dado);
        else if (dado > raiz.dado)
            raiz.direito = removerRec(raiz.direito, dado);
        else {
            if (raiz.esquerdo == null)
                return raiz.direito;
            else if (raiz.direito == null)
                return raiz.esquerdo;

            raiz.dado = valorMinimo(raiz.direito);
            raiz.direito = removerRec(raiz.direito, raiz.dado);
        }

        return raiz;
    }

    int valorMinimo(No raiz) {
        int minv = raiz.dado;
        while (raiz.esquerdo != null) {
            minv = raiz.esquerdo.dado;
            raiz = raiz.esquerdo;
        }
        return minv;
    }

    void imprimirPreOrdem() {
        preOrdemRec(raiz);
        System.out.println();
    }

    void preOrdemRec(No raiz) {
        if (raiz != null) {
            System.out.print(raiz.dado + " ");
            preOrdemRec(raiz.esquerdo);
            preOrdemRec(raiz.direito);
        }
    }

    void imprimirEmOrdem() {
        emOrdemRec(raiz);
        System.out.println();
    }

    void emOrdemRec(No raiz) {
        if (raiz != null) {
            emOrdemRec(raiz.esquerdo);
            System.out.print(raiz.dado + " ");
            emOrdemRec(raiz.direito);
        }
    }

    void imprimirPosOrdem() {
        posOrdemRec(raiz);
        System.out.println();
    }

    void posOrdemRec(No raiz) {
        if (raiz != null) {
            posOrdemRec(raiz.esquerdo);
            posOrdemRec(raiz.direito);
            System.out.print(raiz.dado + " ");
        }
    }

    void imprimirNivelOrdem() {
        if (raiz == null) return;

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);
        while (!fila.isEmpty()) {
            No noTemp = fila.poll();
            System.out.print(noTemp.dado + " ");

            if (noTemp.esquerdo != null) fila.add(noTemp.esquerdo);
            if (noTemp.direito != null) fila.add(noTemp.direito);
        }
        System.out.println();
    }
}
