import lombok.extern.slf4j.Slf4j;

/**
 * default value is assigned to
 */
@Slf4j
class DefaultValueTest {
    static int peek() {
        return j;
    }

    static int i = peek();
    static int j = 1;

    DefaultValueTest() {
        log.info("k is {}", k);
    }

    int k = test();

    int test() {
        log.info("call test");
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(DefaultValueTest.i);
        System.out.println(DefaultValueTest.peek());
        System.out.println(DefaultValueTest.i);

        // object instance will call initializer(includes method) differ vs class instance
        System.out.println(new DefaultValueTest().k);
        System.out.println(new DefaultValueTest().test());
        System.out.println(new DefaultValueTest().k);


    }
}
