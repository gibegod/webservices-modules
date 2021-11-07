//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.11.07 a las 02:34:56 PM ART 
//


package com.example.consumingwebservice.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="idVenta" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="idComprador" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
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
    "idVenta",
    "idComprador"
})
@XmlRootElement(name = "cancelVentaRequest")
public class CancelVentaRequest {

    protected long idVenta;
    protected long idComprador;

    /**
     * Obtiene el valor de la propiedad idVenta.
     * 
     */
    public long getIdVenta() {
        return idVenta;
    }

    /**
     * Define el valor de la propiedad idVenta.
     * 
     */
    public void setIdVenta(long value) {
        this.idVenta = value;
    }

    /**
     * Obtiene el valor de la propiedad idComprador.
     * 
     */
    public long getIdComprador() {
        return idComprador;
    }

    /**
     * Define el valor de la propiedad idComprador.
     * 
     */
    public void setIdComprador(long value) {
        this.idComprador = value;
    }

}
