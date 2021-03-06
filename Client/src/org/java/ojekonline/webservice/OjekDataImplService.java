
package org.java.ojekonline.webservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "OjekDataImplService", targetNamespace = "http://webservice.ojekonline.java.org/", wsdlLocation = "http://localhost:8082/WS/OjekData?wsdl")
public class OjekDataImplService
    extends Service
{

    private final static URL OJEKDATAIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException OJEKDATAIMPLSERVICE_EXCEPTION;
    private final static QName OJEKDATAIMPLSERVICE_QNAME = new QName("http://webservice.ojekonline.java.org/", "OjekDataImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8082/WS/OjekData?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        OJEKDATAIMPLSERVICE_WSDL_LOCATION = url;
        OJEKDATAIMPLSERVICE_EXCEPTION = e;
    }

    public OjekDataImplService() {
        super(__getWsdlLocation(), OJEKDATAIMPLSERVICE_QNAME);
    }

    public OjekDataImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), OJEKDATAIMPLSERVICE_QNAME, features);
    }

    public OjekDataImplService(URL wsdlLocation) {
        super(wsdlLocation, OJEKDATAIMPLSERVICE_QNAME);
    }

    public OjekDataImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, OJEKDATAIMPLSERVICE_QNAME, features);
    }

    public OjekDataImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public OjekDataImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns OjekData
     */
    @WebEndpoint(name = "OjekDataImplPort")
    public OjekData getOjekDataImplPort() {
        return super.getPort(new QName("http://webservice.ojekonline.java.org/", "OjekDataImplPort"), OjekData.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns OjekData
     */
    @WebEndpoint(name = "OjekDataImplPort")
    public OjekData getOjekDataImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservice.ojekonline.java.org/", "OjekDataImplPort"), OjekData.class, features);
    }

    private static URL __getWsdlLocation() {
        if (OJEKDATAIMPLSERVICE_EXCEPTION!= null) {
            throw OJEKDATAIMPLSERVICE_EXCEPTION;
        }
        return OJEKDATAIMPLSERVICE_WSDL_LOCATION;
    }

}
