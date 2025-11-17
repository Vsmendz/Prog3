package atv2;

public class Raiz {
    public static double raiz(double a)
    throws IllegalArgumentException
    {
        if(a < 0){
            throw new IllegalArgumentException("pode n man");
        }else{
            return Math.sqrt(a);
        }
    }
}
