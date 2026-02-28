package Aulas.Trabalho;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MenuGUI extends JFrame {

    private ArrayList<Funcionarios> lista;
    private DefaultTableModel tableModel;
    private JTable tabela;

    private static final double NO_UNIQUE_VALUE = -1.0;

    private static final String[] COLUNAS = {
        "Cargo", "Nome", "ID", "Salário Base", "Bônus/Comissão", "Salário Total"
    };

    public MenuGUI(ArrayList<Funcionarios> lista) {
        this.lista = lista;
        setTitle("SISTEMA DE RH - HH");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new Dimension(700, 500));
        setLayout(new BorderLayout());

        // Table
        tableModel = new DefaultTableModel(COLUNAS, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabela = new JTable(tableModel);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane, BorderLayout.CENTER);

        // Buttons panel
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        JButton btnRegistrar = new JButton("Registrar Funcionário");
        JButton btnRemover = new JButton("Remover Funcionário");
        JButton btnSair = new JButton("Sair");

        painelBotoes.add(btnRegistrar);
        painelBotoes.add(btnRemover);
        painelBotoes.add(btnSair);
        add(painelBotoes, BorderLayout.SOUTH);

        // Load existing employees into table
        atualizarTabela();

        // Listeners
        btnRegistrar.addActionListener(e -> abrirDialogoRegistro());
        btnRemover.addActionListener(e -> removerSelecionado());
        btnSair.addActionListener(e -> sair());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                sair();
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        for (Funcionarios f : lista) {
            double unique = f.getUnique();
            String uniqueStr = (unique == NO_UNIQUE_VALUE) ? "-" : String.format("%.2f", unique);
            tableModel.addRow(new Object[]{
                f.getCargo(),
                f.getNome(),
                f.getMatricula(),
                String.format("%.2f", f.getSalario()),
                uniqueStr,
                String.format("%.2f", f.calcular_salario())
            });
        }
    }

    private void abrirDialogoRegistro() {
        JDialog dialog = new JDialog(this, "Registrar Funcionário", true);
        dialog.setLayout(new GridBagLayout());
        dialog.setMinimumSize(new Dimension(350, 300));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        // Tipo
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0;
        dialog.add(new JLabel("Cargo:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0;
        JComboBox<String> comboCargo = new JComboBox<>(
            new String[]{"Gerente", "Vendedor", "Estagiário", "Diretor"}
        );
        dialog.add(comboCargo, gbc);

        // Nome
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        dialog.add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0;
        JTextField campoNome = new JTextField();
        dialog.add(campoNome, gbc);

        // ID
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0;
        dialog.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0;
        JTextField campoId = new JTextField();
        dialog.add(campoId, gbc);

        // Salário
        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0;
        dialog.add(new JLabel("Salário:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0;
        JTextField campoSalario = new JTextField();
        dialog.add(campoSalario, gbc);

        // Bônus/Comissão (dinâmico)
        gbc.gridx = 0; gbc.gridy = 4; gbc.weightx = 0;
        JLabel labelUnique = new JLabel("Bônus:");
        dialog.add(labelUnique, gbc);
        gbc.gridx = 1; gbc.weightx = 1.0;
        JTextField campoUnique = new JTextField();
        dialog.add(campoUnique, gbc);

        // Update label and visibility based on cargo selection
        comboCargo.addActionListener(e -> {
            String cargo = (String) comboCargo.getSelectedItem();
            if ("Gerente".equals(cargo)) {
                labelUnique.setText("Bônus:");
                labelUnique.setVisible(true);
                campoUnique.setVisible(true);
            } else if ("Vendedor".equals(cargo)) {
                labelUnique.setText("Comissão (0.0–1.0):");
                labelUnique.setVisible(true);
                campoUnique.setVisible(true);
            } else {
                labelUnique.setVisible(false);
                campoUnique.setVisible(false);
            }
        });
        // Initial state
        labelUnique.setVisible(true);
        campoUnique.setVisible(true);

        // Cadastrar button
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2; gbc.weightx = 1.0;
        JButton btnCadastrar = new JButton("Cadastrar");
        dialog.add(btnCadastrar, gbc);

        btnCadastrar.addActionListener(e -> {
            String nome = campoNome.getText().trim();
            String idStr = campoId.getText().trim();
            String salarioStr = campoSalario.getText().trim();
            String cargo = (String) comboCargo.getSelectedItem();

            if (nome.isEmpty() || idStr.isEmpty() || salarioStr.isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "Preencha todos os campos obrigatórios.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int id;
            double salario;
            try {
                id = Integer.parseInt(idStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "ID deve ser um número inteiro.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                salario = Double.parseDouble(salarioStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Salário deve ser um número válido.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                switch (cargo) {
                    case "Gerente": {
                        String bonusStr = campoUnique.getText().trim();
                        if (bonusStr.isEmpty()) {
                            JOptionPane.showMessageDialog(dialog, "Informe o Bônus.",
                                "Erro", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        double bonus = Double.parseDouble(bonusStr);
                        lista.add(new Gerente(nome, id, salario, bonus));
                        break;
                    }
                    case "Vendedor": {
                        String comStr = campoUnique.getText().trim();
                        if (comStr.isEmpty()) {
                            JOptionPane.showMessageDialog(dialog, "Informe a Comissão.",
                                "Erro", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        double comissao = Double.parseDouble(comStr);
                        lista.add(new Vendedor(nome, id, salario, comissao));
                        break;
                    }
                    case "Estagiário":
                        lista.add(new Estagiario(nome, id, salario));
                        break;
                    case "Diretor":
                        lista.add(new Diretor(nome, id, salario));
                        break;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Valor numérico inválido.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(dialog, ex.getMessage(),
                    "Erro de validação", JOptionPane.ERROR_MESSAGE);
                return;
            }

            atualizarTabela();
            dialog.dispose();
        });

        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void removerSelecionado() {
        int linhaSelecionada = tabela.getSelectedRow();
        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um funcionário na tabela.",
                "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nome = (String) tableModel.getValueAt(linhaSelecionada, 1);
        int confirm = JOptionPane.showConfirmDialog(this,
            "Deseja remover o funcionário \"" + nome + "\"?",
            "Confirmar remoção", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            lista.remove(linhaSelecionada);
            atualizarTabela();
        }
    }

    private void sair() {
        try {
            Main.save(lista);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar dados: " + ex.getMessage(),
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
        dispose();
        System.exit(0);
    }

    public static void start(ArrayList<Funcionarios> lista) {
        SwingUtilities.invokeLater(() -> new MenuGUI(lista));
    }
}
