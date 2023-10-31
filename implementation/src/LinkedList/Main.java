package LinkedList;

public class Main {
    public static void main(String[] args){
        MyLinkedList ml = new MyLinkedList();
        ml.add(1);
        ml.add(5);
        ml.add(9);
        ml.add(2);
        ml.add(10);
        ml.add(10);
        ml.add(14);
        ml.print();
        ml.head=ml.reverseRecursive(ml.head);
        ml.print();
        System.out.println(ml.findMiddile().data);
    }
}
