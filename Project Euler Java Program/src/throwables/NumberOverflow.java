package throwables;

public class NumberOverflow extends Exception {
	static final long serialVersionUID = -3387516993124229948L;
	
	public NumberOverflow() {
		super();
	}
	
	public NumberOverflow(String message) {
		super(message);
	}

}
