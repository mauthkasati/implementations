package DoubleLinkedList;

public class Main {
    public static void p(DoublyLinkedList<Integer> dl){
        System.out.println(dl.toString());
    }
    public static void main(String[] args){
        DoublyLinkedList<Integer> dl = new DoublyLinkedList<>();
        dl.addFirst(5);
        dl.addFirst(6);
        dl.addLast(10);
        dl.addLast(8);
        p(dl);
        dl.addByIndex(3, 12);
        p(dl);
        dl.addByIndex(5, 20);
        p(dl);
        dl.addByIndex(2, 100);
        p(dl);
        dl.removeFirst();
        p(dl);
        dl.removeFirst();
        p(dl);
        dl.addFirst(99);
        p(dl);
        System.out.println(dl.getIndexByValue(0));
        System.out.println(dl.getIndexByValue(99));
        System.out.println(dl.getIndexByValue(10));
        // System.out.println(dl.getByIndex(6));
        System.out.println(dl.getIndexByValue(8));
        System.out.println(dl.getIndexByValue(20));
    }
}
