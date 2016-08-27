package converter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * @name 	ConverterControl
 * @package	Converter
 * @author 	Jesse Pasos
 * @desc 	Handle actions performed on the Converter UI.
 * 
 */
public class ConverterControl extends JPanel implements ActionListener {  

	// VARIABLE DECLARATIONS:
	private static final long 	serialVersionUID 	= 1L;
	
	// STRINGS:
	public static 	String 		string_convertType;
	public static 	String 		string_originalUnit;
	public static 	String 		string_originalValue;
	public static 	String 		string_resultingUnit;
	public static 	String 		string_desiredValue;
	
	// COMBO BOXES:
	public JComboBox<String>	comboBox_convertType;
	public JComboBox<String> 	comboBox_originalUnit;
	public JComboBox<String> 	comboBox_resultingUnit;

	// TEXT FIELDS:
	public JTextField 			textField_originalValue;
	public JTextField 			textField_resultingValue;


	/**
	 * @name 	actionPerformed
	 * @desc 	When any action is performed, run the updateValues() function.
	 * 
	 * @param	ActionEvent 	actionEvent
	 * @return 	void
	 * 
	 */
	public void actionPerformed(ActionEvent actionEvent) {
		updateValues();
	}


	/**
	 * @name 	updateValues
	 * @desc 	(Re)assign the classes global variables based on the updated values of the JFrame components.
	 * 
	 * @return 	void
	 * 
	 */
	public void updateValues() {
		
		// COMBO BOX COMPONENTS:
		string_convertType 		= comboBox_convertType.getSelectedItem().toString();
		string_originalUnit 	= comboBox_originalUnit.getSelectedItem().toString();
		string_resultingUnit 		= comboBox_resultingUnit.getSelectedItem().toString();
		
		// TEXT FIELD COMPONENTS:
		string_originalValue 	= textField_originalValue.getText();
		string_desiredValue 	= textField_resultingValue.getText();
	}


	/**
	 * @name 	determineUnit
	 * @desc 	Determine the applicable unit array based on the value of the current unit type.
	
	 * @return	String[] 	An array of units applying to the current unit type.
	 * 
	 */
	public String[] determineUnit() {
		
		switch(string_convertType) {
			case Constants.AREA:
				return Constants.UNIT_AREA;
				
			case Constants.LENGTH:
				return Constants.UNIT_LENGTH;
				
			case Constants.MASS:
				return Constants.UNIT_MASS;
				
			case Constants.TEMPERATURE: 
				return Constants.UNIT_TEMPERATURE;
				
			default:
				return Constants.UNIT_AREA;
		}
	}


	/**
	 * @name 	checkIfValid
	 * @desc 	Check if the current input can be converted into a valid Double value.
	 * 
	 * @param	String 		strValue 		The current string value of the active text field component. 
	 * @return	Boolean		True if the value can be converted into a a type double.
	 * 
	 */
	public Boolean checkIfValid(String strValue) {	
		
		// Try and cast the string value into a double:
		try {
	        Double.valueOf(strValue);
	        return true;
	    } 
		// Return false if exception is thrown:
		catch (NumberFormatException e) {
	        return false;
	    }
	}


	/**
	 * @name 	actionChangeType
	 * @desc 	Respond to a change in the overall unit type combo box. 
	 * 	
	 * @return	void
	 * 
	 */
	public void actionChangeType() {
		
		// Reassign the classes global variables based on the updated values of the JFrame components:
		updateValues();

		
		// Remove all items from the original and desired unit combo boxes:
		comboBox_originalUnit.removeAllItems();
		comboBox_resultingUnit.removeAllItems();
		
		
		// Clear the value from the original and desired text fields:
		textField_originalValue.setText(null);
		textField_resultingValue.setText(null);
			
		
		// Acquire an array of new unit values:
		String[] newUnitList = determineUnit();
				
		
		// Cycle through the array of units in order to populate the original and desired combo box areas:
		for(int count = 0; count < newUnitList.length; count++) {
			comboBox_originalUnit.addItem(newUnitList[count]);
			comboBox_resultingUnit.addItem(newUnitList[count]);
		}
	}


