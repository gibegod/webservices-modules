//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.10.25 a las 09:34:04 PM ART 
//


package io.spring.guides.gs_producing_web_service;

import java.math.BigDecimal;
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
 *         &lt;element name="precioTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="idDomicilio" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="idComprador" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="idVendedor" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="idTarjeta" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
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
    "precioTotal",
    "idDomicilio",
    "idComprador",
    "idVendedor",
    "idTarjeta"
})
@XmlRootElement(name = "addVentaRequest")
public class AddVentaRequest {

    @XmlElement(required = true)
    protected BigDecimal precioTotal;
    protected long idDomicilio;
    protected long idComprador;
    protected long idVendedor;
    protected long idTarjeta;

    /**
     * Obtiene el valor de la propiedad precioTotal.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    /**
     * Define el valor de la propiedad precioTotal.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrecioTotal(BigDecimal value) {
        this.precioTotal = value;
    }

    /**
     * Obtiene el valor de la propiedad idDomicilio.
     * 
     */
    public long getIdDomicilio() {
        return idDomicilio;
    }

    /**
     * Define el valor de la propiedad idDomicilio.
     * 
     */
    public void setIdDomicilio(long value) {
        this.idDomicilio = value;
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

    /**
     * Obtiene el valor de la propiedad idVendedor.
     * 
     */
    public long getIdVendedor() {
        return idVendedor;
    }

    /**
     * Define el valor de la propiedad idVendedor.
     * 
     */
    public void setIdVendedor(long value) {
        this.idVendedor = value;
    }

    /**
     * Obtiene el valor de la propiedad idTarjeta.
     * 
     */
    public long getIdTarjeta() {
        return idTarjeta;
    }

    /**
     * Define el valor de la propiedad idTarjeta.
     * 
     */
    public void setIdTarjeta(long value) {
        this.idTarjeta = value;
    }

}
