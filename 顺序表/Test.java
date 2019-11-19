public class Test {
    public static void main(String[] args) {
        TestAdd();
        TestContains();
        TestSearch();
        TestRemove();

    }
//针对类中每个函数都构造一个函数测试，单元测试
    public static void TestAdd(){
        System.out.println("测试add方法");
        SeqList seqlist = new SeqList();

        seqlist.add(0,1);
        seqlist.add(1,2);
        seqlist.add(2,3);
        seqlist.add(3,4);
        seqlist.display();
    }

    public static void TestContains(){
        System.out.println("测试contains方法");
        SeqList seqlist = new SeqList();

        seqlist.add(0,1);
        seqlist.add(1,2);
        seqlist.add(2,3);
        seqlist.add(3,4);
        seqlist.display();

        boolean result = seqlist.contains(5);
        System.out.println("result=" + result);
    }

    public static void TestSearch(){
        System.out.println("测试search方法");
        SeqList seqlist = new SeqList();

        seqlist.add(0,1);
        seqlist.add(1,2);
        seqlist.add(2,3);
        seqlist.add(3,4);
        seqlist.display();

        int result = seqlist.search(5);
        System.out.println("result=" + result);
    }

    public static void TestRemove(){
        System.out.println("测试remove方法");
        SeqList seqlist = new SeqList();

        seqlist.add(0,1);
        seqlist.add(1,2);
        seqlist.add(2,3);
        seqlist.add(3,4);
        seqlist.remove(3);
        seqlist.display();
    }
}
