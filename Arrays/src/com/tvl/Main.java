package com.tvl;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Object[] arrayA = { 1, 2, 3 };
        print("arrayA", arrayA);
        Object[] arrayB = { 3, 4, 5 };
        print("arrayB", arrayB);

        System.out.println();

        Object[] intsAuB = union(arrayA, arrayB);
        print("a - Union of arrayA and arrayB", intsAuB);

        Object[] intsAintersectB = intersection(arrayA, arrayB);
        print("b - Intersection of arrayA and arrayB", intsAintersectB);

        Object[] intsAdiffB = setDifference(arrayA, arrayB);
        print("c - Set difference arrayA \\ arrayB", intsAdiffB);

        Object[] intsBdiffA = setDifference(arrayB, arrayA);
        print("c - Set difference arrayB \\ arrayA", intsBdiffA);

    }

    // a

    static Object[] union(Object[] a, Object[] b) {

        // Combine arrays
        int length = a.length + b.length;
        Object[] result = new Object[length];

        for (int i=0; i<a.length; i++) {
            result[i] = a[i];
        }

        for (int i=0; i<b.length; i++) {
            result[i + a.length] = b[i];
        }

        return duplicatesRemoved(result);
    }

    // b

    static Object[] intersection(Object[] a, Object[] b) {
        Object[] result = a.clone();
        for (int i = 0; i<result.length; i++) {
            if (!contains(b, result[i])) {
                result[i] = null;
            }
        }
        return removeNulls(result);
    }

    // c

    static Object[] setDifference(Object[] a, Object[] b) {
        Object[] result = a.clone();
        for (int i = 0; i<result.length; i++) {
            if (contains(b, result[i])) {
                result[i] = null;
            }
        }
        return removeNulls(result);
    }

    // Helper functions

    static void print(String text, Object[] a) {
        System.out.println(text + ": " + Arrays.toString(a));
    }

    static Object[] duplicatesRemoved(Object[] array) {
        Object[] temp = array.clone();
        int newLength = temp.length;

        // Set duplicates to null, find new length
        for (int i=0; i<temp.length; i++) {
            for (int j=0; j<temp.length; j++) {
                if (temp[i] != null && i!=j && temp[i].equals(temp[j])) {
                    temp[i] = null;
                    newLength--;
                }
            }
        }

        // Insert into new array
        Object[] result = new Object[newLength];

        int resultIndex = 0;
        for (int i=0; i<temp.length; i++) {
            if (temp[i] != null) {
                result[resultIndex] = temp[i];
                resultIndex++;
            }
        }

        return result;
    }

    static Object[] removeNulls(Object[] array) {
        // Count non-nulls
        int newLength = 0;
        for (int i=0; i<array.length; i++) {
            if (array[i] != null) {
                newLength++;
            }
        }

        // Create smaller array
        Object[] result = new Object[newLength];
        int resultIndex = 0;
        for (int i=0; i<array.length; i++) {
            if (array[i] != null) {
                result[resultIndex] = array[i];
                resultIndex++;
            }
        }

        return result;

    }

    static Boolean contains(Object[] array, Object element) {
        for (Object o : array) {
            if (o.equals(element)) { return true; }
        }
        return false;
    }
}
