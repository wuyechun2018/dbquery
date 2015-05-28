
package  org.wuyechun.util.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "InfoSearchServicesSoap", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface InfoSearchServicesSoap {


    /**
     * 
     * @param realtyOwnerName
     * @param realtyCertCode
     * @param realtyOwnerCode
     * @return
     *     returns  org.wuyechun.util.ws.ArrayOfString
     */
    @WebMethod(operationName = "GetInfo", action = "http://tempuri.org/GetInfo")
    @WebResult(name = "GetInfoResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetInfo", targetNamespace = "http://tempuri.org/", className = " org.wuyechun.util.ws.GetInfo")
    @ResponseWrapper(localName = "GetInfoResponse", targetNamespace = "http://tempuri.org/", className = " org.wuyechun.util.ws.GetInfoResponse")
    public ArrayOfString getInfo(
        @WebParam(name = "RealtyCert_Code", targetNamespace = "http://tempuri.org/")
        String realtyCertCode,
        @WebParam(name = "RealtyOwner_Name", targetNamespace = "http://tempuri.org/")
        String realtyOwnerName,
        @WebParam(name = "RealtyOwner_Code", targetNamespace = "http://tempuri.org/")
        String realtyOwnerCode);

    /**
     * 
     * @param realtyOwnerName
     * @param realtyCertCode
     * @param realtyOwnerCode
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "ShowAllInfo", action = "http://tempuri.org/ShowAllInfo")
    @WebResult(name = "ShowAllInfoResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "ShowAllInfo", targetNamespace = "http://tempuri.org/", className = " org.wuyechun.util.ws.ShowAllInfo")
    @ResponseWrapper(localName = "ShowAllInfoResponse", targetNamespace = "http://tempuri.org/", className = " org.wuyechun.util.ws.ShowAllInfoResponse")
    public String showAllInfo(
        @WebParam(name = "RealtyCert_Code", targetNamespace = "http://tempuri.org/")
        String realtyCertCode,
        @WebParam(name = "RealtyOwner_Name", targetNamespace = "http://tempuri.org/")
        String realtyOwnerName,
        @WebParam(name = "RealtyOwner_Code", targetNamespace = "http://tempuri.org/")
        String realtyOwnerCode);

}
