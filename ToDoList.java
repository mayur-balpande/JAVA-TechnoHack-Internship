import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ToDoList extends JFrame implements ActionListener {
    private JLabel label;
    private JTextField input;
    private JButton addButton, removeButton, viewButton;
    private ArrayList<String> list;
    
    public ToDoList() {
        setTitle("To-Do List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        
        label = new JLabel("Enter an item:");
        input = new JTextField(20);
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");
        viewButton = new JButton("View");
        
        addButton.addActionListener(this);
        removeButton.addActionListener(this);
        viewButton.addActionListener(this);
        
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(input);
        panel.add(addButton);
        panel.add(removeButton);
        panel.add(viewButton);
        add(panel);
        
        list = new ArrayList<String>();
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String item = input.getText();
            if (!item.isEmpty()) {
                list.add(item);
                input.setText("");
                JOptionPane.showMessageDialog(this, "Item added to list.");
            }
        } else if (e.getSource() == removeButton) {
            int index = JOptionPane.showOptionDialog(this, "Select an item to remove:", "Remove Item",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, list.toArray(), null);
            if (index != JOptionPane.CLOSED_OPTION) {
                list.remove(index);
                JOptionPane.showMessageDialog(this, "Item removed from list.");
            }
        } else if (e.getSource() == viewButton) {
            if (list.isEmpty()) {
                JOptionPane.showMessageDialog(this, "The to-do list is empty.");
            } else {
                String[] items = new String[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    items[i] = list.get(i);
                }
                JOptionPane.showMessageDialog(this, new JList(items), "To-Do List", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
    
    public static void main(String[] args) {
        new ToDoList();
    }
}
