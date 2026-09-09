public class Parte3BuscaMatriz {

    static class ResultadoBusca {
        boolean encontrado;
        int linha;
        int coluna;
        long comparacoes;
    }

    static ResultadoBusca buscaSequencial(int[][] m, int linhas, int colunas, int alvo) {
        ResultadoBusca r = new ResultadoBusca();
        r.encontrado = false;
        r.linha = -1;
        r.coluna = -1;
        r.comparacoes = 0;

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                r.comparacoes++;
                if (m[i][j] == alvo) {
                    r.encontrado = true;
                    r.linha = i;
                    r.coluna = j;
                    return r;
                }
            }
        }
        return r;
    }

    static int[][] criarMatrizSequencial(int linhas, int colunas) {
        int[][] m = new int[linhas][colunas];
        int valor = 1;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                m[i][j] = valor++;
            }
        }
        return m;
    }

    static void testarMatriz(int linhas, int colunas) {
        int total = linhas * colunas;
        int[][] m = criarMatrizSequencial(linhas, colunas);

        int valorInicio = m[0][0];
        int valorFim = m[linhas - 1][colunas - 2 >= 0 ? colunas - 2 : colunas - 1];
        int valorInexistente = total + 1000;

        ResultadoBusca rInicio = buscaSequencial(m, linhas, colunas, valorInicio);
        ResultadoBusca rFim = buscaSequencial(m, linhas, colunas, valorFim);
        ResultadoBusca rInexistente = buscaSequencial(m, linhas, colunas, valorInexistente);

        System.out.printf("Matriz %dx%d (%d elementos)%n", linhas, colunas, total);
        System.out.printf("  Busca no INICIO       -> valor=%-6d encontrado=%s linha=%d coluna=%d comparacoes=%d%n",
                valorInicio, rInicio.encontrado ? "sim" : "nao", rInicio.linha, rInicio.coluna, rInicio.comparacoes);
        System.out.printf("  Busca proximo ao FIM  -> valor=%-6d encontrado=%s linha=%d coluna=%d comparacoes=%d%n",
                valorFim, rFim.encontrado ? "sim" : "nao", rFim.linha, rFim.coluna, rFim.comparacoes);
        System.out.printf("  Busca INEXISTENTE     -> valor=%-6d encontrado=%s comparacoes=%d%n",
                valorInexistente, rInexistente.encontrado ? "sim" : "nao", rInexistente.comparacoes);
        System.out.println();
    }

    public static void main(String[] args) {
        testarMatriz(2, 2);
        testarMatriz(10, 10);
        testarMatriz(100, 100);
    }
}
