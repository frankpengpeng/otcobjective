package com.frank.practice.leetCode;

public class FindKthNumFromArray {
    public static void main(String[] args) {
        int[] arr={3,1,2,5,4,7,6};
        FindKthNumFromArray demo = new FindKthNumFromArray();
        int res = demo.findKthNum(arr, 1, 0, arr.length-1);
        System.out.println(res);
    }

    private int getPartNum(int[] arr, int i, int j){
        int left = i;
        int right = j;
        int base = arr[left];
        while (left<right){
            while (left<right &&arr[right] <= base){
                right--;
            }
            if(left<right){
                arr[left] = arr[right];
                left++;
            }
            while (left<right && arr[left]<=base){
                left++;
            }
            if(left<right){
                arr[right] = arr[left];
                right--;
            }
        }
        arr[left] = base;
        return left;
    }
    private int findKthNum(int[] arr, int k, int left, int right) {
        int partition = getPartNum(arr, left, right);
        if (partition == k - 1) {
            return arr[partition];
        } else if (partition > k - 1) {
            return findKthNum(arr, k, left, partition - 1);
        } else {
            return findKthNum(arr, k - partition, partition + 1, right);
        }
    }
}
