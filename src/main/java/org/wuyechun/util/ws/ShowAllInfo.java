
package  org.wuyechun.util.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RealtyCert_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RealtyOwner_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RealtyOwner_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "realtyCertCode",
    "realtyOwnerName",
    "realtyOwnerCode"
})
@XmlRootElement(name = "ShowAllInfo")
public class ShowAllInfo {

    @XmlElement(name = "RealtyCert_Code")
    protected String realtyCertCode;
    @XmlElement(name = "RealtyOwner_Name")
    protected String realtyOwnerName;
    @XmlElement(name = "RealtyOwner_Code")
    protected String realtyOwnerCode;

    /**
     * Gets the value of the realtyCertCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRealtyCertCode() {
        return realtyCertCode;
    }

    /**
     * Sets the value of the realtyCertCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRealtyCertCode(String value) {
        this.realtyCertCode = value;
    }

    /**
     * Gets the value of the realtyOwnerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRealtyOwnerName() {
        return realtyOwnerName;
    }

    /**
     * Sets the value of the realtyOwnerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRealtyOwnerName(String value) {
        this.realtyOwnerName = value;
    }

    /**
     * Gets the value of the realtyOwnerCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRealtyOwnerCode() {
        return realtyOwnerCode;
    }

    /**
     * Sets the value of the realtyOwnerCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRealtyOwnerCode(String value) {
        this.realtyOwnerCode = value;
    }

}
