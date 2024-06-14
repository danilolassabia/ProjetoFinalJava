public class Roupa extends ProdutoBase {
    private String tamanho;
    private String cor;

    public Roupa(String nome, double preco, int quantidade, String tamanho, String cor) {
        super(nome, preco, quantidade);
        this.tamanho = tamanho;
        this.cor = cor;
    }

    public Roupa() {
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTipo(){
        return "Roupa";
    }

    public String exibirDetalhes(){
        String detalhes = String.format("Nome: %s Preço: R$%.2f Quantidade: %d Tamanho: %s Cor: %s meses Tipo: %s", this.getNome(), this.getPreco(), this.getQuantidade(), this.getTamanho(),getCor(), this.getTipo());
        return detalhes;
    }
}
