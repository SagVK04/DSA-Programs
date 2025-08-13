/*
This is MountainArray's API interface.
You should not implement it, or speculate about its implementation
interface MountainArray {
    public int get(int index);
    public int length(); 
}
*/
public class leetcode1095 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = peakIndexInMountainArray(mountainArr);
        int res = bsearch(mountainArr,target,0,peak);
        if(res == -1)
            res = bsearch1(mountainArr,target,peak+1,mountainArr.length()-1);
        return res;
    }
    public int peakIndexInMountainArray(MountainArray mountainArr) {
        int start=0; int end=mountainArr.length()-1; 
        while(start<=end){
            int mid = start + (end-start)/2;
            if(mountainArr.get(mid+1) > mountainArr.get(mid))
                start = mid+1;
            else if(mountainArr.get(mid-1) > mountainArr.get(mid))
                end = mid-1;
            else
                return mid;
        }
        return -1;
    }
    public int bsearch(MountainArray nums, int target, int start, int end){
        while(start<=end){
            int mid = start+(end-start)/2;
            if(target < nums.get(mid))
                end = mid - 1;
            else if(target > nums.get(mid))
                start = mid + 1;
            else 
                return mid;
        }
        return -1;
    }
    public int bsearch1(MountainArray nums, int target, int start, int end){
        while(start<=end){
            int mid = start+(end-start)/2;
            if(target < nums.get(mid))
                start = mid + 1;
            else if(target > nums.get(mid))
                end = mid - 1;
            else 
                return mid;
        }
        return -1;
    }
}
