public class Person {
    public String name;
    public int age;
    public String sex;

    public Person(){
        this.name = "无名氏";
        this.age = 0;
        this.sex = "male";
    }

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void reading(){
        System.out.println(this.name+"读书");
    }

    public void running(){
        System.out.println(this.name+"跑步");
    }
}
