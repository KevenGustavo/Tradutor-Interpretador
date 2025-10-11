public class Main {
    public static void main(String[] args) {
        try {        
            String input = "9*2+7-3/1";
            System.out.println("Analisando a entrada: " + input);

            Parser p = new Parser(input.getBytes());
            p.parse();
        } catch (Error e) {
            System.err.println(e.getMessage());
        }
    }
}