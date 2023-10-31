package Searchs;

// import java.util.Scanner;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target){
        int left =0;
        int right = arr.length-1;
        while(left <= right){
            int mid = (left + right)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid]<target){
                left = mid+1;
            }
            else right = mid-1;
        }
        return -1;
    }
    public static int binarySearchRecursive(int []arr,int target, int left,int right ){
        if(left>right){
            return -1;
        }
        int mid = (left+right)/2;
        if(arr[mid] == target){
            return mid;
        }
        else if(arr[mid] < target){
            return binarySearchRecursive(arr, target, mid+1, right);
        }
        else {
            return binarySearchRecursive(arr, target, left, mid-1);
        }
    }
    public static void main(String[] args){
        // Scanner in = new Scanner(System.in);
        int[] arr = {1,5,10,14,19,18,20,94};
        int[] arr2 = {1};
        System.out.println(binarySearchRecursive(arr, 1, 0,arr.length-1));
        System.out.println(binarySearch(arr, 94));
        System.out.println(binarySearch(arr, 10));
        System.out.println(binarySearch(arr, 20));
        System.out.println(binarySearch(arr, 15));
        System.out.println("--------------");

        System.out.println(binarySearch(arr2, 0));
        System.out.println(binarySearch(arr2, 1));
        System.out.println("-----------------------------");
        System.out.println(binarySearchRecursive(arr, 1, 0,arr.length-1));
        System.out.println(binarySearchRecursive(arr, 94, 0,arr.length-1));
        System.out.println(binarySearchRecursive(arr, 10, 0,arr.length-1));
        System.out.println(binarySearchRecursive(arr, 20, 0,arr.length-1));
        System.out.println(binarySearchRecursive(arr, 15, 0,arr.length-1));

    }
}
