import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static int maxSubArray(int[] nums) {
        int max  = 0;
        int c = 1;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]==nums[i+1]){
                c++;
            }
            else{
                c=1;
            }
            if(c>max)max=c;
        }
        return max;
    }
    public static int maj(int[] arr){
        Arrays.sort(arr);
        int c=1;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] == arr[i+1]) c++;
            else c=1;
            if(c>arr.length/2) return arr[i];
        }
        return -1;
    }
    public static void main(String[] args) throws Exception {
        Scanner in  = new Scanner(System.in);
        in.close();
    }
}
