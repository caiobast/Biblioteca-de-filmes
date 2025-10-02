package filmeoteca;

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
}
