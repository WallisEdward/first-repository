public class SingletonPattern {
    //饿汉模式
//    //不可修改的类对象
//    private static final SingletonPattern instance = new SingletonPattern();
//    //空的私有构造方法
//    private SingletonPattern(){}
//    //外部可调用的方法
//    public static SingletonPattern getInstance(){
//        return instance;
//    }

    //懒汉模式单线程版
//    private static  SingletonPattern instance = null;
//
//    private SingletonPattern(){
//    }
//
//    public static SingletonPattern getInstance(){
//        if (instance == null){
//            instance = new SingletonPattern();
//        }
//        return instance
//    }

    //懒汉模式多线程低性能版
//    private static SingletonPattern instance = null;
//
//    private SingletonPattern(){}
//
//    public static synchronized SingletonPattern getInstance(){
//        if (instance == null){
//            instance = new SingletonPattern();
//        }
//        return instance;
//    }

    //懒汉模式多线程高性能版
    private static volatile SingletonPattern instance = null;

    private SingletonPattern(){
    }

    public static SingletonPattern getInstance(){
        if (instance == null){
            synchronized (SingletonPattern.class){
                if (instance == null){
                    instance = new SingletonPattern();
                }
            }
        }
        return instance;
    }

}