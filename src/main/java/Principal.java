import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcao = "";
        String nomeProduto = "";
        String numCarrinho = "";
        String tipoProduto = "";
        int numProduto;

        Eletronico e1 = new Eletronico("Xbox", 3500, 0, 12);
        Roupa r1 = new Roupa("Jaqueta Couro", 350.99, 0, "M", "Preta");
        Alimento a1 = new Alimento("Pizza Queijo", 22.50, 0, "19/09/2025");
        Eletronico e2 = new Eletronico("Fone de Ouvido", 75.50, 0, 12);
        Roupa r2 = new Roupa("Bermuda", 50.75, 0, "G", "Azul");
        Alimento a2 = new Alimento("Arroz", 11.50, 0, "06/11/2025");
        Eletronico e3 = new Eletronico("Mouse", 210, 0, 12);
        Roupa r3 = new Roupa("Regata", 100.49, 0, "P", "Lilás");
        Alimento a3 = new Alimento("Suco de Uva", 5.50, 0, "13/06/2027");

        List<Eletronico> eletronicos = new ArrayList<>();
        eletronicos.add(e1);
        eletronicos.add(e2);
        eletronicos.add(e3);

        List<Roupa> roupas = new ArrayList<>();
        roupas.add(r1);
        roupas.add(r2);
        roupas.add(r3);

        List<Alimento> alimentos = new ArrayList<>();
        alimentos.add(a1);
        alimentos.add(a2);
        alimentos.add(a3);

        CarrinhoDeCompras c1 = new CarrinhoDeCompras();
        CarrinhoDeCompras c2 = new CarrinhoDeCompras();

        c1.adicionarItem(new Eletronico("Celular", 1500, 2, 12));
        c1.adicionarItem(new Roupa("Calça Jeans", 250.89, 1, "M", "Preta"));
        c1.adicionarItem(new Alimento("Banana", 2.50, 10, "25/06/2024"));

        c2.adicionarItem(new Eletronico("PC Gamer", 7000, 1, 24));
        c2.adicionarItem(new Roupa("Meia Calça", 20, 5, "P", "Marrom"));
        c2.adicionarItem(new Alimento("Carne", 50.50, 2, "10/07/2024"));
        while (!opcao.equals("0")) {
            System.out.println("Bem vindo aos seus carrinhos de compras, o que deseja fazer?\n" +
                    "1-Mostrar meus carrinhos\n" +
                    "2-Gerar um arquivo texto dos carrinhos\n" +
                    "3-Remover produto de um carrinho\n" +
                    "4-Adicionar item a um carrinho\n" +
                    "0-Encerrar o programa");

            opcao = sc.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("Carrinho de compras 1:");
                    c1.listarItens();
                    System.out.println("Carrinho de compras 2:");
                    c2.listarItens();
                    break;
                case "2":
                    c1.gerarArquivoTexto("carrinho1.txt");
                    c2.gerarArquivoTexto("carrinho2.txt");
                    System.out.println("Arquivos gerados com sucesso");
                    break;
                case "3":
                    System.out.println("De qual carrinho deseja remover o produto? (1) ou (2):");
                    numCarrinho = sc.nextLine();
                    System.out.println("Digite o nome do produto que deseja remover");
                    nomeProduto = sc.nextLine();
                    switch (numCarrinho) {
                        case "1":
                            c1.removerItem(nomeProduto);
                            break;
                        case "2":
                            c2.removerItem(nomeProduto);
                            break;
                        default:
                            System.out.println("Número do carrinho incorreto! Digite um número válido");
                            break;
                    }
                    break;
                case "4":
                    System.out.println("Em qual carrinho deseja adicionar o produto? (1) ou (2):");
                    numCarrinho = sc.nextLine();
                    System.out.println("Digite o número do tipo do produto que deseja adicionar\n" +
                            "1-Eletrônico\n" +
                            "2-Roupa\n" +
                            "3-Alimento");
                    tipoProduto = sc.nextLine();
                    switch (numCarrinho) {
                        case "1":
                            switch (tipoProduto) {
                                case "1":
                                    Eletronico eletronico = new Eletronico();
                                    System.out.println("Digite o número do eletrônico que deseja adicionar:\n" +
                                            "1-Xbox\n" +
                                            "2-Fone de ouvido\n" +
                                            "3-Mouse");
                                    try {
                                        numProduto = Integer.parseInt(sc.nextLine());
                                        c1.adicionarItem(eletronicos.get(numProduto - 1));
                                        System.out.println("Insira a quantidade que deseja adicionar dese produto:");
                                        c1.exportarListaProdutos().get(c1.exportarListaProdutos().size() - 1).setQuantidade(Math.abs(Integer.parseInt(sc.nextLine())));
                                        System.out.println("Produto adicionado com sucesso!");

                                    } catch (NumberFormatException | IndexOutOfBoundsException e) {
                                        System.out.println("Insira um número válido!");
                                    }
                                    break;
                                case "2":
                                    Roupa roupa = new Roupa();
                                    System.out.println("Digite o número da roupa que deseja adicionar:\n" +
                                            "1-Jaqueta de couro preta M\n" +
                                            "2-Bermuda azul G\n" +
                                            "3-Regata lilás P");
                                    try {
                                        numProduto = Integer.parseInt(sc.nextLine());
                                        c1.adicionarItem(roupas.get(numProduto - 1));
                                        System.out.println("Insira a quantidade que deseja adicionar dese produto:");
                                        c1.exportarListaProdutos().get(c1.exportarListaProdutos().size() - 1).setQuantidade(Math.abs(Integer.parseInt(sc.nextLine())));
                                        System.out.println("Produto adicionado com sucesso!");

                                    } catch (NumberFormatException | IndexOutOfBoundsException e) {
                                        System.out.println("Insira um número válido!");
                                    }
                                    break;
                                case "3":
                                    Alimento alimento = new Alimento();
                                    System.out.println("Digite o número da roupa que deseja adicionar:\n" +
                                            "1-Pizza de queijo\n" +
                                            "2-Arroz\n" +
                                            "3-Suco de uva");
                                    try {
                                        numProduto = Integer.parseInt(sc.nextLine());
                                        c1.adicionarItem(roupas.get(numProduto - 1));
                                        System.out.println("Insira a quantidade que deseja adicionar dese produto:");
                                        c1.exportarListaProdutos().get(c1.exportarListaProdutos().size() - 1).setQuantidade(Math.abs(Integer.parseInt(sc.nextLine())));
                                        System.out.println("Produto adicionado com sucesso!");

                                    } catch (NumberFormatException | IndexOutOfBoundsException e) {
                                        System.out.println("Insira um número válido!");
                                    }
                                    break;
                                default:
                                    System.out.println("Produto inválido!");
                            }

                            break;
                        case "2":
                            switch (tipoProduto) {
                                case "1":
                                    Eletronico eletronico = new Eletronico();
                                    System.out.println("Digite o número do eletrônico que deseja adicionar:\n" +
                                            "1-Xbox\n" +
                                            "2-Fone de ouvido\n" +
                                            "3-Mouse");
                                    try {
                                        numProduto = Integer.parseInt(sc.nextLine());
                                        c2.adicionarItem(eletronicos.get(numProduto - 1));
                                        System.out.println("Insira a quantidade que deseja adicionar dese produto:");
                                        c2.exportarListaProdutos().get(c2.exportarListaProdutos().size() - 1).setQuantidade(Math.abs(Integer.parseInt(sc.nextLine())));
                                        System.out.println("Produto adicionado com sucesso!");

                                    } catch (NumberFormatException | IndexOutOfBoundsException e) {
                                        System.out.println("Insira um número válido!");
                                    }
                                    break;
                                case "2":
                                    Roupa roupa = new Roupa();
                                    System.out.println("Digite o número da roupa que deseja adicionar:\n" +
                                            "1-Jaqueta de couro preta M\n" +
                                            "2-Bermuda azul G\n" +
                                            "3-Regata lilás P");
                                    try {
                                        numProduto = Integer.parseInt(sc.nextLine());
                                        c2.adicionarItem(roupas.get(numProduto - 1));
                                        System.out.println("Insira a quantidade que deseja adicionar dese produto:");
                                        c2.exportarListaProdutos().get(c2.exportarListaProdutos().size() - 1).setQuantidade(Math.abs(Integer.parseInt(sc.nextLine())));
                                        System.out.println("Produto adicionado com sucesso!");

                                    } catch (NumberFormatException | IndexOutOfBoundsException e) {
                                        System.out.println("Insira um número válido!");
                                    }
                                    break;
                                case "3":
                                    Alimento alimento = new Alimento();
                                    System.out.println("Digite o número da roupa que deseja adicionar:\n" +
                                            "1-Pizza de queijo\n" +
                                            "2-Arroz\n" +
                                            "3-Suco de uva");
                                    try {
                                        numProduto = Integer.parseInt(sc.nextLine());
                                        c2.adicionarItem(alimentos.get(numProduto - 1));
                                        System.out.println("Insira a quantidade que deseja adicionar dese produto:");
                                        c2.exportarListaProdutos().get(c2.exportarListaProdutos().size() - 1).setQuantidade(Math.abs(Integer.parseInt(sc.nextLine())));
                                        System.out.println("Produto adicionado com sucesso!");

                                    } catch (NumberFormatException | IndexOutOfBoundsException e) {
                                        System.out.println("Insira um número válido!");
                                    }
                                    break;
                                default:
                                    System.out.println("Tipo do produto inválido! Tente novamente!");
                            }
                            break;
                        default:
                            System.out.println("Número do carrinho incorreto! Digite um número válido");
                            break;
                    }
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente!");
            }
        }
        System.out.println("Programa finalizado, obrigado!");
    }
}
