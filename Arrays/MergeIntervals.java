package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

//Leetcode 56
public class MergeIntervals {
    // Two pinters solution ,OPTIMAL
    // T(N) : NLOGN
    // sc: 2(n)
    public int[][] mergeOptimal1(int[][] intervals) {
        List<List<Integer>> ans = new ArrayList<>();
        // sort based on the start element , if the start elements are equal then sort based on the end element
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int i = 0;
        int n = intervals.length;

        while (i < n) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int j = i + 1;

            while (j < n && intervals[j][0] <= end) {
                end = Math.max(end, intervals[j][1]);
                j++;
            }

            ans.add(Arrays.asList(start, end));
            i = j;
        }

        //Convert the ans arrayList to array
        int[][] result = new int[ans.size()][2];
        for (int r = 0; r < ans.size(); r++) {

            for (int c = 0; c < 2; c++) {
                result[r][c] = ans.get(r).get(c);
            }
        }
        return result;
    }

    //     Greedy
    public int[][] mergeOptimal(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int n = intervals.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int[] interval : intervals) {
            // if ans List is empty  or the end of last element(in ans list) is lesser than the start of the current element i.e. there is a gap between intervals and it is not a overlapping intervals
            if (ans.isEmpty() || ans.get(ans.size() - 1).get(1) < interval[0]) {
                ans.add(Arrays.asList(interval[0], interval[1]));
            }
            // If we find a overlapping intervals
            else {
                List<Integer> lastInterVal = ans.get(ans.size() - 1);
                int maxEnd = Math.max(lastInterVal.get(1), interval[1]);
                // Updating the interval
                ans.get(ans.size() - 1).set(1, maxEnd);
            }

        }
        //    System.out.println("Asutosh" + ans);
        //Convert the ans arrayList to array
        int[][] result = new int[ans.size()][2];
        for (int r = 0; r < ans.size(); r++) {

            for (int c = 0; c < 2; c++) {
                result[r][c] = ans.get(r).get(c);
            }
        }

        return result;
    }

    public static void main(String args[]) {

    }
}
