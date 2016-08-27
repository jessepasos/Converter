package converter;

/**
 * @name 	ConvertTemperature
 * @package	Converter
 * @author 	Jesse Pasos
 * @desc 	Handle temperature conversions.
 */
public class ConvertTemperature {
	
	// VARIABLE DECLARATIONS:
	public String UNIT_DEFAULT = Constants.CELSIUS;
	public String UNIT_ORIGINAL;
	public String UNIT_TARGET;	
	public double VALUE;

	/**
	 * @name 	ConvertTemperature
	 * @desc 	Class constructor for the temperature converter. Defines the UNIT_ORIGINAL, UNIT_TARGET and VALUE 
	 * 			global variables. 
	 * 
	 * @param	String 		originalUnit
	 * @param	String		targetUnit
	 * @param 	Double		value
	 * 
	 */
	public ConvertTemperature(String originalUnit, String targetUnit, Double value) {
		
		UNIT_ORIGINAL 	= originalUnit;
		UNIT_TARGET 	= targetUnit;		
		VALUE 			= value;
	}


	/**
	 * @name 	result
	 * @desc 	Call the conversion functions and then return the resulting value.

	 * @return	Double 	VALUE 	returns the VALUE global variable.
	 * 
	 */
	public Double result() {

        setConversion();	// Convert the original value into it's default unit.
        getConversion();	// Convert the default value into the desired unit.
		
		return VALUE;
	}


	/**
	 * @name 	setConversion
	 * @desc 	Convert the original value into it's default unit. This function sets the global VALUE variable.
	 * 
	 */
	public void setConversion () {
		
		switch (UNIT_ORIGINAL) {
			
			// Convert FAHRENHEIT to CALCIUS
			case Constants.FAHRENHEIT:
				VALUE = ((VALUE - 32) * 5) / 9;
			    break;

				
			// Convert KELVIN to CALCIUS
			case Constants.KELVIN:
				VALUE = VALUE - 273.15;
				break;

			default:
				break;
		}		
	}


	/**
	 * @name 	getConversion
	 * @desc 	Convert the default value into the desired unit. This function sets the global VALUE variable.
	 * 
	 */
	public void getConversion() {
		
		switch (UNIT_TARGET) {
		
			// Convert CALCIUS to FAHRENHEIT
			case Constants.FAHRENHEIT:
				VALUE = ((VALUE * 9) / 5) + 32;
				break;

			// Convert CALCIUS to KALVIN
			case Constants.KELVIN:
				VALUE = VALUE + 273.15;
				break;
			default:
				break;
		}
	}
}

