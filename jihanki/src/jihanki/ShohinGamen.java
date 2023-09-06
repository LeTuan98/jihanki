package jihanki;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ShohinGamen extends JFrame{
	private JPanel contentPane;
	JTextPane mess;
	Syohin_about sa= new Syohin_about();
	String name;
	Error error=new Error();
	private JTextField changeName;
	private JTextField deleteName;
	public ShohinGamen(String name1) {
		super(name1);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 557, 430);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("変更を加えたい商品名を入力してください");
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 17));
		lblNewLabel.setBounds(48, 48, 272, 21);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("削除したい商品名を入力してください");
		lblNewLabel_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(48, 118, 272, 21);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("変更");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name=changeName.getText();
				int a=sa.checkSyohinmei(name);
				if(a==1) {
					//商品の情報変更画面に移動
					try {
						HenkoGamen frame = new HenkoGamen(name);
						frame.setVisible(true);
					} catch (Exception g) {
						g.printStackTrace();
					}
				}else {
					if(a==0) {
						mess.setText(mess.getText()+error.ERwrong1());
					}else {
						mess.setText(mess.getText()+error.ER3());
					}
				}
			}
		});
		btnNewButton.setBounds(334, 79, 91, 26);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("削除");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name=deleteName.getText();
				int a=sa.checkSyohinmei(name);
				if(a==1) {
					//商品を削除画面に移動する	
					try {
						SakujoGamen frame = new SakujoGamen(name);
						frame.setVisible(true);
					} catch (Exception g) {
						g.printStackTrace();
					}
				}else {
					if(a==0) {
						mess.setText(mess.getText()+error.ERwrong1());
					}else {
						mess.setText(mess.getText()+error.ER3());
					}
				}
			}
		});
		btnNewButton_1.setBounds(334, 154, 91, 26);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("新しく商品を登録したい場合は下記のボタンを押してください");
		lblNewLabel_2.setFont(new Font("MS UI Gothic", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(48, 208, 431, 21);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("キャンセル");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(271, 239, 112, 26);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("登録");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TourokuGamen frame = new TourokuGamen();
					frame.setVisible(true);
				} catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(81, 239, 91, 26);
		contentPane.add(btnNewButton_3);
		
		mess = new JTextPane();
		mess.setForeground(Color.RED);
		mess.setFont(new Font("Cambria", Font.PLAIN, 14));
		mess.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(64, 64, 64), new Color(192, 192, 192)), "Message", TitledBorder.LEADING, TitledBorder.TOP, new Font("", Font.PLAIN, 20), SystemColor.menuText));
		mess.setEditable(false);
		mess.setBackground(Color.LIGHT_GRAY);
		mess.setBounds(58, 287, 421, 78);
//		contentPane.add(mess);
		
		changeName = new JTextField();
		changeName.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		changeName.setBounds(58, 79, 236, 29);
		contentPane.add(changeName);
		changeName.setColumns(1);
		
		deleteName = new JTextField();
		deleteName.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		deleteName.setForeground(new Color(0, 0, 0));
		deleteName.setColumns(1);
		deleteName.setBounds(58, 149, 236, 29);
		contentPane.add(deleteName);
		
		JScrollPane scrollBar = new JScrollPane(mess);
		scrollBar.setBounds(58, 287, 421, 78);
		contentPane.add(scrollBar);
	}
}	
