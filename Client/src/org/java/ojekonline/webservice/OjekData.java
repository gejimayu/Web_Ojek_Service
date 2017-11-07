
package org.java.ojekonline.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "OjekData", targetNamespace = "http://webservice.ojekonline.java.org/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface OjekData {


    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webservice.ojekonline.java.org/OjekData/hideDriverHistoryRequest", output = "http://webservice.ojekonline.java.org/OjekData/hideDriverHistoryResponse")
    public void hideDriverHistory(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservice.ojekonline.java.org/OjekData/validateTokenRequest", output = "http://webservice.ojekonline.java.org/OjekData/validateTokenResponse")
    public boolean validateToken(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns org.java.ojekonline.webservice.Babi
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservice.ojekonline.java.org/OjekData/findDriverRequest", output = "http://webservice.ojekonline.java.org/OjekData/findDriverResponse")
    public Babi findDriver(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservice.ojekonline.java.org/OjekData/getNameUserRequest", output = "http://webservice.ojekonline.java.org/OjekData/getNameUserResponse")
    public String getNameUser(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns org.java.ojekonline.webservice.Babi
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservice.ojekonline.java.org/OjekData/findPrefDriverRequest", output = "http://webservice.ojekonline.java.org/OjekData/findPrefDriverResponse")
    public Babi findPrefDriver(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns org.java.ojekonline.webservice.Babi
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservice.ojekonline.java.org/OjekData/getProfileRequest", output = "http://webservice.ojekonline.java.org/OjekData/getProfileResponse")
    public Babi getProfile(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0,
        @WebParam(name = "arg1", partName = "arg1")
        int arg1);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg6
     */
    @WebMethod
    @Action(input = "http://webservice.ojekonline.java.org/OjekData/insertOrderRequest", output = "http://webservice.ojekonline.java.org/OjekData/insertOrderResponse")
    public void insertOrder(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0,
        @WebParam(name = "arg1", partName = "arg1")
        int arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4,
        @WebParam(name = "arg5", partName = "arg5")
        int arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webservice.ojekonline.java.org/OjekData/updateDriverRequest", output = "http://webservice.ojekonline.java.org/OjekData/updateDriverResponse")
    public void updateDriver(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0,
        @WebParam(name = "arg1", partName = "arg1")
        int arg1,
        @WebParam(name = "arg2", partName = "arg2")
        float arg2);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg10
     * @param arg7
     * @param arg6
     * @param arg9
     * @param arg8
     */
    @WebMethod
    @Action(input = "http://webservice.ojekonline.java.org/OjekData/insertHistoryRequest", output = "http://webservice.ojekonline.java.org/OjekData/insertHistoryResponse")
    public void insertHistory(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0,
        @WebParam(name = "arg1", partName = "arg1")
        int arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4,
        @WebParam(name = "arg5", partName = "arg5")
        String arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6,
        @WebParam(name = "arg7", partName = "arg7")
        int arg7,
        @WebParam(name = "arg8", partName = "arg8")
        String arg8,
        @WebParam(name = "arg9", partName = "arg9")
        int arg9,
        @WebParam(name = "arg10", partName = "arg10")
        int arg10);

    /**
     * 
     * @param arg0
     * @return
     *     returns org.java.ojekonline.webservice.Babi
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservice.ojekonline.java.org/OjekData/getUserHistoryRequest", output = "http://webservice.ojekonline.java.org/OjekData/getUserHistoryResponse")
    public Babi getUserHistory(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns org.java.ojekonline.webservice.Babi
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservice.ojekonline.java.org/OjekData/getDriverHistoryRequest", output = "http://webservice.ojekonline.java.org/OjekData/getDriverHistoryResponse")
    public Babi getDriverHistory(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webservice.ojekonline.java.org/OjekData/hideUserHistoryRequest", output = "http://webservice.ojekonline.java.org/OjekData/hideUserHistoryResponse")
    public void hideUserHistory(
        @WebParam(name = "arg0", partName = "arg0")
        int arg0);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://webservice.ojekonline.java.org/OjekData/insertUserRequest", output = "http://webservice.ojekonline.java.org/OjekData/insertUserResponse")
    public void insertUser(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4,
        @WebParam(name = "arg5", partName = "arg5")
        String arg5);

}
