import java.util.Date;

public class Transacao {
    private int id;
    private Cliente cliente;
    private double valor;
    private Date data;
    private String descricao;

    // Construtor
    public Transacao(int id, Cliente cliente, double valor, Date data, String descricao) {
        this.id = id;
        this.cliente = cliente;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
    }

    // Getters e Setters
    public int getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}

