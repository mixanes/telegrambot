import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyAmazingBot extends TelegramLongPollingBot {


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()){
            String user_first_name = update.getMessage().getChat().getFirstName();
            String user_last_name = update.getMessage().getChat().getLastName();
            String user_username = update.getMessage().getChat().getUserName();
            long user_id = update.getMessage().getChat().getId();
            System.out.println("\n ----------------------------");
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            System.out.println(dateFormat.format(date));
            System.out.println("Message from " + user_first_name + " " + user_last_name + ". (id = " + user_id + ") \n Text - " + update.getMessage().getText());
            String message_text = null;
            if(update.getMessage().getText().equals("/help")) {
                message_text = "/weather- погода сейчас в Оренбурге";
                System.out.println(message_text);
                System.out.println("/bash - цитата с башорг");
                System.out.println("/moneta - подкинуть монетку");
                long chat_id = update.getMessage().getChatId();
                SendMessage message1 = new SendMessage().setChatId(chat_id).setText(message_text);
                SendMessage message2 = new SendMessage().setChatId(chat_id).setText("/bash - цитата с башорг");
                SendMessage message3 = new SendMessage().setChatId(chat_id).setText("/moneta - подкинуть монетку");
                try {
                    sendMessage(message1);
                    sendMessage(message2);
                    sendMessage(message3);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }
            else if(update.getMessage().getText().equals("/start")) {
                message_text = "Здарова "+ user_first_name + ", что бы получить список доступных команд введи /help";
                System.out.println(message_text);
                long chat_id = update.getMessage().getChatId();
                SendMessage message = new SendMessage().setChatId(chat_id).setText(message_text);
                try {
                    sendMessage(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }


            else if (update.getMessage().getText().equals("/bash")){
                try {
                    message_text = bash.test();
                    System.out.println(message_text);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                long chat_id = update.getMessage().getChatId();
                SendMessage message = new SendMessage().setChatId(chat_id).setText(message_text);
                try {
                    sendMessage(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (update.getMessage().getText().equals("/moneta")){

                    message_text = moneta.moneta();
                    System.out.println(message_text);
                long chat_id = update.getMessage().getChatId();
                SendMessage message = new SendMessage().setChatId(chat_id).setText(message_text);
                try {
                    sendMessage(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if(update.getMessage().getText().equals("/test")) {
                try {
                    message_text = message.sendMessage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(message_text);
                long chat_id = update.getMessage().getChatId();
                System.out.println(chat_id);
                SendMessage message = new SendMessage().setChatId(chat_id).setText(message_text);
                try {
                    sendMessage(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }



            }
            else if(update.getMessage().getText().equals("/mix")) {
                String shutdownCmd = "shutdown -s";
                try {
                    Process child = Runtime.getRuntime().exec(shutdownCmd);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            else if (update.getMessage().getText().equals("/roll")){

                    message_text = "выбрасывает: "+ roll.roll();
                    System.out.println(message_text);

                long chat_id = update.getMessage().getChatId();
                SendMessage message = new SendMessage().setChatId(chat_id).setText(message_text);
                try {
                    sendMessage(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }



            else if (update.getMessage().getText().equals("/weather")){
                try {
                    message_text = "Сейчас в Оренбурге "+gismeteo.test("lol");
                    System.out.println(message_text);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                long chat_id = update.getMessage().getChatId();
            SendMessage message = new SendMessage().setChatId(chat_id).setText(message_text);
                try {
                    sendMessage(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }



        }

    }

    @Override
    public String getBotUsername() {
        return "mixpogoda_bot";
    }

    @Override
    public String getBotToken() {
        return "408673339:AAFUS1r2XLf6ZR4AodtrPfF8EjMmOMWBHAA";
    }
}
