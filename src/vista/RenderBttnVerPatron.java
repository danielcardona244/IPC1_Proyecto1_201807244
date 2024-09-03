package vista;


import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RenderBttnVerPatron extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {
    private JButton button;
    private String codigoPatron;

    public RenderBttnVerPatron() {
        button = new JButton("Ver");
        button.addActionListener(this);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return button;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        codigoPatron = (String) table.getValueAt(row, 0); // Obtener el código del patrón
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return codigoPatron;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Aquí puedes implementar lo que sucederá cuando se haga clic en el botón
        System.out.println("Ver patrón: " + codigoPatron);
        // Aquí podrías abrir un nuevo JFrame o mostrar detalles del patrón
    }
}


