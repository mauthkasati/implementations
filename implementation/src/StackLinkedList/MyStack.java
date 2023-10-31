package StackLinkedList;

import java.util.NoSuchElementException;

public class MyStack <T> implements Cloneable{
    private Node<T> top;
    private int size;

    public MyStack(){
        top = null;
        size = 0;
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;
        public Node(T data){
            this.data = data;
        }
    }

    public void push(T data){
        Node<T> newNode = new Node<>(data);
        newNode.next=top;
        top = newNode;
        size++;
    }

    public void pop(){
        if(size==0){
            throw new NoSuchElementException("empty stack");
        }
        top = top.next;
        size--;
    }

    public T peek(){
        if(size==0){
            throw new NoSuchElementException("empty stack");
        }
        return top.data;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void clear(){
        top =null;
        size =0;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(size==0)return"[]";
        sb.append("[");
        Node<T> curr = top;
        while(curr!=null){
            sb.append(curr.data.toString());
            if(curr.next!=null){
                sb.append(", ");
            }
            curr = curr .next;
        }
        sb.append("]");
        return sb.toString();
    }
}
