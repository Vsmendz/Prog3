public class atvcont {
    public static void main(String[] args){
        contador c1 = new contador();
        contador c2 = new contador();
        contador c3 = new contador();
        contador c4 = new contador();
        contador.mostrartotal();
    }
}

class contador{
    static int total;
    public contador(){
        total++;
    }

    public static void mostrartotal(){
        System.out.println("Total = "+total);
    }
}
