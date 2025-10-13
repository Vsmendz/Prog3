public class fibo {

    public static void iterativo(int index){
        int current_term = 1; // primeiro termo da fibonacci
        int ant_term = 0; 

        for (int i = 0;i < index;i++){
            System.out.println(current_term);
            int aux = current_term; // guarda o termo atual
            current_term = current_term + ant_term; // realiza a soma do termo atual com o anterior
            ant_term = aux; // atualiza o anterior
        }
    }

    public static void main(String[] args) {
        iterativo(30);
    }
}

