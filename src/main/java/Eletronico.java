public class Eletronico extends ProdutoBase {
    private int garantiaMeses;

    public Eletronico(String nome, double preco, int quantidade, int garantiaMeses) {
        super(nome, preco, quantidade);
        this.garantiaMeses = garantiaMeses;
    }

    public Eletronico() {
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    public String getTipo(){
        return "Eletrônico";
    }

    public String exibirDetalhes(){
        String detalhes = String.format("Nome: %s Preço: R$%.2f Quantidade: %d Garantia: %d meses Tipo: %s", this.getNome(), this.getPreco(), this.getQuantidade(), this.getGarantiaMeses(), this.getTipo());
        return detalhes;
    }


}
