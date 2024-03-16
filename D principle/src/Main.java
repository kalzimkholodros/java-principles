
interface MessageSender {
    void sendMessage(String message);
}


class EmailSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        // Email gönderme işlemi burada gerçekleştirilir
        System.out.println("Email gönderiliyor: " + message);
    }
}


class SMSSender implements MessageSender {
    @Override
    public void sendMessage(String message) {

        System.out.println("SMS gönderiliyor: " + message);
    }
}


class MessageService {
    private MessageSender sender;


    public MessageService(MessageSender sender) {
        this.sender = sender;
    }


    public void send(String message) {
        sender.sendMessage(message);
    }
}


public class Main {
    public static void main(String[] args) {
        // EmailSender kullanarak bir MessageService örneği oluşturalım
        MessageSender emailSender = new EmailSender();
        MessageService emailService = new MessageService(emailSender);
        emailService.send("Bu bir email mesajıdır.");


        MessageSender smsSender = new SMSSender();
        MessageService smsService = new MessageService(smsSender);
        smsService.send("Bu bir SMS mesajıdır.");
    }
}
