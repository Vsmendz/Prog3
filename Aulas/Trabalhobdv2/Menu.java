package Aulas.Trabalhobdv2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Menu {

    private static DAO FuncDao;
    private static DefaultTableModel tableModel;
    private static JTable tabela;
    private static JFrame frame;

    public static void start() {
        FuncDao = new DAO();
        frame = new JFrame("Funcionários");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // Tabela
        String[] colunas = {"Cargo", "Nome", "ID", "Salário Base", "Salário Total"};
        tableModel = new DefaultTableModel(colunas, 0);
        tabela = new JTable(tableModel);
        frame.add(new JScrollPane(tabela), BorderLayout.CENTER);

        // Botões
        JPanel botoes = new JPanel();
        JButton btnAdd = new JButton("Adicionar");
        JButton btnRemover = new JButton("Remover");
        JButton btnFolha = new JButton("Folha Total");

        btnAdd.addActionListener(e -> adicionar());
        btnRemover.addActionListener(e -> remover());
        btnFolha.addActionListener(e -> folha());

        botoes.add(btnAdd);
        botoes.add(btnRemover);
        botoes.add(btnFolha);
        frame.add(botoes, BorderLayout.SOUTH);

        atualizarTabela();
        frame.setVisible(true);
    }

    private static void atualizarTabela() {
        tableModel.setRowCount(0);
        ArrayList<Funcionarios> lista = FuncDao.listar();
        for (Funcionarios f : lista) {
            tableModel.addRow(new Object[]{
                f.getCargo(),
                f.getNome(),
                f.getMatricula(),
                String.format("%.2f", f.getSalario()),
                String.format("%.2f", f.calcular_salario())
            });
        }
    }

    private static void adicionar() {
        JTextField nome = new JTextField();
        JTextField id = new JTextField();
        JTextField salario = new JTextField();
        JTextField extra = new JTextField();
        String[] cargos = {"Gerente", "Vendedor", "Estagiario", "Diretor"};
        JComboBox<String> cargo = new JComboBox<>(cargos);

        Object[] campos = {
            "Cargo:", cargo,
            "Nome:", nome,
            "ID:", id,
            "Salário Base:", salario,
            "Bônus/Comissão (se aplicável):", extra
        };

        int ok = JOptionPane.showConfirmDialog(frame, campos, "Novo Funcionário", JOptionPane.OK_CANCEL_OPTION);
        if (ok != JOptionPane.OK_OPTION) return;

        try {
            String c = (String) cargo.getSelectedItem();
            String n = nome.getText().trim();
            int i = Integer.parseInt(id.getText().trim());
            double s = Double.parseDouble(salario.getText().trim());

        switch (c) {

            case "Gerente":
                FuncDao.inserir(
                    new Gerente(n, i, s,
                        Double.parseDouble(extra.getText().trim()))
                );
                break;

            case "Vendedor":
                FuncDao.inserir(
                    new Vendedor(n, i, s,
                        Double.parseDouble(extra.getText().trim()))
                );
                break;

            case "Estagiario":
                FuncDao.inserir(
                    new Estagiario(n, i, s)
                );
                break;

            case "Diretor":
                FuncDao.inserir(
                    new Diretor(n, i, s)
                );
                break;
        }
            atualizarTabela();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Dados inválidos: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    private static void remover() {

        int row = tabela.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(frame,
                    "Selecione um funcionário na tabela.");
            return;
        }

        int id = Integer.parseInt(
                tableModel.getValueAt(row, 2).toString()
        );

        FuncDao.remover(id);

        atualizarTabela();
    }

    private static void folha() {
        ArrayList<Funcionarios> lista = FuncDao.listar();
        double total = 0;
        for (Funcionarios f : lista) {
            total += f.calcular_salario();
        }
        JOptionPane.showMessageDialog(frame,
            String.format("Funcionários: %d\nTotal: R$ %.2f", lista.size(), total));
    }
}