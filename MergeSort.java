import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        int[] tamVet = {50, 500, 1000, 5000, 10000};

        for (int tam : tamVet) {
            int[] vet = geraVetAleatorio(tam);

            long tInicio = System.currentTimeMillis();
            int[] res = ordenaMerge(vet, 0, vet.length - 1);
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

    public static int[] ordenaMerge(int[] vet, int esq, int dir) {
        int t = 0;
        int i = 0;

        if (esq < dir) {
            int meio = (esq + dir) / 2;
            int[] resEsq = ordenaMerge(vet, esq, meio);
            int[] resDir = ordenaMerge(vet, meio + 1, dir);

            int[] res = merge(vet, esq, meio, dir);
            t = resEsq[0] + resDir[0] + res[0];
            i = resEsq[1] + resDir[1] + res[1];

            return new int[]{t, i};
        }

        return new int[]{0, 0};
    }

    public static int[] merge(int[] vet, int esq, int meio, int dir) {
        int t = 0;
        int i = 0;

        int n1 = meio - esq + 1;
        int n2 = dir - meio;

        int[] vetEsq = new int[n1];
        int[] vetDir = new int[n2];

        for (int j = 0; j < n1; j++) {
            vetEsq[j] = vet[esq + j];
            i++;
        }

        for (int k = 0; k < n2; k++) {
            vetDir[k] = vet[meio + 1 + k];
            i++;
        }

        int j = 0;
        int k = esq;

        while (j < n1 && k < n2) {
            if (vetEsq[j] <= vetDir[k]) {
                vet[k] = vetEsq[j];
                j++;
            } else {
                vet[k] = vetDir[k];
                k++;
                t++;
            }
            k++;
        }

        while (j < n1) {
            vet[k] = vetEsq[j];
            j++;
            k++;
        }

        while (k < n2) {
            vet[k] = vetDir[k];
            k++;
            k++;
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
