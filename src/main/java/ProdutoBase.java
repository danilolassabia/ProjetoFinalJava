public abstract class ProdutoBase implements Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public ProdutoBase(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public ProdutoBase() {
    }

    public String getTipo(){
        return "";
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public double getPreco(){
        return preco;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public void setQuantidade(int quatidade){
        this.quantidade = quatidade;
    }

    public abstract String exibirDetalhes();

    public String toString(){
        return nome;
    }
}
