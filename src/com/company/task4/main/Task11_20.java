package com.company.task4.main;

import java.util.Random;

public class Task11_20 {
    public static void solveTask11() {
        //11. Даны натуральные числа а1 ,а2 ,..., аn . Указать те из них, у которых остаток от деления
        //на М равен L (0 < L < М-1).
        int[] arr = {1, 2, 2, 4, 3, 6, 7, 0};

        int[] arrL = findNumbersL(arr, 3);

        for (int i = 0; i < arrL.length; i++) {
            System.out.println("11. " + arrL[i]);
        }
    }

    public static int findLengthL(int[] arr, int m) {
        int counter = 0;
        int l = 0;
        for (int i = 0; i < arr.length; i++) {
            l = arr[i] % m;
            if (l > 0 && l < m - 1) {
                counter++;
            }
        }
        return counter;
    }

    public static int[] findNumbersL(int[] arr, int m) {
        int[] arrL = new int[findLengthL(arr, m)];
        int j = 0;
        int l = 0;

        for (int i = 0; i < arr.length; i++) {
            l = arr[i] % m;
            if (l > 0 && l < m - 1) {
                arrL[j] = arr[i];
                j++;
            }
        }
        return arrL;
    }

    public static void solveTask12() {
        //12. Задана последовательность N вещественных чисел. Вычислить сумму чисел,
        //порядковые номера которых являются простыми числами.
        double[] arr = {1, 2, 2, 4, 3, 6, 7, 0};
        int sum = findSum(arr);

        System.out.println("12. " + sum);
    }

