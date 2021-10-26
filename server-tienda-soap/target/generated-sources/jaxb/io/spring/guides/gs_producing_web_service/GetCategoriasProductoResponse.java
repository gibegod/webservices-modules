//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.10.25 a las 08:45:55 PM ART 
//


package io.spring.guides.gs_producing_web_service;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="categoriaProducto" type="{http://spring.io/guides/gs-producing-web-service}categoriaProducto" maxOccurs="unbounded"/&gt;
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
    "categoriaProducto"
})
@XmlRootElement(name = "getCategoriasProductoResponse")
public class GetCategoriasProductoResponse {

    @XmlElement(required = true)
    protected List<CategoriaProducto> categoriaProducto;

    /**
     * Gets the value of the categoriaProducto property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the categoriaProducto property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategoriaProducto().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CategoriaProducto }
     * 
     * 
     */
    public List<CategoriaProducto> getCategoriaProducto() {
        if (categoriaProducto == null) {
            categoriaProducto = new ArrayList<CategoriaProducto>();
        }
        return this.categoriaProducto;
    }

}
