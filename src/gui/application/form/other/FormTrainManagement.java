package gui.application.form.other;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;

import net.miginfocom.swing.MigLayout;

public class FormTrainManagement extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField searchTextField;
    private JButton addNewButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JComboBox<String> filterComboBox;
    private JPanel container0;
    private JPanel container1;
    private TrainTableModel trainTableModel;
    private JTable trainTable;

    public FormTrainManagement() {
        setLayout(new BorderLayout());

        container0 = new JPanel();

        // button container
        container1 = new JPanel();
        searchTextField = new JTextField();
        searchTextField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Tìm kiếm");
        addNewButton = new JButton("Thêm mới");
        updateButton = new JButton("Cập nhật");
        deleteButton = new JButton("Xóa");
        container1.setLayout(new MigLayout("", "[]push[][][][][]", ""));
        container1.add(searchTextField, "w 200!");
        container1.add(addNewButton);
        container1.add(updateButton);
        container1.add(deleteButton);

        addNewButton.setIcon(new FlatSVGIcon("gui/icon/svg/add.svg", 0.35f));
        updateButton.setIcon(new FlatSVGIcon("gui/icon/svg/edit.svg", 0.35f));
        deleteButton.setIcon(new FlatSVGIcon("gui/icon/svg/delete.svg", 0.35f));

        searchTextField.putClientProperty(FlatClientProperties.TEXT_FIELD_TRAILING_ICON,
                new FlatSVGIcon("gui/icon/svg/search.svg", 0.35f));

        // table container
        trainTableModel = new TrainTableModel();
        trainTable = new JTable(trainTableModel);

        container0.setLayout(new MigLayout("wrap, fill, insets 15", "[fill]", "[grow 0][fill]"));
        container0.add(container1);
        container0.add(new JScrollPane(trainTable));

        if (trainTable.getColumnModel().getColumnCount() > 0) {
            trainTable.getColumnModel().getColumn(5).setPreferredWidth(300);
        }

        // Change scroll style
        JScrollPane scroll = (JScrollPane) trainTable.getParent().getParent();
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE,
                "" + "background:$Table.background;" + "track:$Table.background;" + "trackArc:999");

        trainTable.getTableHeader().putClientProperty(FlatClientProperties.STYLE_CLASS, "table_style");
        trainTable.putClientProperty(FlatClientProperties.STYLE_CLASS, "table_style");

        // To Create table alignment
        trainTable.getTableHeader().setDefaultRenderer(getAlignmentCellRender(trainTable.getTableHeader().getDefaultRenderer(), true));
        trainTable.setDefaultRenderer(Object.class, getAlignmentCellRender(trainTable.getDefaultRenderer(Object.class), false));
        
        // Set custom cell renderer for the table
        trainTable.setDefaultRenderer(Object.class, new MultiLineCellRenderer());

        addNewButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);

        add(container0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button actions here
    }

    @SuppressWarnings("serial")
    private TableCellRenderer getAlignmentCellRender(TableCellRenderer oldRender, boolean header) {
        return new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                Component com = oldRender.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
                        column);
                if (com instanceof JLabel) {
                    JLabel label = (JLabel) com;
                    if (column == 5) {
                        label.setHorizontalAlignment(SwingConstants.LEADING);
                    } else {
                        label.setHorizontalAlignment(SwingConstants.LEADING);
                    }
                    if (header == false) {
                        if (isSelected) {
                            com.setForeground(table.getSelectionForeground());
                        } else {
                            com.setForeground(table.getForeground());
                        }
                    }
                }
                return com;
            }
        };
    }

    // Custom Cell Renderer for multiline text
    @SuppressWarnings("serial")
	static class MultiLineCellRenderer extends JTextArea implements TableCellRenderer {
        public MultiLineCellRenderer() {
            setLineWrap(true);
            setWrapStyleWord(true);
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            setText(value != null ? value.toString() : "");
            setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
            setForeground(isSelected ? table.getSelectionForeground() : table.getForeground());
            return this;
        }
    }
}
