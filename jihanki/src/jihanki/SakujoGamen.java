package jihanki;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class SakujoGamen extends JFrame {
	JTextPane mess;
	Syohin syohin;
	DbCon db = new DbCon();
	Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = "";
	SakujoGamen(String name){
		syohin=new Syohin(name);
		syohin.getDbDate(name);
		setTitle("商品削除");
		getContentPane().setBackground(Color.WHITE);
		setTitle("商品削除");
		setBounds( 300, 300, 497, 351);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


		//フォントの設定
		setFont(new Font("MS UI Gothic", Font.BOLD, 17));
		//背景色
		setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);

		JTextPane genzaiName = new JTextPane();
		genzaiName.setText(name);
		genzaiName.setBounds(48, 48, 134, 26);
		genzaiName.setBorder(new LineBorder(Color.GRAY, 1, false));
		getContentPane().add(genzaiName);

		JTextPane genzaiId = new JTextPane();
		genzaiId.setBounds(283, 48, 134, 26);
		genzaiId.setText(Integer.toString(syohin.getTonyuguti()));
		genzaiId.setBorder(new LineBorder(Color.GRAY, 1, false));
		getContentPane().add(genzaiId);

		JLabel lblNewLabel = new JLabel("現在の商品名");
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		lblNewLabel.setBounds(48, 10, 115, 28);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("該当商品の投入口");
		lblNewLabel_1.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		lblNewLabel_1.setBounds(283, 10, 134, 28);
		getContentPane().add(lblNewLabel_1);

		JTextPane genzaiNedan = new JTextPane();
		genzaiNedan.setText(Integer.toString(syohin.getNedan()));
		genzaiNedan.setBounds(48, 128, 134, 26);
		genzaiNedan.setBorder(new LineBorder(Color.GRAY, 1, false));
		getContentPane().add(genzaiNedan);

		JLabel lblNewLabel_2 = new JLabel("該当商品の値段");
		lblNewLabel_2.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		lblNewLabel_2.setBounds(48, 90, 115, 28);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("円");
		lblNewLabel_2_1.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(194, 128, 24, 28);
		getContentPane().add(lblNewLabel_2_1);

		JButton SakujoButton = new JButton("削除");
		SakujoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sakujo();
				mess.setText("削除できました。");
			}
		});
		SakujoButton.setFont(new Font("MS UI Gothic", Font.PLAIN, 16));
		SakujoButton.setForeground(Color.RED);
		SakujoButton.setBounds(248, 117, 80, 37);
		getContentPane().add(SakujoButton);

		JButton CButton = new JButton("キャンセル");
		CButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		CButton.setBounds(357, 117, 80, 37);
		getContentPane().add(CButton);

		mess = new JTextPane();
		mess.setForeground(Color.GREEN);
		mess.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(64, 64, 64), new Color(192, 192, 192)), "Message", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		mess.setBounds(44, 180, 393, 108);
		mess.setEditable(false);
		getContentPane().add(mess);


	}
	public void sakujo() {
		sql = "delete from syohin where id="+syohin.getTonyuguti() ; //SQLの命令文を書く
		System.out.println(sql);
		//DBを更新する、まだ書かない
		try {
            // 接続
            con = DriverManager.getConnection(db.adress,db.useName,db.passWord);
            // パラメータ付きSQL文をDBに送るためのオブジェクト生成
            pstmt = con.prepareStatement(sql);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
}
