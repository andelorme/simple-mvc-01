package dev.local.simplemvc01;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * @author Andre Delorme
 *
 */
public class AlunosListView {

	public AlunosListView(AlunosListController controller) {

		// cria componentes de interface
		JTextField searchTermTextField = new JTextField(20);
		JButton filterButton = new JButton("Filtrar");
		JButton allButton = new JButton("Listar Todos");
		JTable table = new JTable();

		// associa o modelo do controller a tabela da view
		table.setModel(controller.getModel());

		// botão de filtro: realiza chamada ao controller
		filterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.filterData(searchTermTextField.getText());
			}
		});
		// botão de todos: realiza chamada ao controller
		allButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.fetchAll();
			}
		});

		// cria JPanel para organizar os componentes (layout)
		JPanel ctrlPane = new JPanel();

		// adiciona os componentes ao JPanel
		ctrlPane.add(searchTermTextField);
		ctrlPane.add(filterButton);
		ctrlPane.add(allButton);

		// JScrollPane pane com borda e título para a tabela
		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setPreferredSize(new Dimension(600, 200));
		tableScrollPane.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(),
				"Lista de Alunos",
				TitledBorder.CENTER, TitledBorder.TOP));

		// split pane vertical com os controles em cima e a tabela embaixo
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				ctrlPane, tableScrollPane);
		splitPane.setEnabled(false);

		// cria um frame para receber o split pane
		JFrame frame = new JFrame("Swing MVC Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(splitPane);
		frame.pack();
		frame.setVisible(true);
	}

}
