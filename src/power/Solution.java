package power;
public class Solution {
    public double Power(double base, int exponent) {
        if ( base == 0.0 ) {
            return base;
        }
        if ( base == 1.0 || exponent == 1 ) {
            return base;
        }
        if (  exponent == 0 ) {
            return 1;
        }
        
        if ( exponent < 0) {
           return 1/pow(base,Math.abs(exponent));
        }
        return pow(base,exponent);
		
       
        
  }
    private double pow(double base, int exponent) {
        if ( base == 1.0 || exponent == 1 ) {
            return base;
        }
        if ( exponent == 0 ) {
            return 1;
        }
        double result = pow(base,exponent>>1);
        result *= result;
        if ( exponent % 2 == 1) {
            result *= base;
        }
        return result;
    }
}