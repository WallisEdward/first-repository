import java.lang.reflect.Field;

public class TestRef {
    //对类的理解：写了一个类，最终会被加载成.class文件，
    // 这个.class文件会被加载到内存中，方法区中，即类加载的过程
    //在内存中，以什么方式组织.class文件？是创建了一个类相关
    // 的对象，这个对象描述了类具有的信息

    //反射也叫自省，一个对象能利用反射对自己的结构和内部的细节非常清楚
    //Java中提供了一组API来完成反射

    //反射提供的API很多，核心步骤是一样的
    //根据某个字段名称，在.class中获取到对应的Field 字段（拿到内部结构图）
    //再根据内部结构图，获取到指定对象 内部数据 的引用，进而进行读取或者修改
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //String对象不可修改 ，要来通过反射先获取再修改String对象
        String str = "Hello";

        //在内存上String.class对象在方法区中存储，它包含了String类
        // 中所有成员的各种信息，比如：类型、名称、以及该成员在内存的位置
        //先创建一个Field对象，用field对象保存一些信息方便进行接下来的操作
        // value这个变量名是和String的实现内部中
        // private final char value[];这个字段是一致的，即以value为名的字符数组
        Field field = String.class.getDeclaredField("value");

        //把访问权限设置成可访问
        field.setAccessible(true);

        //通过field中的信息，把 str 中的value[]数组获取到
        //value[]就是str 内部存储 “hello”的这个数组
        // 此时char[] value就是一个引用，它保存了从field（含 str 中的value[]数组在内存的位置信息）
        //获得的位置信息。
        char[] value = (char[]) field.get(str);
    }
}
