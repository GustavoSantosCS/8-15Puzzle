package modelo;

import java.util.Arrays;

/**
 * @author gusta
 */
public class Puzzle15 implements Puzzle {

    private Puzzle15 pai;
    private long profundidade;
    private int[][] matriz;
    private int zeroColuna;
    private int zeroLinha;
    private static Heuristica heuristica;

    public Puzzle15(int[][] element, Puzzle15 pai, long profundidade, int linha, int coluna, Heuristica heuristica) {
        this.pai = pai;
        this.profundidade = profundidade;
        this.zeroLinha = linha;
        this.zeroColuna = coluna;
        this.matriz = element;
        if (zeroColuna != -1 && zeroLinha != -1 && element[zeroLinha][zeroColuna] != 0) {
            arrumarPZero();
        }
        this.heuristica = heuristica;
    }

    @Override
    public long calcularFH1() {
        return this.profundidade + heuristica.getH1(matriz);
    }

    @Override
    public long calcularFH2Simples() {
        return this.profundidade + heuristica.getH2(matriz);
    }

    @Override
    public long calcularFH2RH() {
        return this.profundidade + heuristica.getH2(matriz) - heuristica.getH2P(matriz);
    }

    @Override
    public void arrumarPZero() {
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz.length; coluna++) {
                if (matriz[linha][coluna] == 0) {
                    setLocalizacaoDoZero(linha, coluna);
                }
            }
        }
    }

    @Override
    public Puzzle15 getPai() {
        return pai;
    }

    @Override
    public void setLocalizacaoDoZero(int linha, int coluna) {
        this.zeroLinha = linha;
        this.zeroColuna = coluna;
    }

    @Override
    public int getZeroColuna() {
        return zeroColuna;
    }

    @Override
    public int getZeroLinha() {
        return zeroLinha;
    }

    @Override
    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    @Override
    public void imprimir() {
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz.length; coluna++) {
                System.out.print(matriz[linha][coluna] + "  ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    @Override
    public int[][] getMatriz() {
        return matriz;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Arrays.deepHashCode(this.matriz);
        hash = 23 * hash + this.zeroColuna;
        hash = 23 * hash + this.zeroLinha;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Puzzle15 other = (Puzzle15) obj;
        if (this.zeroColuna != other.zeroColuna) {
            return false;
        }
        if (this.zeroLinha != other.zeroLinha) {
            return false;
        }
        if (!Arrays.deepEquals(this.matriz, other.matriz)) {
            return false;
        }
        return true;
    }

    @Override
    public Puzzle15 clone() {
        int[][] matrizC = new int[4][4];
        matrizC[0][0] = matriz[0][0];
        matrizC[0][1] = matriz[0][1];
        matrizC[0][2] = matriz[0][2];
        matrizC[0][3] = matriz[0][3];

        matrizC[1][0] = matriz[1][0];
        matrizC[1][1] = matriz[1][1];
        matrizC[1][2] = matriz[1][2];
        matrizC[1][3] = matriz[1][3];

        matrizC[2][0] = matriz[2][0];
        matrizC[2][1] = matriz[2][1];
        matrizC[2][2] = matriz[2][2];
        matrizC[2][3] = matriz[2][3];

        matrizC[3][0] = matriz[3][0];
        matrizC[3][1] = matriz[3][1];
        matrizC[3][2] = matriz[3][2];
        matrizC[3][3] = matriz[3][3];

        Puzzle15 clone = new Puzzle15(matrizC, this, this.profundidade + 1, getZeroLinha(), getZeroColuna(), heuristica);
        return clone;
    }

    @Override
    public boolean isFinalized() {
        if (matriz[0][0] != 1) {
            return false;
        }
        if (matriz[0][1] != 2) {
            return false;
        }
        if (matriz[0][2] != 3) {
            return false;
        }
        if (matriz[0][3] != 4) {
            return false;
        }
        if (matriz[1][0] != 5) {
            return false;
        }
        if (matriz[1][1] != 6) {
            return false;
        }
        if (matriz[1][2] != 7) {
            return false;
        }
        if (matriz[1][3] != 8) {
            return false;
        }
        if (matriz[2][0] != 9) {
            return false;
        }
        if (matriz[2][1] != 10) {
            return false;
        }
        if (matriz[2][2] != 11) {
            return false;
        }
        if (matriz[2][3] != 12) {
            return false;
        }
        if (matriz[3][0] != 13) {
            return false;
        }
        if (matriz[3][1] != 14) {
            return false;
        }
        if (matriz[3][2] != 15) {
            return false;
        }
        if (matriz[3][3] != 0) {
            return false;
        }
        return true;
    }


}
