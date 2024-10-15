package gui.application.form.other.ticketbooking;

import java.awt.BorderLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.formdev.flatlaf.FlatClientProperties;

import dao.TrainJourneyDAO;
import net.miginfocom.swing.MigLayout;

public class FormSearchTrainJourney extends JPanel {
	
	private JPanel container;
	private JPanel formContainer;
	private JPanel container1;
	private JPanel container2;
	private JPanel container3;
	private JPanel container4;
	private JPanel container5;
	private JLabel thongTinKhachHangLabel;
	private JLabel gaDiLabel;
	private JTextField gaDiTextField;
	private JLabel gaDenLabel;
	private JTextField gaDenTextField;
	private JLabel ngayDiLabel;
	private JTextField ngayDiTextField;
	private JLabel ngayDenLabel;
	private JTextField ngayDenTextField;
	private JButton timKiemButton;
	private TrainJourneyDAO trainJourneyDAO;

	public FormSearchTrainJourney() {
		this.trainJourneyDAO = new TrainJourneyDAO();
		setLayout(new BorderLayout());
		container = new JPanel(new MigLayout("wrap, fill", "[center]", "[center]"));
		formContainer = new JPanel(new MigLayout("wrap", "[fill]"));
		
		container1 = new JPanel(new MigLayout("fill", "[center]"));
		container2 = new JPanel(new MigLayout("wrap", "[]", "[][]"));
		container3 = new JPanel(new MigLayout("wrap", "[]", "[][]"));
		container4 = new JPanel(new MigLayout("wrap", "[]", "[][]"));
		container5 = new JPanel(new MigLayout("wrap, fill", "[center]"));
		
		thongTinKhachHangLabel = new JLabel("THÔNG TIN HÀNH TRÌNH");
		thongTinKhachHangLabel.putClientProperty(FlatClientProperties.STYLE, "font: bold +16");
		container1.add(thongTinKhachHangLabel);
		
		gaDiLabel = new JLabel("Ga đi");
		gaDiTextField = new JTextField(30);
		container2.add(gaDiLabel);
		container2.add(gaDiTextField);
		
		gaDenLabel = new JLabel("Ga đến");
		gaDenTextField = new JTextField(30);
		container3.add(gaDenLabel);
		container3.add(gaDenTextField);
		
		ngayDiLabel = new JLabel("Ngày đi");
		ngayDiTextField = new JTextField(30);
		container4.add(ngayDiLabel);
		container4.add(ngayDiTextField);
		
		timKiemButton = new JButton("Tìm kiếm");
		container5.add(timKiemButton);
		timKiemButton.putClientProperty(FlatClientProperties.STYLE, "background: $primary; foreground: $clr-white");
		
		formContainer.add(container1);
		formContainer.add(container2);
		formContainer.add(container3);
		formContainer.add(container4);
		formContainer.add(container5);
		
		container.add(formContainer);
		this.add(container);
		
		timKiemButton.addActionListener(e -> {
			String gaDi = gaDiTextField.getText().trim();
			String gaDen = gaDenTextField.getText().trim();
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate ngayDi = LocalDate.parse(ngayDiTextField.getText().trim(), dateFormatter);
			List<TrainJourney> trainJourneyList = trainJourneyDAO.searchTrainJourney(gaDi, gaDen, ngayDi);
		});
		
	}

}
