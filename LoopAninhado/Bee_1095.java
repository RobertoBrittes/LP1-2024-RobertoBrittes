public class Bee_1095 {
    public static void main(String[] args) {
        imprimirSequencia();
    }

    public static void imprimirSequencia() {
        int i = 1;
        int j = 60;
        while (j >= 0) {
            System.out.println("I=" + i + " J=" + j);
            i += 3;
            j -= 5;
        }

    }
}