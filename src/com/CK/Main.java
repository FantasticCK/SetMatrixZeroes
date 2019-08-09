package com.CK;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}


class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        int r = matrix.length, c = matrix[0].length;
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if(rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

// Time O(M*N)
class Solution2 {
    public void setZeroes(int[][] matrix) {
        Boolean isCol = false;
        int R = matrix.length;
        int C = matrix[0].length;
        for (int i = 0; i < R; i++) {
            //判断第 1 列是否需要置为 0
            if (matrix[i][0] == 0) {
                isCol = true;
            }
            //找 0 的位置，将相应标记置 0
            for (int j = 1; j < C; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        //根据标志，将元素置 0
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //判断第一行是否需要置 0
        if (matrix[0][0] == 0) {
            for (int j = 0; j < C; j++) {
                matrix[0][j] = 0;
            }
        }

        //判断第一列是否需要置 0
        if (isCol) {
            for (int i = 0; i < R; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}