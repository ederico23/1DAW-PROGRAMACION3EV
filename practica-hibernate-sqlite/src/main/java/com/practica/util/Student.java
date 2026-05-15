package com.practica.util;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	@Id
	// (1) Esta clase es una entidad persistible
	// (2) Se mapea a la tabla llamada "students"
	// (3) Esta es la clave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // (4) Autoincremental
	private Long id;
	@Column(name = "nombre", nullable = false, length = 100) // (5)
	private String nombre;
	@Column(name = "apellidos", nullable = false, length = 150)
	private String apellidos;
	@Column(name = "edad", nullable = false)
	private Integer edad;
	@Column(name = "email", nullable = false, length = 150)
	private String email;

	public Student() {
	} // (6) Constructor vacío: OBLIGATORIO para Hibernate

	public Student(String nombre, String apellidos, Integer edad, String email) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.email = email;
	}
// Getters y setters (omitidos por brevedad) + toString()

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", email="
				+ email + "]";
	}
	
}