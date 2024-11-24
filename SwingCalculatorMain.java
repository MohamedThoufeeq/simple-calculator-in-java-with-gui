import javax.swing.SwingUtilities;

public class SwingCalculatorMain {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				MainWindow mw = new MainWindow();
				mw.show();
			}
		});
	}

}
