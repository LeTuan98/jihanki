package jihanki;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class KanriGamen extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public KanriGamen(String name) {//コンストラクタ、管理画面の実装
		super(name);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 579, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton syohinBt = new JButton("商品");
		syohinBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ShohinGamen frame = new ShohinGamen("商品画面");
					frame.setVisible(true);
				} catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		syohinBt.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		syohinBt.setBounds(109, 84, 118, 41);
		panel.add(syohinBt);
		
		JButton hojyuBt = new JButton("補充");
		hojyuBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HojyuGamen frame = new HojyuGamen("補充画面");
					frame.setVisible(true);
				} catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		hojyuBt.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		hojyuBt.setBounds(324, 84, 118, 41);
		panel.add(hojyuBt);
		
		JButton zaikoBt = new JButton("在庫");
		zaikoBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ZaikoGamen frame = new ZaikoGamen("在庫画面");
					frame.setVisible(true); 
				} catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		zaikoBt.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		zaikoBt.setBounds(109, 189, 91, 41);
		panel.add(zaikoBt);
		
		JButton seteiBt = new JButton("設定");
		seteiBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				LoginChange loginchange = new LoginChange("id and password change");
					loginchange.setVisible(true);
				} catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		seteiBt.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		seteiBt.setBounds(351, 189, 91, 41);
		panel.add(seteiBt);
		
		JButton uriageBt = new JButton("売上");
		uriageBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UriageGamen frame = new UriageGamen("売上管理");
					frame.setVisible(true);
				} catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		uriageBt.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		uriageBt.setBounds(228, 189, 91, 41);
		panel.add(uriageBt);
	}
}
