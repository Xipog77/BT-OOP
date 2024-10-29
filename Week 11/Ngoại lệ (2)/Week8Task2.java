import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Week8Task2 {

    /**
     * Hàm tạo ra ngoại lệ con trỏ.
     * @throws NullPointerException ngoại lệ.
     */
    public void nullPointerEx() throws NullPointerException {
        String s = null;
        s.length();
    }

    /**
     * Hàm trả về lỗi con trỏ null.
     * @return lỗi.
     * @throws NullPointerException ngoại lệ.
     */
    public String nullPointerExTest() throws NullPointerException {
        try {
            nullPointerEx();
            return "Không có lỗi";
        } catch (NullPointerException e) {
            return "Lỗi Null Pointer";
        }
    }

    /**
     * Hàm tạo lỗi.
     * @throws ArrayIndexOutOfBoundsException ngoại lệ.
     */
    public void arrayIndexOutOfBoundsEx() throws ArrayIndexOutOfBoundsException {
        int[] arr = new int[5];
        int value = arr[10];
    }

    /**
     * Hàm trả về lỗi.
     * @return lỗi.
     * @throws ArrayIndexOutOfBoundsException lỗi.
     */
    public String arrayIndexOutOfBoundsExTest() throws ArrayIndexOutOfBoundsException {
        try {
            arrayIndexOutOfBoundsEx();
            return "Không có lỗi";
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Lỗi Array Index Out of Bounds";
        }
    }

    /**
     * Hàm tạo lỗi.
     * @throws ArithmeticException lỗi.
     */
    public void arithmeticEx() throws ArithmeticException {
        int div = 10 / 0;
    }

    /**
     * Hàm trả về lỗi.
     * @return lỗi.
     * @throws ArithmeticException lỗi.
     */
    public String arithmeticExTest() throws ArithmeticException {
        try {
            arithmeticEx();
            return "Không có lỗi";
        } catch (ArithmeticException e) {
            return "Lỗi Arithmetic";
        }
    }

    /**
     * Hàm tạo lỗi.
     * @throws FileNotFoundException lỗi.
     */
    public void fileNotFoundEx() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Khanhdeptrai.txt"));
    }

    /**
     * Hàm trả về lỗi.
     * @return lỗi.
     */
    public String fileNotFoundExTest() {
        try {
            fileNotFoundEx();
            return "Không có lỗi";
        } catch (FileNotFoundException e) {
            return "Lỗi File Not Found";
        }
    }

    /**
     * Hàm tạo lỗi.
     * @throws IOException lỗi.
     */
    public void ioEx() throws IOException {
        throw new IOException("Test");
    }

    /**
     * Hàm trả về lỗi.
     * @return lỗi.
     */
    public String ioExTest() {
        try {
            ioEx();
            return "Không có lỗi";
        } catch (IOException e) {
            return "Lỗi IO";
        }
    }
}
