package jihanki;

public class Error
{
	public String ER1()
	{
		return "ただいまシステムを停止しています。\n";
	}

	public String ER2()
	{
		return "ただいま指定機能サービスを停止しています。\n";
	}

	public String ER3()
	{
		return "データベースに接続できません。\n";
	}

	public String ERst1()
	{
		return "商品の在庫がありません。\n";
	}

	public String ERst2()
	{
		return "釣銭の枚数が足りていません。\n";
	}

	public String ERpay1()
	{
		return "入金が確認できませんでした。\n";
	}

	public String ERfill1()
	{
		return "お釣りを補充して下さい。\n";
	}

	public String ERfill2()
	{
		return "商品補充して下さい。\n";
	}

	public String ERwrong1()
	{
		return "商品名が不明です。\n";
	}

	public String ERwrong2()
	{
		return "IDかパスワードが間違っています。\n";
	}

	public String ERwrong3()
	{
		return "その数値は入力できません。\n";
	}

	public String ERwrong4()
	{
		return "51以上の在庫は追加されません。\n";
	}

	public String ERwrong5()
	{
		return "51枚以上の釣銭は追加されません。\n";
	}

	public String ERwrong6()
	{
		return "商品名に51文字以上の名前は使えません。\n";
	}

	public String ERwrong7()
	{
		return "IDは任意文字列の後に@meitec-grp.comと入力してください\n";
	}

	public String ERwrong8()
	{
		return "パスワードに大文字小文字数字を各1文字以上入れてください\n";
	}
	public String ERwrong9()
	{
		return "値段が不正です。０以上の値段を入力してください。\n";
	}
	public String ERwrong10()
	{
		return "値段が不正です。正確に入力してください。\n";
	}
}

