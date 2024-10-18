package gui.application.form.other.ticketbooking;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.extras.FlatSVGIcon.ColorFilter;

import dao.CoachDAO;
import dao.SeatDAO;
import entity.Coach;
import entity.Seat;
import entity.Train;
import entity.TrainJourneyOptionItem;
import net.miginfocom.swing.MigLayout;

public class SeatsChoosingDialog extends JDialog {

	private JPanel container;
	private JPanel chonGheContainer;
	private JPanel gioVeContainer;
	private JPanel container1;
	private JPanel container2;
	private JPanel container3;
	private JPanel container4;
	private JPanel container5;
	private JLabel chonGheLabel;
	private JPanel toaItem;
	private JPanel dauTauContainer;
	private JLabel dauTauLabel;
	private JLabel dauTauValue;
	private Train train;
	private List<Coach> coachList;
	private CoachDAO coachDAO;
	private Coach selectedCoach;
	private SeatDAO seatDAO;
	private List<Seat> seatsOfselectedCoach;
	private JPanel toaConVeContainer;
	private JLabel toaConVeLabel;
	private JLabel tauConVeValue;
	private JPanel toaDangChonContainer;
	private JLabel toaDangChonLabel;
	private JLabel toaDangChonValue;
	private JPanel toaHetVeContainer;
	private JLabel toaHetVeLabel;
	private JLabel toaHetVeValue;
	private JPanel choTrongContainer;
	private JButton choTrongButton;
	private JLabel choTrongValue;
	private JPanel choDangChonContainer;
	private JButton choDangChonButton;
	private JLabel choDangChonValue;
	private JPanel choDaBanContainer;
	private JButton choDaBanButton;
	private JLabel choDaBanValue;
	private JPanel container2boSung;
	private JLabel toaSoLabel;

	public SeatsChoosingDialog(TrainJourneyOptionItem trainJourneyOptionItem) {
		
		coachDAO = new CoachDAO();
		seatDAO = new SeatDAO();
		
		train = trainJourneyOptionItem.getTrain();
		coachList = coachDAO.getCoaches(train);
		
		// state
		selectedCoach = coachList.get(0);
		// state
		
		this.setLayout(new BorderLayout());
		container = new JPanel(new MigLayout("wrap, fill, insets 32 16", "[fill, grow][300px]", "[fill]"));
		
		chonGheContainer = new JPanel(new MigLayout("flowy", "[]", "[][][][]push[][]"));
		gioVeContainer = new JPanel(new MigLayout());
		
		// chon ghe o phia ben trai
		container1 = new JPanel(new MigLayout("", "", ""));
		container2 = new JPanel(new MigLayout("gapx 0"));
		container2boSung = new JPanel(new MigLayout("wrap, fill", "[center]"));
		container3 = new JPanel(new MigLayout("", "", ""));
		container4 = new JPanel(new MigLayout("", "", ""));
		container5 = new JPanel(new MigLayout("", "", ""));
		
		chonGheLabel = new JLabel("CHỌN GHẾ");
		container1.add(chonGheLabel);
		
		dauTauContainer= new JPanel(new MigLayout("flowy, insets 0, gap 0"));
		dauTauLabel = new JLabel(new FlatSVGIcon("gui/icon/svg/dauTau.svg", 0.4f));
		dauTauValue = new JLabel(train.getTrainNumber());
		dauTauContainer.add(dauTauLabel);
		dauTauContainer.add(dauTauValue, "align 50% 50%");
		container2.add(dauTauContainer);
		container3 = new JPanel(new MigLayout());
		
		setSelectedCoach(selectedCoach);
		
		container4 = new JPanel(new MigLayout("wrap, fill", "[][][]", "[]"));
		toaConVeContainer = new JPanel(new MigLayout());
		FlatSVGIcon toaConVeIcon = new FlatSVGIcon("gui/icon/svg/toatau.svg", 0.45f);
		toaConVeIcon.setColorFilter(new ColorFilter().add(Color.BLACK, Color.decode("#24689B")));
		toaConVeLabel = new JLabel(toaConVeIcon);
		tauConVeValue = new JLabel("Tàu còn vé");
		toaConVeContainer.add(toaConVeLabel);
		toaConVeContainer.add(tauConVeValue);
		container4.add(toaConVeContainer);
		
		toaDangChonContainer = new JPanel(new MigLayout());
		FlatSVGIcon toaDangChonIcon = new FlatSVGIcon("gui/icon/svg/toatau.svg", 0.45f);
		toaDangChonIcon.setColorFilter(new ColorFilter().add(Color.BLACK, Color.decode("#24A94A")));
		toaDangChonLabel = new JLabel(toaDangChonIcon);
		toaDangChonValue = new JLabel("Toa đang chọn");
		toaDangChonContainer.add(toaDangChonLabel);
		toaDangChonContainer.add(toaDangChonValue);
		container4.add(toaDangChonContainer);
		
		toaHetVeContainer = new JPanel(new MigLayout());
		FlatSVGIcon toaHetVeIcon = new FlatSVGIcon("gui/icon/svg/toatau.svg", 0.45f);
		toaHetVeIcon.setColorFilter(new ColorFilter().add(Color.BLACK, Color.decode("#E21A1A")));
		toaHetVeLabel = new JLabel(toaHetVeIcon);
		toaHetVeValue = new JLabel("Toa hết vé");
		toaHetVeContainer.add(toaHetVeLabel);
		toaHetVeContainer.add(toaHetVeValue);
		container4.add(toaHetVeContainer);
		
		container5 = new JPanel(new MigLayout("wrap, fill", "[][][]", "[]"));
		
		choTrongContainer = new JPanel(new MigLayout());
		choTrongButton = new JButton();
		choTrongButton.setPreferredSize(new Dimension(50, 50));
		choTrongButton.setMargin(new Insets(0, 0, 0, 0));
		choTrongValue = new JLabel("Chỗ trống");
		choTrongContainer.add(choTrongButton);
		choTrongContainer.add(choTrongValue);
		container5.add(choTrongContainer);
		
		choDangChonContainer = new JPanel(new MigLayout());
		choDangChonButton = new JButton();
		choDangChonButton.putClientProperty(FlatClientProperties.STYLE, "background: #24A94A");
		choDangChonButton.setPreferredSize(new Dimension(50, 50));
		choDangChonButton.setMargin(new Insets(0, 0, 0, 0));
		choDangChonValue = new JLabel("Chỗ đang chọn");
		choDangChonContainer.add(choDangChonButton);
		choDangChonContainer.add(choDangChonValue);
		container5.add(choDangChonContainer);
		
		choDaBanContainer = new JPanel(new MigLayout());
		choDaBanButton = new JButton();
		choDaBanButton.putClientProperty(FlatClientProperties.STYLE, "background: #E21A1A");
		choDaBanButton.setPreferredSize(new Dimension(50, 50));
		choDaBanButton.setMargin(new Insets(0, 0, 0, 0));
		choDaBanValue = new JLabel("Chỗ đã bán");
		choDaBanContainer.add(choDaBanButton);
		choDaBanContainer.add(choDaBanValue);
		container5.add(choDaBanContainer);
		
		
		chonGheContainer.add(container1);
		chonGheContainer.add(container2);
		chonGheContainer.add(container2boSung);
		chonGheContainer.add(container3);
		chonGheContainer.add(container4);
		chonGheContainer.add(container5);
		
		container.add(chonGheContainer, "grow");
		container.add(gioVeContainer, "dock east");
		
		this.add(container);
		this.setUndecorated(true);
		this.setSize(1500, 750);
		this.setLocationRelativeTo(null);
		
		// style
		chonGheLabel.putClientProperty(FlatClientProperties.STYLE, "font: bold +20");
		
	}
	
