package com.example.producingwebservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mediopago")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MedioPagoModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Long id;
	@Getter @Setter private String nombre;
	
	/*@JoinTable(
	        name = "productomediopago",
	        joinColumns = @JoinColumn(name = "FK_MEDIOPAGOXP", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="FK_PRODUCTOXMP", nullable = false)
	    )
	   	@ManyToMany(cascade = CascadeType.ALL)
	    @Getter @Setter private List<ProductoModel> lstProductos;*/
	   
	   /* public void addAuthor(Author author){
	        if(this.authors == null){
	            this.authors = new ArrayList<>();
	        }
	        
	        this.authors.add(author);
	    }*/

}
