package jihanki;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Kanri {

	private String id;
	private String pass;
	private String furiId;
	DbCon db = new DbCon();//データベース接続
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql;
    
	public Kanri()
	{
		this.id="";
		readLoginAbout();//database からid and pass　を読み込み
		furiId=id;
	
	}

	public String getId()
	{
		//idをとる
		return this.id;
	}

	public void setId(String id)
	{
		//idを変える
		this.furiId=this.id;
		this.id = id;
	}

	public String getPass()
	{
		//パスワードをとる
		return this.pass;
	}

	public void setPass(String pass)
	{
		this.pass = pass;
	}

	public int checkId(String id)
	{
		String[] strArray = id.split("");
		String check="@meitec-grp.com";
		String str="";
		int a=0;
		for(String s : strArray) {
//			System.out.println(s);
			if(s.equals("@")) {
				a=1;
			}
			if(a==1) {
				str+=s;
			}
		}
		if(str.equals(check)) {
			return 1;	
		}else {
			return -1;
		}
	}

	public int checkPass(String pass)
	{
		int omoji=0;
		int komoji=0;
		int suji=0;
		for(int i=0;i<pass.length();i++) {
			char ccc = pass.charAt(i);
//			System.out.println(s);
			if(Character.isLowerCase(ccc) == true) {
				komoji=1;
			}else if(Character.isUpperCase(ccc) == true) {
				omoji=1;
			}else if(Character.isDigit(ccc)==true) {
				suji=1;
			}
			
			
		}
		if((omoji==1&&komoji==1)&&suji==1) {
			return 1;
		}else {
			return -1;
		}
	}

	public void readLoginAbout() {
		try {
			sql = "select * from login";
			// 接続
			con = DriverManager.getConnection(db.adress,db.useName,db.passWord);
			// パラメータ付きSQL文をDBに送るためのオブジェクト生成
			pstmt = con.prepareStatement(sql);
			// SQL文の実行(データ取得)
			rs = pstmt.executeQuery();
			while (rs.next()) {
				this.setId(rs.getString("id"));
				this.setPass(rs.getString("password"));
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

	public void upLoginAbout()
	{
		try {
			// 接続
			sql="UPDATE login SET id='"+id+"',password='"+pass+"' WHERE id='"+furiId+"'";
//			System.out.println(sql);
			con = DriverManager.getConnection(db.adress,db.useName,db.passWord);
			// パラメータ付きSQL文をDBに送るためのオブジェクト生成
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		

		} catch (SQLException e) {
			e.printStackTrace();
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
	

}