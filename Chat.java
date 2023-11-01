
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface ChatOperations {
    void readChat();

    void writeChat();
}

class Chat implements ChatOperations {
    protected List<String> chat;
    protected String fileName;

    public Chat(String fileName) {
        this.fileName = fileName;
        chat = new ArrayList<>();
    }

    @Override
    public void readChat() {
        
            BufferedReader reader = new BufferedReader(new FileReader(fileName))
            String line;
            while ((line = reader.readLine()) != null) {
                chat.add(line);
                System.out.println(line);
            }
    }

    @Override
    public void writeChat() {
        Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your message: ");
            String message = scanner.nextLine();
            chat.add(message);
            saveChat();
            System.out.println("Message added to the chat.");
    }

    public void saveChat() {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName))
            for (String message : chat) {
                writer.println(message);
            }
    }
}