import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Animal> lista_animais = new ArrayList<>();
        lista_animais.add(new cachorro());
        lista_animais.add(new gato());
        lista_animais.add(new Animal());
        lista_animais.add(new cachorro());
        lista_animais.add(new cachorro());
        for (Animal bixinho:lista_animais){
            bixinho.emititsom();
        }
    }
}
