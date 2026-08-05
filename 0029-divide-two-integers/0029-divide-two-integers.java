class Solution {
    public int divide(int dividend, int divisor) {
         if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long dividendD = Math.abs((long) dividend);
        long divisorA = Math.abs((long) divisor);
        long quotient = 0;

        while (dividendD >= divisorA) {
            long tempDivisor = divisorA, multiple = 1;
            while (dividendD >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }
            dividendD -= tempDivisor;
            quotient += multiple;
        }

        quotient *= sign;
        return (int) Math.min(Math.max(quotient, (long) Integer.MIN_VALUE), (long) Integer.MAX_VALUE);
    }
}