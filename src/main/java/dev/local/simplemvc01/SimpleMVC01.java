package dev.local.simplemvc01;

import javax.swing.SwingUtilities;

/**
 *
 * @author andre
 */
public class SimpleMVC01 {

	public static void main(String[] args) {
		// realiza a chamada pela thread de eventos de interface
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					initGui();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void initGui() throws Exception {
		// Cria controller
		AlunosListController controller = new AlunosListController();
		// cria view associada ao controller
		new AlunosListView(controller);
		// solicita ao controller carregar todos os itens
		controller.fetchAll();
	}
}