    public static boolean findSimple(int i) {
        boolean x = false;
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                x = false;
                break;
            } else {
                x = true;
            }
        }
        return x;
    }

    public static int findSum(double[] arr) {
        int sum = 0;
        boolean x;
        for (int i = 3; i < arr.length; i++) {
            x = findSimple(i);
            if (x) {
                sum += arr[i];
            }
        }
        return sum;
    }

    public static void solveTask13() {
        //13. Определить количество элементов последовательности натуральных чисел,
        // кратных числу М и заключенных в промежутке от L до N.
        int[] arr = {1, 2, 2, 4, 3, 6, 7};

        System.out.println("13. counter = " + findCounter(arr, 2, 0, 5));
    }

    public static int findCounter(int[] arr, int m, int l, int n) {
        int a;
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % m == 0) {
                a = arr[i];
                if (isInRange(a, l, n)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static boolean isInRange(int a, int l, int n) {
        boolean x = false;
        if (a > l && a < n) {
            x = true;
        } else {
            return x;
        }
        return x;
    }

    public static void solveTask14() {
        //14. Дан одномерный массив A[N]. Найти:
        //max(a2,a4,,a2k )+min(a1,a3,,a2k+1)
        int[] arr = {1, 2, 2, 4, 3, 6, 7};

        System.out.println(findMax(arr) + findMin(arr));
    }

    public static int findMax(int[] arr) {
        int max = arr[1];
        for (int i = 1; i < arr.length - 2; i = i + 2) {
            if (max < arr[i + 2]) {
                max = arr[i + 2];
            }
        }
        return max;
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length - 2; i = i + 2) {
            if (min > arr[i + 2]) {
                min = arr[i + 2];
            }
        }
        return min;
    }

    public static void solveTask15() {
        //15. Дана последовательность действительных чисел a1,a2,,an . Указать те ее элементы,
        //которые принадлежат отрезку [с, d].
        double[] arr = {1.5, 1.3, 2.2, 4, 3, 6.4, 7};
        double[] arrCriteria = searchByCriteria(arr, 2, 6);

        for (int i = 0; i < arrCriteria.length; i++) {
            System.out.println("15. number = " + arrCriteria[i]);
        }

    }

    public static int findLength(double[] arr, int c, int d) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > c && arr[i] < d) {
                counter++;
            }
        }
        return counter;
    }

    public static double[] searchByCriteria(double[] arr, int c, int d) {
        int j = 0;
        double[] arrCriteria = new double[findLength(arr, c, d)];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > c && arr[i] < d) {
                arrCriteria[j] = arr[i];
                j++;
            }
        }
        return arrCriteria;
    }

    public static void solveTask16() {
        //16. Даны действительные числа a1,a2,,an . Найти
        //max(a1 +a2n,a2 +a2n−1,,an +an+1).
        double[] arr = {1.5, 1.3, 2.2, 4, 3, 6.4, 7};
        System.out.println("16. max sum = " + findMax(arr));

    }

    public static int findCounter(double[] arr) {
        double x = 0;
        int counter = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            x = arr[i] + arr[i + 1];
            counter++;
        }
        return counter;
    }

    public static double[] findSumArray(double[] arr) {
        double[] sum = new double[findCounter(arr)];
        int j = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sum[j] = arr[i] + arr[i + 1];
            j++;
        }
        return sum;
    }

    public static double findMax(double[] arr) {
        double[] sumArray = findSumArray(arr);
        double max = sumArray[0];

        for (int i = 1; i < sumArray.length; i++) {
            if (max < sumArray[i]) {
                max = sumArray[i];
            }
        }
        return max;
    }

    public static void solveTask17() {
        //17. Дана последовательность целых чисел a1 , a2 ,, an .
        // Образовать новую последовательность, выбросив из исходной те члены, которые равны min(a1,a2,,an).
        int[] arr = {1, 2, 2, 4, 3, 6, 7, 1};
        int[] newArr = createNewArray(arr);

        System.out.print("17. array: ");
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }
    }

    public static int findMinInArray(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int findLengthM(int[] arr) {
        int counter = 0;
        int min = findMinInArray(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > min) {
                counter++;
            }

        }
        return counter;
    }

    public static int[] createNewArray(int[] arr) {
        int[] newArr = new int[findLengthM(arr)];
        int min = findMinInArray(arr);
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > min) {
                newArr[j] = arr[i];
                j++;
            }
        }
        return newArr;
    }

    public static void solveTask18() {
        //18*. «Суперзамок». Секретный замок для сейфа состоит из 10 расположенных в рад ячеек,
        // в которые надо вставить игральные кубики. Но дверь открывается только в том случае,
        // когда в любых трех соседних ячейках сумма точек на передних гранях кубиков равна 10.
        // (Игральный кубик имеет на каждой грани от 1 до 6 точек).
        // Напишите программу, которая разгадывает код замка при условии, что два кубика уже вставлены в ячейки.

        Random random = new Random();
        int[] arr = new int[10];
        arr[0] = random.nextInt(6) + 1;
        arr[3] = random.nextInt(6) + 1;

    }

    private static int[] solveLock(int[] lock) {
        int[] foundIndices = new int[2];
        int j = 0;
        for (int i = 0; i < lock.length; ++i) {
            if (lock[i] != 0) {
                foundIndices[j] = i;
                j++;
            }
        }

        if (lock[foundIndices[0]] != lock[foundIndices[1]]) {
            //TODO: NO SOLUTION!
        }

        int firstRecIndex = foundIndices[0] % 3;
        int secondRecIndex = foundIndices[1] % 3;

        //TODO: Fill lock by the same numbers
        //
        return lock;
    }

    public static void solveTask19() {
        //19. В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число.
        // Если таких чисел несколько, то определить наименьшее из них.
        int[] arr = {1, 2, 2, 4, 3, 6, 7, 1};
        int max = findMaxRepeat(findRepeat(arr), arr);
        System.out.println();
        System.out.println("19. " + max);
    }

    public static int[] findRepeat(int[] arr) {
        int[] counter = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    counter[i] += 1;
                }
            }
        }
        return counter;
    }
    public static int findMaxRepeat(int[] counter, int[] arr){
        int max = counter[0];
        int repeatNumber = arr[counter[0]];
        for(int i = 0; i < counter.length; i++){
            if (max < counter[i]){
                max = counter[i];
                repeatNumber = arr[counter[i]];
            }
            if (max == counter[i]){
                if(repeatNumber > arr[counter[i]]){
                    repeatNumber = arr[counter[i]];
                }
            }
        }
        return repeatNumber;
    }
    public static void solveTask20(){
        //20. Дан целочисленный массив с количеством элементов п.
        // Сжать массив, выбросив из него каждый второй элемент (освободившиеся элементы заполнить нулями).
        // Примечание. Дополнительный массив не использовать.
        int[] arr = {1, 2, 2, 4, 3, 6, 7, 1};
        for(int i = 0; i < arr.length;i++){
            System.out.println(excludeSecond(arr)[i]);
        }

    }

    public static int[] excludeSecond(int[] arr){
        for(int i = 1; i < arr.length; i = i+2){
            arr[i] = 0;
        }
        return arr;
    }
}
