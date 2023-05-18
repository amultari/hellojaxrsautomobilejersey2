package it.prova.hellojaxrsautomobilejersey2.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.prova.hellojaxrsautomobilejersey2.model.Automobile;

public class AutomobileDAOMock {

	public static final List<Automobile> DB_MOCK = new ArrayList<>();

	static {
		// preparo una lista mock perché ancora non ho il collegamento alla
		// base dati
		DB_MOCK.add(new Automobile(1L, "fiat", "panda",LocalDate.of(2000, 7, 30)));
		DB_MOCK.add(new Automobile(2L, "opel", "corsa",LocalDate.of(2010, 9, 2)));
		DB_MOCK.add(new Automobile(3L, "audi", "A1",LocalDate.of(1998, 5, 21)));
	}

	public Automobile findById(Long idInput) {
		for (Automobile automobileItem : DB_MOCK) {
			if (automobileItem.getId() == idInput) {
				return automobileItem;
			}
		}

		return null;
	}

	public void insert(Automobile automobileInput) {
		Long maxId = 1L;
		for (Automobile automobileItem : DB_MOCK) {
			if (automobileItem.getId() > maxId)
				maxId = automobileItem.getId();
		}
		automobileInput.setId(++maxId);
		DB_MOCK.add(automobileInput);
	}

	public List<Automobile> findAll() {
		return DB_MOCK;
	}

	public List<Automobile> findByFields(String marca, String modello) {
		List<Automobile> result = new ArrayList<>();

		if ((marca == null || marca.isEmpty()) && (modello == null || modello.isEmpty()))
			return DB_MOCK;

		for (Automobile automobileItem : DB_MOCK) {
			if ((marca != null && !marca.isEmpty() && automobileItem.getMarca().startsWith(marca))
					|| (modello != null && !modello.isEmpty() && automobileItem.getModello().startsWith(modello)))
				result.add(automobileItem);
		}
		return result;
	}
	
	public boolean delete(Long idInput) {
		for (Automobile automobileItem : DB_MOCK) {
			if (automobileItem.getId() == idInput) {
				DB_MOCK.remove(automobileItem);
				return true;
			}
		}
		return false;
	}
	
	public Automobile update(Automobile input) {
		for (Automobile automobileItem : DB_MOCK) {
			if (automobileItem.getId() == input.getId()) {
				automobileItem.setMarca(input.getMarca());
				automobileItem.setModello(input.getModello());
				return automobileItem;
			}
		}
		return null;
	}

}
