//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.10.25 a las 10:36:24 PM ART 
//


package com.example.consumingwebservice.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para denuncia complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="denuncia"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="comentarioComprador" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="comentarioResolucion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="comprador" type="{http://spring.io/guides/gs-producing-web-service}usuario"/&gt;
 *         &lt;element name="mesaAyuda" type="{http://spring.io/guides/gs-producing-web-service}usuario"/&gt;
 *         &lt;element name="producto" type="{http://spring.io/guides/gs-producing-web-service}producto"/&gt;
 *         &lt;element name="categoria" type="{http://spring.io/guides/gs-producing-web-service}categoriaDenuncia"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "denuncia", propOrder = {
    "id",
    "estado",
    "comentarioComprador",
    "comentarioResolucion",
    "comprador",
    "mesaAyuda",
    "producto",
    "categoria"
})
public class Denuncia {

    protected Long id;
    @XmlElement(required = true)
    protected String estado;
    @XmlElement(required = true)
    protected String comentarioComprador;
    @XmlElement(required = true)
    protected String comentarioResolucion;
    @XmlElement(required = true)
    protected Usuario comprador;
    @XmlElement(required = true)
    protected Usuario mesaAyuda;
    @XmlElement(required = true)
    protected Producto producto;
    @XmlElement(required = true)
    protected CategoriaDenuncia categoria;

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

    /**
     * Obtiene el valor de la propiedad producto.
     * 
     * @return
     *     possible object is
     *     {@link Producto }
     *     
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Define el valor de la propiedad producto.
     * 
     * @param value
     *     allowed object is
     *     {@link Producto }
     *     
     */
    public void setProducto(Producto value) {
        this.producto = value;
    }

    /**
     * Obtiene el valor de la propiedad categoria.
     * 
     * @return
     *     possible object is
     *     {@link CategoriaDenuncia }
     *     
     */
    public CategoriaDenuncia getCategoria() {
        return categoria;
    }

    /**
     * Define el valor de la propiedad categoria.
     * 
     * @param value
     *     allowed object is
     *     {@link CategoriaDenuncia }
     *     
     */
    public void setCategoria(CategoriaDenuncia value) {
        this.categoria = value;
    }

}
