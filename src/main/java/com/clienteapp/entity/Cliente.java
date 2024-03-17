package com.clienteapp.entity;

import javax.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long id;
	
	@NotBlank
	private String nombres;
	
	@NotEmpty
	@Column(name = "apellido_paterno")
	private String apellidoPaterno;
	
	@NotEmpty
	@Column(name = "apellido_materno")
	private String apellidoMaterno;
	
	@NotEmpty
	private String telefono;
	
	@NotEmpty
	@Email
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "ciudad")
	private Ciudad ciudad;

}
