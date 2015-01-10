
public class ErrorHandling extends Exception {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private String error;
	
	public ErrorHandling(String error){
		this.error = error;
	}
	
	@Override
	public String toString(){
		return error;
	}
}
