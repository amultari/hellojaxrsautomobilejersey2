package it.prova.hellojaxrsautomobilejersey2.model;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import it.prova.hellojaxrsautomobilejersey2.web.rest.adapters.LocalDateAdapter;

public class Automobile {
	private Long id;
	private String marca;
	private String modello;
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	private LocalDate dataImmatricolazione;

	public Automobile() {
		// TODO Auto-generated constructor stub
	}

	public Automobile(Long id, String marca, String modello, LocalDate dataImmatricolazione) {
		this.id = id;
		this.marca = marca;
		this.modello = modello;
		this.dataImmatricolazione = dataImmatricolazione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public LocalDate getDataImmatricolazione() {
		return dataImmatricolazione;
	}

	public void setDataImmatricolazione(LocalDate dataImmatricolazione) {
		this.dataImmatricolazione = dataImmatricolazione;
	}
}
