import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class DuplicateNumbers {
    static public int getPairs(int arr[]){
        int pairs = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++) {
            String binary = getBinary(arr[i]);
            int sum = getSum(binary);
            if (map.containsKey(sum)) {
                int cnt = map.get(sum);
                map.put(sum, cnt + 1);
            } else
                map.put(sum, 1);
        }
        Iterator mit = map.entrySet().iterator();
        while (mit.hasNext()){
            Map.Entry ele = (Map.Entry)mit.next();
            int val = (int)ele.getValue();
            if(val > 1){
                pairs += (val*(val-1))/2.0;
            }
        }
        return pairs;
    }

    static int getSum(String binary) {
        int sum = 0,n;
        for (int i=0; i < binary.length(); i++ ){
            char ch = binary.charAt(i);
            if(ch == '1')
                n = 1;
            else
                n = 0;
            sum += n;
        }
        return sum;
    }

    static String getBinary(int n){
        String binary = new String();
        binary  = Integer.toString(n%2);
        n /= 2;
        while(n > 0){
            binary += Integer.toString(n%2);
            n /= 2;
        }
        StringBuilder sbuf = new StringBuilder();
        sbuf.append(binary);
        sbuf.reverse();
        binary = sbuf.toString();
        return binary;
    }

    public static void main(String[] args) {
        int arr [] = {2,3};
        System.out.println(getPairs(arr));
    }
}
