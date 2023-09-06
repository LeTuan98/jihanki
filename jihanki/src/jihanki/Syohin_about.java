package jihanki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Syohin_about {
	DbCon db = new DbCon();//データベース接続
	List<Syohin> listSyohin = new ArrayList<>();
	List<Syohin> listSyohinA = new ArrayList<>();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql;
	public int uriageSyouhinGoto(String syohinmei){
		try {
			sql = "SELECT name ,SUM(push-turi) AS uriage from rireki WHERE name=\""+syohinmei+"\";";
			// 接続
			con = DriverManager.getConnection(db.adress,db.useName,db.passWord);
			// パラメータ付きSQL文をDBに送るためのオブジェクト生成
			pstmt = con.prepareStatement(sql);
			// SQL文の実行(データ取得)
			rs = pstmt.executeQuery();
			int a=-1;
			while (rs.next()) {
				a=rs.getInt("uriage");
			}
			return a;

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
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
					return -2;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return -2;
			}
		}
	}
	public int uriageMonth(int month) {
		String str="2022/"+month+"/01";
		String str1="2022/"+(month+1)+"/01";
		try {
			sql = "SELECT SUM(push-turi) AS uriage from rireki WHERE time>=\""+str+"\"AND time<\""+str1+"\";";
			System.out.println(sql);
			// 接続
			con = DriverManager.getConnection(db.adress,db.useName,db.passWord);
			// パラメータ付きSQL文をDBに送るためのオブジェクト生成
			pstmt = con.prepareStatement(sql);
			// SQL文の実行(データ取得)
			rs = pstmt.executeQuery();
			int a=0;
			while (rs.next()) {
				a=rs.getInt("uriage");
			}
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
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
				return -2;
			}
		}
	}
	public int uriageSyohinMonth(String syohinmei,int month) {
		String str="2022/"+month+"/01";
		String str1="2022/"+(month+1)+"/01";
		try {
			sql = "SELECT SUM(push-turi) AS uriage from rireki WHERE time>=\""+str+"\"AND time<\""+str1+"\"and name=\""+syohinmei+"\";";
			System.out.println(sql);
			// 接続
			con = DriverManager.getConnection(db.adress,db.useName,db.passWord);
			// パラメータ付きSQL文をDBに送るためのオブジェクト生成
			pstmt = con.prepareStatement(sql);
			// SQL文の実行(データ取得)
			rs = pstmt.executeQuery();
			int a=0;
			while (rs.next()) {
				a=rs.getInt("uriage");
			}
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
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
				return -2;
			}
		}
	}
	public int uriageSyohinYear(String syohinmei) {
		try {
			sql = "SELECT SUM(push-turi) AS uriage from rireki WHERE time>='2022/01/01'and time<='2022/12/31' and name='"+syohinmei+"';";
			System.out.println(sql);
			// 接続
			con = DriverManager.getConnection(db.adress,db.useName,db.passWord);
			// パラメータ付きSQL文をDBに送るためのオブジェクト生成
			pstmt = con.prepareStatement(sql);
			// SQL文の実行(データ取得)
			rs = pstmt.executeQuery();
			int a=0;
			while (rs.next()) {
				a=rs.getInt("uriage");
			}
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
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
				return -2;
			}
		}
	}
	public int uriage(){
		try {
			sql = "SELECT SUM(push-turi) AS uriage from rireki WHERE time>='2022/01/01'and time<='2022/12/31'";
			System.out.println(sql);
			// 接続
			con = DriverManager.getConnection(db.adress,db.useName,db.passWord);
			// パラメータ付きSQL文をDBに送るためのオブジェクト生成
			pstmt = con.prepareStatement(sql);
			// SQL文の実行(データ取得)
			rs = pstmt.executeQuery();
			int a=0;
			while (rs.next()) {
				a=rs.getInt("uriage");
			}
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
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
				return -2;
			}
		}
	}
	public int checkSyohinmei(String syohinmei) {
		try {
			sql = "SELECT name from syohin";
			// 接続
			con = DriverManager.getConnection(db.adress,db.useName,db.passWord);
			// パラメータ付きSQL文をDBに送るためのオブジェクト生成
			pstmt = con.prepareStatement(sql);
			// SQL文の実行(データ取得)
			rs = pstmt.executeQuery();
			int check=0;
			while (rs.next()) {
				String name=rs.getString("name");
				if(name.equals(syohinmei)) {
					check=1;
				}
			}
			return check;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
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
	public void zaiko() {
		this.listSyohin.removeAll(listSyohin);
		try {
			sql = "SELECT s.id ,name, zansu from syohin as s,zaiko as z where s.id=z.id;";
			// 接続
			con = DriverManager.getConnection(db.adress,db.useName,db.passWord);
			// パラメータ付きSQL文をDBに送るためのオブジェクト生成
			pstmt = con.prepareStatement(sql);
			// SQL文の実行(データ取得)
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String name=rs.getString("name");
				int zansu=rs.getInt("zansu");
				Syohin syohin=new Syohin(name);
				syohin.setZaiko(zansu);
				int id=rs.getInt("id");
				syohin.setTonyuguti(id);
				this.listSyohin.add(syohin);
				
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
	public void zaiko(int a) {
		this.listSyohinA.removeAll(listSyohinA);
		try {
			sql = "SELECT s.id,name, zansu from syohin as s,zaiko as z where s.id=z.id and zansu <="+a+";";
			// 接続
			con = DriverManager.getConnection(db.adress,db.useName,db.passWord);
			// パラメータ付きSQL文をDBに送るためのオブジェクト生成
			pstmt = con.prepareStatement(sql);
			// SQL文の実行(データ取得)
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String name=rs.getString("name");
				int zansu=rs.getInt("zansu");
				int id=rs.getInt("id");
				Syohin syohin=new Syohin(name);
				syohin.setZaiko(zansu);
				syohin.setTonyuguti(id);
				this.listSyohinA.add(syohin);
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
	public int toroku (int id,String name,int nedan) {
		try {
			// 接続
			con = DriverManager.getConnection(db.adress,db.useName,db.passWord);
			sql = "INSERT INTO `syohin`(`id`, `name`, `nedan`) VALUES ("+id+",'"+name+"',"+nedan+");";
			// パラメータ付きSQL文をDBに送るためのオブジェクト生成
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			sql = "INSERT INTO zaiko(id,zansu) VALUES ("+id+",0)";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			return 1;
			// SQL文の実行(データ取得)
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {

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
//	zaiko(int a)
//	zaiko(string syohinmei)
//	delete(string syohinmei)
//	toroku(int a,String syohinmei,int nedan)
}
