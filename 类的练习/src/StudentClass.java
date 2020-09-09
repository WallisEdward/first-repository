public class StudentClass {
    private String name;             //班级名称
    static int capacity = 40;        //最大容量
    private Student students[];      //学生
    private int size;                //实际人数

    //构造方法
    public StudentClass(String name, int size){
        this.name = name;
        this.size = size;
        students = new Student[capacity];
    }

    public String getName(){
        return name;
    }
    public int getCapacity(){
        return capacity;
    }
    public Student[] getStudents(){
        return students;
    }
    public int getSize(){
        return size;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public void setSize(int size) {
        if (size > capacity) {
            System.out.println("size为" + size + ",不能超过" + capacity);
            return;
        }
        this.size = size;
    }

    //可变长参数方法，需在JDK5及以上版本运行
    public void setStudents(Student[] students){
        for (int i = 0; i<size; i++){
            this.students[i] = new Student(students[i]);
        }
        this.size = students.length;
    }
    public String toString(){
        String s;
        s = " 班级:" + name +"\t" + "容量:" + capacity + "\t" +
                "实际人数:" + size +"\n\n";
        s = s + "学号"+"\t" + "姓名"+"\t" + "英语"+
                "\t" + "数学"+"\t"+ "计算机"+"\t"+"总成绩\n";
        for (int i=0; i<size; i++){
            s = s + students[i].getId()+"\t"+students[i].getName()+"\t"
                    +students[i].getEng()+"\t"+students[i].getMath()+"\t"
                    +students[i].getComp()+"\t"+students[i].getSum()+"\n";}
        return s;
    }

    //顺序查找
    public int find(String id){
        for (int i = 0; i < size; i++)
            if (students[i].getId().equals(id)) return i;
        return -1;
    }

    //增加一个学生
    public boolean add(Student aStudent){
        if (size == capacity)
            return false;//没有空间，不能增加
        if (find(aStudent.getId())>=0)
            return false;//此学号已存在，不能增加
        //增加操作
        this.students[size] = new Student(
                new String(aStudent.getId()),
                new String(aStudent.getName()),
                aStudent.getEng(),
                aStudent.getMath(),
                aStudent.getComp()
        );
        size++;
        return true;
    }

    //删除一个学生
    public boolean del(Student aStudent){
        int pos = find(aStudent.getId());
        if (pos== -1)
            return false;//此学号不存在，不能删除
        //删除操作
        //从pos+1位置到size-1,依次向前移动一个位置
        for (int i = pos+1; i<size; i++)
            students[i-1] = students[i];
        //size减少一个
        size--;
        return true;
    }

    //已知学号删除一个学生
    public boolean del(String id){
        int pos = find(id);
        if (pos== -1)
            return false;//此学号不存在，不能删除
        for (int i = pos+1; i<size; i++)
            students[i-1] = students[i];
        size--;
        return true;
    }

    //增加选择排序方法selectionSort
    //将总成绩从高到低排列
    public void selectionSort(){
        Student temp;
        for (int i=0; i<size-1; i++)
            for (int j=i+1;j<size;j++)
                if (students[j].compare(students[i])>0) {
                    temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
    }

    //增加直接插入排序方法
    public void insertSort(){
        Student temp;
        for (int i=1; i<size; i++) {
            temp = students[i];
            int j = i-1;
            while (j>-1 && temp.compare(students[j])>0){
                students[j+1] = students[j];
                j--;
            }
            students[j+1] = temp;
        }
    }


    //

}

