package StackLinkedList;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void p(MyStack<Character> stk) {
        System.out.println(stk.toString());
    }

    public static boolean checkParantheses(String str) {
        try {
            Stack<Character> stk = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i)=='('||str.charAt(i)=='{'||str.charAt(i)=='['){
                    stk.push(str.charAt(i));
                    // System.out.println("pushed : "+str.charAt(i));
                }
                else{
                    // System.out.println("peek = "+stk.peek());
                    // System.out.println("str chat at i = "+str.charAt(i));
                    if(stk.peek()=='('){
                        if(str.charAt(i)==')')stk.pop();
                        else return false;
                    }
                    else if(stk.peek()=='['){
                        if(str.charAt(i)==']')stk.pop();
                        else return false;
                    }
                    else{
                        if(str.charAt(i)=='}')stk.pop();
                        else return false;
                    }
                }
            }
            return stk.size() == 0;
        } catch (Exception e) {
            throw new StackOverflowError("error ,assage : less than 0");
        }
    }
    public static int sum(int n){
        int m =n;
        int sum=0;
        while(m!=0){
            sum+= m%10;
            m/=10;
        }
        return sum;
    }
    public static int fact(int n){
        if(n==0 || n==1)return 1;
        else return n*fact(n-1);
    }
    public static void main(String[] args) {
        System.out.println(fact(4));
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String str = in.next();
            System.out.println(checkParantheses(str));
        }
        // MyStack<Integer> stk = new MyStack<>();
        // p(stk);
        // stk.push(1);
        // stk.push(5);
        // p(stk);
        // stk.push(16);
        // p(stk);
        // stk.pop();
        // p(stk);
        // int n = stk.peek();
        // System.out.println(n);

        // String s = "Muath";
        // MyStack<Character> stack = new MyStack<>();
        // for (int i = 0; i < s.length(); i++) {
        //     stack.push(s.charAt(i));
        // }
        // p(stack);
        // StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < s.length(); i++) {
        //     sb.append(stack.peek());
        //     stack.pop();
        // }
        // System.out.println(sb.toString());
        in.close();
    }
}
