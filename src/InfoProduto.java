public class InfoProduto implements Comparable<InfoProduto> {
    String produto;
    double precoProduto;

    public InfoProduto(String produto, double precoProduto) {
        this.produto = produto;
        this.precoProduto = precoProduto;
    }

    @Override
    public String toString() {
        return "Produto: " + produto + ", Preço: " + precoProduto;
    }

    // Implementando o compareTo para ordenar pelo preço
    @Override
    public int compareTo(InfoProduto outroProduto) {
        // Ordenar do mais caro para o mais barato
        return Double.compare(outroProduto.precoProduto, this.precoProduto);
    }
}
