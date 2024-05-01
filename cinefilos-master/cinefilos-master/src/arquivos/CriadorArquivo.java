package arquivos;

import java.io.*;
public class CriadorArquivo {

    public void CriarArquivo(String conteudo, String nomeArquivo){
        try {

            FileWriter escritor = new FileWriter(nomeArquivo);

            escritor.write(conteudo);

            escritor.close();
            System.out.println("Arquivo salvo com sucesso!");
        }catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar o arquivo: " + e.getMessage());
        }
    }
    public static String lerArquivo(String nomeArquivo) {
        StringBuilder conteudo = new StringBuilder();

        try {

            FileReader leitor = new FileReader(nomeArquivo);
            BufferedReader bufferedReader = new BufferedReader(leitor);


            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                conteudo.append(linha);
                conteudo.append("\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
        }

        return conteudo.toString();
    }
    public void editarArquivo(String nomeArquivo, String novoConteudo) {
        try {
            FileWriter escritor = new FileWriter(nomeArquivo);
            escritor.write(novoConteudo);
            escritor.close();

            System.out.println("Arquivo editado e salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao editar/salvar o arquivo: " + e.getMessage());
        }
    }
}
