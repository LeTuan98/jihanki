package jihanki;

//お金の抽象クラス
public 	abstract class Money{

	//フィールド宣言
	private int jyu;
	private int gojyu;
	private int hyaku;
	private int gohyaku;
	private int sen;

	//お金の枚数取得
	public Money() {
		jyu=0;
		gojyu=0;
		hyaku=0;
		gohyaku=0;
		sen=0;
	}
	//10円の枚数を取得
	public int getJyu(){
		return this.jyu;
	}


	//50円の枚数を取得
	public int getGojyu(){
		return this.gojyu;
	}


	//100円の枚数を取得
	public int getHyaku(){
		return this.hyaku;
	}


	//500円の枚数を取得
	public int getGohyaku(){
		return this.gohyaku;
	}


	//1000円の枚数を取得
	public int getSen(){
		return this.sen;
	}


	//お金の枚数を更新

	//10円の枚数を更新
	public void setJyu(int a){

		this.jyu += a;
	}

	//50円の枚数を更新
	public void setGojyu(int a){

		this.gojyu += a;
	}


	//100円の枚数を更新
	public void setHyaku(int a){

		this.hyaku += a;
	}

	//500円の枚数を更新
	public void setGohyaku(int a){

		this.gohyaku += a;
	}

	//1000円の枚数を更新
	public void setSen(int a){

		this.sen += a;
	}
	public void reset() {
		this.gohyaku=0;
		this.gojyu=0;
		this.sen=0;
		this.jyu=0;
		this.hyaku=0;
	}
	public String veiw() {
		String str="1000円："+Integer.toString(this.getSen())+"枚\n";
		str+=" 500円："+Integer.toString(this.getGohyaku())+"枚\n";
		str+=" 100円："+Integer.toString(this.getHyaku())+"枚\n";
		str+="  50円："+Integer.toString(this.getGojyu())+"枚\n";
		str+="  10円："+Integer.toString(this.getJyu())+"枚\n";
		return str;
	}


}