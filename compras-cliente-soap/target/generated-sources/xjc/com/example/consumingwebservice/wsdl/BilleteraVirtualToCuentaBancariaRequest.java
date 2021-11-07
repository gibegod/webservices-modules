//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.11.07 a las 02:36:54 PM ART 
//


package com.example.consumingwebservice.wsdl;

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
 *         &lt;element name="idVendedor" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="idCuentaBancaria" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="monto" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
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
    "idVendedor",
    "idCuentaBancaria",
    "monto"
})
@XmlRootElement(name = "billeteraVirtualToCuentaBancariaRequest")
public class BilleteraVirtualToCuentaBancariaRequest {

    protected long idVendedor;
    protected long idCuentaBancaria;
    @XmlElement(required = true)
    protected BigDecimal monto;

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
     * Obtiene el valor de la propiedad idCuentaBancaria.
     * 
     */
    public long getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    /**
     * Define el valor de la propiedad idCuentaBancaria.
     * 
     */
    public void setIdCuentaBancaria(long value) {
        this.idCuentaBancaria = value;
    }

    /**
     * Obtiene el valor de la propiedad monto.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMonto() {
        return monto;
    }

    /**
     * Define el valor de la propiedad monto.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMonto(BigDecimal value) {
        this.monto = value;
    }

}
