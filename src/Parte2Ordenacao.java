import java.util.Arrays;

public class Parte2Ordenacao {

    static long comparacoes = 0;
    static long trocas = 0;
    static long seed = 42;

    static long proximo() {
        seed = (seed * 1103515245L + 12345L) & 0xFFFFFFFFL;
        return seed;
    }

    static int[] gerarAleatorios(int n) {
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = (int) (proximo() % 10000);
        }
        return v;
    }

    static void bubbleSort(int[] v) {
        comparacoes = 0;
        trocas = 0;
        int n = v.length;
        for (int i = 0; i < n - 1; i++) {
            boolean trocou = false;
            for (int j = 0; j < n - 1 - i; j++) {
                comparacoes++;
                if (v[j] > v[j + 1]) {
                    int tmp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = tmp;
                    trocas++;
                    trocou = true;
                }
            }
            if (!trocou) break;
        }
    }

    static void trocaInt(int[] v, int a, int b) {
        int tmp = v[a];
        v[a] = v[b];
        v[b] = tmp;
        trocas++;
    }

    static int particiona(int[] v, int baixo, int alto) {
        int pivo = v[alto];
        int i = baixo - 1;
        for (int j = baixo; j < alto; j++) {
            comparacoes++;
            if (v[j] <= pivo) {
                i++;
                trocaInt(v, i, j);
            }
        }
        trocaInt(v, i + 1, alto);
        return i + 1;
    }

    static void quickSortRec(int[] v, int baixo, int alto) {
        if (baixo < alto) {
            int p = particiona(v, baixo, alto);
            quickSortRec(v, baixo, p - 1);
            quickSortRec(v, p + 1, alto);
        }
    }

    static void quickSort(int[] v) {
        comparacoes = 0;
        trocas = 0;
        quickSortRec(v, 0, v.length - 1);
    }

    static void testarTamanho(int n) {
        int[] original = gerarAleatorios(n);
        int[] copiaBubble = Arrays.copyOf(original, n);
        int[] copiaQuick = Arrays.copyOf(original, n);

        long inicioBubble = System.nanoTime();
        bubbleSort(copiaBubble);
        long fimBubble = System.nanoTime();
        long compBubble = comparacoes;
        long trocaBubble = trocas;

        long inicioQuick = System.nanoTime();
        quickSort(copiaQuick);
        long fimQuick = System.nanoTime();
        long compQuick = comparacoes;
        long trocaQuick = trocas;

        System.out.printf("%-8d | %-22d | %-16d | %-22d | %-20d%n",
                n, compBubble, trocaBubble, compQuick, trocaQuick);

        int[] esperado = Arrays.copyOf(original, n);
        Arrays.sort(esperado);
        if (!Arrays.equals(copiaBubble, esperado) || !Arrays.equals(copiaQuick, esperado)) {
            System.err.println("ERRO: ordenacao incorreta para n=" + n);
        }

        double tempoBubbleMs = (fimBubble - inicioBubble) / 1_000_000.0;
        double tempoQuickMs = (fimQuick - inicioQuick) / 1_000_000.0;
        System.err.printf("n=%d tempo bubble=%.4fms tempo quick=%.4fms%n", n, tempoBubbleMs, tempoQuickMs);
    }

    public static void main(String[] args) {
        System.out.printf("%-8s | %-22s | %-16s | %-22s | %-20s%n",
                "Tamanho", "Bubble-Comparacoes", "Bubble-Trocas", "Quick-Comparacoes", "Quick-Movimentacoes");
        int[] tamanhos = {10, 20, 1000};
        for (int n : tamanhos) {
            seed = 42;
            testarTamanho(n);
        }
    }
}
