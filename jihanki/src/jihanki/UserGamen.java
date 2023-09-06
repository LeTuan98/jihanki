package jihanki;


import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class UserGamen extends JFrame {

	private JPanel contentPane;
	List<Syohin> listSyohin = new ArrayList<>();// syohin　マスタ
	List<MyButton> listButton = new ArrayList<>();
	List<JLabel> listLabel = new ArrayList<>();
	int tonyu;
	int turi;
	RemoteMoney remoteMoney=new RemoteMoney();
	LocalMoney localMoney= new LocalMoney();
	TuriMoney turiC;
	DbCon db= new DbCon();
	Connection con = null;
	PreparedStatement pstmt = null;
	Statement stm;
	ResultSet rs = null;
	String sql;
	/**
	 * Launch the application.
	 */
	//button setting
	JButton jyuBt;// お金のボタン一覧
	JButton gojyuBt;
	JButton hyakuBt;
	JButton gohyakuBt;
	JButton senBt;
	JButton kanriBt;
	JButton henkyakuBt;
	JLabel tonyuLable;
	JTextArea mesegeLable;
	JScrollPane scroll; 
//	JPanel panel;

	public UserGamen(String name) {
		super(name);
		setType(Type.UTILITY);
		tonyu=0;
		turi=0;
		this.setMasterSyohin();// 商品マスタを格納
	
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 488);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		hyakuBt = new JButton("100");
		hyakuBt.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		hyakuBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=tonyu;
				a+=100;
				if(checktonyu(a,100)==0) {					
					tonyu+=100;
					localMoney.setHyaku(+1);
					changeTonyu(tonyu);
				}
			}
		});
		hyakuBt.setBounds(537, 370, 64, 21);
		contentPane.add(hyakuBt);
		
		gohyakuBt = new JButton("500");
		gohyakuBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=tonyu;
				a+=500;
				if(checktonyu(a,500)==0) {					
					tonyu+=500;
					localMoney.setGohyaku(+1);
					changeTonyu(tonyu);
				}
			}
		});
		gohyakuBt.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		gohyakuBt.setBounds(514, 409, 87, 21);
		contentPane.add(gohyakuBt);
		
		gojyuBt = new JButton("50");
		gojyuBt.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		gojyuBt.setBounds(465, 370, 62, 21);
		contentPane.add(gojyuBt);
		gojyuBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=tonyu;
				a+=50;
				if(checktonyu(a,50)==0) {					
					tonyu+=50;
					localMoney.setGojyu(+1);
					changeTonyu(tonyu);
				}
			}
		});
		
		jyuBt = new JButton("10");
		jyuBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=tonyu;
				a+=10;
				if(checktonyu(a,10)==0) {					
					tonyu+=10;
					localMoney.setJyu(+1);
					changeTonyu(tonyu);
				}
			}
		});
		jyuBt.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		jyuBt.setBounds(388, 370, 64, 21);
		contentPane.add(jyuBt);
		
		senBt = new JButton("1000");
		senBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=tonyu;
				a+=1000;
				if(checktonyu(a,1000)==0) {					
					tonyu+=1000;
					localMoney.setSen(+1);
					changeTonyu(tonyu);
				}
			}
		});
		senBt.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		senBt.setBounds(388, 409, 87, 21);
		contentPane.add(senBt);
		
		kanriBt = new JButton("管理");
		kanriBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Login frame = new Login("login windows");
					frame.setVisible(true);
				} catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		kanriBt.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		kanriBt.setBounds(270, 370, 87, 21);
		contentPane.add(kanriBt);
		
		henkyakuBt = new JButton("返却");
		henkyakuBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				henkyakuBtPush();
			}
		});
		henkyakuBt.setFont(new Font("MS UI Gothic", Font.BOLD, 14));
		henkyakuBt.setBounds(270, 409, 87, 21);
		contentPane.add(henkyakuBt);
		
		tonyuLable = new JLabel("0  円");
		tonyuLable.setForeground(Color.WHITE);
		tonyuLable.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		tonyuLable.setBounds(113, 348, 81, 32);
		contentPane.add(tonyuLable);
		
		mesegeLable = new JTextArea();
		mesegeLable.setBounds(10, 381, 250, 70);
