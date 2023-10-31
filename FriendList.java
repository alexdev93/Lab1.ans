import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FriendList {
    private List<String> friends;
    private String fileName;

    public FriendList(String fileName) {
        friends = new ArrayList<>();
        this.fileName = fileName;
    }

    public void viewFriendsList() {
        System.out.println("Friend List:");
        for (String friend : friends) {
            System.out.println(friend);
        }
    }

    public void addFriend() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter your friend's name: ");
            String friendName = scanner.nextLine();
            friends.add(friendName);
            saveFriendsList();
            System.out.println(friendName + " added to your friend list.");
        } finally {
            // scanner.close();
        }
    }

    public void readFriendsList() {
        try  {
            BufferedReader reader = new BufferedReader(new FileReader(fileName))
            String line;
            while ((line = reader.readLine()) != null) {
                friends.add(line);
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from " + fileName);
        }
    }

    private void saveFriendsList() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("friends.list"))
            for (String friend : friends) {
                writer.println(friend);
            }
        } catch (IOException e) {
            System.err.println("Error writing to friends.list");
        }
    }
}