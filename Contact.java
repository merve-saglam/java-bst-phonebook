public class Contact {
    String name;
    String phoneNumber;
    Contact left, right;

    public Contact(String name,String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.left = this.right = null;
    }
}
