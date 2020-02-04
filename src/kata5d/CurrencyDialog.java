package kata5d;

import java.awt.PopupMenu;
import javax.swing.JComboBox;
import javax.swing.JPanel;
/**
 *
 * @author Alber
 */
public class CurrencyDialog extends JPanel {
    
    
     public CurrencyDialog(){
        super();
        add(createCombobox());
    }

    private JComboBox createCombobox() {
        return new JComboBox(new String[] {"EUR","USD","GBP"});
    }
}