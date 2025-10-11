public class Parser {
    private Scanner scan;
    private char currentToken;

    public Parser(byte[] input) {
        this.scan = new Scanner(input);
        this.currentToken = this.scan.nextToken();
    }

    public void parse() {
        expr();
    }

    void expr() {
        digit();
        oper();
    }

    private void match(char t) {
        if (currentToken == t) {
            this.currentToken = this.scan.nextToken();
        } else {
            throw new Error("Erro de sintaxe: esperado '" + t + "', mas encontrado '" + currentToken + "'");
        }
    }

    void digit() {
        if (Character.isDigit(currentToken)) {
            System.out.println("push " + currentToken);
            match(currentToken);
        } else {
            throw new Error("Erro de sintaxe: esperado um dígito");
        }
    }

    void oper() {
        if (currentToken == '+') {
            match('+');
            digit();
            System.out.println("add");
            oper();
        } else if (currentToken == '-') {
            match('-');
            digit();
            System.out.println("sub");
            oper();
        } else if (currentToken == '*') {
            match('*');
            digit();
            System.out.println("mul");
            oper();
        } else if (currentToken == '/') {
            match('/');
            digit();
            System.out.println("div");
            oper();
        }
    }
}