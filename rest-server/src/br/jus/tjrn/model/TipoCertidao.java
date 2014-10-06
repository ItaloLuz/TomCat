package br.jus.tjrn.model;

/**
 * Tipo de certidão.
 * 
 * @author luan
 * 
 */
public enum TipoCertidao {

	/** 00 */
	CERTIDAO_ACAO_EXECUCAO_CIVEIS_FISCAIS(
			1,
			"AÇÕES E EXECUÇÕES CÍVEIS E FISCAIS",
			"certidao_acao_execucao_civeis_fiscais.html",
			"2, 158, 175, 197, 214, 1106, 27, 50, 62, 28, 29, 30, 31, 32, 34, 35, 37, 38, 39, 40, 41, 44, 45, 46, 48, 49, 1707, 1709, 51, 52, 53, 54, 55, 56, 57, 59, 60, 1294, 1295, 63, 64, 65, 66, 69, 72, 74, 76, 77, 79, 80, 81, 84, 85, 86, 87, 89, 90, 92, 93, 94, 96, 97, 98, 99, 100, 110, 112, 113, 114, 115, 118, 119, 120, 121, 123, 124, 127, 134, 135, 136, 137, 140, 141, 142, 143, 1124, 1269, 1682, 1683, 156, 157, 229, 10980, 10981, 159, 165, 169, 1111, 1116, 1117, 166, 167, 170, 171, 172, 173, 1118, 83, 176, 177, 178, 179, 180, 181, 182, 183, 186, 188, 190, 191, 192, 193, 194, 195, 196, 1289, 1725, 1726, 207, 210, 1689, 215, 237, 257, 218, 224, 228, 230, 231, 232, 234, 236, 1702, 1230, 1231, 1232, 239, 240, 241, 251, 1701, 258, 261, 155, 1107, 7, 22, 26, 436, 1112, 1114"),
	/** 01 */
	CERTIDAO_INTERDICAO_TUTELA_CURATELA(
			2,
			"CERTIDÃO DE INTERDIÇÃO, TUTELA OU CURATELA",
			"certidao_interdicao_tutela_curatela.html",
			"1106, 50, 58, 61, 1122, 1385, 1107, 26, 1386, 1396, 1399, 1705, 20178, 20285, 20538, 2, 547, 20000"),
	/** 02 */
	CERTIDAO_FALENCIA_RECUPERACAO_JUDICIAL(
			3,
			"FALÊNCIA E/OU RECUPERAÇÃO JUDICIAL",
			"certidao_falencia_recuperacao_judicial.html",
			"214, 1106, 62, 108, 111, 114, 128, 129, 11397, 151, 152, 153, 154, 237, 241, 150, 1107, 26, 20051, 20085, 20086, 20114, 20152, 20410, 20411, 2, 20000");

	private Integer id;
	private String nome;
	/** nome/path do template velocity para gerar a certidão */
	private String templateVelocity;
	private String classesJudiciais;

	private TipoCertidao(Integer id, String nome, String templateVelocity,
			String classesJudiciais) {
		this.id = id;
		this.nome = nome;
		this.templateVelocity = templateVelocity;
		this.classesJudiciais = classesJudiciais;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTemplateVelocity() {
		return templateVelocity;
	}

	public void setTemplateVelocity(String templateVelocity) {
		this.templateVelocity = templateVelocity;
	}

	public String getClassesJudiciais() {
		return classesJudiciais;
	}

	public void setClassesJudiciais(String classesJudiciais) {
		this.classesJudiciais = classesJudiciais;
	}

}
