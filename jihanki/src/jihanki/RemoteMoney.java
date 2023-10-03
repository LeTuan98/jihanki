package jihanki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//データベースのお金の実装
public class RemoteMoney extends Money{
	public RemoteMoney(){
		setData();
	}

	DbCon db = new DbCon();
	Connection con = null;
	PreparedStatement pstmt = null;
	Statement stm=null;
	ResultSet rs = null;
	String sql = "select * from money_about";
	private  void setData(){
		try {
			// 接続
			con = DriverManager.getConnection(db.adress,db.useName,db.passWord);
			// パラメータ付きSQL文をDBに送るためのオブジェクト生成
			pstmt = con.prepareStatement(sql);
			// SQL文の実行(データ取得)
			rs = pstmt.executeQuery();

			// データ取得したレコードの表示
			while (rs.next()) {
				switch(rs.getInt("id")){//データベースの残数をローカルに更新

				case 1: setJyu(rs.getInt("zansu"));
				break ;
				case 2: setGojyu(rs.getInt("zansu"));
				break ;
				case 3: setHyaku(rs.getInt("zansu"));
				break ;
				case 4: setGohyaku(rs.getInt("zansu"));
				break ;
				case 5: setSen(rs.getInt("zansu"));
				break ;
				}
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
	public void update(){
		for(int i=1;i<6;i++){
			int zansu=0;
			switch(i){//データベースの残数をローカルに更新

			case 1: zansu=getJyu();
			break ;
			case 2: zansu=getGojyu();
			break ;
			case 3: zansu=getHyaku();
			break ;
			case 4: zansu=getGohyaku();
			break ;
			case 5: zansu=getSen();
			break ;
			}
			sql ="UPDATE money_about SET zansu="+zansu+ " WHERE id = "+i;
//			System.out.println(sql);
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

}
