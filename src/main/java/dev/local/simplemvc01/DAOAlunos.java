package dev.local.simplemvc01;

import javax.swing.table.DefaultTableModel;

/**
 * @author Andre Delorme
 * 
 */
public class DAOAlunos extends DefaultTableModel {

	// campos do modelo
	private static final Object[] FIELDS = { "Nome", "Sobrenome", "RA",
			"Curso", "Semestre" };

	// lista de alunos (modelos)
	private static final Object[][] DATA = {
			{ "José", "Silva", 5730735, "ADS", 4 },
			{ "Maria", "Pereira", 5743313, "PSICO", 2 },
			{ "Sandra", "Rodrigues", 7813423, "ADS", 4 },
			{ "Márcio", "Fonseca", 3385166, "VET", 4 },
			{ "João", "Santos", 455591, "ADS", 2 },
			{ "Rodrigo", "Oliveira", 5555353, "PSICO", 1 },
			{ "José", "Souza", 893125, "ADS", 1 },
			{ "Arthur", "Pereira", 2824896, "PSICO", 4 },
			{ "Dalva", "Alvas", 5093026, "ADS", 2 },
			{ "Paulo", "Santos", 6301789, "VET", 3 }
	};

	// executa filtro no modelo
	public static Object[][] filterData(String searchTerm) {
		int idx = 0;
		Object[][] newData = new Object[DATA.length][];
		for (Object[] o : DAOAlunos.DATA) {
			if ("*".equals(searchTerm.trim())) {
				newData[idx++] = o;
			} else {
				if (String.valueOf(o[0]).startsWith(searchTerm.toUpperCase().trim())) {
					newData[idx++] = o;
				}
			}
		}
		return newData;
	}
	// retorna os campos (pra montagem da tabela, no caso)
	public static Object[] getHeaders() {
		return FIELDS;
	}
	// retorna todos os alunos
	public static Object[][] getAll() {
		return DATA;
	}

}
