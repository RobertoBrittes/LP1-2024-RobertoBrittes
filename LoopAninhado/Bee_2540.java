import java.util.Scanner;

public class Bee_2540 {
    final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        int qtdVotos = 0;
        int qtdVotosFavoraveis = 0;
        boolean impeachment = false;
        while (Sc.hasNextInt()) {
            qtdVotosFavoraveis = 0;
    
            qtdVotos = lerNumInt();
            
            for (int i = 0; i < qtdVotos; i++) {
                if (lerNumInt() == 1) {
                    qtdVotosFavoraveis++;
                }
            }

            impeachment = verificarImpeachmentLider(qtdVotos, qtdVotosFavoraveis);

            if (impeachment) {
                System.out.println("impeachment");
            } else {
                System.out.println("acusacao arquivada");
            }
        }
    }

    public static int lerNumInt() {
        return Sc.nextInt();
    }

    public static boolean verificarImpeachmentLider(int qtdVotos, int qtdVotosFavoraveis) {
        boolean impeachment = false;
        if (qtdVotosFavoraveis * 3 >= qtdVotos * 2) {
            impeachment = true;
        }
        return impeachment;
    }
}