	/**
	 * @name 	actionChangeValue
	 * @desc 	Responds to a conversion action. Processed the supplied variables and reassigns them to the 
	 * 			appropriate text field component. 
	 * 
	 * @param	Boolean 	blnSource 	A true value indicates that the 'original value' field is being modified.
	 * 									A false value indicates that the 'converted value' field is being modified.
	 * @return	void
	 * 
	 */
	public void actionChangeValue(Boolean blnSource) {
		
		// Reassign the classes global variables based on the updated values of the JFrame components:
		updateValues();
		
		
		// Set the placeholder variables for the original and converted values:
		String 		newOriginal 	= "0.0";
		String 		newResult 		= "0.0";
		
		
		// Set the default components for the original and resulting values:
		JTextField 	textFieldOriginal = textField_originalValue;
		JTextField 	textFieldResult = textField_resultingValue;
		
		
		// If true, converting original to desired:
		String valueSource 	= string_originalValue;
		String unitSource 	= string_originalUnit;
		String unitTarget	= string_resultingUnit;
		
		
		// If false, converting desired to original:
		if(!blnSource) {
			valueSource = string_desiredValue;
			unitSource 	= string_resultingUnit;
			unitTarget	= string_originalUnit;
			textFieldOriginal = textField_resultingValue;
			textFieldResult = textField_originalValue;
		}
						
		// Check if value is valid or not:
		if(!checkIfValid(valueSource)) {
			// If invalid change result to "invalid" string:
			newOriginal = "invalid";
			newResult = "invalid";
		}	
		else {
			// If valid, convert value:
			Double dblValue = Double.valueOf(valueSource);
			newOriginal = String.valueOf(dblValue);
			newResult = convert(dblValue, unitSource, unitTarget);
		}		

		
		// Set the original and result text areas with their new values:
		textFieldOriginal.setText(newOriginal);
		textFieldResult.setText(newResult);		
		
	}


	/**
	 * @name 	actionReset
	 * @desc 	Clear all components and reset them to their original on-load values.
	 * 	
	 * @return	void
	 * 
	 */
	public void actionReset() {
		
		// Set the selected conversion type combo box to AREA:
		comboBox_convertType.setSelectedItem(Constants.AREA);
		
		// Run the actionChangeType() function:
		actionChangeType();
	}


	/**
	 * @name 	convert
	 * @desc 	Begin the conversion process. Depending on the specified conversion type value, run the appropriate 
	 * 			conversion class.
	 * 
	 * @param	Double 		valueSource		The original value.
	 * @param	String 		unitSource		The original unit.
	 * @param 	String 		unitTarget		The desired unit.
	 * 
	 * @return	String		A formatted String of the converted value.
	 * 
	 */
	public String convert(Double valueSource, String unitSource, String unitTarget) {
		
		switch(string_convertType) {

			// Handle AREA conversions:
			case Constants.AREA: 
				ConvertArea convertArea = new ConvertArea(unitSource, unitTarget, valueSource);
				return formatResult(convertArea.result());
				
			// Handle LENGTH conversions:
			case Constants.LENGTH: 
				ConvertLength convertLength = new ConvertLength(unitSource, unitTarget, valueSource);
				return formatResult(convertLength.result());
				
			// Handle MASS conversions:
			case Constants.MASS: 
				ConvertMass convertMass = new ConvertMass(unitSource, unitTarget, valueSource);
				return formatResult(convertMass.result());
				
			// Handle TEMPERATURE conversions:
			case Constants.TEMPERATURE: 
				ConvertTemperature convertTemperature = new ConvertTemperature(unitSource, unitTarget, valueSource);
				return formatResult(convertTemperature.result());
					
			// Return "invalid" string:
			default:
				return "Invalid";
		}
	}


	/**
	 * @name 	formatResult
	 * @desc 	Format the supplied Double variable into a string. Use the decimal formatter to round down the 
	 * 			result, set the resulting decimal places, and convert into a string type variable.
	 * 
	 * @param	Double 		result 		The resulting value.
	 * @return	String 		The resulting value formatted into a string.
	 * 
	 */
	public static String formatResult(Double result) {
		
		DecimalFormat decimalFormat = new DecimalFormat("#.#######");
		decimalFormat.setRoundingMode(RoundingMode.CEILING);		
		return decimalFormat.format(result);		
	}
}
