package com.frank.practice.leetCode;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        RotateMatrix demo = new RotateMatrix();
        demo.rotate(arr);
        for(int i=0;i< arr.length;i++) {
            for(int j = 0;j<arr[0].length; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }

    private void rotate(int[][] arr) {
        for(int i =0 ; i<arr.length;i++){
            for(int j = i; j< arr[0].length;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        for (int i=0; i<arr.length;i++){
            for(int j = 0; j< arr.length/2;j++) {
                int temp = arr[i][arr.length-1-j];
                arr[i][arr.length-1-j] = arr[i][j];
                arr[i][j] = temp;
            }
        }
    }
}
