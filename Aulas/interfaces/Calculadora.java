import java.awt.FlowLayout;
import javax.swing.*;

public class Calculadora extends JFrame {

    private JTextField txtN1;
    private JTextField txtN2;
    private JComboBox<String> cbOperacao;
    private JCheckBox chkPopup;
    private JButton btnCalcular;

    public Calculadora() {

        this.setTitle("Calculadora");
        this.setSize(400,300);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.add(new JLabel("Número 1:"));
        txtN1 = new JTextField(10);
        this.add(txtN1);
        this.add(new JLabel("Número 2:"));
        txtN2 = new JTextField(10);
        this.add(txtN2);

        String[] ops = {"Somar", "Subtrair", "Multiplicar", "Dividir"};
        cbOperacao = new JComboBox<>(ops);
        this.add(cbOperacao);

        chkPopup = new JCheckBox("Mostrar em JOptionPane");
        this.add(chkPopup);

        btnCalcular = new JButton("Calcular");

        btnCalcular.addActionListener(e -> {

            double n1 = Double.parseDouble(txtN1.getText());
            double n2 = Double.parseDouble(txtN2.getText());
            String op = (String) cbOperacao.getSelectedItem();

            double resultado = 0;

            switch(op) {
                case "Somar": resultado = n1 + n2; break;
                case "Subtrair": resultado = n1 - n2; break;
                case "Multiplicar": resultado = n1 * n2; break;
                case "Dividir":
                    if(n2 == 0) {
                        JOptionPane.showMessageDialog(this,"Divisão por zero!");
                        return;
                    }
                    resultado = n1 / n2;
                    break;
            }

            String msg = "Resultado: " + resultado;

            if(chkPopup.isSelected()) {
                JOptionPane.showMessageDialog(this, msg);
            } else {
                System.out.println(msg);
            }
        });
        this.add(btnCalcular);
    }

    public static void main(String[] args) {
        new Calculadora().setVisible(true);
    }
}
