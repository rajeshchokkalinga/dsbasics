package ds.basics.coding;

class CoinChangeProblem{

    // Returns the count of ways we can
    // sum coins[0...n-1] coins to get sum "sum"
    static int count(int coins[], int n, int sum)
    {

        // If sum is 0 then there is 1 solution
        // (do not include any coin)
        if (sum == 0)
            return 1;

        // If sum is less than 0 then no
        // solution exists
        if (sum < 0)
            return 0;

        // If there are no coins and sum
        // is greater than 0, then no
        // solution exist
        if (n <= 0)
            return 0;

        // count is sum of solutions (i)
        // including coins[n-1] (ii) excluding coins[n-1]
        return count(coins, n - 1, sum)
              + count(coins, n, sum - coins[n - 1]);
    }

    // Driver code
    public static void main(String args[])
    {
        int coins[] = { 1, 2, 5 };
        int n = coins.length;

        System.out.println(count(coins, n, 5));
        coinCombinationPrint(coins, 0, 5);
    }

    static int coinCombination(int[] coins, int index, int target){
        if(target == 0)
            return 1;
        int ways = 0;
        for(int i = index ; i < coins.length;i++){
            if(target - coins[i] >= 0){
                ways += coinCombination(coins, i, target- coins[i]);
            }
        }
        return  ways;
    }

    static void coinCombinationPrint(int[] coins, int index, int target){
        int sum = 0;
      for(int i = index;i<coins.length;i++){
          while(target != 0){

          }
      }
    }

}

// This code is contributed by jyoti369
