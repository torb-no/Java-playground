public class ArrayHelpers {

    public static Object[] combined(Object[] a, Object[] b) {
        // Combine arrays
        int length = a.length + b.length;
        Object[] result = new Object[length];

        for (int i=0; i<a.length; i++) {
            result[i] = a[i];
        }

        for (int i=0; i<b.length; i++) {
            result[i + a.length] = b[i];
        }

        return result;
    }

    public static Object[] combinedAndDuplicatesRemoved(Object[] a, Object[] b) {
        return duplicatesRemoved(combined(a, b));
    }

    public static Object[] objectRemoved(Object[] array, Object object) {
        Object[] result = new Object[array.length - 1];

        int resultIndex = 0;
        for (int i=0; i<array.length; i++) {
            if (!array[i].equals(object)) {
                result[resultIndex] = object;
                resultIndex++;
            }
        }

        return result;
    }

    public static Object[] duplicatesRemoved(Object[] array) {
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


    public static Object[] removeNulls(Object[] array) {
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

}