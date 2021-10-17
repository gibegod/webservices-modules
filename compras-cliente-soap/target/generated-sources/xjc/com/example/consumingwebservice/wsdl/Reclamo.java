//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.10.17 a las 02:49:09 PM ART 
//


package com.example.consumingwebservice.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para reclamo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="reclamo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="comentarioComprador" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="comentarioResolucion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="comprador" type="{http://spring.io/guides/gs-producing-web-service}usuario"/&gt;
 *         &lt;element name="mesaAyuda" type="{http://spring.io/guides/gs-producing-web-service}usuario"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reclamo", propOrder = {
    "id",
    "estado",
    "comentarioComprador",
    "comentarioResolucion",
    "fecha",
    "comprador",
    "mesaAyuda"
})
public class Reclamo {

    protected Long id;
    @XmlElement(required = true)
    protected String estado;
    @XmlElement(required = true)
    protected String comentarioComprador;
    @XmlElement(required = true)
    protected String comentarioResolucion;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fecha;
    @XmlElement(required = true)
    protected Usuario comprador;
    @XmlElement(required = true)
    protected Usuario mesaAyuda;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad comentarioComprador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComentarioComprador() {
        return comentarioComprador;
    }

    /**
     * Define el valor de la propiedad comentarioComprador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComentarioComprador(String value) {
        this.comentarioComprador = value;
    }

    /**
     * Obtiene el valor de la propiedad comentarioResolucion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComentarioResolucion() {
        return comentarioResolucion;
    }

    /**
     * Define el valor de la propiedad comentarioResolucion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComentarioResolucion(String value) {
        this.comentarioResolucion = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad comprador.
     * 
     * @return
     *     possible object is
     *     {@link Usuario }
     *     
     */
    public Usuario getComprador() {
        return comprador;
    }

    /**
     * Define el valor de la propiedad comprador.
     * 
     * @param value
     *     allowed object is
     *     {@link Usuario }
     *     
     */
    public void setComprador(Usuario value) {
        this.comprador = value;
    }

    /**
     * Obtiene el valor de la propiedad mesaAyuda.
     * 
     * @return
     *     possible object is
     *     {@link Usuario }
     *     
     */
    public Usuario getMesaAyuda() {
        return mesaAyuda;
    }

    /**
     * Define el valor de la propiedad mesaAyuda.
     * 
     * @param value
     *     allowed object is
     *     {@link Usuario }
     *     
     */
    public void setMesaAyuda(Usuario value) {
        this.mesaAyuda = value;
    }

}
