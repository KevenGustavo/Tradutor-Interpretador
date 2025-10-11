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

    public Token nextToken() {
        skipWhitespace();
        char ch = peek();

        if (Character.isDigit(ch)) {
            return number(); 
        }

        switch (ch) {
            case '+':
                advance();
                return new Token(TokenType.PLUS, "+"); 
            case '-':
                advance();
                return new Token(TokenType.MINUS, "-"); 
            case '\0':
                return new Token(TokenType.EOF, "EOF"); 
            default:
                throw new Error("Erro léxico no caractere: " + ch);
        }
    }

    private Token number() {
        int start = current;
        while (Character.isDigit(peek())) {
            advance();
        }
        String n = new String(input, start, current - start);
        return new Token(TokenType.NUMBER, n); // Retorna um Token do tipo NUMBER [cite: 516]
    }

    private void skipWhitespace() {
        char ch = peek();
        while (ch == ' ' || ch == '\r' || ch == '\t' || ch == '\n') {
            advance();
            ch = peek();
        }
    }
}