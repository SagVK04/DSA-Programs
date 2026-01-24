        /*  lb,ub indicates range of maximum no.of
            books for each student i.e. how many given paged books
            one student can take
         */
        /*  lb = 49 means a student can hold different as many books
            as want where total allotted pages for all allotted books are <= 49
         */
        /*
            lb = 172 means a student can hold different as many books
            as want where total allotted pages for all allotted books are <= 172
        */
        /*
            lb = 172 means a student can hold different as many books
            as want where total allotted pages for all allotted books are <= 172
        */
        /*
            1. countSt(nums,mid) means nums array has nums.length numbers of
                different paged books, mid is the maximum pages that can be allotted for a student
            2. Add each nums element with previous total allotted pages for each student
                i. If sum <= mid-means that same student can hold the current of certain number
                    of pages as the  maximum permitted page no. is not exceeded
                ii. If sum > mid - means adding extra pages of extra book will exceed max permitted page no.
                    Hence increase student no. as new student is needed for the current book element allocation
                    set the previous total allocated pages to the only current pages value
                    as it tracks previous total allocated pages for the only current student
            3. Returns total number  of students among which all books are  allocated
               while max page value is not exceeded
        */
        /*
            1. If k no. of student found, try to search for less no. of students
            2. The  less no. of students, less no. of split partition,
               the more no. of pages can be allocated
            3. Return lb because once optimal no. of students will be found and
               entire bs will go on for st_no <= k, there  is no chance that it will be violated
        */

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int lb = findMax(nums); int ub = findSum(nums);
        while(lb <= ub){
            int mid = lb + (ub-lb)/2;
            int st_no = count_student(nums,mid);
            if(st_no > k) lb = mid+1;
            else ub = mid-1;
        }
        return lb;
    }
    public int findMax(int[] nums){
        int max=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) max = Math.max(max,nums[i]);
        return max;
    }
    public int findSum(int[] nums){
        int sum=0;
        for(int i=0; i<nums.length; i++) sum += nums[i];
        return sum;
    }
    public int count_student(int[] nums, int max_page){
        int student = 1; int totalPage = 0;
        for(int num: nums){
            if(num + totalPage <= max_page) totalPage += num;
            else{
                student++; totalPage = num;
            }
        }
        return student;
    }
}
