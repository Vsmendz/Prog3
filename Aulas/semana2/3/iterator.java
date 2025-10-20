import java.util.*;

public class iterator{
    public static void printanome(ArrayList l){
        Iterator i = l.iterator();
        while (i.hasNext()) {
            String nome = (String)i.next();
            System.out.println("Aluno = "+nome);
        }
    }

    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Jao");
        list.add("pedro");
        list.add("tomate");
        list.add("juca");
        list.add("linder");

        printanome(list);
        list.remove(0);
        list.remove(2);
        System.out.println();
        printanome(list);

        }
}
