/**
 * This class is used for the demo on learning Eclipse.
 * @author Antonio Contreras
 *
 */
public class RossInts {
	int rossInt;
	
	public RossInts(int i) {
		put(i);
	}
	
	void put (int s) {
		rossInt = s * 10;
	}
	
	/**
	 * 
	 * @return
	 */
	int  get() {
		return rossInt;
	}
	public static void main(String[] args) {
		RossInts x = new RossInts(2);
		int num = x.get();
		System.out.println(num);
	}

}
