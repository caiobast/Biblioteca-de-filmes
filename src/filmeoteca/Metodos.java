package filmeoteca;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

public class Metodos { //metodos apartados para serem usados a parte e manter a organização

    public static void exibirFilmes (String caminhoArq){
       List<String []> filmes = Csv.lerComOpenCsv(caminhoArq);
        System.out.println("\n==== Lista de filmes =====");
       int count = 1;
        for (String[] dado : filmes) {
            if (count != 1) {
                System.out.println(dado[1]);
            }
            count ++;
        }
    }

    public static void informacoesFilmes (String caminhoArq, Scanner tec) {
        List<String[]> dados = Csv.lerComOpenCsv(caminhoArq);
        System.out.println("Qual filme você deseja ter mais informações: ");
        String temp = tec.nextLine();
        Csv.acharFilmeCsv(dados, temp);
    }

    public static void adicionarFilmes(String caminhoArq, Scanner tec) {
       List <String[]> temporaria = Csv.lerComOpenCsv(caminhoArq);
        String id = Metodos.geracaoID(temporaria);

        System.out.println("Digite o nome do filme: ");
        String nome = tec.nextLine();

        System.out.println("Digite o gênero do filme: ");
        String genero = tec.nextLine();

        System.out.println("Digite o ano do filme: ");
        String ano = tec.nextLine();

        System.out.println("Digite a sinopse do filme: ");
        String sinopse = tec.nextLine();
// fazer verificação se o filme exsite.
        String [] linha = {id, nome, genero, ano, sinopse};

        Csv.escreverCsv(caminhoArq, linha );
    }

    public static String geracaoID (List<String []> lista){
        int contador = -1;
        for (String[] temp : lista) {
            contador ++;
        }
        contador ++;
        String id = String.valueOf(contador);

        return id;
    }

    public static void verificacaoID (String caminhoArq){ // ver se id pode ser usado e se está em ordem crescente

    }

    public static void alteracaoID(String caminhoArq, String nome){
        //para desenvolvedor mudar id
        //jogar codigo pra csv
        List<String[]> temp = Csv.lerComOpenCsv(caminhoArq);
        Scanner tec = new Scanner(System.in);

        System.out.println("Deseja ver o id anterior? ");
        String escolha = tec.nextLine();

        if (escolha.equalsIgnoreCase("s")){
            for (String[] dado : temp){
                if (dado[1].equalsIgnoreCase(nome)){
                    System.out.println("Id anterior: " + dado[0]);
                }
            }
        }

        System.out.println("Digite o novo id para: " + nome);
        String id = tec.nextLine();

        for (String[] dado : temp){
            if (dado[1].equalsIgnoreCase(nome)){
                dado[0] = id;
            }
        }

        try (CSVWriter escritor = new CSVWriter(new FileWriter(caminhoArq))) {
            escritor.writeAll(temp);

        } catch (Exception e) {
            System.out.println("Erro ao editar filme: " + e.getMessage());
            ;
        }
    }

    public static void edicaoFilmes (String caminhoArq, Scanner tec){
        System.out.println("Deseja ver nosso acervo de filmes? ");
        String resp = tec.nextLine();

        if (resp.equalsIgnoreCase("s")){
            Metodos.exibirFilmes(caminhoArq);
        }

        System.out.println("Qual filme você deseja alterar? ");
        String nome = tec.nextLine();
        Csv.editarCsv(caminhoArq, nome);
    }

}
