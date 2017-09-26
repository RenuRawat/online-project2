package com.collaborate.Model;

public class Error {
	
	
	int errorCode;
	String errorMessage;
	
	
	public Error() {
		super();
	
	}
	public Error(int errorCode, String errorMessage) {
		
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	
	  /* public static void main(String args[]) {
		      int num[] = {1, 2, 3, 4};
		      System.out.println(num[5]);
		   }
	   */
	/*   
	   try {
		   // Protected code
		}catch(ExceptionType1 e1) {
		   // Catch block
		}catch(ExceptionType2 e2) {
		   // Catch block
		}catch(ExceptionType3 e3) {
		   // Catch block
		}*/
	
	
	 
}
