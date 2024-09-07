import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Relatorio {
    private ArrayList<Transacao> transacoes;

    public Relatorio(ArrayList<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    // Geração do relatório financeiro
    public void gerarRelatorio(String nomeArquivo) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("Relatório Financeiro\n");
            writer.write("Data de Emissão: " + sdf.format(new Date()) + "\n\n");
            writer.write("Cliente\t\tValor\t\tData\t\tDescrição\n");
            writer.write("------------------------------------------------------\n");

            double total = 0;
            for (Transacao transacao : transacoes) {
                String linha = transacao.getCliente().getNome() + "\t\t" +
                        transacao.getValor() + "\t\t" +
                        sdf.format(transacao.getData()) + "\t\t" +
                        transacao.getDescricao() + "\n";
                writer.write(linha);
                total += transacao.getValor();
            }

            writer.write("------------------------------------------------------\n");
            writer.write("Total Geral: R$ " + total + "\n");
            writer.write("------------------------------------------------------\n");
            System.out.println("Relatório gerado com sucesso: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao gerar o relatório: " + e.getMessage());
        }
    }
}
