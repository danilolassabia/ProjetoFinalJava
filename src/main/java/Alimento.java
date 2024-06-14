public class Alimento extends ProdutoBase{
    private String dataValidade;

    public Alimento(String nome, double preco, int quantidade, String dataValidade) {
        super(nome, preco, quantidade);
        this.dataValidade = dataValidade;
    }

    public Alimento() {
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getTipo(){
        return "Alimento";
    }

    public String exibirDetalhes(){
        String detalhes = String.format("Nome: %s Preço: R$%.2f Quantidade: %d Data de Validade: %s meses Tipo: %s", this.getNome(), this.getPreco(), this.getQuantidade(), this.getDataValidade(), this.getTipo());
        return detalhes;
    }
}
