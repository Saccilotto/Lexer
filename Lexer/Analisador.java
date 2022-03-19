import java.util.ArrayList;

public class Analisador {
    private String linhaCodigo;
    private ArrayList<Lexema> lexemas = new ArrayList<Lexema>();

    public Analisador(String linhaCodigo){
        this.linhaCodigo = linhaCodigo;
        separador();
    }

    public String getComando(){return linhaCodigo;}

    private void separador(){
        String nome ="";
        String num ="";
        Token token =null;
        String assign_op="";
        String eq_op="";
        for(int i=0; i<linhaCodigo.length(); i++){

            char c = linhaCodigo.charAt(i);

            if((i+1)==linhaCodigo.length()){
                token = Token.FIM;
            }
            
            if(Character.isLetter(c) || (Character.isDigit(c) && nome!="")){
                if(num!="")
                break;
                nome += Character.toString(c);
            }else if(Character.isDigit(c)){
                num += Character.toString(c);
            }else
            {
                switch(c){
                    case('('):
                        token = Token.LPAREN;
                        break;
                    case(')'):
                        token = Token.RPAREN;
                        break;
                    case('+'):
                        token = Token.ADD_OP;
                        break;
                    case('-'):
                        token = Token.SUB_OP;
                        break;
                    case('*'):
                        token = Token.MUL_OP;
                        break;
                    case('/'):
                        token = Token.DIV_OP;
                        break;
                    case('>'):
                        token = Token.GT_OP;
                        break;
                    case('<'):
                        token = Token.LT_OP;
                        break;
                    case('='):
                        if(eq_op!=""){
                            eq_op += Character.toString(c);
                            token = Token.EQ_OP;
                        }
                        else if(assign_op!=""){
                            assign_op += Character.toString(c);
                            token = Token.ASSIGN_OP;
                        }
                        eq_op += Character.toString(c);
                        break;
                    case(':'):
                        assign_op += Character.toString(c);
                        break;
                    case(';'):
                        token = Token.FIM;
                        break;
                    case('\n'):
                        token = Token.FIM;
                        break;
                    case('\t'):
                        token = Token.FIM;
                        break;
                    case('\r'):
                        token = Token.FIM;
                        break;
                    case(' '):
                        token = Token.FIM;
                        break;
                    default:
                        break;
                }
            }
            if (token!=null){
                if(nome!= "" && nome.length()<100){
                    lexemas.add(new Lexema(nome,Token.IDENT));
                    nome = "";
                }else if (num!="" && num.length()<100){
                    lexemas.add(new Lexema(num,Token.INT_LIT));
                    num = "";
                }
                else{
                    num = "";
                    nome = "";
                }
                if(token!=Token.FIM){
                    if(token==Token.ASSIGN_OP){
                        lexemas.add(new Lexema(assign_op,token));
                        assign_op = "";
                    }else if(token==Token.EQ_OP){
                        lexemas.add(new Lexema(eq_op,token));
                        eq_op = "";
                    }else
                        lexemas.add(new Lexema(Character.toString(c),token));
                }     
            token = null;
            }
        }
    }

    public ArrayList<Lexema> getLexema(){return lexemas;}


}
