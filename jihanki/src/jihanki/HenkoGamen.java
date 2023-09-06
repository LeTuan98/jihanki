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
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class HenkoGamen extends JFrame {

	private JPanel contentPane;
	private JTextField genzaiNedan;
	private JTextField genzaiName;
	private JTextField henkoAtoName;
	private JTextField henkoAtoNedan;
	Error er=new Error();
	String name;
	String nedan;
	Syohin syohin;
	JTextPane mess;
	public HenkoGamen(String name) {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 742, 442);
		setTitle("変更画面");
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("現在の商品名");
		JLabel lblNewLabel_1 = new JLabel("現在の値段");
		JLabel lblNewLabel_2 = new JLabel("→");
		JLabel lblNewLabel_3 = new JLabel("変更後の商品名");
		JLabel lblNewLabel_1_1 = new JLabel("変更後の値段");
		JLabel lblNewLabel_2_1 = new JLabel("円");
		JLabel lblNewLabel_2_1_1 = new JLabel("円");

		JButton	btn_2 = new JButton("キャンセル");
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mess = new JTextPane();
		mess.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
		genzaiNedan = new JTextField();
		genzaiName = new JTextField();
		henkoAtoName = new JTextField();
		henkoAtoNedan = new JTextField();


		//各画面部品の設定

		lblNewLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 17));
		lblNewLabel.setBounds(35, 37, 126, 21);
		contentPane.add(lblNewLabel);

		lblNewLabel_1.setFont(new Font("MS UI Gothic", Font.BOLD, 17));
		lblNewLabel_1.setBounds(35, 164, 112, 21);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 99));
		lblNewLabel_2.setBounds(308, 128, 81, 69);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3.setFont(new Font("MS UI Gothic", Font.BOLD, 17));
		lblNewLabel_3.setBounds(445, 37, 126, 21);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_1_1.setFont(new Font("MS UI Gothic", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(445, 164, 112, 21);
		contentPane.add(lblNewLabel_1_1);

		lblNewLabel_2_1.setFont(new Font("HGP明朝E", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(210, 187, 45, 46);
		contentPane.add(lblNewLabel_2_1);

		lblNewLabel_2_1_1.setFont(new Font("HGP明朝E", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(620, 187, 45, 46);
		contentPane.add(lblNewLabel_2_1_1);



		btn_2.setBounds(576, 256, 112, 26);
		contentPane.add(btn_2);
		mess.setForeground(Color.BLACK);
		mess.setBackground(Color.LIGHT_GRAY);
		mess.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(64, 64, 64), new Color(192, 192, 192)), "Message", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		mess.setBounds(22, 295, 666, 98);
		mess.setEditable(false);
		contentPane.add(mess);

		genzaiNedan.setBounds(35, 195, 163, 38);
		contentPane.add(genzaiNedan);
		genzaiNedan.setColumns(10);

		genzaiName.setColumns(10);
		genzaiName.setBounds(35, 80, 220, 38);
		contentPane.add(genzaiName);

		henkoAtoName.setColumns(10);
		henkoAtoName.setText("");
		henkoAtoName.setBounds(445, 80, 220, 38);
		contentPane.add(henkoAtoName);

		henkoAtoNedan.setColumns(10);
		henkoAtoNedan.setText("");
		henkoAtoNedan.setBounds(445, 195, 163, 38);
		contentPane.add(henkoAtoNedan);
		syohin=new Syohin(name);
		syohin.getDbDate(name);
		this.genzaiName.setText(name);
		this.genzaiNedan.setText(Integer.toString(syohin.getNedan()));
		JButton btn = new JButton("変更");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//hekou

				String name=henkoAtoName.getText();
				if(name.isEmpty()==true||henkoAtoNedan.getText().isEmpty()==true) {
					mess.setText("入力不正です。\n入力してください。");
				}else {
					int nedan=9999;
					try{
						nedan =Integer.parseInt(henkoAtoNedan.getText());
					}
					catch (NumberFormatException ex){
						ex.printStackTrace();
					}
					int a=henko(name,nedan);
					if(a==1) {
						mess.setText("変更できました");
					}else if(a==-1) {
						mess.setText(er.ERwrong6());
					}else if(a==-2) {
						mess.setText(er.ERwrong9());
					}else if(a==9999) {
						mess.setText(er.ERwrong10());
					}else if(a==1990) {
						mess.setText("１９９０円以下の値段を設計してください。");
					}
				}
			}
		});
		btn.setBounds(401, 256, 91, 26);
		contentPane.add(btn);
	}
	public int henko(String name,int nedan) {
		if(nedan==9999) {
			return 9999;
		}else if(nedan>1990) {
			return 1990;
		}
		if(name.length()>50) {
			return -1;
		}else if(nedan<=0) {
			return -2;
		}else {
			syohin.setName(name);
			syohin.setNedan(nedan);
			syohin.setUpDbName();
			syohin.setUpDbNedan();
			return 1;
		}
	}
}
