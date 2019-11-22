public class TestLinkedList {
    public static void main(String[] args) {
        testAddFirst();
        testAddLast();
        testRemove();
    }

    public static void testAddFirst(){
        System.out.println("测试头插");
        LinkedList list = new LinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.display();
    }

    public static void testAddLast(){
        System.out.println("测试尾插");
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.display();
    }

    public static void testRemove(){
        System.out.println("测试移除");
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.display();
        list.remove(4);
        list.display();
    }
}
