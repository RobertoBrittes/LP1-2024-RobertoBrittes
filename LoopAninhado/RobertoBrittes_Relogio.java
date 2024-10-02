public class RobertoBrittes_Relogio {
    public static void main(String[] args) {
        imprimirRelogio();
    }

    public static void imprimirRelogio() {
        int hh = 0;
        int mim = 0;
        int seg = 0;
        int ms = 0;
        
        while (hh < 24) {
            mim = 0;
            while (mim < 60) {
                seg = 0;
                while (seg < 60) {
                    ms = 0;
                    while (ms < 1000) {
                        System.out.printf("%2d:%2d:%2d:%3d\n", hh, mim, seg, ms);
                        ms++;
                    }
                    seg++;
                }
                mim++;
            }
            hh++;
        }
    }
}