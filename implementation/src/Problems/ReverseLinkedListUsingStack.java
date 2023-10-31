package Problems;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;



public class ReverseLinkedListUsingStack{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(list.get(i));
        }
        for (int i = 0; i < n; i++) {
            list.set(i, stack.pop());
        }
        System.out.println(list);
    }
}