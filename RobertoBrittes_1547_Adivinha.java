// Prof. Odair - 16:51
import java.util.Scanner;

public class RobertoBrittes_1547_Adivinha {
    
    final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        //inicialização de variaveis
        int qtdCamisetas = 0;
        int qtdAlunos = 0;
        int numSecreto = 0;
        int ganhador = 0;

        //recebe a qtd de camisetas a serem sorteadas
        qtdCamisetas = lerNumInt();

        //verifica os alunos que ganharam a camiseta em cada grupo
        for (int i = 0; i < qtdCamisetas; i++) {
            do {
                qtdAlunos = lerNumInt();                //entrada da qtd de alunos no grupo
            } while (qtdAlunos < 4 || qtdAlunos > 10);

            do {
                numSecreto = lerNumInt();               //entrada do num secreto
            } while (numSecreto > 100 || numSecreto < 1);

            ganhador = verificarGanhador(qtdAlunos, numSecreto); //verifica o ganhador da camiseta

            imprimir("" + ganhador); //imprime o vencedor da camiseta
        }
    }

    //metodo para imprimir
    public static void imprimir(String string) {
        System.out.println(string);
    }

    //metodo que verifica o vencedor da camiseta
    public static int verificarGanhador(int qtdAlunos, int numSecreto){
        int ganhador = 0;
        int diferencaNumGanhador = 1000;
        int numEscolhidoAluno = 0;
        
        for (int i = 1; i <= qtdAlunos; i++) {
            do {
                numEscolhidoAluno = lerNumInt();       //recebe o num escolhido pelo aluno
            } while (numEscolhidoAluno > 100 || numEscolhidoAluno < 1);

            if (numEscolhidoAluno > numSecreto) {
                if ((numEscolhidoAluno - numSecreto) < diferencaNumGanhador) {  //verifica se o num escolhido é menor
                    diferencaNumGanhador = numEscolhidoAluno - numSecreto;      //que a diferença do atual vencedor
                    ganhador = i;
                }
            } else {
                if ((numSecreto - numEscolhidoAluno) < diferencaNumGanhador) {
                    diferencaNumGanhador = numSecreto - numEscolhidoAluno;
                    ganhador = i;
                }
            }
        }
        return ganhador;
    }

    //metodo para ler num inteiro
    public static int lerNumInt() {
        int valor = 0;
        valor = Sc.nextInt();
        return valor;
    }
}
/*
 * Conceito A
 * 
 * 
 */