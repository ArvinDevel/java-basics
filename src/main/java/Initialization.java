import lombok.Getter;

/**
 * properties are initialized to default values when doing the initialization of the object.
 * But the local variables are not initialized to default values in the method.
 */
public class Initialization {
    @Getter
    private String string;
    @Getter
    private Integer integer;
    @Getter
    private int anInt;
    private void initialiationLocalVariable(){
        int anInt;
        String string;
        // Compiler does not check for the unused variable
        Integer notUsedInt;
        // comment to see the compilation error
//        System.out.println(anInt + string);
    }

}
