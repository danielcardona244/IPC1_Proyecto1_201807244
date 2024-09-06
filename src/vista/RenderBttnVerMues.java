package vista;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RenderBttnVerMues extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {
    private JButton button;
    private int fila;
    private JTable table;

    public RenderBttnVerMues() {
        button = new JButton();
        button.setText("Ver");
        button.addActionListener(this);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        this.table = table;
        fila = row;
        return button;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.table = table;
        fila = row;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return fila;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
  
        System.out.println("Botón en la fila " + fila + " presionado. Valor de la columna ");
     
    }
}