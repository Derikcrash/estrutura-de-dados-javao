public class Parte5HandsOn2 {

    static final int SENSORES = 5;
    static final int HORAS = 24;

    public static void main(String[] args) {
        double[][] sensores = new double[SENSORES][HORAS];
        long seed = 7;

        for (int i = 0; i < SENSORES; i++) {
            for (int j = 0; j < HORAS; j++) {
                seed = (seed * 1103515245L + 12345L) & 0xFFFFFFFFL;
                double frac = ((seed / 65536L) % 1000L) / 1000.0;
                sensores[i][j] = 15.0 + frac * 17.0;
            }
        }
        sensores[2][15] = 33.4;

        long operacoes = 0;

        double[] mediaSensor = new double[SENSORES];
        System.out.println("1) Media de cada sensor:");
        for (int i = 0; i < SENSORES; i++) {
            double soma = 0;
            for (int j = 0; j < HORAS; j++) {
                soma += sensores[i][j];
                operacoes++;
            }
            mediaSensor[i] = soma / HORAS;
            System.out.printf("   Sensor %d: %.2f C%n", i, mediaSensor[i]);
        }

        double maior = sensores[0][0];
        int sensorMaior = 0;
        int horaMaior = 0;
        for (int i = 0; i < SENSORES; i++) {
            for (int j = 0; j < HORAS; j++) {
                operacoes++;
                if (sensores[i][j] > maior) {
                    maior = sensores[i][j];
                    sensorMaior = i;
                    horaMaior = j;
                }
            }
        }
        System.out.println();
        System.out.printf("2) Maior temperatura registrada: %.2f C%n", maior);
        System.out.printf("3) Sensor responsavel: Sensor %d%n", sensorMaior);
        System.out.printf("4) Horario da ocorrencia: %dh%n", horaMaior);

        double somaGeral = 0;
        for (int i = 0; i < SENSORES; i++) {
            for (int j = 0; j < HORAS; j++) {
                somaGeral += sensores[i][j];
                operacoes++;
            }
        }
        double mediaGeral = somaGeral / (SENSORES * HORAS);
        System.out.println();
        System.out.printf("5) Media geral (120 medicoes): %.2f C%n", mediaGeral);

        double limite = 28.0;
        int acimaLimite = 0;
        for (int i = 0; i < SENSORES; i++) {
            for (int j = 0; j < HORAS; j++) {
                operacoes++;
                if (sensores[i][j] > limite) {
                    acimaLimite++;
                }
            }
        }
        System.out.println();
        System.out.printf("6) Limite informado: %.1f C%n", limite);
        System.out.printf("   Quantidade de leituras acima do limite: %d%n", acimaLimite);

        System.out.println();
        System.out.printf("Total de posicoes percorridas por passagem completa: %d (5 x 24)%n", SENSORES * HORAS);
        System.out.printf("Total aproximado de operacoes contadas no programa: %d%n", operacoes);
    }
}
