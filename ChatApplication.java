import java.util.Scanner;

public class ChatApplication {
    public static void main(String[] args) {
        PrivateChat privateChat = new PrivateChat("Donut[AFK].log");
        PublicChat publicChat = new PublicChat("Eukarte.log");
        FriendList friendList = new FriendList("friends.list");

        Scanner scanner = new Scanner(System.in);
        try {

            while (true) {
                System.out.println("\n\n1: Read from private chat");
                System.out.println("2: Write into private chat");
                System.out.println("3: Read from public chat");
                System.out.println("4: Write into public chat");
                System.out.println("5: View friend's list");
                System.out.println("6: Add a new friend");
                System.out.println("7: Exit\n\n");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        privateChat.readChat();
                        break;
                    case 2:
                        privateChat.writeChat();
                        break;
                    case 3:
                        publicChat.readChat();
                        break;
                    case 4:
                        publicChat.writeChat();
                        break;
                    case 5:
                        friendList.readFriendsList();
                        break;
                    case 6:
                        friendList.addFriend();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } finally {
            // scanner.close();
        }
    }
}
