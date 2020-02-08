
package app.models.jaxb.classes;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for event complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="event">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="basePrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rating" type="{}rating" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "event", propOrder = {
    "basePrice",
    "id",
    "name",
    "rating"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-02-01T02:05:06+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class Event {

    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-02-01T02:05:06+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected double basePrice;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-02-01T02:05:06+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected long id;
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-02-01T02:05:06+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String name;
    @XmlSchemaType(name = "string")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-02-01T02:05:06+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected Rating rating;

    /**
     * Gets the value of the basePrice property.
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-02-01T02:05:06+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Sets the value of the basePrice property.
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-02-01T02:05:06+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setBasePrice(double value) {
        this.basePrice = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-02-01T02:05:06+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-02-01T02:05:06+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-02-01T02:05:06+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-02-01T02:05:06+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the rating property.
     * 
     * @return
     *     possible object is
     *     {@link Rating }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-02-01T02:05:06+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public Rating getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rating }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-02-01T02:05:06+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setRating(Rating value) {
        this.rating = value;
    }

}
