import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Csv {

    public static List<String[]> lerComOpenCsv(String caminhoArq) {
        List<String[]> filmes = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(caminhoArq))) {
            filmes = reader.readAll();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return filmes;
}
        public static void acharFilmeCsv (List < String[]>filmes, String nomeFilme){
            boolean encontrado = false;

            for (String[] linha : filmes) {
                if (linha.length > 4 && linha[1].equalsIgnoreCase(nomeFilme)) {
                    System.out.println("Filme encontrado: " + linha[1]);
                    System.out.println("Gênero: " + linha[2]);
                    System.out.println("Ano: " + linha[3]);
                    System.out.println("Sinopse: " + linha[4]);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Filme não encontrado: " + nomeFilme);
            }
        }

        public static void escreverCsv(String caminhoArq, String[] lista  ){
                try (CSVWriter writer = new CSVWriter (new FileWriter(caminhoArq, true))) {
                    writer.writeNext(lista);

                } catch (IOException e) {
                    e.printStackTrace();
            }
        }

        public static void editarCsv (String caminhoArq, String nome){
                List<String[]> temp = Csv.lerComOpenCsv(caminhoArq);
                boolean encontrado = false;

                for (String[] dado : temp) {
                    if(dado[1].equalsIgnoreCase(nome)){
                        encontrado = true;
                        Scanner tec = new Scanner(System.in);

                        System.out.println("Filme encontrado com sucesso!");
                        Csv.acharFilmeCsv(temp, nome);

                        System.out.println("Digite o nome: ");
                        dado[1] = tec.nextLine();

                        System.out.println("Digite o gênero: ");
                        dado[2] = tec.nextLine();

                        System.out.println("Digite o ano: ");
                        dado[3] = tec.nextLine();

                        System.out.println("Digite a sinopse: ");
                        dado[4] = tec.nextLine();

                        break;
                    }
                }

                if(!encontrado){
                    System.out.println("Filme não encontrado!");
                    return;
                }

                try (CSVWriter escritor = new CSVWriter (new FileWriter(caminhoArq))) {
                    escritor.writeAll(temp);

                } catch (Exception e) {
                    System.out.println("Erro ao editar filme: "+ e.getMessage());;
                }
        }
    }
