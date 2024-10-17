package gui.application.form.other.employee;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;

import dao.EmployeeDAO;
import dao.TrainDAO;
import entity.Employee;
import entity.TrainDetails;
import gui.application.form.other.train.TrainAddingDialog;
import gui.application.form.other.train.TrainTableModel;
import gui.application.form.other.train.TrainUpdateDialog;
import net.miginfocom.swing.MigLayout;

public class FormEmployeeManager extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JTextField searchTextField;
	private JButton addNewButton;
	private JButton updateButton;
	private JButton deleteButton;
	private JPanel container0;
	private JPanel container1;
	private EmployeeTable emplyeeTable;
	private TrainAddingDialog trainAddingDialog;
	private EmployeeDAO employeeDao;
	
	
	public FormEmployeeManager() {
		setLayout(new BorderLayout());
		

		employeeDao = new EmployeeDAO();
		container0 = new JPanel();
		
		
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
	}

//		searchTextField.getDocument().addDocumentListener(new DocumentListener() {

//			@Override
//			public void removeUpdate(DocumentEvent e) {
//				search();
//			}
//
//			@Override
//			public void insertUpdate(DocumentEvent e) {
//				search();
//			}
//
//			@Override
//			public void changedUpdate(DocumentEvent e) {
//				search();
////			}
//		});
//	}
//	
//	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

//	public void search() {
//		String trainNumberToFind = searchTextField.getText().trim();
//		List<Employee>  = employeeDao.getTrainDetailsByTrainNumber(trainNumberToFind);
//		trainTableModel.setTrainDetailsList(trainDetailsList);
//		trainTableModel.fireTableDataChanged();
//	}
}

