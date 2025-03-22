import java.util.*;
public class Returnlist{
    public static void main(String [] args){
        int[] sortedArray={1,2,12,8,9,7,12,5,2,7,12,6};
        int target = 12;    
        System.out.println("Indices are "+search1(sortedArray,target,0)); 
    }
    static ArrayList<Integer> search(int[] arr, int target, int index,ArrayList<Integer> list){ 
        if(arr == null)
            return null;
        if(index==arr.length)
            return list;
        if(target==arr[index])
            list.add(index+1);
        return search(arr,target,index+1,list);
    }
    static ArrayList<Integer> search1(int[] arr, int target, int index){
        ArrayList<Integer> list = new ArrayList<>();
        if(arr == null)
            return null;
        if(index==arr.length)
            return list;
        //this contains answers for that function call only
        if(target==arr[index])
            list.add(index+1);
        ArrayList<Integer> ansfrombelow = search1(arr,target,index+1);
        list.addAll(ansfrombelow);
        return list;
    }
}