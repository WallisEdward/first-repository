public class SeqList {

    private int[] data = new int[10];
    private int size = 0;

    //打印顺序表
    public void display(){
       // System.out.println(Arrays.toString(data));
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i]);
            if (i != size -1){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
    //在pos位置新增元素
    public void add(int pos,int elem){
        //pos=size相当于尾插
        if (pos < 0 || pos >size){
            return;
        }
        if (this.size >= this.data.length){
            //当前容量不够了，需要扩容
            //申请一块更大的空间，把原有的数据拷贝过去
            realloc();
        }
        if (pos == size){
            //尾插的情况。直接把元素放到size下标的位置上
            this.data[pos] = elem;
            this.size++;
            return;
        }
        //处理插入在中间的情况，进行搬运，把后面的元素依次往后挪
        for (int i = this.size; i >pos ; i--) {
            this.data[i] = this.data[i-1];
        }
        this.data[pos] = elem;
        this.size++;
    }

    void realloc(){
        //扩容大小根据实际场景决定
        int[] newData = new int[this.data.length*2];
        for (int i = 0; i < this.data.length; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }

    //判定是否包含某个元素
    public boolean contains(int toFind){
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == toFind){
                return true;
            }
        }
        return false;
    }

    //查找某个元素对应的位置
    public int search(int toFind){
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == toFind){
                return i;
            }
        }
        return -1;
    }

    //获取pos位置的元素
    public int getPos(int pos){
        return this.data[pos];
    }

    //给pos位置的元素设置value
    public void setPos(int pos,int value){
        this.data[pos] = value;
    }

    //删除第一次出现的关键字key
    public void remove(int toRemove){
        int pos = search(toRemove);
        if (pos == 1){
            //这个值不存在不必删除
            return;
        }
        if (pos == this.size - 1){
            //删除最后一个元素直接size--
            this.size--;
            return;
        }
        //删除中间位置则挪动其后覆盖它
        for (int i = pos; i < this.size-1; i++) {
            this.data[i] = this.data[i+1];
        }
        this.size--;
    }

    //获取顺序表长度
    public int size(){
        return this.size;
    }

    //清空顺序表
    public void clear(){
        this.size = 0;
        this.data = new int[10];
    }

}
