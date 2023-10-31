
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
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName))
            String line;
            while ((line = reader.readLine()) != null) {
                chat.add(line);
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from " + fileName);
        }
    }

    @Override
    public void writeChat() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter your message: ");
            String message = scanner.nextLine();
            chat.add(message);
            saveChat();
            System.out.println("Message added to the chat.");
        } finally {
            // scanner.close();
        }
    }

    public void saveChat() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName))
            for (String message : chat) {
                writer.println(message);
            }
        } catch (IOException e) {
            System.err.println("Error writing to " + fileName);
        }
    }
}