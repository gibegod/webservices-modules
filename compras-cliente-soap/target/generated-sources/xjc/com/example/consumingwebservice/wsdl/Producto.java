//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.10.23 a las 04:00:56 PM ART 
//


package com.example.consumingwebservice.wsdl;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para producto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="producto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="imagen" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="precio" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="stockInicial" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="stockActual" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="activo" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="categoria" type="{http://spring.io/guides/gs-producing-web-service}categoriaProducto"/&gt;
 *         &lt;element name="vendedor" type="{http://spring.io/guides/gs-producing-web-service}usuario"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "producto", propOrder = {
    "id",
    "nombre",
    "descripcion",
    "imagen",
    "precio",
    "stockInicial",
    "stockActual",
    "activo",
    "categoria",
    "vendedor"
})
public class Producto {

    protected Long id;
    @XmlElement(required = true)
    protected String nombre;
    @XmlElement(required = true)
    protected String descripcion;
    @XmlElement(required = true)
    protected String imagen;
    @XmlElement(required = true)
    protected BigDecimal precio;
    @XmlElement(required = true)
    protected BigInteger stockInicial;
    @XmlElement(required = true)
    protected BigInteger stockActual;
    protected boolean activo;
    @XmlElement(required = true)
    protected CategoriaProducto categoria;
    @XmlElement(required = true)
    protected Usuario vendedor;

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
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad imagen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Define el valor de la propiedad imagen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImagen(String value) {
        this.imagen = value;
    }

    /**
     * Obtiene el valor de la propiedad precio.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrecio() {
        return precio;
    }

    /**
     * Define el valor de la propiedad precio.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrecio(BigDecimal value) {
        this.precio = value;
    }

    /**
     * Obtiene el valor de la propiedad stockInicial.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getStockInicial() {
        return stockInicial;
    }

    /**
     * Define el valor de la propiedad stockInicial.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setStockInicial(BigInteger value) {
        this.stockInicial = value;
    }

    /**
     * Obtiene el valor de la propiedad stockActual.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getStockActual() {
        return stockActual;
    }

    /**
     * Define el valor de la propiedad stockActual.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setStockActual(BigInteger value) {
        this.stockActual = value;
    }

    /**
     * Obtiene el valor de la propiedad activo.
     * 
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * Define el valor de la propiedad activo.
     * 
     */
    public void setActivo(boolean value) {
        this.activo = value;
    }

    /**
     * Obtiene el valor de la propiedad categoria.
     * 
     * @return
     *     possible object is
     *     {@link CategoriaProducto }
     *     
     */
    public CategoriaProducto getCategoria() {
        return categoria;
    }

    /**
     * Define el valor de la propiedad categoria.
     * 
     * @param value
     *     allowed object is
     *     {@link CategoriaProducto }
     *     
     */
    public void setCategoria(CategoriaProducto value) {
        this.categoria = value;
    }

    /**
     * Obtiene el valor de la propiedad vendedor.
     * 
     * @return
     *     possible object is
     *     {@link Usuario }
     *     
     */
    public Usuario getVendedor() {
        return vendedor;
    }

    /**
     * Define el valor de la propiedad vendedor.
     * 
     * @param value
     *     allowed object is
     *     {@link Usuario }
     *     
     */
    public void setVendedor(Usuario value) {
        this.vendedor = value;
    }

}
