package converter;

/**
 * @name 	ConvertLength
 * @package	Converter
 * @author 	Jesse Pasos
 * @desc 	Handle length conversions.
 */
public class ConvertLength {

	// VARIABLE DECLARATIONS:
	public String UNIT_DEFAULT = Constants.KILOMETRE;	
	public String UNIT_ORIGINAL;
	public String UNIT_TARGET;	
	public double VALUE;
	

	/**
	 * @name 	ConvertLength
	 * @desc 	Class constructor for the temperature converter. Defines the UNIT_ORIGINAL, UNIT_TARGET and VALUE 
	 * 			global variables. 
	 * 
	 * @param	String 		originalUnit
	 * @param	String		targetUnit
	 * @param 	Double		value
	 * 
	 */
	public ConvertLength(String originalUnit, String targetUnit, Double value) {
		
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
		
			case Constants.METRE:
				VALUE = VALUE / 1000;
			    break;
				
			case Constants.CENTIMETRE:
				VALUE = VALUE / 100000;
			    break;
		
			case Constants.MILLIMETRE:
				VALUE = VALUE / 1e+6;
			    break;
		
			case Constants.MICROMETRE:
				VALUE = VALUE / 1e+9;
			    break;
		
			case Constants.NANOMETRE:
				VALUE = VALUE / 1e+12;
			    break;
		
			case Constants.MILE:
				VALUE = VALUE / 0.621371;
			    break;
		
			case Constants.YARD:
				VALUE = VALUE / 1093.61;
			    break;
		
			case Constants.FOOT:
				VALUE = VALUE / 3280.84;
			    break;
		
			case Constants.INCH:
				VALUE = VALUE / 39370.1;
			    break;
		
			case Constants.NAUT_MILE:
				VALUE = VALUE / 0.539957;
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
		
			case Constants.METRE:
				VALUE = VALUE * 1000;
			    break;
				
			case Constants.CENTIMETRE:
				VALUE = VALUE * 100000;
			    break;
		
			case Constants.MILLIMETRE:
				VALUE = VALUE * 1e+6;
			    break;
		
			case Constants.MICROMETRE:
				VALUE = VALUE * 1e+9;
			    break;
		
			case Constants.NANOMETRE:
				VALUE = VALUE * 1e+12;
			    break;
		
			case Constants.MILE:
				VALUE = VALUE * 0.621371;
			    break;
		
			case Constants.YARD:
				VALUE = VALUE * 1093.61;
			    break;
		
			case Constants.FOOT:
				VALUE = VALUE * 3280.84;
			    break;
		
			case Constants.INCH:
				VALUE = VALUE * 39370.1;
			    break;
		
			case Constants.NAUT_MILE:
				VALUE = VALUE * 0.539957;
			    break;
			    
			default:
				break;
		}
	}
}
