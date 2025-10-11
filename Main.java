public class Main {
    public static void main(String[] args) {
        try {        
            String input = "8+5-7+9";
            System.out.println("Analisando a entrada: " + input);

            Parser p = new Parser(input.getBytes());
            p.parse();
        } catch (Error e) {
            System.err.println(e.getMessage());
        }
    }
}