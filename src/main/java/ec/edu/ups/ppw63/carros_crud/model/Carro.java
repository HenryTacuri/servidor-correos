package ec.edu.ups.ppw63.carros_crud.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Carro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int codigo;
	private String marca;
	private String modelo;
	private String color;
	private int anio;
	private double cilindraje;
	private double precio;
	
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getAnio() {
		return anio;
	}
	
	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	public double getCilindraje() {
		return cilindraje;
	}
	
	public void setCilindraje(double cilindraje) {
		this.cilindraje = cilindraje;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Carro [codigo=" + codigo + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", anio="
				+ anio + ", cilindraje=" + cilindraje + ", precio=" + precio + "]";
	}
	
}
