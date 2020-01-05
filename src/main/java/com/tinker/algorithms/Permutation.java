package com.tinker.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void main(String[] args){
        int[] nums={1,2,3};
        List<List<Integer>> res=permute(nums);
        for(List<Integer> item:res){
            System.out.println(item);
        }
    }


    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
            System.out.println("add: "+tempList);
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                System.out.println("before    "+"i: "+i+"  tmpList: "+tempList);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
                System.out.println("after  "+"i: "+i+"  tmpList: "+tempList);
            }
        }
    }
}
