package jihanki;

public class TuriMoney extends Money{

	private int turi;


	public TuriMoney(int turi){
		this.turi = turi;
		sen(this.turi);
	}

	public void jyu(int local){

			setJyu(local/10);
		
	}


	public void gojyu(int local){

		if(local%50==0){
			setGojyu(local/50);
			
		}else{
			setGojyu(local/50);
			jyu(local%50);
		}
	}


	public void hyaku(int local){

		if(local%100==0){
			setHyaku(local/100);
			
		}else{
			setHyaku(local/100);
			gojyu(local%100);
		}
	}


	public void gohyaku(int local){

		if(local%500==0){
			setGohyaku(local/500);
		
		}else{
			setGohyaku(local/500);
			hyaku(local%500);
		}
	}


	public void sen(int local){

		if(local%1000==0){
			setSen(local/1000);
		
		}else{
			setSen(local/1000);
			gohyaku(local%1000);
		}
	}
}
