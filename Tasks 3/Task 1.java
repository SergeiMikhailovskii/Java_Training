/*
*Задана матрица размера N x M. Необходимо выполнить следующие
действия:
 найти экстремальные значения (минимальный и максимальный
элементы) данной матрицы;
 найти среднеарифметическое и среднегеометрическое значения всех
элементов матрицы;
 найти позицию первого встретившегося локального минимума
(максимума), а если таких элементов нет, то возвратить -1 (локальный
минимум
– это элемент, который меньше любого из своих соседей; локальный
максимум – это элемент, который больше любого из своих соседей);
 транспонировать матрицу (при решении данного задания не
рекомендуется задействовать дополнительную память).
* */
package com.company;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n, m;
        boolean isInputCorrect = false;
        boolean isWorkFinished = false;


        do {
            System.out.println("Enter n:");
            n = enterNumber();
            if (n>0){
                isInputCorrect = true;
            }
            else {
                System.out.println("N should be more than 0");
            }
        }while (!isInputCorrect);

        isInputCorrect = false;

        do {
            System.out.println("Enter m:");
            m = enterNumber();
            if (m>0){
                isInputCorrect = true;
            }
            else {
                System.out.println("M should be more than 0");
            }
        }while (!isInputCorrect);

        double minRange = 0;
        double maxRange = 10;

        double[][] matrix = new double[n][m];
        matrix = generateMatrix(matrix, minRange, maxRange);
        System.out.println("Matrix: ");
        for (int i = 0; i<n;i++){
            for (int j = 0; j<m;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        do {
            switch (menu()){
                case 1:
                    System.out.println("Min = "+findMinValue(matrix));
                    System.out.println("Max = "+findMaxValue(matrix));
                    break;
                case 2:
                    System.out.println("Arithmetical mean = "+findArithmeticalMean(matrix));
                    System.out.println("Geometrical mean = "+findGeometricalMean(matrix));
                    break;
                case 3:
                    findFirstLocalMinAndMax(matrix);
                    break;
                case 4:
                    matrix = transposeMatrix(matrix);
                    System.out.println("Matrix: ");
                    for (int i = 0; i<n;i++){
                        for (int j = 0; j<m;j++){
                            System.out.print(matrix[i][j]+" ");
                        }
                        System.out.println();
                    }
                    break;
                case 0:
                    isWorkFinished = true;
                    break;
                    default:
                        System.out.println("Choose 1 - 4 or 0!");
            }
        }while (!isWorkFinished);
    }


    private static int enterNumber(){
        int number = 0;
        boolean isInputCorrect = false;
        Scanner scanner = new Scanner(System.in);
        do {
            if (scanner.hasNextInt()){
                number = scanner.nextInt();
                isInputCorrect = true;
            }
            else {
                System.out.println("Wrong input!");
                scanner.nextLine();
            }
        }while (!isInputCorrect);
        return number;
    }

    private static int menu(){
        int choice;
        System.out.println("1 - find min and max values");
        System.out.println("2 - find arithmetical and geometrical mean");
        System.out.println("3 - find position of the first local min and max");
        System.out.println("4 - transpose matrix");
        System.out.println("0 - exit");
        choice = enterNumber();
        return choice;
    }

    private static double findMinValue(double[][] matrix){
        double min = matrix[0][0];
        for (double[] aMatrix : matrix) {
            for (double anAMatrix : aMatrix) {
                if (anAMatrix < min) {
                    min = anAMatrix;
                }
            }
        }
        return min;
    }

    private static double findMaxValue(double[][] matrix){
        double max = matrix[0][0];
        for (double[] aMatrix : matrix) {
            for (double anAMatrix : aMatrix) {
                if (anAMatrix > max) {
                    max = anAMatrix;
                }
            }
        }
        return max;
    }

    private static double[][] generateMatrix(double[][] matrix, double minRange, double maxRange){
        Random random = new Random();

        for (int i = 0; i<matrix.length; i++){
            for (int j = 0; j<matrix[i].length; j++){
                matrix[i][j] = new BigDecimal(minRange+(maxRange-minRange)*random.nextDouble()).
                        setScale(2, RoundingMode.HALF_UP).doubleValue();
            }
        }
        return matrix;
    }

    private static double findArithmeticalMean(double[][] matrix){
        double arithmeticalMean = 0;
        for (double[] aMatrix : matrix) {
            for (double anAMatrix : aMatrix) {
                arithmeticalMean += anAMatrix;
            }
        }
        arithmeticalMean = new BigDecimal(arithmeticalMean/matrix.length*matrix[0].length).
                setScale(2, RoundingMode.HALF_UP).doubleValue();
        return arithmeticalMean;
    }

    private static double findGeometricalMean(double[][] matrix){
        double geometricalMean = 1;
        for (double[] aMatrix : matrix) {
            for (double anAMatrix : aMatrix) {
                geometricalMean *= anAMatrix;
            }
        }
        geometricalMean = new BigDecimal(Math.pow(geometricalMean, 1.0/(matrix.length*matrix[0].length))).
                setScale(2, RoundingMode.HALF_UP).doubleValue();
        return geometricalMean;
    }

    private static double[][] transposeMatrix(double[][] matrix){
        double temp;
        for (int i = 0; i<matrix.length;i++){
            for (int j = i+1; j<matrix[i].length;j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //Как транспонировать прямоугольную матрицу без доп. матрицы, я не придумал
        return matrix;
    }

    private static void findFirstLocalMinAndMax(double[][] matrix){
        boolean isLocalMinFound = false;
        boolean isLocalMaxFound = false;
        for (int j = 1; j<matrix[0].length-1;j++){
            if (matrix[0][j-1]>matrix[0][j] && matrix[0][j+1]>matrix[0][j] && matrix[1][j]>matrix[0][j]){
                isLocalMinFound = true;
                System.out.println("Local min = matrix[0]["+j+"]");
                break;
            }
        }
        if (!isLocalMinFound && matrix.length>2){
            for (int i = 1; i<matrix.length-1;i++){
                if (matrix[i-1][0]>matrix[i][0] && matrix[i+1][0]>matrix[i][0] && matrix[i][1]>matrix[i][0]){
                    isLocalMinFound =true;
                }
                if(!isLocalMinFound) {
                    for (int j = 1; j < matrix[i].length - 1; j++) {
                        if (matrix[i - 1][j] > matrix[i][j]
                                && matrix[i + 1][j] > matrix[i][j]
                                && matrix[i][j - 1] > matrix[i][j]
                                && matrix[i][j + 1] > matrix[i][j]) {
                            System.out.println("Local min = matrix[" + i + "][" + j + "]");
                            isLocalMinFound = true;
                            break;
                        }
                    }
                }
                if(!isLocalMinFound) {
                    if (matrix[i-1][matrix[i].length - 1]>matrix[i][matrix[i].length - 1]
                            && matrix[i+1][matrix[i].length - 1]>matrix[i][matrix[i].length - 1]
                            && matrix[i][matrix[i].length - 2]>matrix[i][matrix[i].length - 1]){
                        isLocalMinFound =true;
                    }
                }
            }
        }
        if (!isLocalMinFound){
            for (int j = 1;j<matrix[matrix.length-1].length-1;j++){
                if (matrix[matrix.length-1][j-1]>matrix[matrix.length-1][j]
                        && matrix[matrix.length-1][j+1]>matrix[matrix.length-1][j]
                        && matrix[matrix.length-2][j]>matrix[matrix.length-1][j]){
                    isLocalMinFound = true;
                    System.out.println("Local min = matrix["+(matrix.length-1)+"]["+j+"]");
                    break;
                }

            }
        }

        if (!isLocalMinFound){
            System.out.println("Local min = -1");
        }

        for (int j = 1; j<matrix[0].length-1;j++){
            if (matrix[0][j-1]<matrix[0][j] && matrix[0][j+1]<matrix[0][j] && matrix[1][j]<matrix[0][j]){
                isLocalMaxFound = true;
                System.out.println("Local max = matrix[0]["+j+"]");
                break;
            }
        }
        if (!isLocalMaxFound && matrix.length>2){
            for (int i = 1; i<matrix.length-1;i++){
                if (matrix[i-1][0]<matrix[i][0] && matrix[i+1][0]<matrix[i][0] && matrix[i][1]<matrix[i][0]){
                    isLocalMaxFound =true;
                }
                if(!isLocalMaxFound) {
                    for (int j = 1; j < matrix[i].length - 1; j++) {
                        if (matrix[i - 1][j] < matrix[i][j]
                                && matrix[i + 1][j] < matrix[i][j]
                                && matrix[i][j - 1] < matrix[i][j]
                                && matrix[i][j + 1] < matrix[i][j]) {
                            System.out.println("Local max = matrix[" + i + "][" + j + "]");
                            isLocalMaxFound = true;
                            break;
                        }
                    }
                }
                if(!isLocalMaxFound) {
                    if (matrix[i-1][matrix[i].length - 1]<matrix[i][matrix[i].length - 1]
                            && matrix[i+1][matrix[i].length - 1]<matrix[i][matrix[i].length - 1]
                            && matrix[i][matrix[i].length - 2]<matrix[i][matrix[i].length - 1]){
                        isLocalMaxFound =true;
                    }
                }
            }
        }
        if (!isLocalMaxFound){
            for (int j = 1;j<matrix[matrix.length-1].length-1;j++){
                if (matrix[matrix.length-1][j-1]<matrix[matrix.length-1][j]
                        && matrix[matrix.length-1][j+1]<matrix[matrix.length-1][j]
                        && matrix[matrix.length-2][j]<matrix[matrix.length-1][j]){
                    isLocalMaxFound = true;
                    System.out.println("Local max = matrix["+(matrix.length-1)+"]["+j+"]");
                    break;
                }

            }
        }

        if (!isLocalMaxFound){
            System.out.println("Local max = -1");
        }

    }


}