	private void reactToSelectedCoachChanged() {
		container2.removeAll();
		dauTauContainer= new JPanel(new MigLayout("flowy, insets 0, gap 0"));
		dauTauLabel = new JLabel(new FlatSVGIcon("gui/icon/svg/dauTau.svg", 0.45f));
		dauTauValue = new JLabel(train.getTrainNumber());
		dauTauContainer.add(dauTauLabel);
		dauTauContainer.add(dauTauValue, "align 50% 50%");
		container2.add(dauTauContainer);
		for (Coach coach : coachList) {
			JPanel toaTauContainer = new JPanel(new MigLayout("flowy, insets 0, gap 0"));
			FlatSVGIcon toaTauIcon = new FlatSVGIcon("gui/icon/svg/ToaTau.svg", 0.45f);
			JButton toaTauButton = new JButton(toaTauIcon);
			if (coach.equals(selectedCoach) ) {
				ColorFilter colorFilter = new ColorFilter();
				colorFilter.add(Color.BLACK, Color.decode("#24A94A"));
				toaTauIcon.setColorFilter(colorFilter);
			} else {
				ColorFilter colorFilter = new ColorFilter();
				colorFilter.add(Color.decode("#24A94A"), Color.BLACK);
				toaTauIcon.setColorFilter(colorFilter);
			}
			toaTauButton.putClientProperty(FlatClientProperties.STYLE, "background: #fafafa; borderWidth: 0; focusWidth: 0");
			JLabel toaTauValue = new JLabel(coach.getCoachNumber() + "");
			toaTauContainer.add(toaTauButton);
			toaTauContainer.add(toaTauValue, "align 50% 50%");
			container2.add(toaTauContainer);
			
			toaTauButton.addActionListener(e -> {
				setSelectedCoach(coach);
			});
		}
		
		// container2BoSung
		container2boSung.removeAll();
		toaSoLabel = new JLabel("Toa số " + selectedCoach.getCoachNumber() + ": " + selectedCoach.getCoachType());
		toaSoLabel.putClientProperty(FlatClientProperties.STYLE, "font: plain +2, margin 16 0 0 0");
		container2boSung.add(toaSoLabel, "align 50% 50%");
		
		// container3
		container3.removeAll();
		if (selectedCoach.getCoachType().equals("Ngồi mềm điều hòa") || selectedCoach.getCoachType().equals("Ngồi mềm đều hòa")) {
			container3.setLayout(new MigLayout("flowy, wrap", "[]", "[][][][]"));
		} else if (selectedCoach.getCoachType().equals("Giường nằm khoang 6 điều hòa")) {
			container3.setLayout(new MigLayout("flowy, wrap", "[]", "[][][]"));
		} else if (selectedCoach.getCoachType().equals("Giường nằm khoang 4 điều hòa")) {
			container3.setLayout(new MigLayout("flowy, wrap", "[]", "[][]"));
		}
		seatsOfselectedCoach = seatDAO.getSeats(selectedCoach);
		for (Seat seat : seatsOfselectedCoach) {
			JButton seatButton = new JButton(seat.getSeatNumber() + "");
			seatButton.setPreferredSize(new Dimension(50, 50));
			seatButton.setMargin(new Insets(0, 0, 0, 0));
			container3.add(seatButton);
		}
		container3.repaint();
		container3.revalidate();
		// container 3
		
		container2.repaint();
		container2.revalidate();
	}

	public Coach getSelectedCoach() {
		return selectedCoach;
	}

	public void setSelectedCoach(Coach selectedCoach) {
		this.selectedCoach = selectedCoach;
		reactToSelectedCoachChanged();
		
	}

}
