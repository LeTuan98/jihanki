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

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField idLabel;
	private JTextField passLabel;
	JLabel mess;
	Kanri kanri=new Kanri();
	String id=kanri.getId();
	String pass=kanri.getPass();
	String idText="";//ユーザーが入力したid
	String passText="";//ユーザーが入力したパスワード
	/**
	 * Create the frame.
	 */
	public Login(String name) {
		super(name);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 459, 302);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idText=idLabel.getText();
				passText=passLabel.getText();
				String str=checkLogin();
				mess.setText(str);
				
			}
		});
		btnNewButton.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 16));
		btnNewButton.setBounds(92, 190, 119, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Pass");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 16));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(79, 114, 87, 28);
		contentPane.add(lblNewLabel_1);
		
		idLabel = new JTextField();
		idLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 15));
		idLabel.setBounds(161, 76, 188, 30);
		contentPane.add(idLabel);
		idLabel.setColumns(10);
		
		passLabel = new JTextField();
		passLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 15));
		lblNewLabel_1.setLabelFor(passLabel);
		passLabel.setBounds(161, 116, 189, 30);
		contentPane.add(passLabel);
		passLabel.setColumns(10);
		
	    mess = new JLabel("");
	    mess.setForeground(Color.RED);
	    mess.setFont(new Font("MS UI Gothic", Font.PLAIN, 12));
		mess.setBounds(231, 201, 204, 19);
		contentPane.add(mess);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID");
		lblNewLabel_1_1.setLabelFor(idLabel);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(79, 77, 100, 28);
		contentPane.add(lblNewLabel_1_1);
	}
	public String checkLogin() {
		String str="";
		if(id.equals(idText)&&pass.equals(passText)) {
			try {
				KanriGamen frame =  new KanriGamen("管理画面");
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}	
//		 System.exit(HIDE_ON_CLOSE);
		this.setVisible(false);
		}else {
			
			str="Idかパスワードか間違います";
		}
		return str;
	}

}
