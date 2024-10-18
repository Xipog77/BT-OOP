// Import your library
// Do not change the name of the Solution class

//package org.Week6;


import static java.lang.Math.sqrt;

public class Solution {

    /**
     *  calculate the fibonacci number n, by using a for function.
     */
    public static long fibonacci(long n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        long n1 = 0;
        long n2 = 1;
        long next = 0;
        for (int i = 2; i <= n; i++) {
            next = n1 + n2;
            if (next < n2) {
                return 9223372036854775807L;
            }
            n1 = n2;
            n2 = next;
        }
        return next;
    }

    /**
     *  find if number n is a prime number or not.
     */
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(fibonacci(2));
    }
    private int numerator = 0;
    private int denominator = 1;

    /**
     *  calculate the gcd of two number a and b by using a recursion.
     */
    private static int gcd(int a, int b) {
        if (a == 0) {
            if (b < 0) {
                return -b;
            } else {
                return b;
            }
        } else if (b == 0 || b % a == 0) {
            if (a < 0) {
                return -a;
            } else {
                return a;
            }
        } else if (a % b == 0) {
            if (b < 0) {
                return -b;
            } else {
                return b;
            }
        } else if (a > b) {
            return gcd(b, a - b);
        } else {
            return gcd(a, b - a);
        }
    }

    /**
     *  Ham khoi tao Soulution.
     */
    Solution(int num, int den) {
        numerator = num;
        denominator = den;
    }

    /*
     * Ham cai dat tu so.
     */
    public void setNumerator(int num) {
        numerator = num;
        return;
    }

    /*
     * Ham cai dat mau so.
     */
    public void setDenominator(int num) {
        if (num == 0) {
            System.out.println("Lỗi: Mẫu số không thể bằng 0");
        } else {
            denominator = num;
        }
    }

    /*
     * Ham tra ve tu so.
     */
    public int getNumerator() {
        return numerator;
    }

    /*
     * Ham tra ve mau so.
     */
    public int getDenominator() {
        return denominator;
    }

    /*
     * Ham rut gon phan so.
     */
    public Solution reduce() {
        int n = gcd(numerator, denominator);
//        numerator /= n;
//        denominator /= n;
        Solution solution = new Solution(numerator/n,denominator/n);
        return solution;
    }

    /*
     * Ham cong hai phan so.
     */
    public Solution add(Solution target) {
        int num = numerator * target.getDenominator() + denominator * target.getNumerator();
        int dem = denominator * target.getNumerator();
        Solution solution = new Solution(num,dem).reduce();
        return solution;
    }

    /*
     * Ham tru hai phan so.
     */
    public Solution subtract(Solution target) {
        int num = numerator * target.getDenominator() - denominator * target.getNumerator();
        int dem = denominator * target.getNumerator();
        Solution solution = new Solution(num,dem).reduce();
        return solution;
    }

    /*
     * Ham nhan hai phan so.
     */
    public Solution multiply(Solution target) {
        int num = numerator * target.getNumerator();
        int dem = denominator * target.getDenominator();
        Solution solution = new Solution(num,dem).reduce();
        return solution;
    }

    /*
     * Ham chia hai phan so.
     */
    public Solution divide(Solution target) {
        if (target.numerator == 0) {
            return null;
        }
        int num = numerator * target.getDenominator();
        int dem = denominator * target.getNumerator();
        Solution solution = new Solution(num,dem).reduce();
        return solution;
    }

    /*
     * Ham so sanh hai phan so.
     */
    public boolean equals(Object obj) {
        if (obj instanceof Solution) {

            Solution other = (Solution) obj;

            Solution s1 = this.reduce();
            Solution s2 = other.reduce();

            if (s1.getNumerator() == s2.getNumerator() && s1.getDenominator() == s2.getDenominator()) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

}