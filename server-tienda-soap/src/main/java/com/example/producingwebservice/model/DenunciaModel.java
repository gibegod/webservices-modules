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
@Table(name = "denuncia")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DenunciaModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Long id;
	@Getter @Setter private String comentarioComprador;
	@Getter @Setter private String estado;
	@Getter @Setter private String comentarioResolucion;
	@ManyToOne
	@JoinColumn(name = "FK_CATEGORIADENUNCIA", nullable = false, updatable = false)
	@Getter @Setter private CategoriaDenunciaModel categoria;
	@ManyToOne
	@JoinColumn(name = "FK_PRODUCTO", nullable = false, updatable = false)
	@Getter @Setter private ProductoModel producto;
	@ManyToOne
	@JoinColumn(name = "FK_USUARIO_COMPRADOR", nullable = false, updatable = false)
	@Getter @Setter private UsuarioModel comprador;
	@ManyToOne
	@JoinColumn(name = "FK_USUARIO_MESA", nullable = false, updatable = false)
	@Getter @Setter private UsuarioModel mesaAyuda;
}
