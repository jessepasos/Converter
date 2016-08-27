package converter;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 * @name 	HandleUserInterface
 * @package	Converter
 * @author 	Jesse Pasos
 * @desc 	Builds the user interface components and sets the appropriate action listeners. 
 */
public class HandleUserInterface extends JPanel implements ActionListener  {

	// VARIABLE DECLARATIONS:
	private static final long serialVersionUID = 1L;
		
	
	// CONVERTER CONTROLL CLASS:
	private static ConverterControl cvControl = new ConverterControl();

	
	// STRING 'TITLE' VARIABLES:
	private static String 		titleConvertionType 	= "Select a conversion type: ";
	private static String 		titleOriginalValue		= "Original value: ";
	private static String 		titleResultingValue 	= "Converted value: ";
	private static String 		titleActionPanel 		= "Actions: ";
	
	
	// PANEL VARIABLES:
	private static JPanel 		panel_main 				= new JPanel();
	private static JPanel		panel_units				= new JPanel();
	private static JPanel 		panel_convertType		= new JPanel();
	private static JPanel		panel_originalValue		= new JPanel();
	private static JPanel		panel_resultingValue	= new JPanel();
	private static JPanel 		panel_actions			= new JPanel();
	
	
	// TEXT FIELD VARIABLES:
	private static JTextField	textField_originalValue = new JTextField();
	private static JTextField	textField_resultingValue = new JTextField();
	
	
	// BUTTON VARIABLES:
	private static JButton 		button_submit 			= new JButton("Convert");
	private static JButton 		button_reset			= new JButton("Reset");
	
	
	// COMBO-BOX VARIABLES:
	private static JComboBox<String> 	comboBox_convertType	= new JComboBox<String>(Constants.UNIT_TYPE);
	private static JComboBox<String> 	comboBox_originalUnit	= new JComboBox<String>(Constants.UNIT_AREA);
	private static JComboBox<String> 	comboBox_resultingUnit	= new JComboBox<String>(Constants.UNIT_AREA);
	

	/**
	 * @name 	HandleUserInterface
	 * @desc 	Class constructor. Set all component panels and action listeners.
	 * 
	 */
	public HandleUserInterface() {
	
		// Set panels:
		setConvertTypePanel();
		setOriginalPanel();
		setDesiredPanel();		
		setActionPanel();
		setMainPanel();
		
		
		// Set main panel:
		add(panel_main);
		
		
		// Add listeners:
		comboBox_convertType.addActionListener(this);
		comboBox_originalUnit.addActionListener(this);
		comboBox_resultingUnit.addActionListener(this);
		textField_originalValue.addActionListener(this);
		textField_resultingValue.addActionListener(this);
		button_submit.addActionListener(this);
		button_reset.addActionListener(this);
		
	}	


