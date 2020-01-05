package com.tinker.algorithms;

public class FindInRotatedSortArray {

    public static void main(String[] args){
        int[] data={4,5,6,7,0,1,2};
        System.out.println(search(data,0));
    }
    public static int search(int[] nums, int target) {
        if(nums==null){
            return -1;
        }
        int pivot=findSeperatedIndex(nums,target);
        int start=0;
        int end=nums.length-1;
        if(nums[0]>target){
            start=pivot+1;
        }else{
            end=pivot;
        }
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                start=mid+1;
            }else if(nums[mid]>target){
                end=mid-1;
            }
        }
        return -1;
    }

    private static int findSeperatedIndex(int[] nums,int target){
        int end=nums.length-1;
        int start=0;
        int index=0;
        if(nums[end]>nums[0]){
            index=end;
        }else{
            while(start<end){
                int mid=(start+end)/2;
                if(end-start==1){
                    return start;
                }else if(nums[mid]<nums[0]){
                    end=mid;
                }else if(nums[mid]>nums[0]){
                    start=mid;
                }
            }
            index=start;
        }
        return index;
    }
}
