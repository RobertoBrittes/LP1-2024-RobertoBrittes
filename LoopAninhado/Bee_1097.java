public class Bee_1097 {
    public static void main(String[] args) {
        imprimirSequencia();
    }

    public static void imprimirSequencia() {
        int i = 1;
        int j = 7;
        while (i < 10) {
            for (int k = 0; k < 3; k++) {
                System.out.println("I=" + i + " J=" + j);
                j--;
            }
            j += 5;
            i += 2;
        }
    }
}
