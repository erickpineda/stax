package net.erickpineda.stax;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * @author Erick Pineda - StAX.
 *
 */
public class App {
	/**
	 * Ruta del fichero XML a leer.
	 */
	private static String ubicacionFichero = "src/main/resources/alumnes.xml";
	/**
	 * Abre el fichero de lectura.
	 */
	private static FileReader r;
	/**
	 * Parserque procesará el fichero XML.
	 */
	private static XMLStreamReader parser;
	/**
	 * Lista de alumnos.
	 */
	private List<Alumno> losAlumnos;
	/**
	 * Lista de asignaturas.
	 */
	private List<String> lasAsignaturas;
	/**
	 * Nombre de un alumno.
	 */
	private String alumne;
	/**
	 * Nombre de una asignatura.
	 */
	private String assignatura;

	public static void main(String[] args) {

		try {
			App ex = new App();
			ex.inicio();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método que abre y lee el fichero XML y lo parsea através de la instancia
	 * creada.
	 * 
	 * @throws FileNotFoundException
	 *             Exepción de fichero no válido.
	 * @throws XMLStreamException
	 *             Excepción del parser XML.
	 */
	public void inicio() throws FileNotFoundException, XMLStreamException {

		r = new FileReader(ubicacionFichero);
		parser = XMLInputFactory.newInstance().createXMLStreamReader(r);
		losAlumnos = new ArrayList<Alumno>();

		while (parser.hasNext()) {
			parser.next();
			startElement();
			endElement();
			endDocument();
		}

	}

	/**
	 * Método que recoge los valores de asignatura y los almacena en una lista.
	 * 
	 * @throws XMLStreamException
	 *             Excepción del parser XML.
	 */
	protected void startElement() throws XMLStreamException {

		if (parser.getEventType() == XMLStreamReader.START_ELEMENT) {

			if (parser.getLocalName().equalsIgnoreCase("alumne"))
				lasAsignaturas = new ArrayList<String>();

			if (parser.getLocalName().equalsIgnoreCase("nom"))
				alumne = parser.getElementText();

			if (parser.getLocalName().equalsIgnoreCase("assignatura")) {
				assignatura = parser.getElementText();
				lasAsignaturas.add(new String(assignatura));
			}

		}
	}

	/**
	 * Método que recoge los valores de alumnos, por cada asignatura.
	 */
	protected void endElement() {
		if (parser.getEventType() == XMLStreamReader.END_ELEMENT) {

			if (parser.getLocalName().equalsIgnoreCase("nom")) {

			}

			if (parser.getLocalName().equalsIgnoreCase("credits")) {

				if (!losAlumnos.contains(alumne))
					losAlumnos.add(new Alumno(alumne, lasAsignaturas));
			}

		}
	}

	/**
	 * Método que itera la lista de alumnos y los muestra por pantalla.
	 */
	protected void endDocument() {
		if (parser.getEventType() == XMLStreamReader.END_DOCUMENT)
			losAlumnos.stream().forEach(e -> System.out.println(e));

	}

}
