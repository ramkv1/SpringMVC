package com.rk;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Demo {
	public static void main(String args[]) {
		Solution solution=new Solution();
		System.out.println(solution.isIsomorphic("egg", "add"));
	}
}
class Solution {
    public boolean isIsomorphic(String s, String t) {
     Map<Character, Character> map=new HashMap<>();
     Set<Character> set=new HashSet<>();
     int n=s.length()-1;

     while(n>=0){
         if(map.containsKey(s.charAt(n)) && map.get(s.charAt(n)) != t.charAt(n)){
             return false;
             }
         if( !map.containsKey(s.charAt(n)) && set.contains(t.charAt(n))){
             return false;
         }
         set.add(t.charAt(n));
         map.put(s.charAt(n), t.charAt(n));
         n--;
     }  
     System.out.println(map.toString());
     System.out.println(set.toString());
     return true;
    }
}