package converter;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @name 	Converter
 * @package	Converter
 * @author 	Jesse Pasos
 * @desc 	Initialize the Converter program.
 */
public class Converter extends JFrame {

	private static final long serialVersionUID = 1L;

	
	/**
	 * @name 	Converter
	 * @desc 	Converter class constructor. Construct the programs JFrame structure.
	 * 
	 * @return 	void
	 * 
	 */
	public Converter() {

		add(new HandleUserInterface());
		setTitle("Converter");
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
    }

	
	/**
	 * @name 	main
	 * @desc 	Run the converter, opening the program.
	 * 
	 * @param	String[] args
	 */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

            	Converter converter = new Converter();
            	converter.setVisible(true);
            }
        });
    }
}