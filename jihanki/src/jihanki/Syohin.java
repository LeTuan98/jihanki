package jihanki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Syohin {

	private String name;
	private int nedan;
	private int tonyuguti;
	private int zaiko;
	DbCon db = new DbCon();
	Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = "";
    public Syohin(String name) {
    	this.name=name;
    }
	public String getName()  //このまま同じ
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setUpDbName()
	{
		//DBにアップロードする
		sql = "UPDATE syohin set name = '" + name + "' where id = " + tonyuguti ; //SQLの命令文を書く
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
	public void getDbDate(String name)
	{
		//DBにアップロードする
		sql = "select s.id as tonyuguti,nedan,zansu from syohin as s,zaiko as z where s.id=z.id and name='"+name+"'"; //SQLの命令文を書く
		//DBを更新する、まだ書かない
		try {
            // 接続
            con = DriverManager.getConnection(db.adress,db.useName,db.passWord);
            // パラメータ付きSQL文をDBに送るためのオブジェクト生成
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
			while (rs.next()) {
				this.setNedan(rs.getInt("nedan"));
				this.setTonyuguti(rs.getInt("tonyuguti"));
				this.setZaiko(rs.getInt("zansu"));
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


	public int getNedan()
	{
		return this.nedan;
	}

	public void setNedan(int nedan)
	{
		this.nedan = nedan;
	}

	public void setUpDbNedan()
	{
		//DBにアップロードする
		sql = "UPDATE syohin set nedan = " + nedan + " Where id = " + tonyuguti ; //SQLの命令文を書く
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

	public int getTonyuguti()
	{
		return this.tonyuguti;
	}

	public void setTonyuguti(int tonyuguti)
	{
		this.tonyuguti = tonyuguti;
	}

	public void setUpDbTonyuguti()
	{
		//DBにアップロードする
		sql = "UPDATE syohin set id = " + tonyuguti + " Where name = '" + name + "'" ; //SQLの命令文を書く
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

	public int getZaiko()
	{
		return this.zaiko;
	}

	public void setZaiko(int zaiko)
	{
		this.zaiko = zaiko;
	}

	public void setUpDbZaiko()
	{
		//DBにアップロードする
		sql = "UPDATE zaiko set zansu = " + zaiko + " Where id = " + tonyuguti ; //SQLの命令文を書く
		//DBを更新する、まだ書かない
		System.out.println(sql);
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
//	public void setUpDbZaiko(String name)
//	{
//		//DBにアップロードする
//		sql = "UPDATE zaiko = " + zaiko + "WEHRE = '" + name+"'" ; //SQLの命令文を書く
//		//DBを更新する、まだ書かない
//		try {
//            // 接続
//            con = DriverManager.getConnection(db.adress,db.useName,db.passWord);
//            // パラメータ付きSQL文をDBに送るためのオブジェクト生成
//            pstmt = con.prepareStatement(sql);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//            try {
//                if (pstmt != null) {
//                    pstmt.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//            try {
//                if (con != null) {
//                    con.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//	}

	public void updateAll()
	{
		//すべて？をDBにアップロードする
		setUpDbName();
		setUpDbNedan();
		setUpDbTonyuguti();
		setUpDbZaiko();
	}
}
