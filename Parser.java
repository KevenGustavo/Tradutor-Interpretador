public class Parser {
    private byte[] input;
    private int current;

    public Parser(byte[] input) {
        this.input = input;
        this.current = 0;
    }

    public void parse() {
        expr();
    }

    void expr() {
        digit();
        oper();
    }

    private char peek() {
        if (current < input.length) {
            return (char) input[current];
        }
        return '\0';
    }

    private void match(char c) {
        if (c == peek()) {
            current++;
        } else {
            throw new Error("Erro de sintaxe: esperado '" + c + "', mas encontrado '" + peek() + "'");
        }
    }

    void digit() {
        if (Character.isDigit(peek())) {
            System.out.println("push " + peek());
            match(peek());
        } else {
            throw new Error("Erro de sintaxe: esperado um dígito");
        }
    }

    void oper() {
        if (peek() == '+') {
            match('+');
            digit();
            System.out.println("add");
            oper();
        } else if (peek() == '-') {
            match('-');
            digit();
            System.out.println("sub");
            oper();
        }
    }
}