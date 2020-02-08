
package app.models.jaxb.classes;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rating.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="rating">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HIGH"/>
 *     &lt;enumeration value="MID"/>
 *     &lt;enumeration value="LOW"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "rating")
@XmlEnum
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2020-02-01T02:05:06+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
public enum Rating {

    HIGH,
    MID,
    LOW;

    public String value() {
        return name();
    }

    public static Rating fromValue(String v) {
        return valueOf(v);
    }

}
