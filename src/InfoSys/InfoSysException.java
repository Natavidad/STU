package InfoSys;
public class InfoSysException extends Exception{
	  public InfoSysException() {
	    this("InfoSysException");
	  }
	  public InfoSysException(String msg) {
	    super(msg);
	  }
	}
