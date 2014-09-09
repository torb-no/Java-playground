public class ArraySet implements Set {

    Object[] elements;

    public ArraySet() {
        elements = new Object[0];
    }

    public ArraySet(Set set) {
        elements = set.toArray();
    }

    public ArraySet(Object[] _elements) {
        elements = ArrayHelpers.duplicatesRemoved(_elements);
    }

    public String toString() {
        String s = "ArraySet. Items: \n";
        for (Object o : elements) {
            s += o.toString() + "\n";
        }
        return s;
    }

    // Manipulate contents

    public void add(Object element) {
        Object[] newElement = { element };
        elements = ArrayHelpers.combinedAndDuplicatesRemoved(elements, newElement);
    }

    public void remove(Object element) {
        elements = ArrayHelpers.objectRemoved(elements, element);
    }

    public void replaceSet(Set set) {
        elements = set.toArray();
    }


    // Queries about the set

    public Boolean empty() {
        return this.elements.length == 0;
    }

    public Boolean equals(Set set) {
        return isSubsetOf(set) && set.isSubsetOf(this);
    }

    public Boolean isSubsetOf(Set set) {
        for (Object element : elements) {
            if (!set.containsElement(element)) {
                return false;
            }
        }
        return true;
    }

    public Boolean containsElement(Object element) {
        for (Object o : elements) {
            if (o.equals(element)) { return true; }
        }
        return false;
    }


    // Collection stuff

    public Set getUnion(Set set) {
        return new ArraySet(ArrayHelpers.combinedAndDuplicatesRemoved(this.toArray(), set.toArray()));
    }

    public Set getIntersection(Set set) {
        Object[] result = this.toArray();
        for (int i = 0; i<result.length; i++) {
            if (!set.containsElement(result[i])) {
                result[i] = null;
            }
        }
        return new ArraySet(ArrayHelpers.removeNulls(result));
    }

    public Set getSetDifference(Set set) {
        Object[] result = this.toArray();
        for (int i = 0; i<result.length; i++) {
            if (set.containsElement(result[i])) {
                result[i] = null;
            }
        }
        return new ArraySet(ArrayHelpers.removeNulls(result));
    }

    public Object[] toArray() {
        return elements.clone();
    }

    // Debug stuff

    public void printElements() {
        for (Object obj : elements) {
            System.out.println(obj);
        }
    }

    public void print() {
        System.out.println(toString());
    }

}