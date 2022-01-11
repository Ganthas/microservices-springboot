package com.jsanhueza.composer.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Alumno {

	private String id;
	private String nombre;
	private String apellido;
	private Integer estatura;

}