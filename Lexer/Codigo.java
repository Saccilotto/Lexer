import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Codigo{
    public Codigo(){}

    void menu(){
        Scanner scanner = new Scanner(System.in);
        boolean iteration = true;
        while (iteration) {
            System.out.println("Digite o nome do arquivo de texto (presente no diretório atual): ");
            String file = scanner.next();
            String fullPath = new File("").getAbsolutePath() + "/" + file;
            if(fullPath.equals("") || fullPath.equals(null)) {
                System.out.println("Diretorio invalido.");
            } else {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(fullPath));
                    String currentLine = reader.readLine();
                    Analisador analisador = new Analisador(currentLine);
                    ArrayList<Lexema> lex = analisador.getLexema();
    
                    for(int i = 0;i < analisador.getLexema().size();i++){
                        System.out.println("('"+ lex.get(i).getValor() + ", " + lex.get(i).getToken() + ", " + lex.get(i).getToken().idToken + ")");
                    }
                    reader.close();
                } catch(IOException ex){
                    System.out.println("Insira um diretório válido.");
                }
                iteration = false;
            }
            scanner.close();
        }
    }
}
