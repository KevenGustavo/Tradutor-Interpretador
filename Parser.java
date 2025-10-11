public class Parser {
    private Scanner scan;
    private Token currentToken;

    public Parser(byte[] input) {
        this.scan = new Scanner(input);
        this.currentToken = this.scan.nextToken();
    }

    public void parse() {
        letStatement();
    }

    void expr() {
        term();
        oper();
    }

    private void match(TokenType t) {
        if (currentToken.type == t) {
            this.currentToken = this.scan.nextToken();
        } else {
            throw new Error("Erro de sintaxe: esperado " + t + " mas encontrado " + currentToken.type);
        }
    }

    void number() {
        System.out.println("push " + currentToken.lexeme);
        match(TokenType.NUMBER);
    }

    void oper() {
        if (currentToken.type == TokenType.PLUS) {
            match(TokenType.PLUS);
            term();
            System.out.println("add");
            oper();
        } else if (currentToken.type == TokenType.MINUS) {
            match(TokenType.MINUS);
            term();
            System.out.println("sub");
            oper();
        }
    }

    void term() {
        if (currentToken.type == TokenType.NUMBER) {
            number();
        } else if (currentToken.type == TokenType.IDENT) {
            System.out.println("push " + currentToken.lexeme);
            match(TokenType.IDENT);
        } else {
            throw new Error("syntax error");
        }
    }

    void letStatement() {
        match(TokenType.LET);
        String id = currentToken.lexeme;
        match(TokenType.IDENT);
        match(TokenType.EQ);
        expr();
        System.out.println("pop " + id);
        match(TokenType.SEMICOLON);
    }
}