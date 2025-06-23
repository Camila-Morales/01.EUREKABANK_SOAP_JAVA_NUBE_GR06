
package ws_eurekabank_soap_java_clienteconsola;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for regTransferenciaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="regTransferenciaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "regTransferenciaResponse", propOrder = {
    "estado"
})
public class RegTransferenciaResponse {

    protected int estado;

    /**
     * Gets the value of the estado property.
     * 
     */
    public int getEstado() {
        return estado;
    }

    /**
     * Sets the value of the estado property.
     * 
     */
    public void setEstado(int value) {
        this.estado = value;
    }

}
