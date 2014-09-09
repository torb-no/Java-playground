public class Main {

    public static void main(String[] args) {

        ArraySet setA = new ArraySet(new Object[]{ 1, 2, 3 });
        ArraySet setLikeA = new ArraySet(setA);
        ArraySet setB = new ArraySet(new Object[]{ 3, 4, 5 });

        setLikeA.print();
        ArraySet setAB = new ArraySet(setA.getUnion(setB));
        setAB.print();

        ArraySet setAiB = new ArraySet(setA.getIntersection(setB));
        setAiB.print();

        ArraySet setAdiffB = new ArraySet(setA.getSetDifference(setB));
        setAdiffB.print();
    }

}
