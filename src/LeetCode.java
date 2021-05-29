
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
		int[] prices =  {1,2,3,4,5,6,7};
		int k = 3;
		practice.rotate(prices, k);
		//System.out.println("Profit is: " + profit);
		
	}
	
	

}
