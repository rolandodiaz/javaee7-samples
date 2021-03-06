package pe.joedayz.javaee7.cdi.ejemplo01;

import java.util.Date;

public class Libro01 {

	private String titulo;
	private Float precio;
	private String descripcion;
	private String isbn;
	private Date fechaCreacion;

	public Libro01() {

	}

	public Libro01(String titulo, Float precio, String descripcion) {
		super();
		this.titulo = titulo;
		this.precio = precio;
		this.descripcion = descripcion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Libro01");
		sb.append(", titulo='").append(titulo).append('\'');
		sb.append(", precio=").append(precio);
		sb.append(", descripcion='").append(descripcion).append('\'');
		sb.append(", isbn='").append(isbn).append('\'');
		sb.append('}');
		return sb.toString();
	}

}
