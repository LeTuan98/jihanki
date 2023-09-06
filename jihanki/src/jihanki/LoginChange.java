package jihanki;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginChange extends JFrame {
	Error error=new Error();
	private JPanel contentPane;
	private JTextField idLabel;
	private JTextField passLabel;
	JLabel mess;
	private JButton cancelBt;
	Kanri kanri=new Kanri();
	String id="";//ユーザーが入力したid
	String pass="";//ユーザーが入力したパスワード

	public LoginChange(String name) {
		super(name);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 506, 383);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton henkoBt = new JButton("変更");
		henkoBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id=idLabel.getText();
				pass=passLabel.getText();
				if(kanri.checkId(id)==1&&kanri.checkPass(pass)==1) {
					kanri.setId(id);
					kanri.setPass(pass);
					kanri.upLoginAbout();
					String str="変更できました";
					mess.setText(str);
					mess.setForeground(Color.green);
					dispose();
				}else if(kanri.checkId(id)==-1){
					String str=error.ERwrong7();
					mess.setText(str);
					mess.setForeground(Color.RED);
					idLabel.setText("");
					passLabel.setText("");
				}else if(kanri.checkId(pass)==-1){
					String str=error.ERwrong8();
					mess.setText(str);
					mess.setForeground(Color.RED);
					idLabel.setText("");
					passLabel.setText("");
				}
				
			}
		});
		henkoBt.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 16));
		henkoBt.setBounds(79, 200, 119, 30);
		contentPane.add(henkoBt);
		
		JLabel lblNewLabel_1 = new JLabel("New Password");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 16));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(79, 114, 156, 28);
		contentPane.add(lblNewLabel_1);
		
		idLabel = new JTextField();
		idLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 15));
		idLabel.setBounds(79, 75, 271, 30);
		contentPane.add(idLabel);
		idLabel.setColumns(10);
		
		passLabel = new JTextField();
		passLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 15));
		lblNewLabel_1.setLabelFor(passLabel);
		passLabel.setBounds(79, 150, 271, 30);
		contentPane.add(passLabel);
		passLabel.setColumns(10);
		
	    mess = new JLabel("");
	    mess.setForeground(Color.RED);
	    mess.setFont(new Font("MS UI Gothic", Font.PLAIN, 12));
		mess.setBounds(78, 254, 271, 82);
		contentPane.add(mess);
		
		JLabel lblNewLabel_1_1 = new JLabel("New ID");
		lblNewLabel_1_1.setLabelFor(idLabel);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(79, 40, 100, 28);
		contentPane.add(lblNewLabel_1_1);
		
		cancelBt = new JButton("キャンセル");
		cancelBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelBt.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 16));
		cancelBt.setBounds(231, 200, 119, 30);
		contentPane.add(cancelBt);
	}


}
