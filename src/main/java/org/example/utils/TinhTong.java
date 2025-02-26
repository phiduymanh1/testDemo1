package org.example.utils;

public class TinhTong {
    public static int sumArray(int[] arr) {
        if (arr == null){
            throw new IllegalArgumentException("arr is null");
        }
        int sum = 0;
        for (int num : arr){
            sum += num;
        }
        return sum;
    }
}
