public class Bee_1098 {
    public static void main(String[] args) {
        imprimirSequencia();
    }

    public static void imprimirSequencia() {
        float i = 0;
        while (i < 2.2) {
            if (i < 1) {
                for (float k = 1; k <= 3; k++) {
                    System.out.printf("I=%f.0  J=%f.0\n", i, (k+i));
                }
            } else if (i < 2) {
                for (float k = 1; k <= 3; k++) {
                    k--;
                    System.out.printf("I=%f.0  J=%f.0\n", i, (k+i));
                    k++;
                }
            } else {
                for (float k = 1; k <= 3; k++) {
                    k-=2;
                    System.out.printf("I=%f.0  J=%f.0\n", i, (k+i));
                    k+=2;
                }
            }
            i += 0.2;
        }
    }
}
