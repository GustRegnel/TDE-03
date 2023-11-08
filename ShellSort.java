import java.util.Random;

public class ShellSort {
    public static void main(String[] args) {
        int[] tams = {50, 500, 1000, 5000, 10000};

        for (int tam : tams) {
            int[] v = gerarVetorAlea(tam);
            long tIni = System.currentTimeMillis();
            int[] res = shellSort(v);
            long tFim = System.currentTimeMillis();

            System.out.println("Tamanho do vetor: " + tam);
            System.out.println("Tempo de execução: " + (tFim - tIni) + " ms");
            System.out.println("Número de trocas: " + res[0]);
            System.out.println("Número de iterações: " + res[1]);
            System.out.println();
        }
    }

    public static int[] shellSort(int[] v) {
        int n = v.length;
        int trocas = 0;
        int iters = 0;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int chave = v[i];
                int j = i;

                iters++;

                while (j >= gap && v[j - gap] > chave) {
                    v[j] = v[j - gap];
                    j -= gap;
                    trocas++;
                }

                v[j] = chave;
            }
        }

        return new int[]{trocas, iters};
    }

    public static int[] gerarVetorAlea(int tam) {
        int[] v = new int[tam];
        Random r = new Random();

        for (int i = 0; i < tam; i++) {
            v[i] = r.nextInt(10000);
        }

        return v;
    }
}
