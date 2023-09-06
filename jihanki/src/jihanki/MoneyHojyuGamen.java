package jihanki;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class MoneyHojyuGamen extends JFrame {
	RemoteMoney dbMoney=new RemoteMoney();
	JTable table;
	JComboBox comboBox;
	Error error=new Error();
	JTextPane mess;
	MoneyHojyuGamen(){
		setType(Type.UTILITY);
		setTitle("金在庫");
		setBounds( 300, 300, 582, 402);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		mess = new JTextPane();
		mess.setFont(new Font("MS UI Gothic", Font.BOLD, 13));
		mess.setForeground(Color.BLACK);
		mess.setBackground(Color.LIGHT_GRAY);
		mess.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Message", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		mess.setBounds(34, 282, 350, 62);
		mess.setEditable(false);

		JScrollPane scrollBar = new JScrollPane(mess);
		scrollBar.setBounds(34, 282, 350, 62);
		getContentPane().add(scrollBar);

		JButton btnNewButton_1 = new JButton("10個");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=choose();
				int b=10;
				switch(a) {
				case 0:{
					String str="";
					if(dbMoney.getJyu()+10<=50) {
						dbMoney.setJyu(b);
					}else{
						str+=error.ERwrong5();
					}
					if(dbMoney.getGojyu()+10<=50) {
						dbMoney.setGojyu(b);

					}else{
						str+=error.ERwrong5();
					}
					if(dbMoney.getHyaku()+10<=50) {
						dbMoney.setHyaku(b);

					}else{
						str+=error.ERwrong5();
					}
					if(dbMoney.getGohyaku()+10<=50) {
						dbMoney.setGohyaku(b);

					}else{
						str+=error.ERwrong5();
					}
					if(dbMoney.getSen()+10<=50) {
						dbMoney.setSen(b);
					}else{
						str+=error.ERwrong5();
					}
					dbMoney.update();
					viewMoney();
					mess.setText(str);
					break;
				}
				case 10:{
					String str="";
					if(dbMoney.getJyu()+10<=50) {
						dbMoney.setJyu(b);
					}else{
						str+=error.ERwrong5();
					}
					dbMoney.update();
					viewMoney();
					mess.setText(str);
					break;
				}
				case 50:{
					String str="";
					if(dbMoney.getGojyu()+10<=50) {
						dbMoney.setGojyu(b);
					}else{
						str+=error.ERwrong5();
					}
					dbMoney.update();
					viewMoney();
					mess.setText(str);
					break;
				}
				case 100:{
					String str="";
					if(dbMoney.getHyaku()+10<=50) {
						dbMoney.setHyaku(b);
					}else{
						str+=error.ERwrong5();
					}
					dbMoney.update();
					viewMoney();
					mess.setText(str);
					break;
				}
				case 500:{
					String str="";
					if(dbMoney.getGohyaku()+10<=50) {
						dbMoney.setGohyaku(b);
					}else{
						str+=error.ERwrong5();
					}
					dbMoney.update();
					viewMoney();
					mess.setText(str);
					break;
				}
				case 1000:{
					String str="";
					if(dbMoney.getSen()+10<=50) {
						dbMoney.setSen(b);
					}else{
						str+=error.ERwrong5();
					}
					dbMoney.update();
					viewMoney();
					mess.setText(str);
					break;
				}default:{
					dispose();break;
				}

				}
			}
		});
		btnNewButton_1.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		btnNewButton_1.setBounds(414, 148, 116, 28);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Max");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=choose();
				
				switch(a) {
				case 0:{
					String str="";
					if(dbMoney.getJyu()<=50) {
						int b=50-dbMoney.getJyu();
						dbMoney.setJyu(b);

					}else{
						str+=error.ERwrong5();
					}
					if(dbMoney.getGojyu()<=50) {
						int b=50-dbMoney.getGojyu();
						dbMoney.setGojyu(b);

					}else{
						str+=error.ERwrong5();
					}
					if(dbMoney.getHyaku()<=50) {
						int b=50-dbMoney.getHyaku();
						dbMoney.setHyaku(b);

					}else{
						str+=error.ERwrong5();
					}
					if(dbMoney.getGohyaku()<=50) {
						int b=50-dbMoney.getGohyaku();
						dbMoney.setGohyaku(b);

					}else{
						str+=error.ERwrong5();
					}
					if(dbMoney.getSen()<=50) {
						int b=50-dbMoney.getSen();
						dbMoney.setSen(b);

					}else{
						str+=error.ERwrong5();
					}
					dbMoney.update();
					viewMoney();
					mess.setText(str);
					break;
				}
				case 10:{
					String str="";
					if(dbMoney.getJyu()<=50) {
						int b=50-dbMoney.getJyu();
						dbMoney.setJyu(b);

					}else{
						str+=error.ERwrong5();
					}
					dbMoney.update();
					viewMoney();
					mess.setText(str);
					break;
				}
				case 50:{
					String str="";
					if(dbMoney.getGojyu()<=50) {
						int b=50-dbMoney.getGojyu();
						dbMoney.setGojyu(b);

					}else{
						str+=error.ERwrong5();
					}
					dbMoney.update();
					viewMoney();
					mess.setText(str);
					break;
				}
				case 100:{
					String str="";
					if(dbMoney.getHyaku()<=50) {
						int b=50-dbMoney.getHyaku();
						dbMoney.setHyaku(b);

					}else{
						str+=error.ERwrong5();
					}
					dbMoney.update();
					viewMoney();
					mess.setText(str);
					break;
				}
				case 500:{
					String str="";
					if(dbMoney.getGohyaku()<=50) {
						int b=50-dbMoney.getGohyaku();
						dbMoney.setGohyaku(b);

					}else{
						str+=error.ERwrong5();
					}
					dbMoney.update();
					viewMoney();
					mess.setText(str);
					break;
				}
				case 1000:{
					String str="";
					if(dbMoney.getSen()<=50) {
						int b=50-dbMoney.getSen();
						dbMoney.setSen(b);
					}else{
						str+=error.ERwrong5();
					}
					dbMoney.update();
					viewMoney();
					mess.setText(str);
					break;
				}default:{
					dispose();break;
				}

				}
			}
		});
		btnNewButton_1_1.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_1_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(414, 208, 116, 28);
		getContentPane().add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("1個");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=choose();
				switch(a) {
				case 0:{
					String str="";
					if(dbMoney.getJyu()+1<=50) {
						dbMoney.setJyu(1);
					}else{
						str+=error.ERwrong5();
					}
					if(dbMoney.getGojyu()+1<=50) {
						dbMoney.setGojyu(1);

					}else{
						str+=error.ERwrong5();
					}
					if(dbMoney.getHyaku()+1<=50) {
						dbMoney.setHyaku(1);

					}else{
						str+=error.ERwrong5();
					}
					if(dbMoney.getGohyaku()+1<=50) {
						dbMoney.setGohyaku(1);

					}else{
						str+=error.ERwrong5();
					}
					if(dbMoney.getSen()+1<=50) {
						dbMoney.setSen(1);

					}else{
						str+=error.ERwrong5();
					}
					dbMoney.update();
					viewMoney();
					mess.setText(str);
					break;
				}
				case 10:{
					String str="";
					if(dbMoney.getJyu()+1<=50) {
	
						dbMoney.setJyu(1);

					}else{
						str+=error.ERwrong5();
					}
					dbMoney.update();
					viewMoney();
					mess.setText(str);
					break;
				}
				case 50:{
					String str="";
					if(dbMoney.getGojyu()+1<=50) {
						dbMoney.setGojyu(1);

					}else{
						str+=error.ERwrong5();
					}
					dbMoney.update();
					viewMoney();
					mess.setText(str);
					break;
				}
				case 100:{
					String str="";
					if(dbMoney.getHyaku()+1<=50) {
						dbMoney.setHyaku(1);

					}else{
						str+=error.ERwrong5();
					}
					dbMoney.update();
					viewMoney();
					mess.setText(str);
					break;
				}
				case 500:{
					String str="";
					if(dbMoney.getGohyaku()+1<=50) {
						dbMoney.setGohyaku(1);

					}else{
						str+=error.ERwrong5();
					}
					dbMoney.update();
					viewMoney();
					mess.setText(str);
					break;
				}
				case 1000:{
					String str="";
					if(dbMoney.getSen()+1<=50) {
						dbMoney.setSen(1);

					}else{
						str+=error.ERwrong5();
					}
					dbMoney.update();
					viewMoney();
					mess.setText(str);
					break;
				}default:{
					dispose();break;
				}

				}
			}
		});
		btnNewButton_1_2.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_1_2.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		btnNewButton_1_2.setBounds(414, 35, 116, 28);
		getContentPane().add(btnNewButton_1_2);

		JButton btnNewButton_1_3 = new JButton("5個");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=choose();
				switch(a) {
				case 0:{
					String str="";
					if(dbMoney.getJyu()+5<=50) {
						dbMoney.setJyu(5);
					}else{
						str+=error.ERwrong5();
					}
					if(dbMoney.getGojyu()+5<=50) {
						dbMoney.setGojyu(5);
					}else{
						str+=error.ERwrong5();
					}
					if(dbMoney.getHyaku()+5<=50) {
						dbMoney.setHyaku(5);
					}else{
						str+=error.ERwrong5();
					}
					if(dbMoney.getGohyaku()+5<=50) {
						dbMoney.setGohyaku(5);

					}else{
						str+=error.ERwrong5();
					}
					if(dbMoney.getSen()+5<=50) {
						dbMoney.setSen(5);

					}else{
						str+=error.ERwrong5();
					}
					dbMoney.update();
					viewMoney();
					mess.setText(str);
					break;
				}
				case 10:{
					String str="";
					if(dbMoney.getJyu()+5<=50) {
						dbMoney.setJyu(5);
					}else{
						str+=error.ERwrong5();
					}
					dbMoney.update();
					viewMoney();
					mess.setText(str);
					break;
				}
				case 50:{
					String str="";
					if(dbMoney.getGojyu()+5<=50) {
						dbMoney.setGojyu(5);
					}else{
						str+=error.ERwrong5();
					}
					dbMoney.update();
					viewMoney();
					mess.setText(str);
					break;
				}
				case 100:{
					String str="";
					if(dbMoney.getHyaku()+5<=50) {
						dbMoney.setHyaku(5);
					}else{
						str+=error.ERwrong5();
					}
					dbMoney.update();
					viewMoney();
					mess.setText(str);
					break;
				}
				case 500:{
					String str="";
					if(dbMoney.getGohyaku()+5<=50) {
						dbMoney.setGohyaku(5);
					}else{
						str+=error.ERwrong5();
					}
					dbMoney.update();
					viewMoney();
					mess.setText(str);
					break;
				}
				case 1000:{
					String str="";
					if(dbMoney.getSen()+5<=50) {
						dbMoney.setSen(5);
					}else{
						str+=error.ERwrong5();
					}
					dbMoney.update();
					viewMoney();
					mess.setText(str);
					break;
				}default:{
					dispose();break;
				}

				}
			}
		});
		btnNewButton_1_3.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_1_3.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		btnNewButton_1_3.setBounds(414, 89, 116, 28);
		getContentPane().add(btnNewButton_1_3);

		String s1[] = {"金額を選択", "１０円", "１００円", "５００円", "１０００円"};
		comboBox = new JComboBox(s1);
		comboBox.setFont(new Font("HGP創英角ｺﾞｼｯｸUB", Font.PLAIN, 15));
		comboBox.setBounds(34, 35, 348, 38);
		getContentPane().add(comboBox);
		table = new JTable(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"\u7A2E\u985E", "\u6B8B\u6570"
				}
				) {
			Class[] columnTypes = new Class[] {
					Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setEnabled(false);
		//フォントの設定
		table.setFont(new Font("MS UI Gothic", Font.BOLD, 17));
		//背景色
		table.setBackground(new Color(255, 255, 255));
		table.setRowHeight(30);

		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(34, 89, 348, 174);
		sp.setPreferredSize(new Dimension(400, 210));
		getContentPane().add(sp);


		JButton btnNewButton_1_1_1 = new JButton("取出");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int check=1;
				String str="";
				if(dbMoney.getJyu()>50) {
					int b=dbMoney.getJyu()-50;
					dbMoney.setJyu(-b);
					str="10円は"+b+"枚とりだしました\n";
					check=0;
				}
				if(dbMoney.getGojyu()>50) {
					int b=dbMoney.getGojyu()-50;
					dbMoney.setGojyu(-b);
					str+="50円は"+b+"枚とりだしました\n";
					check=0;
				}
				if(dbMoney.getHyaku()>50) {
					int b=dbMoney.getHyaku()-50;
					dbMoney.setHyaku(-b);
					str+="100円は"+b+"枚とりだしました\n";
					check=0;
				}
				if(dbMoney.getGohyaku()>50) {
					int b=dbMoney.getGohyaku()-50;
					dbMoney.setGohyaku(-b);
					str+="500円は"+b+"枚とりだしました\n";
					check=0;
				}
				if(dbMoney.getSen()>50) {
					int b=dbMoney.getSen()-50;
					dbMoney.setSen(-b);
					str+="1000円は"+b+"枚とりだしました\n";
					check=0;
				}
				dbMoney.update();
				viewMoney();
				if(check==1) {
					str="現在取り出される金額がありません";
				}
				mess.setText(str);
			}
		});
		btnNewButton_1_1_1.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_1_1_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		btnNewButton_1_1_1.setBounds(414, 264, 116, 28);
		getContentPane().add(btnNewButton_1_1_1);

		viewMoney();

	}
	public void viewMoney() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.getDataVector().removeAllElements();
		model.addRow(new Object[] {10,this.dbMoney.getJyu()});
		model.addRow(new Object[] {50,this.dbMoney.getGojyu()});
		model.addRow(new Object[] {100,this.dbMoney.getHyaku()});
		model.addRow(new Object[] {500,this.dbMoney.getGohyaku()});
		model.addRow(new Object[] {1000,this.dbMoney.getSen()});
	}
	private int choose() {
		String str=this.comboBox.getSelectedItem().toString();
		if(str.equals("金額を選択")) {
			return 0;
		}else if(str.equals("１０円")) {
			return 10;
		}else if(str.equals("１００円")) {
			return 100;
		}else if(str.equals("５００円")) {
			return 500;
		}else if(str.equals("１０００円")) {
			return 1000;
		}else return -1;
	}

}

