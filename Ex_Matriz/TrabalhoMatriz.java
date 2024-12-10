import java.util.Random;
import java.util.Scanner;

public class TrabalhoMatriz {
    final static Scanner Sc = new Scanner(System.in);
    final static Random Rand = new Random();

    public static void main(String[] args) {
        int n = lerNumInt();
        int m = lerNumInt();
        int linhaEscolhida = 0;
        int colunaEscolhida = 0;
        int multiplo = 0;
        int[] somaLinhas;
        int[] somaColunas;
        int[] linhaObtida;
        int[] colunaObtida;
        int[] diagonalPrincipal;
        int[] diagonalSecundaria;
        int[] posMaiorElemento = criarVetorInt(2);
        int[][] mat = criarMatriz(n, m);
        int[][] matMultiplicada = criarMatriz(n, m);
        mat = inicializarMatriz(mat);

        // metodo soma linhas matriz
        somaLinhas = criarVetorInt(n);
        somaLinhas = somarLinhasMatrizInt(mat, somaLinhas);
        imprimirSomaLinhas(somaLinhas);

        // metodo soma colunas matriz
        somaColunas = criarVetorInt(m);
        somaColunas = somarColunasMatrizInt(mat, somaColunas);
        imprimirSomaColunas(somaColunas);

        // metodo para obter a linha selecionada
        linhaObtida = criarVetorInt(m);
        linhaEscolhida = lerNumInt();
        linhaObtida = obterLinha(mat, linhaEscolhida, linhaObtida);
        imprimirLinha(linhaObtida);

        // metodo para obter a coluna selecionada
        colunaObtida = criarVetorInt(n);
        colunaEscolhida = lerNumInt();
        colunaObtida = obterColuna(mat, colunaEscolhida, colunaObtida);
        imprimirColuna(colunaObtida);

        // metodo para multiplicar matriz
        multiplo = lerNumInt();
        matMultiplicada = multiplicarMatrizConstante(mat, multiplo, matMultiplicada);
        imprimirMatriz(matMultiplicada);

        // metodo para encontrar a diagonal principal
        diagonalPrincipal = criarVetorInt(n);
        diagonalPrincipal = obterDiagonalPrincipal(mat, diagonalPrincipal);
        imprimirDiagonal(diagonalPrincipal, "principal");

        // metodo para encontrar a diagonal secundaria
        diagonalSecundaria = criarVetorInt(n);
        diagonalSecundaria = obterDiagonalSecundaria(mat, diagonalSecundaria);
        imprimirDiagonal(diagonalSecundaria, "secundaria");

        // metodo para encontrar a posição do maior elemento
        posMaiorElemento = encontrarPosMaiorElemento(mat, posMaiorElemento);
        imprimirPosMaiorElemento(posMaiorElemento);
    }

    public static void imprimirPosMaiorElemento(int[] posMaiorElemento) {
        System.out.printf("Posição maior elemento: [%d][%d]", posMaiorElemento[0], posMaiorElemento[1]);
    }

    public static int[] encontrarPosMaiorElemento(int[][] matriz, int[] posMaiorElemento) {
        int maiorElemento = encontrarMaiorElemento(matriz);
        posMaiorElemento[0] = 0;
        posMaiorElemento[1] = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (maiorElemento == matriz[i][j]) {
                    posMaiorElemento[0] = i;
                    posMaiorElemento[1] = j;
                    break;
                }
            }
        }
        return posMaiorElemento;
    }

    public static int encontrarMaiorElemento(int[][] matriz) {
        int maiorElemento = matriz[0][0];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] > maiorElemento) {
                    maiorElemento = matriz[i][j];
                }
            }
        }
        return maiorElemento;
    }

    public static void imprimirDiagonal(int[] diagonal, String tipo) {
        System.out.println("Diagonal " + tipo);
        for (int i = 0; i < diagonal.length; i++) {
            System.out.print(" " + diagonal[i]);
        }
        System.out.println();
    }

    public static int[] obterDiagonalSecundaria(int[][] matriz, int[] diagonalSecundaria) {
        int cont = diagonalSecundaria.length - 1;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (j == cont) {
                    diagonalSecundaria[i] = matriz[i][j];
                }
            }
        }
        return diagonalSecundaria;
    }

    public static int[] obterDiagonalPrincipal(int[][] matriz, int[] diagonalPrincipal) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (i == j) {
                    diagonalPrincipal[i] = matriz[i][j];
                }
            }
        }
        return diagonalPrincipal;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] multiplicarMatrizConstante(int[][] matriz, int valor, int[][] matMultiplicada) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matMultiplicada[i][j] *= valor;
            }
        }
        return matriz;
    }

    public static void imprimirColuna(int[] colunaObtida) {
        System.out.println("Coluna obtida: ");
        for (int i = 0; i < colunaObtida.length; i++) {
            System.out.print(colunaObtida[i] + " ");
        }
    }

    public static int[] obterColuna(int[][] matriz, int coluna, int[] colunaObtida) {
        for (int i = 0; i < colunaObtida.length; i++) {
            colunaObtida[i] = matriz[i][coluna];
        }
        return colunaObtida;
    }

    public static void imprimirLinha(int[] linhaObtida) {
        System.out.println("Linha obtida: ");
        for (int i = 0; i < linhaObtida.length; i++) {
            System.out.print(linhaObtida[i] + " ");
        }
    }

    public static int[] obterLinha(int[][] matriz, int linha, int[] linhaObtida) {
        for (int i = 0; i < linhaObtida.length; i++) {
            linhaObtida[i] = matriz[linha][i];
        }
        return linhaObtida;
    }

    public static void imprimirSomaLinhas(int[] somaLinhas) {
        for (int i = 0; i < somaLinhas.length; i++) {
            System.out.println("Soma linha " + i + ": " + somaLinhas[i]);
        }
    }

    public static void imprimirSomaColunas(int[] somaColunas) {
        for (int i = 0; i < somaColunas.length; i++) {
            System.out.println("Soma coluna " + i + ": " + somaColunas[i]);
        }
    }

    public static int[][] criarMatriz(int n, int m) {
        return new int[n][m];
    }

    public static int lerNumInt() {
        return Sc.nextInt();
    }

    public static int[][] inicializarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = Rand.nextInt(10);
            }
        }
        return matriz;
    }

    public static int[] somarLinhasMatrizInt(int[][] matriz, int[] somaLinhas) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                somaLinhas[i] += matriz[i][j];
            }
        }
        return somaLinhas;
    }

    public static int[] somarColunasMatrizInt(int[][] matriz, int[] somaColunas) {
        for (int i = 0; i < matriz[0].length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                somaColunas[i] += matriz[j][i];
            }
        }
        return somaColunas;
    }

    public static int[] criarVetorInt(int n) {
        int[] vetorInt = new int[n];
        return vetorInt;
    }
}
