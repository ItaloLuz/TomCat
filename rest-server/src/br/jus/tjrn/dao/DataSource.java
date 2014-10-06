package br.jus.tjrn.dao;

public enum DataSource {
	
	PJE("pje", "pje.properties"),
	PJE_TESTE("pje_teste", ""),
	PJE_CERTIDAO("pje_certidao", "pje_certidoes.properties"),
	GUIA_CARDAPIO("guia_cardapio", "guia_cardapio.properties");
	
	private String persistenceUnit;
	private String persistenceProperties;
	
	private DataSource(String persistenceUnit, String persistenceProperties) {
		this.persistenceUnit = persistenceUnit;
		this.persistenceProperties = persistenceProperties;
	}

	public String getPersistenceUnit() {
		return persistenceUnit;
	}

	public void setPersistenceUnit(String persistenceUnit) {
		this.persistenceUnit = persistenceUnit;
	}

	public String getPersistenceProperties() {
		return persistenceProperties;
	}

	public void setPersistenceProperties(String persistenceProperties) {
		this.persistenceProperties = persistenceProperties;
	}
	
}
