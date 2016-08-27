package converter;

/**
 * @name 	ConvertArea
 * @package	Converter
 * @author 	Jesse Pasos
 * @desc 	Handle temperature conversions.
 */
public class ConvertArea {

	// VARIABLE DECLARATIONS:
	public String UNIT_DEFAULT = Constants.KILO_SQ;
	public String UNIT_ORIGINAL;
	public String UNIT_TARGET;	
	public double VALUE;


	/**
	 * @name 	ConvertArea
	 * @desc 	Class constructor for the temperature converter. Defines the UNIT_ORIGINAL, UNIT_TARGET and VALUE 
	 * 			global variables. 
	 * 
	 * @param	String 		originalUnit
	 * @param	String		targetUnit
	 * @param 	Double		value
	 * 
	 */
	public ConvertArea(String originalUnit, String targetUnit, Double value) {
		
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
		
			case Constants.METRE_SQ:
				VALUE = VALUE / 1e+6;
			    break;
				
			case Constants.FOOT_SQ:
				VALUE = VALUE / 1.076e+7;
			    break;
				
			case Constants.MILE_SQ:
				VALUE = VALUE / 0.386102;
			    break;
				
			case Constants.YARD_SQ:
				VALUE = VALUE / 1.196e+6;
			    break;
				
			case Constants.INCH_SQ:
				VALUE = VALUE / 1.55e+9;
			    break;
				
			case Constants.ACRE:
				VALUE = VALUE / 247.105;
			    break;
				
			case Constants.HECTARE:
				VALUE = VALUE / 100;
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
		
			case Constants.METRE_SQ:
				VALUE = VALUE * 1e+6;
			    break;
				
			case Constants.FOOT_SQ:
				VALUE = VALUE * 1.076e+7;
			    break;
				
			case Constants.MILE_SQ:
				VALUE = VALUE * 0.386102;
			    break;
				
			case Constants.YARD_SQ:
				VALUE = VALUE * 1.196e+6;
			    break;
				
			case Constants.INCH_SQ:
				VALUE = VALUE * 1.55e+9;
			    break;
				
			case Constants.ACRE:
				VALUE = VALUE * 247.105;
			    break;
				
			case Constants.HECTARE:
				VALUE = VALUE * 100;
			    break;		
		
			default:
				break;
		}
	}
}
