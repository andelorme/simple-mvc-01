package dev.local.simplemvc01;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Andre Delorme
 *
 */
public class AlunosListController {
	// associa classe de modelo
	private DAOAlunos model = new DAOAlunos();
	// filtra lista
	public void filterData(String searchTerm) {
		if (searchTerm != null && !"".equals(searchTerm)) {
			Object[][] newData = DAOAlunos.filterData(searchTerm);
			model.setDataVector(newData, DAOAlunos.getHeaders());

		} else {
			JOptionPane.showMessageDialog(null,
					"Search term is empty", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	// carrega todos os alunos na lista
	public void fetchAll() {
		Object[][] newData = DAOAlunos.getAll();
		model.setDataVector(newData, DAOAlunos.getHeaders());
	}
	// retorna o modelo (para a view, no caso)
	public DefaultTableModel getModel() {
		return model;
	}

}
