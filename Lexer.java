import java.io.*;
import java.util.ArrayList;

public class Lexer {
    private int LETTER = 0;
    private int DIGIT = 1;
    private int UNKNKOWN = 99;

    /*Tokens*/
    private int IDENT = 1;
    private int INT_LIT = 2;
    private int LPAREN = 3;
    private int RPAREN = 4;
    private int ADD_OP = 5;
    private int SUB_OP = 6;
    private int MUL_OP = 7;
    private int DIV_OP = 8;
    private int GT_OP = 9;
    private int LT_OP = 10;
    private int EQ_OP = 11;
    private int ASSIGN_OP = 12; 

    private ArrayList<String> lex;
    private ArrayList<Triplet> triplets;

    public Lexer() {
        lex = new ArrayList<String>();
        triplets  = new ArrayList<Triplet>();

    }

    public void lookup(char ch) {
        switch (ch) {
            Triplet t;
            case '(':
                t = new Triplet(Character.toString(ch), "LPAREN", LPAREN); 
                triplets.add(t);
            case ')':
                t = new Triplet(Character.toString(ch), "RPAREN", RPAREN);
                triplets.add(t);
            case '+':
                t = new Triplet(Character.toString(ch), "ADD_OP", ADD_OP);
                triplets.add(t);
            case '-':
                t = new Triplet(Character.toString(ch), "SUB_OP", SUB_OP);
                triplets.add(t);
            case '*':
                t = new Triplet(Character.toString(ch), "MUL_OP", MUL_OP);
                triplets.add(t);
            case '/':
                t = new Triplet(Character.toString(ch), "DIV_OP", DIV_OP);
                triplets.add(t);
            case '>':
                t = new Triplet(Character.toString(ch), "GT_OP", GT_OP);
                triplets.add(t);
            case '<':
                t = new Triplet(Character.toString(ch), "LT_OP", LT_OP);
                triplets.add(t);
            case '==':
                t = new Triplet(Character.toString(ch), "EQ_OP", EQ_OP);
                triplets.add(t);
            case '=':
                t = new Triplet(Character.toString(ch), "ASSIGN_OP", ASSIGN_OP);
                triplets.add(t);
            default:
                break;
        }
    }
    
    public static void main(String Args[]) throws Exception {
        String filePath = new File("").getAbsolutePath();
        File arq = new File(filePath + "/sample.txt");
        BufferedReader br = new BufferedReader(new FileReader(arq));
        int aux;

        while((aux = br.read()) != -1) {
            System.out.println((char)aux);
        }
    }
}

