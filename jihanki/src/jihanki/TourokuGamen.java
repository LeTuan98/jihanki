package jihanki;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class TourokuGamen extends JFrame {
	private JTextField name;
	private JTextField nedan;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	Choice tonyuguti;
    Syohin_about sa=new Syohin_about();
    int checkTo=0;
    Error error=new Error();
	TourokuGamen(){
		getContentPane().setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		getContentPane().setBackground(Color.WHITE);
		setTitle("商品登録");
		setBounds( 300, 300, 500, 288);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		//フォントの設定
		setFont(new Font("MS UI Gothic", Font.BOLD, 17));
		//背景色
		setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);


		JLabel lblNewLabel = new JLabel("登録したい商品名を入力");
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		lblNewLabel.setBounds(30, 22, 172, 26);
		getContentPane().add(lblNewLabel);

		name = new JTextField();
		name.setText(" ");
		name.setBackground(Color.WHITE);
		name.setBounds(30, 52, 172, 26);
		name.setBorder(new LineBorder(Color.GRAY, 1, false));
		getContentPane().add(name);
		name.setColumns(10);


		lblNewLabel_1 = new JLabel("登録したい商品の値段を入力");
		lblNewLabel_1.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		lblNewLabel_1.setBounds(30, 81, 172, 26);
		getContentPane().add(lblNewLabel_1);

		nedan = new JTextField();
		nedan.setColumns(10);
		nedan.setBorder(new LineBorder(Color.GRAY, 1, false));
		nedan.setBackground(Color.WHITE);
		nedan.setBounds(30, 106, 172, 26);
		getContentPane().add(nedan);

		lblNewLabel_2 = new JLabel("円");
		lblNewLabel_2.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		lblNewLabel_2.setBounds(213, 106, 32, 26);
		getContentPane().add(lblNewLabel_2);



		JTextPane mess = new JTextPane();
		mess.setBounds(30, 160, 446, 68);
		mess.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(64, 64, 64), new Color(192, 192, 192)), "Message", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
//		mess.setBorder(new LineBorder(Color.GRAY, 1, false));
		getContentPane().add(mess);

		lblNewLabel_3 = new JLabel("登録できる投入口を選択");
		lblNewLabel_3.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		lblNewLabel_3.setBounds(288, 22, 172, 26);
		getContentPane().add(lblNewLabel_3);


		tonyuguti = new Choice();
		tonyuguti.setFont(new Font("Dialog", Font.BOLD, 14));
		tonyuguti.setBounds(298, 54, 109, 24);
		getContentPane().add(tonyuguti);

		JButton btnNewButton = new JButton("登録");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkTo==0) {
					mess.setText("エラー\n現在開けている投入口がありません\\nどの商品かを削除してください。");
				}else {
					String syohinmei=name.getText();
					String str=nedan.getText();
					if(syohinmei.isEmpty()==true||str.isEmpty()==true) {
						mess.setText("入力箇所があります\nすべてを入力してください。");
					}else {
						int number=0;
						try{
							number = Integer.parseInt(str);
							System.out.println(number);
						}
						catch (NumberFormatException ex){
							ex.printStackTrace();
							number=-1;
						}
						int a=sa.checkSyohinmei(syohinmei);
						if(a==1) {
							mess.setText("この商品はすでに登録されました\n違う名前で登録してください。");
						}else if(a==0) {
							if(number==-1||number>=1990||number<=0) {
								mess.setText(error.ERwrong10());
							}else {
								int id=Integer.parseInt(tonyuguti.getItem(tonyuguti.getSelectedIndex()));
								int i=sa.toroku(id,syohinmei,number);
								if(i==1) {
								mess.setText("商品を登録できました。");}
								else {
									mess.setText("登録できませんでした");
								}
							}
						}
					}
				}
			}
		});
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setFont(new Font("MS UI Gothic", Font.PLAIN, 17));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(267, 106, 91, 40);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("キャンセル");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(372, 106, 104, 40);
		getContentPane().add(btnNewButton_1);

		sa.zaiko();
		int[] num = new int[12];
		int[] check = new int[12];
		for(int j=0;j<12;j++) {
			num[j]=j+1;
			check[j]=0;
		}
		for(int i=0;i<sa.listSyohin.size();i++) {
			System.out.print(Integer.toString(sa.listSyohin.get(i).getTonyuguti()));
			for(int j=0;j<12;j++) {
				if(sa.listSyohin.get(i).getTonyuguti()==num[j]) {
					check[j]=1;
				}
			}
			
		}
		for(int j=0;j<12;j++) {
			if(check[j]==0) {
				this.tonyuguti.add(Integer.toString(num[j]));
				checkTo=1;
			}
			
		}
		if(checkTo==0) {
			mess.setText("現在開けている投入口がありません\nどの商品かを削除してください。");
		}


	}
}
