public class Node {
    Node next;
    Integer val;

    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "Node{" +
                ", next=" + next +
                ", val=" + val +
                '}';
    }

    public void displayNode(){
        System.out.println("{" + val + "}");
    }
}
