package jihanki;

import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class UriageGamen extends JFrame {

	private JPanel contentPane;
	private JTextField syohinmei;
	int monthT;
	String syohinName;
	Syohin_about sa=new Syohin_about();
	private JTable table;
	JScrollPane scrollBar;
	Error error=new Error();
	public UriageGamen(String name) {
		super(name);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Choice month = new Choice();
		month.setFont(new Font("Dialog", Font.BOLD, 14));
		month.setBounds(28, 60, 81, 24);
		contentPane.add(month);
		month.add("0");
		month.add("1");
		month.add("2");
		month.add("3");
		month.add("4");
		month.add("5");
		month.add("6");
		month.add("7");
		month.add("8");
		month.add("9");
		month.add("10");
		month.add("11");
		month.add("12");
//		month.getItem(month.getSelectedIndex());

		JLabel lblNewLabel = new JLabel("月");
		lblNewLabel.setBounds(115, 60, 19, 19);
		contentPane.add(lblNewLabel);

		syohinmei = new JTextField();
		syohinmei.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		syohinmei.setBounds(168, 54, 157, 30);
		contentPane.add(syohinmei);
		syohinmei.setColumns(10);

		JButton kensakuBt = new JButton("検索");
		kensakuBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				monthT=Integer.parseInt(month.getItem(month.getSelectedIndex()).replaceAll("　", " "));
				syohinName=syohinmei.getText().replaceAll("　", " ");
				readDate(monthT,syohinName);
			}
		});
		kensakuBt.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		kensakuBt.setBounds(339, 52, 68, 32);
		contentPane.add(kensakuBt);

		JButton sogou = new JButton("総売上を確認");
		sogou.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int uriage=sa.uriage();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[]{0, "全品", uriage});
			}
		});
		sogou.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		sogou.setBounds(421, 54, 155, 30);
		contentPane.add(sogou);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u6708", "\u5546\u54C1\u540D", "\u58F2\u4E0A"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setColumnSelectionAllowed(true);
		table.setBounds(45, 430, 505, -305);
		
		scrollBar = new JScrollPane(table);
		scrollBar.setBounds(28, 124, 548, 329);
		contentPane.add(scrollBar);
	}
	public void readDate(int month,String name) {
		
		if(month!=0&&name.equals("")) {
			int uriage=sa.uriageMonth(month);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addRow(new Object[]{month, name, uriage});
		}else if(month!=0&&name.equals("")!=true) {
			if(sa.checkSyohinmei(name)==1) {
				int uriage=sa.uriageSyohinMonth(name, month);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[]{month, name, uriage});	
			}else {
				int uriage=-1;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[]{month, error.ERwrong1(), uriage});
			}
		}else if(month==0&&name.equals("")!=true) {
			if(sa.checkSyohinmei(name)==1) {
				int uriage=sa.uriageSyohinYear(name);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[]{month, name, uriage});
			}else {
				int uriage=-1;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[]{month, error.ERwrong1(), uriage});
			}
		}
		else if(month==0&&name.equals("")==true) {
			int uriage=sa.uriage();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addRow(new Object[]{0, "全品", uriage});
		}
	}
}
