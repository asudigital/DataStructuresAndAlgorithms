package Arrays;

import java.util.*;

public class ThreeSum {
// Better
    public List<List<Integer>>  HashSetSolution(int[] nums){
        Set<List<Integer>> ans = new HashSet<>();
        int n = nums.length;
        for(int i=0 ; i<n ; i++)
        {
            Set<Integer> st = new HashSet<>();
            for(int j=i+1; j<n ; j++)
            {
                int sum = nums[i] + nums[j];    // 0-sum = -sum -> target(check target is in set or not)
                if(!st.contains(-sum)){
                    st.add(nums[j]);
                    continue;
                }  else {
                    // target is present in the set
                    List<Integer> temp= Arrays.asList(nums[i], nums[j],-sum);
                    //to avoid duplicate
                    Collections.sort(temp);
                    ans.add(temp);
                }
            }
        }
        List<List<Integer>> answer = new ArrayList<>(ans);
        return answer ;

    }

    // Optimal
    public List<List<Integer>> twoPointersSolution(int[] nums){
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        for(int i=0; i<n ; i++)
        {
            if( i>0 && nums[i] ==nums[i-1])  continue ;
            int j = i+1;
            int k = n-1;

            while(j<k){
                if(nums[i]+nums[j]+nums[k] == 0){

                    List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while(j<k && nums[j] == nums[j-1]){
                        j++;
                    }
                    while(j<k && nums[k] == nums[k+1]){
                        k--;
                    }

                }
                if(nums[i]+nums[j]+nums[k] <0)
                {
                    j++;
                }
                if(nums[i]+nums[j]+nums[k] > 0)
                {
                    k--;
                }
            }
        }
        return ans;
    }

    public static void main(String args[]){

    }
}
