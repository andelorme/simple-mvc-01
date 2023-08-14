package dev.local.simplemvc01;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Andre Delorme
 *
 */
public class AlunosListController {

	private DAOAlunos model = new DAOAlunos();

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

	public void fetchAll() {
		Object[][] newData = DAOAlunos.getAll();
		model.setDataVector(newData, DAOAlunos.getHeaders());
	}

	public DefaultTableModel getModel() {
		return model;
	}

}
