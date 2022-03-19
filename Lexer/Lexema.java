public class Lexema {
        private String valor;
        private Token token;
        
        public Lexema(String valor, Token token){
            this.valor = valor;
            this.token = token;
        }
    
        public String getValor() {return valor;}
        
        public Token getToken() {return token;}
        
}
