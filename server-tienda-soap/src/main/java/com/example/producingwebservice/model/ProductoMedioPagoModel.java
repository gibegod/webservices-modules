package com.example.producingwebservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "productomediopago")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductoMedioPagoModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Long id;
	
	@ManyToOne
	@JoinColumn(name = "FK_PRODUCTO_MP", nullable = false, updatable = false)
	@Getter @Setter private ProductoModel producto;
	
	@ManyToOne
	@JoinColumn(name = "FK_MEDIOPAGO_P", nullable = false, updatable = false)
	@Getter @Setter private MedioPagoModel mediopago;

	public ProductoMedioPagoModel(ProductoModel producto, MedioPagoModel mediopago) {
		super();
		this.producto = producto;
		this.mediopago = mediopago;
	}
	
	

}
