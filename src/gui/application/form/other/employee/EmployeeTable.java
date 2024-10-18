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
		Employee employee = employeeList.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return employee.getEmployeeID();
		case 1:
			return employee.getFullName();
		case 2:
			return employee.isGender();
		case 3:
			return employee.getDateOfBirth();
		case 4:
			return employee.getEmail();
		case 5:
			return employee.getPhoneNumber();
		case 6:
			return employee.getRole();
		case 7:
			return employee.getStartingDate();
		case 8:
			return employee.getSalary();
		case 9:
			return employee.getImageSource();
	}
	return null;
	}
	
	public void setEmployeeList(List<Employee> empoyLists) {
		this.employeeList = empoyLists;
	}
	

}
