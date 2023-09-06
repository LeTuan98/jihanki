package jihanki;

public class Main {

	public static void main(String[] args) {
		try {
			UserGamen frame = new UserGamen("自動販売機");
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		try {
//			HenkoGamen frame = new HenkoGamen("コーラ");
//			frame.setVisible(true);
//		} catch (Exception g) {
//			g.printStackTrace();
//		}
	}

}
