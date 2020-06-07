import lombok.extern.slf4j.Slf4j;

//volatile修饰类
@Slf4j
public class Volatile4Ref implements Runnable {
    class Foo {
        boolean flag = true;
        int value = 0;

        Foo() {

        }

        Foo(boolean flag, int value) {
            this.flag = flag;
            this.value = value;
        }
    }

    private volatile Foo foo = new Foo();

    public void stop() {
        foo = new Foo(false, 1);

//        foo.value = 1;
//        foo.flag = false;
    }

    @Override
    public void run() {
        while (foo.flag) {
        }
        log.info("value is {}", foo.value);
    }


    public static void main(String[] args) throws InterruptedException {
        Volatile4Ref test = new Volatile4Ref();
        Thread t = new Thread(test);
        t.start();

        Thread.sleep(1000);
        test.stop();
    }
}
