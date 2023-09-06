package jihanki;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class HojyuGamen extends JFrame {
	private JTextField suryo;
	JTable table;
	JTextPane mess;
	DbCon db = new DbCon();//データベース接続
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql;
	Error error=new Error();
	Syohin_about kanri=new Syohin_about();
	JButton btnNewButton_2;
	HojyuGamen(String title){
		super(title);
		setType(Type.UTILITY);
		setBounds( 300, 300, 615, 390);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		table = new JTable(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"\u5546\u54C1\u540D", "\u5728\u5EAB"
				}
				) {
			Class[] columnTypes = new Class[] {
					String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		//フォントの設定
		table.setFont(new Font("MS UI Gothic", Font.BOLD, 17));
		//背景色
		table.setBackground(new Color(255, 255, 255));

		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(12, 197, 251, 145);
		sp.setPreferredSize(new Dimension(400, 210));

		JPanel p = new JPanel();
		p.setLayout(null);
		p.add(sp);

		getContentPane().add(p, BorderLayout.CENTER);

		//戻るボタン
		JButton btnNewButton = new JButton("お金補充はこちら");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MoneyHojyuGamen frame = new MoneyHojyuGamen();
					frame.setVisible(true);
				} catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		btnNewButton.setBounds(433, 147, 162, 28);
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		p.add(btnNewButton);

		mess = new JTextPane();
		mess.setFont(new Font("MS UI Gothic", Font.BOLD, 13));
		mess.setForeground(Color.BLACK);
		mess.setBackground(Color.LIGHT_GRAY);
		mess.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Message", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		mess.setBounds(297, 185, 298, 159);
		mess.setEditable(false);

		JScrollPane scrollBar = new JScrollPane(mess);
		scrollBar.setBounds(297, 188, 298, 154);
		p.add(scrollBar);


		JButton btnNewButton_1 = new JButton("10個");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(kanri.listSyohinA.isEmpty()!=true){
					mess.setText("");
					for(int i=0;i<kanri.listSyohinA.size();i++) {
						if((kanri.listSyohinA.get(i).getZaiko()+10)<=50) {
							kanri.listSyohinA.get(i).setZaiko(kanri.listSyohinA.get(i).getZaiko()+10);
							kanri.listSyohinA.get(i).setUpDbZaiko();
							String str=kanri.listSyohinA.get(i).getName()+"10個補充しました。\n";
							mess.setText(mess.getText()+str);
						}
						else {
							String str=kanri.listSyohinA.get(i).getName()+error.ERwrong4();
							mess.setText(mess.getText()+str);
						}
					}
					btnNewButton_2.doClick();

				}else {
					mess.setText("");
					for(int i=0;i<kanri.listSyohin.size();i++) {
						if((kanri.listSyohin.get(i).getZaiko()+10)<=50) {
							kanri.listSyohin.get(i).setZaiko(kanri.listSyohin.get(i).getZaiko()+10);
							kanri.listSyohin.get(i).setUpDbZaiko();
							String str=kanri.listSyohin.get(i).getName()+"10個補充しました。\n";
							mess.setText(mess.getText()+str);
						}
						else {
							String str=kanri.listSyohin.get(i).getName()+error.ERwrong4();
							mess.setText(mess.getText()+str);
						}
					}
					view();
				}
			}
		});
		btnNewButton_1.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		btnNewButton_1.setBounds(12, 159, 116, 28);
		p.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Max");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(kanri.listSyohinA.isEmpty()!=true){
					mess.setText("");
					for(int i=0;i<kanri.listSyohinA.size();i++) {
						if((kanri.listSyohinA.get(i).getZaiko())<=50) {
							int a=50-kanri.listSyohinA.get(i).getZaiko();
							kanri.listSyohinA.get(i).setZaiko(50);
							kanri.listSyohinA.get(i).setUpDbZaiko();
							String str=kanri.listSyohinA.get(i).getName()+a+"個補充しました。\n";
							mess.setText(mess.getText()+str);
						}
						else {
							String str=kanri.listSyohinA.get(i).getName()+error.ERwrong4();
							mess.setText(mess.getText()+str);
						}
					}
					btnNewButton_2.doClick();
				}else {
					mess.setText("");
					for(int i=0;i<kanri.listSyohin.size();i++) {
						if((kanri.listSyohin.get(i).getZaiko())<=50) {
							int a=50-kanri.listSyohin.get(i).getZaiko();
							kanri.listSyohin.get(i).setZaiko(50);
							kanri.listSyohin.get(i).setUpDbZaiko();
							String str=kanri.listSyohin.get(i).getName()+a+"個補充しました。\n";
							mess.setText(mess.getText()+str);
						}
						else {
							String str=kanri.listSyohin.get(i).getName()+error.ERwrong4();
							mess.setText(mess.getText()+str);
						}
					}
					view();
				}

			}
		});
		btnNewButton_1_1.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_1_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(147, 159, 116, 28);
		p.add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("1個");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(kanri.listSyohinA.isEmpty()!=true){
					mess.setText("");
					for(int i=0;i<kanri.listSyohinA.size();i++) {
						if((kanri.listSyohinA.get(i).getZaiko()+1)<=50) {
							kanri.listSyohinA.get(i).setZaiko(kanri.listSyohinA.get(i).getZaiko()+1);
							kanri.listSyohinA.get(i).setUpDbZaiko();
							String str=kanri.listSyohinA.get(i).getName()+"1個補充しました。\n";
							mess.setText(mess.getText()+str);
						}
						else {
							String str=kanri.listSyohinA.get(i).getName()+error.ERwrong4();
							mess.setText(mess.getText()+str);
						}
					}
					btnNewButton_2.doClick();
				}else {
					mess.setText("");
					for(int i=0;i<kanri.listSyohin.size();i++) {
						if((kanri.listSyohin.get(i).getZaiko()+1)<=50) {
							kanri.listSyohin.get(i).setZaiko(kanri.listSyohin.get(i).getZaiko()+1);
							kanri.listSyohin.get(i).setUpDbZaiko();
							String str=kanri.listSyohin.get(i).getName()+"1個補充しました。\n";
							mess.setText(mess.getText()+str);
						}
						else {
							String str=kanri.listSyohin.get(i).getName()+error.ERwrong4();
							mess.setText(mess.getText()+str);
						}
					}
					view();
				}
			}
		});

		btnNewButton_1_2.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_1_2.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		btnNewButton_1_2.setBounds(12, 121, 116, 28);
		p.add(btnNewButton_1_2);

		JButton btnNewButton_1_3 = new JButton("5個");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(kanri.listSyohinA.isEmpty()!=true){
					mess.setText("");
					for(int i=0;i<kanri.listSyohinA.size();i++) {
						if((kanri.listSyohinA.get(i).getZaiko()+5)<=50) {
							kanri.listSyohinA.get(i).setZaiko(kanri.listSyohinA.get(i).getZaiko()+5);
							kanri.listSyohinA.get(i).setUpDbZaiko();
							String str=kanri.listSyohinA.get(i).getName()+"5個補充しました。\n";
							mess.setText(mess.getText()+str);
						}
						else {
							String str=kanri.listSyohinA.get(i).getName()+error.ERwrong4();
							mess.setText(mess.getText()+str);
						}
					}
					btnNewButton_2.doClick();
				}else {
					mess.setText("");
					for(int i=0;i<kanri.listSyohin.size();i++) {
						if((kanri.listSyohin.get(i).getZaiko()+5)<=50) {
							kanri.listSyohin.get(i).setZaiko(kanri.listSyohin.get(i).getZaiko()+5);
							kanri.listSyohin.get(i).setUpDbZaiko();
							String str=kanri.listSyohin.get(i).getName()+"5個補充しました。\n";
							mess.setText(mess.getText()+str);
						}
						else {
							String str=kanri.listSyohin.get(i).getName()+error.ERwrong4();
							mess.setText(mess.getText()+str);
						}
					}
					view();
				}
			}
		});
		btnNewButton_1_3.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_1_3.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		btnNewButton_1_3.setBounds(147, 123, 116, 28);
		p.add(btnNewButton_1_3);

		suryo = new JTextField();
		suryo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				suryo.setText("");
			}
		});
		suryo.setText("何個以下か入力");
		suryo.setBounds(12, 50, 409, 38);
		p.add(suryo);
		suryo.setColumns(10);

		btnNewButton_2 = new JButton("🔍");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str=suryo.getText();
				int number=0;
				int check=1;
				try{
					number = Integer.parseInt(str);
				}
				catch (NumberFormatException ex){
					ex.printStackTrace();
					check=0;
					mess.setText("入力エラー、数字を入力してください。");
				}
				if(check!=0) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.getDataVector().removeAllElements();
					kanri.zaiko(number);
					for(int i=0;i<kanri.listSyohinA.size();i++) {
						model.addRow(new Object[] {kanri.listSyohinA.get(i).getName(),kanri.listSyohinA.get(i).getZaiko()});
					}
					if(kanri.listSyohinA.size()==0) {
						model.addRow(new Object[] {"------------",0});
						mess.setText("条件に当てはまる商品はありません");
					}
				}
			}
		});
		btnNewButton_2.setBounds(443, 46, 52, 45);
		p.add(btnNewButton_2);


		view();
	}
	public void view() {
		kanri.zaiko();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.getDataVector().removeAllElements();
		for(int i=0;i<kanri.listSyohin.size();i++) {
			model.addRow(new Object[] {kanri.listSyohin.get(i).getName(),kanri.listSyohin.get(i).getZaiko()});
		}
	}
}

