import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactDirectory directory = new ContactDirectory();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter commands (ADD, SEARCH, DELETE, SHOW)");
        while (true){
            String command = scanner.nextLine();
            String[] parts = command.split(" ", 3);
        switch (parts[0].toUpperCase()){
            case "ADD":
               if (parts.length == 3){
                   directory.add(parts[1], parts[2]);
                   System.out.println("contact added");
               }else {
                   System.out.println("invalid command format");
               }
               break;
            case "SEARCH":
                if (parts.length == 2){
                    System.out.println(directory.search(parts[1]));
                }else {
                    System.out.println("invalid command format");
                }
                break;
            case "DELETE":
                if (parts.length == 2){
                    if (directory.delete(parts[1])){
                        System.out.println("contact '" + parts[1] + " 'deleted");
                    } else {
                        System.out.println("contact not found");
                    }
                } else {
                    System.out.println("invalid command format");
                }
                break;
            case "SHOW":
                directory.show();
                break;
            default:
                System.out.println("unknown command");
        }
        }
    }
}