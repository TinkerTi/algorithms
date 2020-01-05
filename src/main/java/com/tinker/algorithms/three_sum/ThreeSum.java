package com.tinker.algorithms.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args){
        ThreeSum threeSum=new ThreeSum();
        int[] num={-1,0,1,3,-3,0,0,0};
        long startTime=System.currentTimeMillis();
        List<List<Integer>> result=threeSum.threeSum(num);
        System.out.println(System.currentTimeMillis()-startTime);

        for(List<Integer> item:result){
            System.out.print("[ ");
            for(Integer integer:item){
                System.out.print(integer);
            }
            System.out.println(" ]");
        }
    }

    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        Arrays.sort(num);
        int index=Arrays.binarySearch(num,0);
        int left=index;
        int right=index;

        while(left>=0){
            if(num[left]==0){
                left--;
            }else{
                break;
            }
        }
        left++;
        while(right<num.length){
            if(num[right]==0){
                right++;
            }else{
                break;
            }
        }
        right--;
        if(right-left+1>=3){
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<3;i++){
                temp.add(0);
            }
            result.add(temp);
        }
        //只包含一个负数的情况
        if(right+1<num.length){
            for(int i=0;i<left;i++){
                findSum(num,left,num[i],result);
            }
            for(int i=0;i<left;i++){
                for(int j=i+1;j<left;j++){
                    find(num,left,num[i],num[j],result);
                }
            }
        }
        return result;

    }

    private void findSum(int[] num,int start,int key,List<List<Integer>> result){
        HashMap<Integer,Integer> numMap=new HashMap<>();
        for(int i=start;i<num.length;i++){
            if(numMap.get(-key-num[i])!=null){
                List<Integer> temp=new ArrayList<>();
                temp.add(key);
                temp.add(numMap.get(-key-num[i]));
                temp.add(num[i]);
                result.add(temp);
            }
            numMap.put(num[i],num[i]);
        }
    }

    private void find(int[] num,int start, int key1,int key2,List<List<Integer>> result){
        int target=-(key1+key2);
        for(int i=start;i<num.length;i++){
            if(num[i]==target){
                List<Integer> temp=new ArrayList<>();
                temp.add(key1);
                temp.add(key2);
                temp.add(num[i]);
                result.add(temp);
            }
        }
    }

    private int partition(int[] data,int key){
        int point=0;
        int right=data.length-1;
        int pivot=data[right];
        for(int i=0;i<right;i++){
            if(data[i]<pivot){
                swap(data,i,point++);
            }
        }
        swap(data,point,right);
        return point;
    }

    private void swap(int[] data,int i,int j){
        int temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }
}
