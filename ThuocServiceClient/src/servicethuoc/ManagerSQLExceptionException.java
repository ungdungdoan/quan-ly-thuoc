
/**
 * ManagerSQLExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package servicethuoc;

public class ManagerSQLExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1478014375738L;
    
    private servicethuoc.ManagerStub.ManagerSQLException faultMessage;

    
        public ManagerSQLExceptionException() {
            super("ManagerSQLExceptionException");
        }

        public ManagerSQLExceptionException(java.lang.String s) {
           super(s);
        }

        public ManagerSQLExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ManagerSQLExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(servicethuoc.ManagerStub.ManagerSQLException msg){
       faultMessage = msg;
    }
    
    public servicethuoc.ManagerStub.ManagerSQLException getFaultMessage(){
       return faultMessage;
    }
}
    