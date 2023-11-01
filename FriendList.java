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
        System.out.print("Enter your friend's name: ");
        String friendName = scanner.nextLine();
        friends.add(friendName);
        saveFriendsList();
        System.out.println(friendName + " added to your friend list.");
    }

    public void readFriendsList() {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            friends.add(line);
            System.out.println(line);
        }
    }

    private void saveFriendsList() {
        FileWriter fileWriter = new FileWriter("friends.list");
        PrintWriter writer = new PrintWriter(fileWriter);
        for (String friend : friends) {
            writer.println(friend);
        }
    }
}