	/**
	 * @name 	setConvertTypePanel
	 * @desc 	Build the convert type panel. This panel contains the 'conversion type' combo box.
	 * 
	 * @return	void
	 * 
	 */
	public static void setConvertTypePanel() {
		
		// Build the panel container:
		panel_convertType.setBorder(
			BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(titleConvertionType), 
				BorderFactory.createEmptyBorder(5,5,5,5)
			)
		);
		
		
		// Set the panels grid layout:
		panel_convertType.setLayout(new GridLayout(1, 1, 5, 5));
		
		
		// Add the 'convert type' combo box:
		panel_convertType.add(comboBox_convertType);
		
	}


	/**
	 * @name 	setOriginalPanel
	 * @desc 	Builds the original value panel. This panel contains the 'original value' text field and the 
	 * 			'original unit' combo box.
	 * 	
	 * @return	void
	 * 
	 */
	public static void setOriginalPanel() {
		
		// Build the panel container:
		panel_originalValue.setBorder(
			BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(titleOriginalValue), 
				BorderFactory.createEmptyBorder(5,5,5,5)
			)
		);
		
		
		// Set the panels grid layout:
		panel_originalValue.setLayout(new GridLayout(2, 1, 5, 5));
		
		
		// Set the column size for the original value text field:
		textField_originalValue.setColumns(10);
		
		
		// Add the original value text field:
		panel_originalValue.add(textField_originalValue);
		
		
		// Add the original unit combo box:
		panel_originalValue.add(comboBox_originalUnit);
		
	}


	/**
	 * @name 	setDesiredPanel
	 * @desc 	Builds the desired value panel. This panel contains the 'desired value' text field and the 
	 * 			'desired unit' combo box.
	 * 	
	 * @return	void
	 * 
	 */
	public static void setDesiredPanel() {
		
		// Build the panel container:
		panel_resultingValue.setBorder(
			BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(titleResultingValue), 
				BorderFactory.createEmptyBorder(5,5,5,5)
			)
		);
		
		
		// Set the panels grid layout:
		panel_resultingValue.setLayout(new GridLayout(2, 1, 5, 5));
		
		
		// Set the column size for the desired value text field:
		textField_resultingValue.setColumns(10);
		
		
		// Add the desired value text field:
		panel_resultingValue.add(textField_resultingValue);
		
		
		// Add the desired unit combo box:
		panel_resultingValue.add(comboBox_resultingUnit);
		
	};


	/**
	 * @name 	setActionPanel
	 * @desc 	Builds the action panel. This panel contains the 'convert' button and the 'reset button'.
	 * 	
	 * @return	void
	 * 
	 */
	public static void setActionPanel() {
		
		// Build the panel container:
		panel_actions.setBorder(
				BorderFactory.createCompoundBorder(
					BorderFactory.createTitledBorder(titleActionPanel), 
					BorderFactory.createEmptyBorder(5,5,5,5)
				)
			);
		
		
		// Set the panels grid layout:
		panel_actions.setLayout(new GridLayout(2, 1, 5, 5));
		
		
		// Add the submit button:
		panel_actions.add(button_submit);
		
		
		// Add the reset button:
		panel_actions.add(button_reset);
		
	}


	/**
	 * @name 	setMainPanel
	 * @desc 	Builds the main panel, placing all of the other panels.
	 * 	
	 * @return	void
	 * 
	 */
	public static void setMainPanel() {
		
		// Set units panel:
		panel_units.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel_units.setLayout(new GridLayout(1, 2, 5, 5));
		panel_units.add(panel_originalValue);
		panel_units.add(panel_resultingValue);
		
		
		// Set main panel:
		panel_main.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel_main.setLayout(new GridLayout(3, 1, 5, 5));
		panel_main.add(panel_convertType);
		panel_main.add(panel_units);
		panel_main.add(panel_actions);
	}


	/**
	 * @name 	setControls
	 * @desc 	(Re)assign the cvControl global variables based on the current values of the associated components. 
	 * 	
	 * @return	void
	 * 
	 */
	public void setControls() {
		
		// Reset the combo box values:
		cvControl.comboBox_convertType 		= comboBox_convertType;
		cvControl.comboBox_originalUnit 	= comboBox_originalUnit;
		cvControl.comboBox_resultingUnit 	= comboBox_resultingUnit;
		
		// Reset the text field values:
		cvControl.textField_originalValue 	= textField_originalValue;
		cvControl.textField_resultingValue 	= textField_resultingValue;
		
	}
	
	


	/**
	 * @name 	actionPerformed
	 * @desc 	Respond to any triggered actions. Run the setControls() function to redefine the ConverterControl
	 * 			variables and then run the appropriate ConvertedControl actions depending on the currently active 
	 * 			action.
	 * 
	 * @param	ActionEvent 	actionEvent
	 * @return	void
	 */
	public void actionPerformed(ActionEvent actionEvent) {

		// (Re)assign the cvControl global variables based on the current values of the associated components:
		setControls();		
		
		
		// Change in the conversion type combo box selection:
		if(actionEvent.getSource() == comboBox_convertType) {					
			cvControl.actionChangeType();			
		}	
		
		
		// Change in the original value text field:
		if(actionEvent.getSource() == textField_originalValue) {	
			cvControl.actionChangeValue(true);		
		}
		
		
		// Change in the resulting value text field:
		if(actionEvent.getSource() == textField_resultingValue) {	
			cvControl.actionChangeValue(false);		
		}
		
		
		// Click of the submit button:
		if(actionEvent.getSource() == button_submit) {	
			cvControl.actionChangeValue(true);	
		}
		
		
		// Click of the reset button:
		if(actionEvent.getSource() == button_reset) {	
			cvControl.actionReset();		
		}
	}
}
