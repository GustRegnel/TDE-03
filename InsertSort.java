import java.util.Random;

public class InsertSort {
    public static void main(String[] args) {
        int[] tamVet = {50, 500, 1000, 5000, 10000};

        for (int tam : tamVet) {
            int[] vet = geraVetAleatorio(tam);

            long tInicio = System.currentTimeMillis();
            int[] res = ordenaInsert(vet);
            long tFim = System.currentTimeMillis();

            int numT = res[0];
            int numI = res[1];

            System.out.println("Tamanho do vetor: " + tam);
            System.out.println("Tempo decorrido: " + (tFim - tInicio) + " ms");
            System.out.println("Número de trocas: " + numT);
            System.out.println("Número de iterações: " + numI);
            System.out.println();
        }
    }

    public static int[] ordenaInsert(int[] vet) {
        int n = vet.length;
        int t = 0;
        int i = 0;

        for (int j = 1; j < n; j++) {
            int chave = vet[j];
            int k = j - 1;
            i++;

            while (k >= 0 && vet[k] > chave) {
                vet[k + 1] = vet[k];
                k--;
                t++;
            }

            vet[k + 1] = chave;
        }

        return new int[]{t, i};
    }

    public static int[] geraVetAleatorio(int tam) {
        int[] vet = new int[tam];
        Random aleat = new Random();

        for (int j = 0; j < tam; j++) {
            vet[j] = aleat.nextInt(10000);
        }

        return vet;
    }
}
