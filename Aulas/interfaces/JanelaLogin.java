import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JanelaLogin extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton entrar;

    public JanelaLogin() {

        this.setTitle("Login");
        this.setSize(400,300);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(new JLabel("Usuário:"));
        txtUsuario = new JTextField(30);
        this.add(txtUsuario);

        this.add(new JLabel("Senha:"));
        txtSenha = new JPasswordField(30);
        this.add(txtSenha);
        this.setLocationRelativeTo(null);

        entrar = new JButton("Entrar");

        entrar.addActionListener(e -> {
            String nome = txtUsuario.getText();

            JOptionPane.showMessageDialog(
                this,
                "Bem-vindo, " + nome + "!"
            );
        });

        this.add(entrar);
    }

    public static void main(String[] args) {
        new JanelaLogin().setVisible(true);
    }
}
