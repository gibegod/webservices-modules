package com.example.consumingwebservice.dto;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UsuarioLoginDTO {
	@Getter @Setter String user;
	@Getter @Setter private String pass;
}