import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Codigo{

    public Codigo(){}

    void menu(){
        Scanner s = new Scanner(System.in);
        //while (true) {
            //System.out.println("Entre o diretorio do arquivo txt (0=fim): ");
            String diretorio = "teste.txt";
            /*if(diretorio=="0"){
                break;
            }*/
            try {
            BufferedReader reader = new BufferedReader(new FileReader(diretorio));
            String currentLine = reader.readLine();
            Analisador analisador = new Analisador(currentLine);
            
            ArrayList<Lexema> lex = analisador.getLexema();

            for(int i=0;i < analisador.getLexema().size(); i++){
                System.out.println("('"+ lex.get(i).getValor() + "', " + lex.get(i).getToken() +", "+ lex.get(i).getToken().idToken +")");
            }

            reader.close();
            }catch (IOException ex){
                System.out.println("Insira um diretório válido.");
            }
        //}
        s.close();
    }

}
