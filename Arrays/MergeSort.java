package Arrays;
import java.util.*;
import java.util.List;
//Super short memory trick
//
//        Think like this:
//
//        temp is a small box starting from 0
//        arr is a big box starting from low
//        So we say:
//        “Whatever position I am in the big box, go that much back to pick from the small box.”


/**  THEORY: To Explain the conversion of temp to arr[]
 * Imagine this situation
 *
 * You have a big row of boxes (this is your array arr):
 *
 * Index:  0   1   2   3   4   5
 * arr =  [10, 20, 30, 40, 50, 60]
 *
 *
 * Now your merge function is working only on a small part of this row.
 * Say it is working from index 2 to 5:
 *
 * 30, 40, 50, 60
 *
 *
 * While merging, you don’t put the numbers back directly in the big row.
 * You first put them in a small tray (this is temp):
 *
 * temp = [30, 40, 50, 60]
 *
 * Now comes the copying part
 *
 * You want to put the numbers from the small tray back into the big row at the correct place.
 *
 * So you start from index low = 2 and go till high = 5.
 *
 * But here is the catch
 *
 * The tray (temp) starts from position 0,
 * while the big row (arr) starts from position 2 for this part.
 *
 * So you need a way to match them.
 *
 * The logic in simple words
 *
 * When you are at:
 *
 * arr[2] → take from temp[0]
 *
 * arr[3] → take from temp[1]
 *
 * arr[4] → take from temp[2]
 *
 * arr[5] → take from temp[3]
 *
 * That’s why the code says:
 *
 * arr[i] = temp.get(i - low);
 *
 *
 * Because:
 *
 * when i = low → i - low = 0
 *
 * when i = low + 1 → i - low = 1
 *
 * and so on…
 *
 * In one simple line
 *
 * The small list (temp) starts from 0,
 * but we are putting things back starting from low,
 * so we shift the index by doing i - low.
 */
public class MergeSort {

    void mergeSort(int arr[], int low, int high) {
        // code here

        //base case
        if( low >= high) return ;

        int mid = (low + high) / 2;

        mergeSort(arr , low , mid);
        mergeSort(arr , mid+1 , high);

        merge(arr , low , mid , high);

    }

    public void merge(int[] arr , int low , int mid , int high)
    {
        int left = low ;
        int right = mid+1;
        List<Integer> temp = new ArrayList<>();

        while(left <=mid && right <= high)
        {
            if(arr[left] <= arr[right]){

                temp.add(arr[left]);
                left++;
            } else{
                temp.add(arr[right]);
                right++;
            }
        }

        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }

        while( right <= high){
            temp.add(arr[right]);
            right++;
        }

        // Theory present above
        for(int i=low ; i<=high ; i++){
            arr[i] = temp.get(i-low);
        }
    }

}
