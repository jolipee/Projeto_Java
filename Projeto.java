public class Projeto {
    private String nome;
    private String descricao;
    private double orcamento;

    public Projeto(String nome, String descricao, double orcamento) {
        this.nome = nome;
        this.descricao = descricao;
        this.orcamento = orcamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Orçamento: " + orcamento);
    }

    public void ajustarOrcamento(double novoOrcamento) {
        orcamento = novoOrcamento;
    }

    public void atualizarDescricao(String novaDescricao) {
        descricao = novaDescricao;
    }
}
