package com.rk;

public class Demo {
	public static void main(String[] args) {
		Solution solution=new Solution();
		String a="aa",b="aab";
		System.out.println(solution.canConstruct(a, b));
		/*int[] nums={1,1,2};
		System.out.println(solution.removeDuplicates(nums));*/
		/*Solution solution=new Solution();
		System.out.println(solution.wordPattern("abba","dog cat cat dog"));		 */
	}
}
/*class Solution {
    public int strStr(String haystack, String needle) {
        int haylength=haystack.length();
        int needlength=needle.length();
        if(haylength<needlength){
            return -1;
        }
        for(int i=0;i<haylength-needlength;i++){
            int j=0;
            while(j<needlength && haystack.charAt(i+j)==needle.charAt(j)){
            	System.out.println(haystack.charAt(i+j)+"===>"+needle.charAt(j));
                j++;
                if(j==needlength)
                return i;
            }
        }
        return -1;
    }
}*/
////********Column Number*********
/*class Solution {
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        for(char ch : columnTitle.toCharArray()) {
            int diff = ch-('A' - 1);
            sum = sum *26 + diff;
        }
        return sum;
    }
}*/

//////**********Column Title*******************
/*class Solution {
    public String convertToTitle(int columnNumber) {
        String ans = "";
        while (columnNumber>0){
            columnNumber--;
            ans = (char) ('A'+ (columnNumber%26)) + ans;
            columnNumber = columnNumber/26;
        }
        return ans;
    }
}*/

/*class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> mp = new HashMap<>();
        char[] alpha = pattern.toCharArray();
        String[] words = s.split(" ");
        if(words.length!=pattern.length()) return false;
        int i=0;
        for(char ch : alpha){
            if(mp.containsKey(ch)){
                if(!mp.get(ch).equals(words[i++]))
                return false;
            }
            else{
                if(mp.containsValue(words[i]))
                return false;
                mp.put(ch,words[i++]);
            }
            
        }
        return true;
    }
}*/
/*class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        int addIndex = 1; //index that unique characters will be inserted at

        for(int i = 0; i < nums.length - 1; i++) {
            
            if(nums[i] < nums[i + 1]){ //if true, num[i + 1] is a new unique number
              nums[addIndex] = nums[i + 1];
              addIndex++;
            }
        }
        return addIndex;
    }
}*/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[128];
        for(int i = 0; i < ransomNote.length(); i++)
            arr[ransomNote.charAt(i)]++;
        for(int i = 0; i < magazine.length(); i++)
            if(arr[magazine.charAt(i)] != 0)
                arr[magazine.charAt(i)]--;
        for(int i = 0; i < ransomNote.length(); i++)
            if(arr[ransomNote.charAt(i)] > 0)
                return false;
        return true;
    }
}