import java.util.Scanner;

public class Bee_1091 {
    final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        int qtdConsultas = 0;
        int ptDivisorN = 0;
        int ptDivisorM = 0;
        String lugar = null;

        while (true) {
            qtdConsultas = lerNumInt();
            if (qtdConsultas == 0) {
                break;
            }
            ptDivisorN = lerNumInt();
            ptDivisorM = lerNumInt();
            for (int i = 0; i < qtdConsultas; i++) {
                lugar = verificarLugar(qtdConsultas, ptDivisorN, ptDivisorM);
                imprimir(lugar);
            }
        }
    }

    public static void imprimir(String string) {
        System.out.println(string);
    }

    public static String verificarLugar(int qtdConsultas, int ptDivisorN, int ptDivisorM) {
        String lugar = null;
        int coordX = lerNumInt();
        int coordY = lerNumInt();

        if (coordX == ptDivisorN || coordY == ptDivisorM) {
            lugar = "divisa";
        } else if (coordX < ptDivisorN && coordY > ptDivisorM) {
            lugar = "NO";
        } else if (coordX > ptDivisorN && coordY > ptDivisorM) {
            lugar = "NE";
        } else if (coordX > ptDivisorN && coordY < ptDivisorM) {
            lugar = "SE";
        } else if (coordX < ptDivisorN && coordY < ptDivisorM) {
            lugar = "SO";
        }

        return lugar;
    }

    public static int lerNumInt() {
        return Sc.nextInt();
    }
}
