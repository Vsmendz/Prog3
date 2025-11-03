class Livro {
    public String titulo;
    public String autor;

    public Livro(){
        this.autor = "unknown";
        this.titulo = "none";
    }

    public Livro(String autort,String titulot){
        this.autor = autort;
        this.titulo = titulot;
    }
}