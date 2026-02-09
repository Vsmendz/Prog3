
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class janela extends JFrame {
    private JLabel lb1;

    public janela() {
        this.setTitle("priemira janela");
        this.setSize(300,200);

        this.lb1 = new JLabel("Bem vindo!!!!",JLabel.CENTER);
        
        JButton sair = new JButton("Sair");

        sair.addActionListener(e -> {
            System.out.println("clicou no botão");
            System.exit(0);
        });
        this.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        this.add(lb1);
        this.add(sair);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        new janela().setVisible(true);;
    }
}