public class Triatleta implements Nadador,Corredor,Ciclista{
    @Override
    public void correr(){
        System.out.println("Esta correndo");
    }
    @Override
    public void pedalar(){
        System.out.println("Esta pedalando");
    }
    @Override
    public void nadar(){
        System.out.println("Esta nadando");
    }
}
