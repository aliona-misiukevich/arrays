package com.company.task4.main;

public class Task1_10 {
    public static void solveTask1() {
        //1. В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.
        int k;
        int s;
        s = 0;
        k = 3;

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % k == 0) {
                s += arr[i];
            }
        }
        System.out.println("1. s = " + s);

    }

    public static void solveTask2() {
        //2. В целочисленной последовательности есть нулевые элементы. Создать массив из номеров этих элементов.
        int[] arr = {1, 3, 0, 3, 2, 0, 7};
        int[] arr1 = putZeroElement(arr);
        for (int i = 0; i < countZeroElement(arr); i++) {
            System.out.println(arr1[i]);
        }
    }

    public static int countZeroElement(int[] arr) {
        int counter;
        counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                counter++;
            }
        }
        return counter;
    }

    public static int[] putZeroElement(int[] arr) {
        int j = 0;
        int[] arrZeroIndex = new int[countZeroElement(arr)];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arrZeroIndex[j] = i;
                j++;
            }
        }
        return arrZeroIndex;
    }

    public static void solveTask3() {
        //3. Дана последовательность целых чисел а1 а2,..., аn . Выяснить, какое число встречается раньше - положительное или отрицательное.
        int[] arr = {0, 2, -3, 4, 5, 6, 7};
        int a;
        a = checkWhatFirst(arr);

        if (a > 0) {
            System.out.println("positive");
        } else if (a < 0) {
            System.out.println("negative");
        } else {
            System.out.println("result is 0");
        }
    }

    private static int checkWhatFirst(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return arr[i];
            }
        }
        return 0;
    }

    public static void solveTask4() {
        //4. Дана последовательность действительных чисел а1 а2 ,..., аn . Выяснить, будет ли она возрастающей.
        double[] arr = {0, 2, 3, 4, 5, 6, 7};

        if (checkRaise(arr)) {
            System.out.println("возрастающая");
        } else {
            System.out.println("не возрастающая");
        }
    }

    private static boolean checkRaise(double[] arr) {
        //boolean x = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void solveTask5() {
        //5. Дана последовательность натуральных чисел а1 , а2 ,..., ап. Создать массив из четных чисел этой последовательности.
        // Если таких чисел нет, то вывести сообщение об этом факте.
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] arrEven = createArrayEven(arr);
        if (arrEven.length == 0) {
            System.out.println("there are no such numbers");
            return;
        }

        System.out.println(arrEven.length);

    }

    public static int findLength(int[] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                counter++;
            }
        }
        return counter;
    }

    public static int[] createArrayEven(int[] arr) {
        int l = findLength(arr);
        if (l == 0) {
            return new int[0];
        }
        int[] arrEven = new int[l];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                arrEven[j] = arr[i];
                j++;
            }
        }
        return arrEven;
    }

    public static void solveTask6() {
        //6. Дана последовательность чисел а1 ,а2 ,..., ап. Указать наименьшую длину числовой оси, содержащую все эти числа.
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("the sum is " + findLengthOs(arr));
    }

    public static int findLengthOs(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        int sum = min + max + 1;
        return sum;
    }

    public static void solveTask7() {
        //7. Дана последовательность действительных чисел а1 ,а2 ,..., ап. Заменить все ее члены, большие данного Z, этим числом. Подсчитать количество замен.
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        System.out.println(replace(arr, 5));

    }

    public static int replace(int[] arr, int z) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > z) {
                arr[i] = z;
                counter++;
            }
        }
        return counter;
    }

    public static void solveTask8() {
        //8. Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных, положительных и нулевых элементов.
        int[] arr = {1, 2, -3, 4, 5, -6, 7, 0};

        System.out.println("positive = " + countPositive(arr));
        System.out.println("negative = " + countNegative(arr));
        System.out.println("zero = " + countZero(arr));
    }

    public static int countPositive(int[] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                counter++;
            }
        }
        return counter;
    }

    public static int countNegative(int[] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                counter++;
            }
        }
        return counter;
    }

    public static int countZero(int[] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                counter++;
            }
        }
        return counter;
    }

    public static void solveTask9() {
        //9. Даны действительные числа а1 ,а2 ,..., аn . Поменять местами наибольший и наименьший элементы.
        int[] arr = {1, 2, -3, 4, 5, -6, 7, 0};
        int[] replaceArr;

        replaceArr = replaceMaxMin(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(replaceArr[i]);
        }
    }

    public static int[] replaceMaxMin(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        int indexMax = 0;
        int indexMin = 0;
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                indexMax = i;
            }
            if (min > arr[i]) {
                min = arr[i];
                indexMin = i;
            }
        }

        arr[indexMax] = min;
        arr[indexMin] = max;
        return arr;
    }
    public static void solveTask10() {
        //10. Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых аi > i.
        int[] arr = {1, 2, 2, 4, 3, 6, 7, 0};
        int[] arrNumbers = new int[findLengthI(arr)];
        arrNumbers = findNumbersMoreIndex(arr);

        for(int i = 0; i < arrNumbers.length; i++){
            System.out.println("10. " + arrNumbers[i]);
        }
    }
    public static int findLengthI(int[] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > i) {
                counter++;
            }
        }
        return counter;
    }
    public static int[] findNumbersMoreIndex(int[] arr) {
        int l = findLengthI(arr);
        int[] arrNumbers = new int[l];
        int j = 0;
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] > i) {
                arrNumbers[j] = arr[i];
                j++;
            }
        } return arrNumbers;
    }
}

