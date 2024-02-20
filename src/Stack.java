public class Stack {
    private Node topItem;
    private int limit;
    private int size;
    private String name;

    public Stack(String name, int limit) {
        this.topItem = null;
        this.limit = limit;
        this.size = 0;
        this.name = name;
    }

    public void push(int value) {
        if (!isFull()) {
            Node newItem = new Node(value, topItem);
            topItem = newItem;
            size++;
        } else {
            System.out.println("Stack is full. Cannot push " + value);
        }
    }

    public int pop() {
        if (!isEmpty()) {
            int itemToRemove = topItem.getValue();
            topItem = topItem.getNextNode();
            size--;
            return itemToRemove;
        } else {
            System.out.println("Stack is empty. Cannot pop.");
            return -1; 
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return topItem.getValue();
        } else {
            System.out.println("Stack is empty. Cannot peek.");
            return -1; 
        }
    }

    public boolean isFull() {
        return size >= limit;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String getName() {
        return name;
    }

    public int getLimit() {
        return limit;
    }

    public int getSize(){
        return size;
    }
}
