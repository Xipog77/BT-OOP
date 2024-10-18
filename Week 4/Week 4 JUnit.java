public class Week4 {
    public static int max2Int(int a, int b) {
        if (a > b) return a;
        else return b;
    }

    public static int minArray (int[] array) {
        int min = array[0];
        for (int i : array) {
            if (i < min) min = i;
        }
        return min;
    }

    public static String calculateBMI(double weight, double height) {
        double BMI = Math.round((weight/ (height * height)) * 10.0) / 10.0;
        if (BMI < 18.5)
            return "Thiếu cân";
        else if (BMI <= 22.9)
            return "Bình thường";
        else if (BMI <= 24.9)
            return "Thừa cân";
        else
            return "Béo phì";
    }
}
 