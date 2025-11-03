public class Animal {
    public void emititsom(){
        System.out.println("404");
    }
}

class cachorro extends Animal{
    @Override
    public void emititsom(){
        System.out.println("au au!!");
    }
}

class gato extends Animal{
    @Override
    public void emititsom(){
        System.out.println("miau miau!!");
    } 
}
