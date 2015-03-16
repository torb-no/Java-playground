/**
 * Created with IntelliJ IDEA.
 * User: torbjorn
 * Date: 12.09.14
 * Time: 21:54
 * To change this template use File | Settings | File Templates.
 */
public class UnionSet extends Set {

    private Set a, b;

    public UnionSet(Set a, Set b) {
       this.a = a;
       this.b = b;
    }

    // Get info

    public Boolean empty() {
        return a.empty() && b.empty();
    }

    public Boolean containsElement(Object element) {
        return a.containsElement(element) || b.containsElement(element);
    }

    public Boolean isSubsetOf(Set set) {
        return a.isSubsetOf(set) && b.isSubsetOf(set);
    }

    public String toString() {
        return "( " + a.toString() + " ∪ " + b.toString() + " )";
    }

}
