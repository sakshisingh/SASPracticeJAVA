package interviewPrograms;

//Final as this class cannot be subclassed.
public final class MySingleton {
	private static MySingleton instance = null;
	
	private MySingleton() {
		// To ensure that no class can create an object.
		//Since constructor is private, this class cannot be sub-classed
	}
	
	public static MySingleton getInstance() {
		if(instance==null)
			instance=new MySingleton();
		return instance;
	}
	
	//Ensure that new object is not created via cloning
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
