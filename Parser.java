public class Parser {
    private Scanner scan;
    private Token currentToken;

    public Parser(byte[] input) {
        this.scan = new Scanner(input);
        this.currentToken = this.scan.nextToken();
    }

    public void parse() {
        expr();
    }

    void expr() {
        number();
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
            number();
            System.out.println("add");
            oper();
        } else if (currentToken.type == TokenType.MINUS) {
            match(TokenType.MINUS);
            number();
            System.out.println("sub");
            oper();
        }
    }
}