package DoubleLinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements Cloneable{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T>{
        T data;
        Node<T> prev;
        Node<T> next;
        Node(T data){
            this.data = data;
        }
    }

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(T data){
        Node<T> newNode = new Node<>(data);
        if(size == 0){
            head = tail = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T data){
        Node<T> newNode = new Node<>(data);
        if(size == 0){
            head = tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    
    public void addByIndex(int index, T data){
        if(index<0 || index > size){
            throw new IndexOutOfBoundsException("you entered wrong index");
        }
        else if(size==0){
            addFirst(data);
        }
        else if(index == size){
            addLast(data);
        }
        else {
            Node<T> newNode = new Node<>(data);
            if(index <= size/2){
                Node<T> curr = head;
                for (int i = 0; i < index-1; i++) {
                    curr = curr.next;
                }
                newNode.next = curr.next;
                newNode.prev = curr;
                curr.next.prev = newNode;
                curr.next = newNode;
            }
            else{
                Node<T> curr = tail;
                for (int i = size-1; i > index+1; i--) {
                    curr = curr.prev;
                }
                newNode.prev = curr.prev;
                newNode.next = curr;
                curr.prev.next = newNode;
                curr.prev = newNode;
            }
            size++;
        }
        // if(index<0&&index>=size){
        //     throw new IndexOutOfBoundsException("You entered wrong index");
        // }
        // else if(size == 0){
        //     addFirst(data);
        // }
        // else if(size == index){
        //     addLast(data);
        // }
        // else{
        //     Node<T> newNode = new Node<>(data);
        //     Node<T> curr = head;
        //     Node<T> curr2 = tail;
        //     if(index<=size/2){
        //         for (int i = 0; i < index-1; i++) {
        //             curr = curr.next;
        //         }
        //         System.out.println("mode 1111111111111111111");
        //     }
        //     else{
        //         for (int i = size-1; i > index+1 ; i--) {
        //             curr2 = curr2.prev;
        //         }
        //         System.out.println("mode 2222222222222222222");
        //     }
        //     if(index<=size/2){
        //         newNode.next = curr.next;
        //         newNode.prev = curr;
        //         curr.next.prev = newNode;
        //         curr.next = newNode;
        //     }
        //     else{
        //         newNode.prev = curr2.prev;
        //         newNode.next = curr2;
        //         curr2.prev.next = newNode;
        //         curr2.prev = newNode;
        //     }
        //     size++;
        // }
    }
    public void removeFirst(){
        if(size==0){
            throw new NoSuchElementException("the List is Empty");
        }
        else if(size == 1){ //head == tail
            head = tail = null;
            size--;
        }
        else{
            head = head.next;
            head.prev = null;
            size--;
        }
    }
    public void removeLast(){
        if(size == 0){
            throw new NoSuchElementException("the List is empty");
        }
        else if(size == 1){
            head = tail = null;
            size--;
        }
        else {
            tail = tail.prev;
            tail.next = null;
            size--;
        }
    }
    public void removeByIndex(int index){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("you entered a not valid index");
        }
        else if(index == 0){
            removeFirst();
        }
        else if(index == 1){
            removeLast();
        }
        else {
            if(index<=size/2){
                Node<T> curr = head;
                for (int i = 0; i < index-1; i++) {
                    curr = curr.next;
                }
                curr.next.next.prev = curr;
                curr.next = curr.next.next;
                size--;
            }
            else{
                Node<T> curr = tail;
                for (int i = size-1; i > index+1; i--) {
                    curr = curr.prev;
                }
                curr.prev.prev.next = curr;
                curr.prev = curr.prev.prev;
                size--;
            }
        }
    }
    public T getByIndex(int index){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("wrong index");
        }
        else if(index == 0){
            return head.data;
        }
        else if(index==size-1){
            return tail.data;
        }
        else{
            if(index <= size/2){
                Node<T> curr = head;
                for (int i = 0; i < index; i++) {
                    curr = curr.next;
                }
                return curr.data;
            }
            else {
                Node<T> curr = tail;
                for (int i = size-1; i>index; i--) {
                    curr = curr.prev;
                }
                return curr.data;
            }
        }
    }
    public int getIndexByValue(T val){
        Node<T> curr = head;
        int index = 0;
        while(index<size){
            if(curr.data==val){
                return index;
            }
            curr=curr.next;
            index++;
        }
        return -1;
    }
    public boolean contains(T val){
        return getIndexByValue(val)!=-1;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void clear(){
        head = tail =null;
        size = 0;
    }
    @SuppressWarnings("unchecked")
    @Override
    public DoublyLinkedList<T> clone() {
        try {
            DoublyLinkedList<T> clonedList = (DoublyLinkedList<T>) super.clone();
    
            if (!isEmpty()) {
                Node<T> current = head;
                Node<T> newHead = new Node<>(current.data);
                Node<T> newTail = newHead;
                clonedList.head = newHead;
    
                while (current.next != null) {
                    current = current.next;
                    Node<T> newNode = new Node<>(current.data);
                    newTail.next = newNode;
                    newNode.prev = newTail;
                    newTail = newNode;
                }
    
                clonedList.tail = newTail;
                clonedList.size = size;
            }
    
            return clonedList;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    public void swapBetweenTwoNodes(int index1, int index2) {
        if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size || index1 == index2) {
            return;
        }
    
        int smallerIndex = Math.min(index1, index2);
        int largerIndex = Math.max(index1, index2);
        Node<T> node1 = head;
        Node<T> node2 = head;
    
        for (int i = 0; i < smallerIndex; i++) {
            node1 = node1.next;
        }
    
        for (int i = 0; i < largerIndex; i++) {
            node2 = node2.next;
        }
    
        if (smallerIndex == 0) {
            head = node2;
        } else {
            node1.prev.next = node2;
        }
    
        if (largerIndex == size - 1) {
            tail = node1;
        } else {
            node2.next.prev = node1;
        }
    
        Node<T> temp = node1.next;
        node1.next = node2.next;
        node2.next = temp;
    
        temp = node1.prev;
        node1.prev = node2.prev;
        node2.prev = temp;
    }
    
    public void swapValuesBetweenTwoNodes(int index1, int index2) {
        if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size || index1 == index2) {
            return;
        }
    
        Node<T> node1 = head;
        Node<T> node2 = head;
    
        for (int i = 0; i < index1; i++) {
            node1 = node1.next;
        }
    
        for (int i = 0; i < index2; i++) {
            node2 = node2.next;
        }
    
        T temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }
    public T findMiddle() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    
        Node<T> slow = head;
        Node<T> fast = head;
    
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
    
        return slow.data;
    }
    @Override
    public String toString(){
        if(size==0)return "[]";
        else{
            StringBuilder sb = new StringBuilder();
            Node <T> curr = head;
            sb.append("[");
            while(curr != null){
                sb.append(curr.data.toString());
                if(curr.next!=null){
                    sb.append(", ");
                }
                curr = curr.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }

}
