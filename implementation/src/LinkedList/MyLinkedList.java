package LinkedList;

import java.util.Stack;

public class MyLinkedList {
    public Node head;  // The first node in the linked list
    
    public class Node {
        int data;  // The data stored in this node
        Node next; // The next node in the linked list
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // Add a new node to the end of the linked list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
    // Remove the first occurrence of a node with the specified data from the linked list
    public void remove(int data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
    
    // Get the size of the linked list
    public int size() {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }
    
    // Check if the linked list is empty
    public boolean isEmpty() {
        return head == null;
    }
    
    // Get the data stored in the node at the specified index
    public int get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    // Print the contents of the linked list
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    } 



    // reverses
    public void reverseIterative() {
        Node previous = null;
        Node current = head;
        Node next = null;
    
        while (current != null) {
            next = current.next; // Store the next node
            current.next = previous; // Reverse the link
            previous = current; // Move the previous node to the current node
            current = next; // Move the current node to the next node
        }
    
        head = previous; // Set the new head to the previous node
    }

    public Node reverseRecursive(Node node) {
        if (node == null || node.next == null) {
            return node; // Base case: empty list or single node
        }
        
        Node reversed = reverseRecursive(node.next); // Recursively reverse the rest of the list
        
        node.next.next = node; // Set the next node in the reversed list to point to the current node
        node.next = null; // Set the current node to the end of the reversed list
        
        return reversed; // Return the new head of the reversed list
    } 
    
    public void reverseStack() {
        if (head == null || head.next == null) {
            return; // Base case: empty list or single node
        }
    
        Stack<Node> stack = new Stack<>();
        Node current = head;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
    
        head = stack.pop();
        current = head;
        while (!stack.isEmpty()) {
            Node nextNode = stack.pop();
            current.next = nextNode;
            current = nextNode;
        }
        current.next = null; // Mark the last node as the tail of the reversed list
    }
    
    public Node findMiddile(){
        Node slow = head;
        Node fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
