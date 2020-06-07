import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ByteBufferTest {

    String sfin = "/Users/arvin/Desktop/layui-v2.5.6.zip";
    String sfou = "FileOut.txt";
    String sfou2 = "FileOut2.txt";

    public void copyFileByAllocDir() throws Exception {
        FileInputStream fin = new FileInputStream(sfin);
        FileChannel fcin = fin.getChannel();

        FileOutputStream fout = new FileOutputStream(sfou);
        FileChannel fcout = fout.getChannel();

        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        long startTime = System.currentTimeMillis();
        while (true) {
            buffer.clear();
            int r = fcin.read(buffer);

            if (r == -1)
                break;
            buffer.flip();
            fcout.write(buffer);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("By copyFileByAllocDir Use cnt : " + (endTime - startTime));
    }

    // 经测试使用ByteBuffer.allocateDirect(1024)的确要比使用
// ByteBuffer.allocate(1024)快！
    public void copyFileByAlloc() throws Exception {
        FileInputStream fin = new FileInputStream(sfin);
        FileChannel fcin = fin.getChannel();

        FileOutputStream fout2 = new FileOutputStream(sfou2);
        FileChannel fcout2 = fout2.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        long startTime = System.currentTimeMillis();
        while (true) {
            buffer.clear();
            int r = fcin.read(buffer);

            if (r == -1)
                break;
            buffer.flip();
            fcout2.write(buffer);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("By copyFileByAlloc Use cnt : " + (endTime - startTime));
    }

    public static void main(String[] args) throws Exception{
        ByteBufferTest test = new ByteBufferTest();
        test.copyFileByAllocDir();
        test.copyFileByAlloc();
    }
}
