import java.util.*;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input: ");
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Integer> res = findPrime(n);

        System.out.println("Output: ");
        System.out.println(res.toString().substring(1,res.toString().length()-1));
    }
    public static List<Integer> findPrime(int n){
        int[] isPrime = new int[n+1];
        for(int i=2;i<=n;i++) isPrime[i] = 1;
        for(int i=2;i*i<=n;i++){
            if(isPrime[i] == 1){
                for(int j=i*i;j<=n;j+=i) isPrime[j] = 0;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(isPrime[i] == 1) ans.add(i);
        }
        return ans;
    }
}
