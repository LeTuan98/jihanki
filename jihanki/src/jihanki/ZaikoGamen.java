package jihanki;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class ZaikoGamen extends JFrame {
	JTable table;
	DbCon db = new DbCon();//データベース接続
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql;
	Syohin_about kanri=new Syohin_about();
	ZaikoGamen(String title){
		super(title);
		setType(Type.UTILITY);
		setBounds( 300, 300, 547, 264);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);




		table = new JTable(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"\u5546\u54C1\u540D", "\u6B8B\u6570"
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
		sp.setBounds(12, 25, 342, 189);
		sp.setPreferredSize(new Dimension(400, 210));

		JPanel p = new JPanel();
		p.setLayout(null);
		p.add(sp);

		getContentPane().add(p, BorderLayout.CENTER);

		//戻るボタン
		JButton btnNewButton = new JButton("管理画面に戻る");
		btnNewButton.setFont(new Font("MS UI Gothic", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(361, 28, 126, 21);
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		p.add(btnNewButton);
		zaiko();
	}
	public void zaiko() {
		kanri.zaiko();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(int i=0;i<kanri.listSyohin.size();i++) {
			model.addRow(new Object[] {kanri.listSyohin.get(i).getName(),kanri.listSyohin.get(i).getZaiko()});
		}
	
	}

}

