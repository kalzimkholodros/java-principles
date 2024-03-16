import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdvancedChatbot {
    private static final Map<String, String> responses = new HashMap<>();

    static {
        responses.put("merhaba", "Merhaba! Nasıl yardımcı olabilirim?");
        responses.put("nasılsın", "Ben bir chatbot'um, her zaman iyiyim!");
        responses.put("hoşça kal", "Görüşmek üzere!");
        responses.put("saat kaç", "Şu anda saat " + getCurrentTime() + ".");
        responses.put("hesapla", "Lütfen bir matematik işlemi girin (örneğin, hesapla 4 + 5).");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chatbot'a hoş geldiniz! Çıkmak için 'hoşça kal' yazabilirsiniz.");

        while (true) {
            System.out.print("Soru: ");
            String question = scanner.nextLine().toLowerCase();

            if (question.equals("hoşça kal")) {
                System.out.println(responses.get("hoşça kal"));
                break;
            }

            String response = responses.getOrDefault(question, "Üzgünüm, anlamadım. Lütfen tekrar sorun.");
            if (question.startsWith("hesapla")) {
                response = calculate(question.substring(8));
            }

            System.out.println("Cevap: " + response);
        }

        scanner.close();
    }

    private static String calculate(String expression) {
        try {
            String[] tokens = expression.split("(?<=[-+*/])|(?=[-+*/])");
            double operand1 = Double.parseDouble(tokens[0]);
            String operator = tokens[1];
            double operand2 = Double.parseDouble(tokens[2]);

            switch (operator) {
                case "+":
                    return String.valueOf(operand1 + operand2);
                case "-":
                    return String.valueOf(operand1 - operand2);
                case "*":
                    return String.valueOf(operand1 * operand2);
                case "/":
                    return String.valueOf(operand1 / operand2);
                default:
                    return "Geçersiz işlem!";
            }
        } catch (Exception e) {
            return "Hatalı işlem! Lütfen doğru bir işlem girin.";
        }
    }

    private static String getCurrentTime() {
        return java.time.LocalTime.now().toString();
    }
}
