 //The DP soln will give TLE,  TC-O(n*max value of nums[i])
 //To resolve this , Greedy approach will be used. TC-O(n)
 class Solution {
    public boolean canJump(int[] nums) {
        Boolean [] dp=new Boolean[nums.length-1];
        for(int i=0;i<dp.length;i++){
            dp[i]=false;
        }
        return Jump(0,nums.length-1,nums,new HashMap<Integer,Boolean>());
    }
    public static boolean Jump(int currentIndex,int lastIndex,int [] nums,HashMap<Integer,Boolean> memo){
        if(currentIndex>=lastIndex){
            return true;
        }
        int CurrentKey=currentIndex;

        if(memo.containsKey(CurrentKey)){
            return memo.get(CurrentKey);
        }
        int JumpCapacity=nums[currentIndex];
        boolean ans=false;
        for(int i=1;i<=JumpCapacity;i++){
            boolean Jumps=Jump(currentIndex+i,lastIndex,nums,memo);
           if(Jumps){
               memo.put(CurrentKey,true);
               return true;
           }
           //ans=ans|| Jumps;
        }
        memo.put(CurrentKey,ans);
          return ans;
    }
}