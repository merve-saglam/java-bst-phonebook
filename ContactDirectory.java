public class ContactDirectory {
    private Contact root;
    public void add(String name, String phoneNumber){
        root = addRecursive(root, name, phoneNumber);
    }
    private Contact addRecursive(Contact current, String name, String phoneNumber){
        if (current == null){
            return new Contact(name, phoneNumber);
        }
        if (name.compareToIgnoreCase(current.name) < 0){
            current.left = addRecursive(current.left, name, phoneNumber);
        } else if (name.compareToIgnoreCase(current.name) > 0) {
            current.right = addRecursive(current.right, name, phoneNumber);
        } else {
            current.phoneNumber = phoneNumber;
        }
        return current;
    }
    public String search(String name){
        Contact contact = searchRecursive(root, name);
        return contact == null ? "contact not found" : contact.phoneNumber;
    }
    private Contact searchRecursive(Contact current, String name){
        if (current == null || name.equalsIgnoreCase(current.name)){
            return current;
        }
        return name.compareToIgnoreCase(current.name) < 0 ? searchRecursive(current.left, name) : searchRecursive(current.right, name);
    }
    public boolean delete(String name){
        if (search(name).equals("contact not found")){
            return false;
        }
        root = deleteRecursive(root, name);
        return true;
    }
    private Contact deleteRecursive(Contact current, String name){
        if (current == null){
            return null;
        }
        if (name.compareToIgnoreCase(current.name) < 0){
            current.left = deleteRecursive(current.left, name);
        } else if (name.compareToIgnoreCase(current.name) > 0) {
            current.right = deleteRecursive(current.right, name);
        }else {
            if (current.left == null && current.right == null){
                return null;
            } else if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            } else{
                Contact smallest = findSmallest(current.right);
                current.name = smallest.name;
                current.phoneNumber = smallest.phoneNumber;
                current.right = deleteRecursive(current.right, smallest.name);
            }
        }
        return current;
    }
    private Contact findSmallest(Contact root){
        return root.left == null ? root : findSmallest(root.left);
    }
    public void show(){
        inOrderTraversal(root);
    }
    private void inOrderTraversal(Contact current){
        if (current != null){
            inOrderTraversal(current.left);
            System.out.println(current.name + ": " + current.phoneNumber);
            inOrderTraversal(current.right);
        }
    }
}
