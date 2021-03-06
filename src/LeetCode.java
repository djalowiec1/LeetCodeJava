import java.util.*;


/**
 * @author djalowiec
 *
 */
public class LeetCode {

    public int removeDuplicates(int[] nums) {
    	//  Remove Duplicates from Sorted Array
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
    public int maxProfit(int[] prices) {
    	//Best Time to Buy and Sell Stock II
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
    public void rotate(int[] nums, int k) {
    	//Rotate Array
    	int[] numsClone = new int[nums.length];
        //
    	int i;
    	for(i = 0; i < nums.length; i++) {
    		numsClone[(i+k) % nums.length] = nums[i];
    	}
    	//copy
        for (i = 0; i < nums.length; i++) {
            nums[i] = numsClone [i];
          }
    	//nums =  numsReturn.clone();
    }
    public boolean containsDuplicate(int[] nums) {
    	HashSet <Integer> HashSet = new HashSet <>(nums.length);
    	for(int x = 0; x < nums.length; x++) {
	    	if(HashSet.contains(nums[x])) {
	    		return true;
	    	}
	    	HashSet.add(nums[x]);
	    	}
    	 return false; 

    }
    public int singleNumber(int[] nums) {
    	if(nums.length == 1) {
    		return nums[0];
    	}
    	Arrays.sort(nums);
    	int x ;
    	for(x = 0; x < nums.length -1 ; x++) {
    		if(nums[x] != nums[x+1]) {
    			return nums[x];
    		} else {
    			//skip another
    			x++;
    		}
    	}
    	return nums[x];
    	
    }
    public int[] intersect(int[] nums1, int[] nums2) {
     HashSet<Integer> set = new HashSet<Integer>();
     for(int i : nums1) {
    	 set.add(i); //no DUPLICATES
     }
     
     HashSet<Integer> intersect = new HashSet<Integer>();
     for(int j : nums2) {
    	 if(set.contains(j)) {
    		 intersect.add(j);
    	 }
     }
     int[] result = new int[intersect.size()];
     int i = 0;
     for(int x: intersect) {
    	 result[i] = x;
    	 i++;
     }
     //Integer[] array = new Integer[intersect.size()];
     //intersect.toArray(array);
     
     return result;
    }
    public int[] plusOne(int[] digits) {
      boolean addAnother = false;
      for(int x = digits.length - 1; x >= 0; x-- ) {
    	  if(digits[x] < 9) {
    		  digits[x]  = digits[x] + 1;
    		  return digits;
    	  } else {
    		  //set to 0
    		  digits[x]  = 0;
    		  addAnother = true;
    	  }
      }
	  int[] result = new int[digits.length + 1];
      if(addAnother) {
    	  Arrays.fill(result, 1);
    	  for(int i = 1; i < result.length; i++) {
    		  result[i] = digits[i - 1];
    	   }
      }
      return result;
    }
    public void moveZeroes(int[] nums) {
        //move zeros to end 
    	//int y = 0;
    	
    	//count all 0
    	int cntZero = 0;
    	for(int x : nums) {
    		if(x == 0) {
    			cntZero ++;
    		}
    	}
    	List<Integer> order = new ArrayList<Integer>();
    	for(int x : nums) {
    		if(x != 0) {
    			order.add(x);
    		}
    	}
    	if(cntZero > 0) {
    		do {
    			order.add(0);
    			cntZero--;
    		} while (cntZero > 0);
    	}
    	for(int i = 0; i <nums.length; i++) {
    		nums[i] = order.get(i);
    	}
    }
    public int[] twoSum(int[] nums, int target) {
		int[] result = {0,0};
    	/*
    	 * brute force
		int[] result = {0,0};
        for(int x = 0; x<nums.length; x++) {
        	for (int y = x + 1; y < nums.length; y++) {
        		if(nums[x] + nums[y] == target) {
        			result[0] = x;
        			result[1] = y;
        			return result;
        		}
        	}
        	
        }*/
    	HashMap<Integer, Integer> findTarget = new HashMap<Integer, Integer>();
        for(int x = 0; x<nums.length; x++) {
        	findTarget.put(nums[x], x);
        }
        //now find same ones
        for(int x = 0; x<nums.length; x++) {
        	int partner = target - nums[x];
        	if(findTarget.containsKey(partner)){
        		if(findTarget.get(partner) != x) {
        			int[] value = {x , findTarget.get(partner)};
        			return value;
        		}
        	}
        }
        
        
        return result;
    }
    public void reverseString(char[] s) {
    	StringBuilder newString = new StringBuilder();
        newString.append(s);
        newString.reverse();
        for(char p = 0; p< newString.length(); p++) {
        	s[p] = newString.charAt(p);
        }
    }
    public int reverse(int x) {
    	//save if negative
    	boolean negative = false;
    	long q = x;
    	if(q < 0) {
    		negative = true;
    		q = q * -1;
    	}
        StringBuilder p = new StringBuilder();
        p.append(q);
        p.reverse();
        
        long result = Long.parseLong(p.toString());
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
        	return 0;
        }
        int intVersion = (int) result;
        if(negative) {
        	intVersion = intVersion * -1;
        }
        return intVersion; 
    }
    public int firstUniqChar(String s) {
      //CURRENT
    	
    	//hash map
    	// c 0
    	// p 1
    	
    	HashMap <Character, Integer> map = new HashMap <Character, Integer>();
    	for (int i = 0; i< s.length(); i++) {
    		char c = s.charAt(i);
    		map.put(s.charAt(i), map.getOrDefault(c, 0) + 1);
    	}
    	for (int j = 0; j< s.length(); j++) {
    		if(map.get(s.charAt(j)) == 1) {
    			return 1;
    		}
        }
    	
    	return -1;
      //return - 1;   
    }
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        if(Arrays.equals(str1, str2)) {
        	return true;
        } else {
        	return false; 
        }
    }
    public boolean isPalindrome(String s) {
    	int start = 0;
    	int end = s.length() - 1;
    	
    	while(start < end ) {
    		while(start < end && !Character.isLetterOrDigit(s.charAt(start))) {
    			start ++;
    		}
    		while(start < end && !Character.isLetterOrDigit(s.charAt(end))) {
    			end --;
    		}
    		if(start < end && 
    		   Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)))   {
    			return false;
    		}
			start++;
			end--;
    	}
    	return true;
    }
    
    public int myAtoi(String s) {
	     if(s.length() == 0 || s.isBlank()) {
	    	 return 0;
	     }
	     String Result = "";
	     int returnInt = 0;
	     boolean negative = false;
	     //step 1 Read in and ignore any leading whitespace   
	     s = s.stripLeading();
	     //step 2 check for +/ - to see if negative or postive result
	     if(s.charAt(0) == '+' || s.charAt(0) == '-' )  {
	    	 if(s.charAt(0) == '-') {
	    		 negative = true;
	    	 }
	    	 s = s.substring(1, s.length());
	     }
	     //step 3 read in numeric number
	     for(int i = 0; i < s.length() ; i++) {
	    	 if(Character.isDigit(s.charAt(i))) {
	    		 Result = Result + s.charAt(i);
	    	 } else {
	    		 break;
	    	 }
	     }
	     long longResult;
	     //step 4 convert
	     if(!Result.isBlank()) {
	    	 //check if too big 
	    	 String regex = "^0+(?!$)";
	    	 Result = Result.replaceAll(regex, "");
	    	 if(Result.length() > 10) {
	    		 if(negative) {
	    			 return Integer.MIN_VALUE;
	    		 } else {
	    			 return  Integer.MAX_VALUE;
	    		 }
	    	 } else {
		    	 longResult = Long.parseLong(Result);
	    	 }
	     } else {
	    	 return 0;
	     }
	     if(negative) {
	    	 longResult = longResult * -1;
	     }
	     //step 5check if can fit in int
	     if(longResult >= Integer.MAX_VALUE || longResult <= Integer.MIN_VALUE  ) {
	    	 if(negative) {
	    		 returnInt = Integer.MIN_VALUE;
	    	 } else {
	    		 returnInt = Integer.MAX_VALUE;
	    	 } 
	     } else {
	    	 returnInt = (int) longResult;
	     }
	     return  returnInt;
    }
    
    public int strStr(String haystack, String needle) {
        if(haystack.isBlank() && needle.isBlank() ) {
        	return 0;
        }
        if(!haystack.isBlank() && needle.isBlank() ) {
        	return 0;
        }
        //if hay stack -1
        if(needle.isBlank() || haystack.isBlank()  ||needle.length() > haystack.length()) {
        	return -1;
        }
        if(needle.length() == haystack.length()) { 
        	if(needle.equals(haystack)) {
        		return 0;
        	}
        }
        
        //now check 
        for(int x = 0; x < haystack.length() ; x++ ) {
        	if(haystack.charAt(x) == needle.charAt(0)) {
        		int needleP = 1;
        		while(needleP < needle.length()) {
                	if(haystack.charAt(x + needleP) == needle.charAt(needleP))  {
                		needleP++;
                	} else {
                		break;
                	}
                	return x;
        		}
        	}
        }
        return -1;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LeetCode practice = new LeetCode();
		//1. remove duplicare
		//int[] nums =  {1,2,4,5};
		//int lenght = practice.removeDuplicates(nums);
		//System.out.println("remove duplicate lenght is: " + lenght);
		
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("\n");
		
		//2.Best time to buy
		//int[] prices =  {7,1,5,3,6,4};
		//int profit = practice.maxProfit(prices);
		//System.out.println("Profit is: " + profit);
		
		//3.rotate
		//int[] prices =  {1,2,3,4,5,6,7};
		//int k = 3;
		//practice.rotate(prices, k);
		//System.out.println("Profit is: " + profit);
		
		//int[] array =  {4,1,2,1,2};
		//int onlyOnce = practice.singleNumber(array);
		//System.out.println("numer to appear only once is: " + onlyOnce);
		
		
		String strStr = "20000000000000000000";
		//9223372036854775807
		//20000000000000000000
		//2147483647
		practice.strStr("abc","c");
		
	}
	
	

}
