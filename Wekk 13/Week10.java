import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Week10 {

    private static final Map<String, String> map = new HashMap<>();

    // '^': đảm bảo xuất hiện ở đầu dòng. anchor
    // '\s': đại diện cho khoảng trắng.
    // '+': yêu cầu ít nhất một ký tự khoảng trắng.
    // '.': khớp với tất cả ký tự, trừ xuống dòng.
    // '*': cho phép nhiều ký tự xuất hiện.
    // '$': đảm bảo không còn ký tự nào ngoại trừ xuống dòng. anchor
    // '':

    private static final String PACKAGE_REGEX = "^package\\s+(.*);$";
    private static final String IMPORT_REGEX = "^import\\s+(?:static\\s+)?((?:\\w+\\.)+(\\w+));$";
    private static final String CLASS_REGEX =
            "^(?:\\s{2})*(?:(?:abstract|public|private|protected|static|final)\\s+)*"
                    + "(class|interface|enum)\\s+([^<\\s]+)([^{]+)?\\s*\\{";
    private static final String STATIC_METHOD_REGEX =
                    // Bắt comment.
            "^(?<!\\s{0,20}/\\*\\n)"
                    // Đảm bảo có 1 dòng thụt lề và phát hiện kiểu.
            + "(?:\\s{2})+(?:(?:public|private|protected)\\s+)*"
                    // Phát hiện phương thức static hoặc static final và kiểu trả về.
            + "static\\s+(?:final\\s+)?[\\w<>,.?\\[\\]\\s]+\\s+(\\w+)"
                    // Bắt toàn bộ danh sách tham số (bao gồm kiểu và tên tham số).
            + "\\s*\\(([\\w<>,.?\\[\\]\\s]*)\\)\\s*\\{";

    // Khi sử dụng Pattern.MULTILINE,
    // biểu thức chính quy sẽ coi mỗi dòng trong chuỗi văn bản là một chuỗi riêng biệt khi xử lý các ký tự anchor:

    // dòng khai báo package.
    public static final Pattern packagePattern = Pattern.compile(PACKAGE_REGEX, Pattern.MULTILINE);

    // dòng khai báo import.
    public static final Pattern importPattern = Pattern.compile(IMPORT_REGEX, Pattern.MULTILINE);

    // dòng khai báo các class.
    public static final Pattern classPattern = Pattern.compile(CLASS_REGEX, Pattern.MULTILINE);

    // dòng khai báo các phương thức tĩnh.
    public static final Pattern staticMethodPattern = Pattern.compile(
            STATIC_METHOD_REGEX,
            Pattern.MULTILINE);

//    Pattern: Đại diện cho một mẫu biểu thức chính quy, cung cấp công cụ để làm việc với regex.
//    Matcher: Thực hiện việc so khớp chuỗi với mẫu Pattern,
//              cung cấp các phương pháp tìm kiếm, nhóm bắt, và thao tác với kết quả khớp.

    /**
     * Nếu đã lưu trong map, lấy từ map.
     * Nếu kiểu dữ liệu bắt đầu bằng chữ in hoa (VD: String), thêm tiền tố java.lang..
     * Nếu là kiểu generic (VD: List<String>), tách và xử lý riêng từng phần.
     * @param type key.
     * @return value.
     */
    private static String getType(String type) {
        if (map.containsKey(type)) {
            return map.get(type);
        } else if (type.matches("[A-Z]\\w+")) {
            return "java.lang." + type;
        } else if (type.contains("<")) {
            String[] parts = type.split("<");
            parts[0] = getType(parts[0]);
            parts[1] = getType(parts[1].replace(">", ""));

            return String.format("%s<%s>", parts[0], parts[1]);
        } else {
            return type;
        }
    }

    /**
     * Ham lay chu ky static.
     * @param fileContent tep can xu ly.
     * @return List.
     */
    public static List<String> getAllFunctions(String fileContent) {
        List<String> methodSignatures = new ArrayList<>();

        String packageName = "";

        Matcher matcher;

        // tìm package.
        matcher = packagePattern.matcher(fileContent);
        if (matcher.find()) {
            packageName = matcher.group(1);
        }

        // tìm tên import, từ đó lưu đầy đủ tên import.
        matcher = importPattern.matcher(fileContent);
        while (matcher.find()) {
            String fullImport = matcher.group(1);
            String nameImport = matcher.group(2);
            map.put(nameImport, fullImport);
        }

        // tìm tên class, từ đó lưu đầy đủ tên class.
        matcher = classPattern.matcher(fileContent);
        while (matcher.find()) {
            String className = matcher.group(2);
            map.put(className, packageName + "." + className);
        }

        matcher = staticMethodPattern.matcher(fileContent);
        while (matcher.find()) {
            String method = matcher.group(1);
            String allParam = matcher.group(2);

            StringBuilder allType = new StringBuilder().append("(");

            if (!allParam.isEmpty()) {
                // Loại bỏ dấu ...
                allParam = allParam.replaceAll("\\.{3}", "");

                allParam = allParam.replace("\n", "").trim();

                String[] params = allParam.split(", ");
                for (int i = 0; i < params.length; i++) {
                    // Lấy kiểu tham số
                    params[i] = getType(params[i].split(" ")[0]);
                }

                for (String param : params) {
                    allType.append(param).append(",");
                }

                // Xóa dấu phẩy cuối cùng
                allType.deleteCharAt(allType.length() - 1);
            }

            allType.append(")");
            methodSignatures.add(method + allType.toString());
        }

        return methodSignatures;
    }
}
