class binarysearch{
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6,7,9};
        int[] arr1 = {9,7,6,5,4,3,2};
        int target = 3;
        if(arr1[arr1.length-1] > arr1[0]){
            System.out.println("Array in increasing order...");
            System.out.println(ascendBinary(arr1,target));
        }
        else{
            System.out.println("Array in decreasing order...");
            System.out.println(descendBinary(arr1,target));
        }
    }
    static int ascendBinary(int[] nums, int target){
        int start=0; int end=nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(target < nums[mid])
                end = mid - 1;
            else if(target > nums[mid])
                start = mid + 1;
            else 
                return mid;
        }
        return -1;
    }
    static int descendBinary(int[] nums, int target){
        int start=0; int end=nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(target < nums[mid])
                start = mid + 1;
            else if(target > nums[mid])
                end = mid - 1;
            else 
                return mid;
        }
        return -1;
    }
}