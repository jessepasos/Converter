package converter;

/**
 * @name 	ConvertMass
 * @package	Converter
 * @author 	Jesse Pasos
 * @desc 	Handle temperature conversions.
 */
public class ConvertMass {

	// VARIABLE DECLARATIONS:
	public String UNIT_DEFAULT = Constants.GRAM;
	public String UNIT_ORIGINAL;
	public String UNIT_TARGET;	
	public double VALUE;

	
	/**
	 * @name 	ConvertMass
	 * @desc 	Class constructor for the temperature converter. Defines the UNIT_ORIGINAL, UNIT_TARGET and VALUE 
	 * 			global variables. 
	 * 
	 * @param	String 		originalUnit
	 * @param	String		targetUnit
	 * @param 	Double		value
	 * 
	 */
	public ConvertMass(String originalUnit, String targetUnit, Double value) {
		
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
		
			case Constants.TONNE:
				VALUE = VALUE / 1e-6;
			    break;
				
			case Constants.KILOGRAM:
				VALUE = VALUE / 0.001;
				break;
					
			case Constants.STONE:
				VALUE = VALUE / 0.000157473;
				break;
				
			case Constants.POUND:
				VALUE = VALUE / 0.00220462;
				break;
				
			case Constants.MILLIGRAM:
				VALUE = VALUE / 1000;
				break;
				
			case Constants.MICROGRAM:
				VALUE = VALUE / 1e+6;
				break;
				
			case Constants.IMP_TON:
				VALUE = VALUE / 9.8421e-7;
				break;
				
			case Constants.US_TON:
				VALUE = VALUE / 1.1023e-6;
				break;
				
			case Constants.OUNCE:
				VALUE = VALUE / 0.035274;
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
		
			case Constants.TONNE:
				VALUE = VALUE * 1e-6;
			    break;
				
			case Constants.KILOGRAM:
				VALUE = VALUE * 0.001;
				break;
					
			case Constants.STONE:
				VALUE = VALUE * 0.000157473;
				break;
				
			case Constants.POUND:
				VALUE = VALUE * 0.00220462;
				break;
				
			case Constants.MILLIGRAM:
				VALUE = VALUE * 1000;
				break;
				
			case Constants.MICROGRAM:
				VALUE = VALUE * 1e+6;
				break;
				
			case Constants.IMP_TON:
				VALUE = VALUE * 9.8421e-7;
				break;
				
			case Constants.US_TON:
				VALUE = VALUE * 1.1023e-6;
				break;
				
			case Constants.OUNCE:
				VALUE = VALUE * 0.035274;
				break;
		
			default:
				break;
		}
	}
}

