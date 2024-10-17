package gui.application.form.other.employee;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dao.EmployeeDAO;
import entity.Employee;

public class EmployeeTable extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Employee> employeeList;
	private String[] columnNames = { "ID nhân viên", "Họ tên", "Giới tính", "Ngày sinh", "Email", "SĐT", "Chức vụ","Ngày nhận việc","Lương","Ảnh" };
	private EmployeeDAO employeeDao;
	
	public EmployeeTable () {
		employeeDao = new EmployeeDAO();
		employeeList = employeeDao.getAllEmployee();
	}
	

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public int getRowCount() {
		return employeeList.size();
	}

	@Override
	public int getColumnCount() {
		return 10;
	}

	

	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
