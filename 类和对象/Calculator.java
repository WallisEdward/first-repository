public class Calculator {
//    编写一个类Calculator,有两个属性num1,num2,这两个数据的值，不能在定义的同时初始化，最后实现加减乘除四种运算.
//    设计一个包含多个构造函数的类，并分别用这些构造函数来进行实例化对象。
//    实现交换两个变量的值。要求：需要交换实参的值。
    public int num1;
    public int num2;

    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int add(){
        int sum = this.num1 + this.num2;
        return sum;
    }

    public int subtraction(){
        int ret = this.num1 - this.num2;
        return ret;
    }

    public int multiplication(){
        int ret = this.num1*this.num2;
        return ret;
    }

    public double division(){
        double ret = (double)(this.num1)/(double)(this.num2);
        return ret;
    }
}

