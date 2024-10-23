// Prof. Odair - 16:51
import java.util.Scanner;

public class RobertoBrittes_7848_Media {
    final static Scanner Sc = new Scanner(System.in);
    public static void main(String[] args) {
        //inicialização de variaveis
        final float media = 75.548f;                    // constante deve ser MAIÚSCULO
        float percentualAcimaMedia = 0;
        int qtdAcimaMedia = 0;
        int qtdPessoasTurma = 0;
        int nota = 0;
        int qtdTestes = 0;
        boolean acimaMedia = false;

        do {
            qtdTestes = lerNumInt();       //entrada da qtd de testes 
        } while (qtdTestes <= 0 || qtdTestes > 1000);
        
        for (int i = 0; i < qtdTestes; i++) {
            qtdAcimaMedia = 0;
            qtdPessoasTurma = lerNumInt(); //leitura da qtd de pessoas na turma
            
            for (int cont = 0; cont < qtdPessoasTurma; cont++) {
                
                do {
                    nota = lerNumInt();     //entrada da nota do aluno
                } while (nota < 0 || nota > 100);

                acimaMedia = verificarAcimaMedia(media, nota); //verifica se o aluno está acima da media
                if (acimaMedia) {
                    qtdAcimaMedia++;
                }
            }
            percentualAcimaMedia = calcularPercentualAcimaMedia(qtdPessoasTurma, qtdAcimaMedia); //calcula o percentual
                                                                                                 //acima da media
            System.out.printf("%.3f%s\n", percentualAcimaMedia, "%");
        }

    }

    //verifica se o aluno está acima da media
    public static boolean verificarAcimaMedia(float media, int nota) {
        boolean acimaMedia = false;
        if (nota > media) {
            acimaMedia = true;
        }
        return acimaMedia;
    }
    
    //metodo para ler num inteiro
    public static int lerNumInt() {
        int valor = 0;
        valor = Sc.nextInt();
        return valor;
    }

    //metodo para calcular o percentual acima da media
    public static float calcularPercentualAcimaMedia(int qtdPessoasTurma, int qtdAcimaMedia) {
        float percentualAcimaMedia = 0f;
        percentualAcimaMedia = (qtdAcimaMedia/(float)qtdPessoasTurma) * 100;
        return percentualAcimaMedia;
    }
}
/* Conceito A
 * 
 * Validar as entradas nos métodos que lê as variáveis.
 * 
 */