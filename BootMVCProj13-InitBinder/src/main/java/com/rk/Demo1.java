package com.rk;

public class Demo1 {
	public static void main(String[] args) {
		Solution1 solution1=new Solution1();
		//System.out.println(solution1.singleNumber(new int[] {1,1,2,4,3,2,3}));
		System.out.println(solution1.maxProfit(new int[] {7,1,5,3,6,4}));
	}
}
/*class Solution1 {
    public int climbStairs(int n) {
      if(n<4)
      return n;
      int f=2,s=3,t=0;
      for(int i=3;i<n;i++){
          t=f+s;
          f=s;
          s=t;
      }
      return t;
    }
}*/
/*class Solution1 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        if(nums.length==1){
            return nums[0];
        }
        for(int i=0;i<nums.length-1;i+=2){
            if(nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
       return nums[nums.length-1];
    }
    
}*/


class Solution1 {
    public int maxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE; // least so far
        int op = 0; // overall profit
        int pist = 0; // profit if sold today
        
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < lsf){ // if we found new buy value which is more smaller then previous one
                lsf = prices[i]; // update our least so far
            }
            pist = prices[i] - lsf; // calculating profit if sold today by, Buy - sell
            if(op < pist){ // if pist is more then our previous overall profit
                op = pist; // update overall profit
            }
        }
        return op; // return op 
    }
}