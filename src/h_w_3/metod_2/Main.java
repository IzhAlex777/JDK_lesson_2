package h_w_3.metod_2;

public class Main {
    public static void main(String[] args) {
        Pair pair = new Pair(new R1().getS1(),new R2().getF2());
        Pair pair1 = new Pair(new R1().getI3(),new R2().getF2());
        Pair pair2 = new Pair(new R1().getC4(),new R2().getI3());
        Pair pair3 = new Pair(new R1(),new R2());
        System.out.println(pair);
        System.out.println(pair1);
        System.out.println(pair2);
        System.out.println(pair3);
    }
}
