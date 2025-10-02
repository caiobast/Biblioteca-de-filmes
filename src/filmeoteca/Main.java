package filmeoteca;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String caminho = "C:\\Users\\Caio\\Downloads\\filmes - Página1.csv";
        Scanner tec = new Scanner(System.in);
        int n;
        System.out.println("Seja bem vindo a biblioteca digital Calexandria!");

        do {

        System.out.println("\n ==== Menu ====");
        System.out.println("1: Se deseja ver todo nosso acervo de fimes");
        System.out.println("2: Se deseja pesquisar mais informações sobre algum filme");
        System.out.println("3: Se deseja adicionar algum filme a nossa estante");
        System.out.println("4: Geração de id");
        System.out.println("5: Se deseja editar algum filme");
        System.out.println("6: Se deseja deletar algum filme");
        System.out.println("0: Se deseja sair");
        System.out.print("Digite a opção selecionada: ");
        n = tec.nextInt();
        tec.nextLine();

        switch (n) {
            case 0:
                System.out.println("Até logo mais!");
                break;

            case 1:
                Metodos.exibirFilmes(caminho);
                break;

            case 2:
                List<String[]> dados = Csv.lerComOpenCsv(caminho);
                System.out.println("Qual filme você deseja ter mais informações: ");
                String temp = tec.nextLine();
                Csv.acharFilmeCsv(dados, temp);
                break;

            case 3:
                Metodos.adicionarFilmes(caminho, tec);
                break;

            case 4:
                List<String[]> dado = Csv.lerComOpenCsv(caminho);
                String id = Metodos.geracaoID(dado);
                System.out.println("Geração de ID bem sucedida: " + id);
                break;

            case 5:
                System.out.println("Qual filme você deseja alterar? ");
                String nome = tec.nextLine();
                Csv.editarCsv(caminho, nome);
                break;

            case 6:
                System.out.println("Qual filme você deseja deletar? ");
                String nomed = tec.nextLine();
                Csv.removeRegistro(caminho, nomed);
                break;

            default:
                System.out.println("Opção inválida! Tente novamente!");
                break;
        }
        }while (n != 0);
    }
}

//{"11", "Superman", "Ação", "2025", "O herói cryptoniano luta contra os temíveis vilões da cidade de Metrópolis"};

//            for (String[] linha : dado) {
//                for (String valor : linha) {
//                    System.out.print(valor + " ");
//                }
//                System.out.println();
//            }

//        System.out.println(dado.get(1)[4]);
