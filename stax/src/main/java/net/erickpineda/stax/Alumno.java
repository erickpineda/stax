package net.erickpineda.stax;

import java.util.List;

public class Alumno {
	/**
	 * Lista de asignaturas.
	 */
	private List<String> asignaturas;
	/**
	 * Nombre de un alumno.
	 */
	private String nombreAlumno;

	/**
	 * Constructor que crea un alumno a partir de su nombre.
	 * 
	 * @param alumno
	 */
	public Alumno(String alumno) {
		this.nombreAlumno = alumno;
	}

	/**
	 * Constructor que crea un alumno a partir de su nombre y una lista de
	 * asignaturas.
	 * 
	 * @param alumno
	 *            Parámetro de alumno a crear.
	 * @param asignaturas
	 *            Parámetro de lista de asignaturas para el alumno.
	 */
	public Alumno(String alumno, List<String> asignaturas) {
		this.nombreAlumno = alumno;
		this.asignaturas = asignaturas;
	}

	/**
	 * 
	 * @return Retorna las asignaturas por cada alumno.
	 */
	public List<String> todasLasAsignaturas() {
		System.out.println(this.getNombreAlumno());
		return asignaturas;
	}

	/**
	 * @return the asignaturas
	 */
	public List<String> getAsignaturas() {
		return asignaturas;
	}
	/**
	 * 
	 * @return Retorna una asignatura de la lista.
	 */
	public String getUnaAsignatura() {
		String miAsignatura = "";
		int cont = 0;

		if (cont != this.getSizeAsignaturas()) {
			miAsignatura = asignaturas.get(cont);
			cont++;
		}

		return miAsignatura;
	}

	/**
	 * 
	 * @return Retorna el tamaño de la lista de asignaturas.
	 */
	public int getSizeAsignaturas() {
		return asignaturas.size();
	}

	/**
	 * @return the nombreAlumno.
	 */
	public String getNombreAlumno() {
		return nombreAlumno;
	}

	/**
	 * @param asignaturas
	 *            the asignaturas to set
	 */
	public void setAsignaturas(List<String> asignaturas) {
		this.asignaturas = asignaturas;
	}

	/**
	 * @param nombreAlumno
	 *            the nombreAlumno to set.
	 */
	public void setNombreAlumno(String alumno) {
		this.nombreAlumno = alumno;
	}

	/**
	 * Clase alumno convertido a String.
	 */
	public String toString() {
		return this.getNombreAlumno() + " con asignaturas "
				+ this.getAsignaturas();
	}

}
