package kata5d;


import java.awt.FlowLayout;
import java.awt.PopupMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author Alber
 */
public class MoneyDialog extends JPanel {
    
    public MoneyDialog() {
        super(new FlowLayout());
        add(CreateTextEdit());
        add(new CurrencyDialog());
    }

    private JTextField CreateTextEdit() {
        return new JTextField(10);
    }
}