//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.11.07 a las 02:36:54 PM ART 
//


package com.example.consumingwebservice.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="billeteraVirtual" type="{http://spring.io/guides/gs-producing-web-service}billeteraVirtual"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "billeteraVirtual"
})
@XmlRootElement(name = "getBilleteraVirtualResponse")
public class GetBilleteraVirtualResponse {

    @XmlElement(required = true)
    protected BilleteraVirtual billeteraVirtual;

    /**
     * Obtiene el valor de la propiedad billeteraVirtual.
     * 
     * @return
     *     possible object is
     *     {@link BilleteraVirtual }
     *     
     */
    public BilleteraVirtual getBilleteraVirtual() {
        return billeteraVirtual;
    }

    /**
     * Define el valor de la propiedad billeteraVirtual.
     * 
     * @param value
     *     allowed object is
     *     {@link BilleteraVirtual }
     *     
     */
    public void setBilleteraVirtual(BilleteraVirtual value) {
        this.billeteraVirtual = value;
    }

}
