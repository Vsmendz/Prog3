import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class livro extends JFrame {

    private JTextField txtTitulo, txtDescricao, txtCampoExtra, txtBusca;
    private JComboBox<String> cbTipo;
    private JTextArea areaResultados;
    private ArrayList<String> itens = new ArrayList<>();

    public livro() {

        setTitle("Sistema de Mídias");
        setSize(600,500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painelTopo = new JPanel(new GridLayout(6,2,5,5));

        painelTopo.add(new JLabel("Título:"));
        txtTitulo = new JTextField();
        painelTopo.add(txtTitulo);

        painelTopo.add(new JLabel("Descrição:"));
        txtDescricao = new JTextField();
        painelTopo.add(txtDescricao);

        painelTopo.add(new JLabel("Tipo:"));
        cbTipo = new JComboBox<>(new String[]{"Livro","Filme"});
        painelTopo.add(cbTipo);

        painelTopo.add(new JLabel("Campo específico:"));
        txtCampoExtra = new JTextField();
        painelTopo.add(txtCampoExtra);

        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnListar = new JButton("Listar");

        painelTopo.add(btnAdicionar);
        painelTopo.add(btnListar);

        add(painelTopo,BorderLayout.NORTH);

        areaResultados = new JTextArea();
        add(new JScrollPane(areaResultados),BorderLayout.CENTER);

        JPanel painelBusca = new JPanel();

        txtBusca = new JTextField(15);
        JButton btnFiltrar = new JButton("Filtrar");
        JButton btnExportar = new JButton("Exportar Dados");
        JButton btnImportar = new JButton("Importar Dados");

        painelBusca.add(txtBusca);
        painelBusca.add(btnFiltrar);
        painelBusca.add(btnExportar);
        painelBusca.add(btnImportar);

        add(painelBusca,BorderLayout.SOUTH);

        // 🔘 adicionar
        btnAdicionar.addActionListener(e -> {

            if(txtTitulo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,"Título vazio!");
                return;
            }

            String item = cbTipo.getSelectedItem()+" - "
                    +txtTitulo.getText()+" - "
                    +txtDescricao.getText()+" - "
                    +txtCampoExtra.getText();

            itens.add(item);
            JOptionPane.showMessageDialog(this,"Item adicionado!");
        });

        // 🔘 listar
        btnListar.addActionListener(e -> {
            areaResultados.setText("");
            for(String i : itens)
                areaResultados.append(i+"\n");
        });

        // 🔘 filtrar
        btnFiltrar.addActionListener(e -> {
            areaResultados.setText("");
            for(String i : itens)
                if(i.contains(txtBusca.getText()))
                    areaResultados.append(i+"\n");
        });

        // 🔘 exportar (estrutura pronta)
        btnExportar.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            fc.showSaveDialog(this);
        });

        // 🔘 importar (estrutura pronta)
        btnImportar.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(this);
        });
    }

    public static void main(String[] args) {
        new livro().setVisible(true);
    }
}
