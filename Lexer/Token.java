public enum Token {
    IDENT(1),
    INT_LIT(2),
    LPAREN(3),
    RPAREN(4),
    ADD_OP(5),
    SUB_OP(6),
    MUL_OP(7),
    DIV_OP(8),
    GT_OP(9),
    LT_OP(10),
    EQ_OP(11),
    ASSIGN_OP(12),
    FIM(0);

    public int idToken;
    
    Token(int valor){
        idToken = valor;
    }
}
