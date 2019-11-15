public class Exchange {
    public double num1;
    public double num2;

    public Exchange(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void Exchange(){
        double tmp;
        tmp = this.num1;
        this.num1 = this.num2;
        this.num2 = tmp;
        System.out.println("交换后的num1是："+this.num1+" 交换后的num2是："+this.num2);
    }
}
