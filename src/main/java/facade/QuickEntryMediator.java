package facade;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * @author wusd
 * @date 2020/2/13 20:00
 */
public class QuickEntryMediator {
    private JTextField itsJTextField;
    private JList itsJList;
    public QuickEntryMediator(JTextField t, JList l) {
        itsJTextField = t;
        itsJList = l;

        itsJTextField.getDocument().addDocumentListener(
                new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        textFieldChanged();
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        textFieldChanged();
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        textFieldChanged();
                    }
                }
        );
    }
    private void textFieldChanged() {
        String prefix = itsJTextField.getText();
        if (prefix.length() == 0) {
            itsJList.clearSelection();
            return;
        }
        ListModel m = itsJList.getModel();
        boolean found = false;
        for (int i = 0; i < m.getSize() && found == false; i++) {
            Object o = m.getElementAt(i);
            String s= o.toString();
            if (s.startsWith(prefix)) {
                itsJList.setSelectedValue(o, true);
                found = true;
            }
        }
        if (!found) {
            itsJList.clearSelection();
        }
    }
}
