// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

// You may assume that you have an infinite number of each kind of coin.

// The answer is guaranteed to fit into a signed 32-bit integer.

 

// Example 1:

// Input: amount = 5, coins = [1,2,5]
// Output: 4
// Explanation: there are four ways to make up the amount:
// 5=5
// 5=2+2+1
// 5=2+1+1+1
// 5=1+1+1+1+1


class Solution {
    public int change(int amount, int[] coins) {
        return CoinChange(amount,0,coins,new HashMap<String,Integer>());
        
    }
    public static int CoinChange(int amount,int currentIndex,int [] coins,HashMap<String,Integer>memo){
        if(amount==0){
            return 1;
        }
        if(currentIndex==coins.length){
            return 0;
        }
        int currentCoin=coins[currentIndex];
        String Currentkey=Integer.toString(currentIndex)+"-"+Integer.toString(amount);
        if(memo.containsKey(Currentkey)){
            return memo.get(Currentkey);
        }
        int consider=0;
        if(amount>=currentCoin){
            consider=CoinChange(amount-currentCoin,currentIndex,coins,memo);
        }
        int NoConsider=CoinChange(amount,currentIndex+1,coins,memo);
        memo.put(Currentkey,consider+NoConsider);
        return consider+NoConsider;
    }
}
