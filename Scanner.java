public class Scanner {
    private byte[] input;
    private int current;

    public Scanner(byte[] input) {
        this.input = input;
        this.current = 0;
    }

    private char peek() {
        if (current < input.length) {
            return (char) input[current];
        }
        return '\0'; // Fim de arquivo
    }

    private void advance() {
        if (peek() != '\0') {
            current++;
        }
    }

    public char nextToken() {
        char ch = peek();

        if (Character.isDigit(ch) || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            advance();
            return ch;
        }

        if (ch == '\0') {
            return '\0';
        }

        throw new Error("Caractere inválido: " + ch);
    }
}