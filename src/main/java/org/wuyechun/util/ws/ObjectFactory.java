
package  org.wuyechun.util.ws;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the  org.wuyechun.util.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:  org.wuyechun.util.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ShowAllInfo }
     * 
     */
    public ShowAllInfo createShowAllInfo() {
        return new ShowAllInfo();
    }

    /**
     * Create an instance of {@link ShowAllInfoResponse }
     * 
     */
    public ShowAllInfoResponse createShowAllInfoResponse() {
        return new ShowAllInfoResponse();
    }

    /**
     * Create an instance of {@link GetInfoResponse }
     * 
     */
    public GetInfoResponse createGetInfoResponse() {
        return new GetInfoResponse();
    }

    /**
     * Create an instance of {@link ArrayOfString }
     * 
     */
    public ArrayOfString createArrayOfString() {
        return new ArrayOfString();
    }

    /**
     * Create an instance of {@link GetInfo }
     * 
     */
    public GetInfo createGetInfo() {
        return new GetInfo();
    }

}
