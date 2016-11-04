
/**
 * ManagerCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package servicethuoc;

    /**
     *  ManagerCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ManagerCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ManagerCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ManagerCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for deleteThuoc method
            * override this method for handling normal response from deleteThuoc operation
            */
           public void receiveResultdeleteThuoc(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteThuoc operation
           */
            public void receiveErrordeleteThuoc(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateThuoc method
            * override this method for handling normal response from updateThuoc operation
            */
           public void receiveResultupdateThuoc(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateThuoc operation
           */
            public void receiveErrorupdateThuoc(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for detroy method
            * override this method for handling normal response from detroy operation
            */
           public void receiveResultdetroy(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from detroy operation
           */
            public void receiveErrordetroy(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addThuoc method
            * override this method for handling normal response from addThuoc operation
            */
           public void receiveResultaddThuoc(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addThuoc operation
           */
            public void receiveErroraddThuoc(java.lang.Exception e) {
            }
                


    }
    