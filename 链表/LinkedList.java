class LinkedNode{
                    //实现单链表的基本操作
                    //1. 头插
                    //2. 尾插
                    //3. 获取长度
                    //4. 包含元素
                    //5. 移除元素
    public int data = 0;
    public LinkedNode next = null;

    public LinkedNode(int data){
        this.data = data;
    }

}
public class LinkedList {
    //链表的头节点（第一个节点），有了这个节点就可以
    //根据next把剩下所有元素都获取到
    private LinkedNode head = null;

    //移除元素
    public void remove(int toRemove){
        //空链表的情况
        if(head == null){
            return;
        }
        //删除的是否是头节点
        if (head.data == toRemove){
            this.head = this.head.next;
            return;
        }
        //删除中间节点,用prev记录需要删除节点的前一个节点
        LinkedNode prev = searchPrev(toRemove);
        prev.next = prev.next.next;
        return;
    }
    //判断元素是否在链表中
    public boolean contains(int toFind){
        //直接遍历
        for (LinkedNode cur = this.head;cur != null;cur = cur.next){
            if (cur.data == toFind){
                return true;
            }
        }
        return false;
    }
    //获取长度
    public int size(){
        int size = 0;

        for (LinkedNode cur = this.head; cur != null; cur = cur.next){
            size++;
        }
        return size;
    }
    //尾插
    public void addLast(int elem){
        LinkedNode node = new LinkedNode(elem);
        //空链表的情况
        if(this.head == null){
            this.head = node;
            return;
        }
        //其他情况,找到最后一个节点
        LinkedNode cur = this.head;
        //cur指向最后一个节点
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
        return;
    }

    //头插
    public void addFirst(int elem){
        //先创建一个节点，让这个节点的值就是elem
        LinkedNode node = new LinkedNode(elem);
        //空链表的情况
        if (this.head == null){
            this.head = node;
            return;
        }
        //如果不是空链表的情况，就把节点放在链表的开始
        //更新头
        node.next = head;
        this.head = node;
        return;

    }

    public void display(){
        //打印链表中的所有元素
        System.out.print("[");
        for (LinkedNode node = this.head;
        node != null; node = node.next){
            System.out.print(node.data);
            if(node.next != null) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    private LinkedNode searchPrev(int toRemove){
        //要删除元素的前一个位置
        if (this.head == null){
            return null;
        }
        LinkedNode prev = this.head;
        while(prev.next != null){
            if (prev.next.data == toRemove){
                return prev;
            }
            prev = prev.next;
        }
        //返回null表示没找到
        return null;
    }


//    public void removeAllKey(int toRemove){
//            if (head == null){
//                return;
//            }
//            //先处理后续的节点，最后处理头节点
//        LinkedNode prev = head;
//        LinkedNode cur = head.next;
//        while(cur !=null){
//            if (cur.data == toRemove){
//                prev.next = cur.next;
//                cur = prev.next;//让cur继续指向prev的下一个节点
//            }else {
//                prev = cur;
//                cur = cur.next;
//            }
//        }
//        //头节点的情况
//        if (this.head.data == toRemove){
//            this.head = this.head.next;
//        }
//        return;
//}

}
