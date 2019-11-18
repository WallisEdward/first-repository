public class Test {
    public static void main(String[] args) {
        Calculator simple = new Calculator(4,2);
        System.out.println(simple.add());
        System.out.println(simple.subtraction());
        System.out.println(simple.multiplication());
        System.out.println(simple.division());

        Person xiaoming = new Person("小明",19,"male");
       xiaoming.reading();
       xiaoming.running();

       Person p = new Person();
        System.out.println(p.name);
        System.out.println(p.sex);
        System.out.println(p.age);

       Exchange change1 = new Exchange(1.0,2.0);
       change1.Exchange();
    }
}