//		JScrollPane sc=new JScrollPane(mesegeLable);
//		contentPane.add(mesegeLable);
		
		scroll= new JScrollPane(mesegeLable);
		scroll.setBounds(10, 381, 250, 70);
		contentPane.add(scroll);
		
		lblNewLabel = new JLabel("投入金額：");
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		lblNewLabel.setBounds(25, 348, 81, 32);
		contentPane.add(lblNewLabel);
		
		this.veiwsyohin();
		
	}
	public void setMasterSyohin() {// syouhin master データベースから商品のデータを読み込み
		 sql = "select name,nedan,s.id as tonyuguti,zansu from syohin as s,zaiko as z where s.id=z.id;";
		try {
			// 接続
			con = DriverManager.getConnection(db.adress,db.useName,db.passWord);
			// パラメータ付きSQL文をDBに送るためのオブジェクト生成
			pstmt = con.prepareStatement(sql);
			// SQL文の実行(データ取得)
			rs = pstmt.executeQuery();

			// データ取得したレコードの表示
			while (rs.next()) { //
				String name=rs.getString("name");
				int nedan=rs.getInt("nedan");
				int tonyuguti=rs.getInt("tonyuguti");
				int zansu=rs.getInt("zansu");
				Syohin syo=new Syohin(name);
				syo.setNedan(nedan);
				syo.setTonyuguti(tonyuguti);
				syo.setZaiko(zansu);
				listSyohin.add(syo);
			}

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
	int x=37;
	int y=100;
	int y1=40;
	int x1=25;
	private JLabel lblNewLabel;
	public void veiwsyohin() {//商品を購入するボタンを表示メソッド
		for(int i=0;i<listSyohin.size();i++) {
//			String name="syohin"+Integer.toString(i+1);
			MyButton button= new MyButton(Integer.toString(listSyohin.get(i).getNedan()));
//			button.setText(Integer.toString(button.getNedan()));
			button.syohin=listSyohin.get(i);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(button.syohin.getZaiko()>0) {
						if(tonyu>=button.syohin.getNedan()) {
							String str=konyu(button.syohin.getNedan(),button.syohin.getName(),button.syohin.getZaiko(),button.syohin.getTonyuguti());
							mesegeLable.setText(mesegeLable.getText()+str);
						}else {
							mesegeLable.setText(mesegeLable.getText()+"お金が足りません。\nもっと投入してください。\n");
						}}else {
							String str="在庫がありません\n";
							mesegeLable.setText(mesegeLable.getText()+str);
						}
				}
			});
			listButton.add(button);//ボタンと商品名のスタイルをデザイン
			listLabel.add(new JLabel(listSyohin.get(i).getName()));
			listButton.get(i).setBounds(x, y, 66, 21);
			listLabel.get(i).setBounds(x1, y1, 90, 89);
			listLabel.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			listLabel.get(i).setFont(new Font("MS UI Gothic", Font.BOLD, 13));
			listLabel.get(i).setBackground(new Color(128, 128, 128));
			listLabel.get(i).setForeground(Color.WHITE);
			if(listSyohin.get(i).getZaiko()==0) {
				listButton.get(i).setBackground(Color.RED);
			}
			x+=150;
			x1+=150;
			if(i==3) {
				x=37;
				x1=25;
				y+=70;
				y1+=70;
			}else if(i==7) {
				x=37;
				x1=25;
				y+=70;
				y1+=70;
			}
			contentPane.add(listButton.get(i));//ボタンを画面に追加
			contentPane.add(listLabel.get(i));
		}
	}
	public void changeTonyu(int tonyu) {//投入金額を表示するためのメソッド
		String str=Integer.toString(tonyu)+" 　円";
		tonyuLable.setText(str);
	}
	public int checktonyu(int tonyu,int turi) {//1990えん以上投入したときのメッセージ
		if(tonyu>1990) {
			this.mesegeLable.setText(this.mesegeLable.getText()+"投入の上限は１９９０円です。\n");
			this.mesegeLable.setText(this.mesegeLable.getText()+turi+"円を返却します。\n");
			return 1;
		}
		else return 0;
	}
	public String konyu(int nedan,String name,int zansu,int id) {//購入できる時の処理
		turi=tonyu-nedan;//お釣り計算
		String str="";
		if(turi==0) {//お釣りがない場合
			remoteMoney.setJyu(localMoney.getJyu());
			remoteMoney.setGojyu(localMoney.getGojyu());
			remoteMoney.setHyaku(localMoney.getHyaku());
			remoteMoney.setGohyaku(localMoney.getGohyaku());
			remoteMoney.setSen(localMoney.getSen());
			remoteMoney.update();//ここまで投入金額をデータベースを反映するための処理
			str=name+"を購入できました。\n";
			str+="お釣りはありません。\n";
			resetData(id,zansu-1);
			this.rireki(name,tonyu,turi);
			tonyu=0;
			localMoney.reset();
			changeTonyu(tonyu);
		}else {//ある場合
			turiC=new TuriMoney(turi);
			remoteMoney.setJyu(localMoney.getJyu());
			remoteMoney.setGojyu(localMoney.getGojyu());
			remoteMoney.setHyaku(localMoney.getHyaku());
			remoteMoney.setGohyaku(localMoney.getGohyaku());
			remoteMoney.setSen(localMoney.getSen());
			
			int check=1;
			while(check!=0) {
				if(turiC.getSen()<=remoteMoney.getSen()) {
					if(turiC.getGohyaku()<=remoteMoney.getGohyaku()) {
						if(turiC.getHyaku()<=remoteMoney.getHyaku()) {
							if(turiC.getGojyu()<=remoteMoney.getGojyu()) {
								if(turiC.getJyu()<=remoteMoney.getJyu()) {
									check=0;
									henkyaku();//お釣り計算と返却
									str=name+"を購入できました\n";
									str+="お釣りは"+turi+"円です\n";
									str+=turiC.veiw();
									System.out.println(str);
									turiC.reset();
									this.rireki(name,tonyu,turi);
									resetData(id,zansu-1);
									turi=0;
									tonyu=0;
									localMoney.reset();
									changeTonyu(tonyu);
								}else {
									str="現在お釣りが足りないため,\n投入金額をすべて返却します。\n本当に申し訳ございません。\n";
									this.mesegeLable.setText(this.mesegeLable.getText()+str);
									str="";
									remoteMoney.setJyu(-localMoney.getJyu());
									remoteMoney.setGojyu(-localMoney.getGojyu());
									remoteMoney.setHyaku(-localMoney.getHyaku());
									remoteMoney.setGohyaku(-localMoney.getGohyaku());
									remoteMoney.setSen(-localMoney.getSen());
									henkyakuBtPush();
									turiC.reset();
									turi=0;
									check=0;
								}
							}else {
								turiC.setGojyu(-1);
								turiC.setJyu(+5);
							}
						}else {
							turiC.setHyaku(-1);
							turiC.setGojyu(+2);
						}
					}else {
						turiC.setGohyaku(-1);
						turiC.setHyaku(+5);
					}
				}else {
					turiC.setSen(-1);
					turiC.setGohyaku(+2);
				}
			}
		}
		
		
		return str;
			
	}
	public void henkyaku() {//購入後、databesu　を更新
		remoteMoney.setJyu(-turiC.getJyu());
		remoteMoney.setGojyu(-turiC.getGojyu());
		remoteMoney.setHyaku(-turiC.getHyaku());
		remoteMoney.setGohyaku(-turiC.getGohyaku());
		remoteMoney.setSen(-turiC.getSen());
		remoteMoney.update();
	}
	public void henkyakuBtPush() {
		String str1=tonyu+"円を返却します。\n";
		String str=localMoney.veiw();
		this.mesegeLable.setText(this.mesegeLable.getText()+str1+str);
		tonyu=0;
		localMoney.reset();
		changeTonyu(tonyu);
	}
	public void resetData(int id,int zansu) {
		sql ="UPDATE zaiko SET zansu="+zansu+ " WHERE id= "+id;
//		System.out.println(sql);
		try {
			// 接続
			con = DriverManager.getConnection(db.adress,db.useName,db.passWord);
			// パラメータ付きSQL文をDBに送るためのオブジェクト生成
			stm=con.createStatement();
			stm.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (stm != null) {
					stm.close();
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
		for(int i=0;i<listButton.size();i++) {
			if(listButton.get(i).syohin.getTonyuguti()==id) {
				listButton.get(i).syohin.setZaiko(zansu);
				if(zansu==0) {
					listButton.get(i).setBackground(Color.RED);
				}
			}
		}
	}
	private void rireki(String name,int push,int turi) {
		sql ="INSERT INTO `rireki`(name, push,turi) VALUES ('"+name+"',"+push+","+turi+")";
//		System.out.println(sql);
		try {
			// 接続
			con = DriverManager.getConnection(db.adress,db.useName,db.passWord);
			// パラメータ付きSQL文をDBに送るためのオブジェクト生成
			stm=con.createStatement();
			stm.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (stm != null) {
					stm.close();
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
