import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Produto> itens = new ArrayList<Produto>();

    public CarrinhoDeCompras() {
    }

    public void adicionarItem(Produto produto) {
        itens.add(produto);
    }

    public void removerItem(String nomeProduto) {
        if(itens.removeIf(produto -> produto.getNome().equals(nomeProduto))){
            System.out.println("Item removido com sucesso!");
        }else System.out.println("Item não encontrado!");
    }

    public void listarItens() {
        String detalhes = "";
        for (Produto produto : itens) {
            detalhes = produto.exibirDetalhes();
            System.out.println(detalhes);
        }
    }

    public List<Produto> exportarListaProdutos() {
        return itens;
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto produto : itens) {
            total += produto.getPreco() * produto.getQuantidade();
        }
        return total;
    }

    public void gerarArquivoTexto(String nomeArquivo){
        try (PrintWriter pw = new PrintWriter(nomeArquivo);) {
            int numItem = 1;
            pw.println("Item:\t\tQtd:\t\tNome:\t\tPreço:\t\tSubTotal:");
            for (Produto produto : itens) {
                pw.printf("%d\t\t%d\t\t%s\t\t%.2f\t\t%.2f\n",
                        numItem,produto.getQuantidade(),produto.getNome(),produto.getPreco(),produto.getPreco()*produto.getQuantidade());
                numItem +=1;
            }
            pw.printf("Total: %.2f",calcularTotal());
        } catch (IOException e) {
            System.out.println("Ocorreu um erro durante a gravação do arquivo " + nomeArquivo);
        }

    }


}
