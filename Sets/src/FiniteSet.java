public class FiniteSet implements Set {

    Object[] elements;

    public FiniteSet() {
        elements = new Object[0];
    }

    public FiniteSet(Set set) {
        elements = set.toArray();
    }

    public FiniteSet(Object[] _elements) {
        elements = ArrayHelpers.duplicatesRemoved(_elements);
    }

    public String toString() {
        String s = "FiniteSet. Items: \n";
        for (Object o : elements) {
            s += o.toString() + "\n";
        }
        return s;
    }

    // Manipulate contents


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
        return new FiniteSet( ArrayHelpers.combinedAndDuplicatesRemoved( this.toArray(), set.toArray() ) );
    }

    public Set getUnion(Object element) {
        return getUnion( new FiniteSet(new Object[]{ element }) );
    }

    public Set getIntersection(Set set) {
        Object[] result = this.toArray();
        for (int i = 0; i<result.length; i++) {
            if (!set.containsElement(result[i])) {
                result[i] = null;
            }
        }
        return new FiniteSet(ArrayHelpers.removeNulls(result));
    }

    public Set getSetDifference(Set set) {
        Object[] result = this.toArray();
        for (int i = 0; i<result.length; i++) {
            if (set.containsElement(result[i])) {
                result[i] = null;
            }
        }
        return new FiniteSet(ArrayHelpers.removeNulls(result));
    }

    public Set getSetDifference(Object element) {
        return getSetDifference( new FiniteSet(new Object[]{ element }) );
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