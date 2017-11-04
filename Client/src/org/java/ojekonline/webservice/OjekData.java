
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
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://webservice.ojekonline.java.org/OjekData/getUsernameRequest", output = "http://webservice.ojekonline.java.org/OjekData/getUsernameResponse")
    public String getUsername();

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

}