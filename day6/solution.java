import java.util.HashMap;
import java.util.Map;

class Node<T> {
    T data;
    int both;

    public Node(T data) {
        this.data = data;
        this.both = 0;
    }
}

class XORLinkedList<T> {
    private Map<Integer, Node<T>> memory = new HashMap<>();
    
    private int headAddress = 0;
    private int tailAddress = 0;
    private int addressCounter = 1; 

    private int _allocate(Node<T> node) {
        int address = addressCounter++; 
        memory.put(address, node);
        return address;
    }

    private Node<T> _dereference(int address) {
        return memory.get(address);
    }

    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        int newNodeAddress = _allocate(newNode);

        if (headAddress == 0) {
            headAddress = newNodeAddress;
            tailAddress = newNodeAddress;
        } else {
            Node<T> currentTail = _dereference(tailAddress);
            int prevAddressOfTail = currentTail.both ^ 0;
            currentTail.both = prevAddressOfTail ^ newNodeAddress;
            newNode.both = tailAddress ^ 0;
            tailAddress = newNodeAddress;
        }
    }

    public Node<T> get(int index) {
        int currentAddress = headAddress;
        int prevAddress = 0; 

        for (int i = 0; i < index; i++) {
            if (currentAddress == 0) {
                throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
            }
            Node<T> currentNode = _dereference(currentAddress);
            int nextAddress = currentNode.both ^ prevAddress;
            prevAddress = currentAddress;
            currentAddress = nextAddress;
        }
        
        return _dereference(currentAddress);
    }
}

public class Main {
    public static void main(String[] args) {
        XORLinkedList<String> list = new XORLinkedList<>();

        System.out.println("Adding A, B, C, D...");
        list.add("A"); 
        list.add("B"); 
        list.add("C"); 
        list.add("D"); 

        System.out.println("Reading back:");
        try {
            System.out.println("Index 0: " + list.get(0).data);
            System.out.println("Index 1: " + list.get(1).data);
            System.out.println("Index 2: " + list.get(2).data);
            System.out.println("Index 3: " + list.get(3).data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
