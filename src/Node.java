public class Node {
    int value;
    Node next; 

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public void setNextNode(Node next) {
        this.next = next;
    }

    public Node getNextNode() {
        return this.next;
    }

    public int getValue() {
        return this.value;
    }
}