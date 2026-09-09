public class Parte4HandsOn1 {

    public static void main(String[] args) {
        double[] temperatura = {19.5, 21.0, 18.2, 25.3, 30.1, 17.8, 22.4, 28.9, 20.0, 24.6};
        long operacoes = 0;

        System.out.print("Indice:      ");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%6d", i);
            operacoes++;
        }
        System.out.print("\nTemperatura: ");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%6.1f", temperatura[i]);
            operacoes++;
        }
        System.out.println();
        System.out.println();

        double soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += temperatura[i];
            operacoes++;
        }
        double media = soma / 10.0;

        double maior = temperatura[0];
        double menor = temperatura[0];
        int idxMaior = 0;
        int idxMenor = 0;
        for (int i = 1; i < 10; i++) {
            operacoes++;
            if (temperatura[i] > maior) {
                maior = temperatura[i];
                idxMaior = i;
            }
            operacoes++;
            if (temperatura[i] < menor) {
                menor = temperatura[i];
                idxMenor = i;
            }
        }

        int acimaMedia = 0;
        for (int i = 0; i < 10; i++) {
            operacoes++;
            if (temperatura[i] > media) {
                acimaMedia++;
            }
        }

        System.out.printf("Media geral: %.2f%n", media);
        System.out.printf("Maior valor: %.1f (indice %d)%n", maior, idxMaior);
        System.out.printf("Menor valor: %.1f (indice %d)%n", menor, idxMenor);
        System.out.printf("Quantidade de valores acima da media: %d%n", acimaMedia);
        System.out.printf("Total aproximado de operacoes de percurso do array: %d%n", operacoes);
    }
}
