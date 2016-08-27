package converter;

/**
 * @name 	Constants
 * @package	Converter
 * @author 	Jesse Pasos
 * @desc 	A list of defined constants.
 * 
 */
public final class Constants {

	// UNIT TYPES:
	public static final String  AREA 		= "Area";
	public static final String  LENGTH 		= "Length";
	public static final String  MASS 		= "Mass";
	public static final String  TEMPERATURE = "Temperature";
	
	// AREA UNIT OPTIONS:
	public static final String  KILO_SQ 	= "Square Kilometre";
	public static final String  METRE_SQ 	= "Square Metre";
	public static final String  FOOT_SQ 	= "Square Foot";
	public static final String  MILE_SQ 	= "Square Mile";	
	public static final String  YARD_SQ 	= "Square Yard";	
	public static final String  INCH_SQ 	= "Square Inch";	
	public static final String  ACRE 		= "Acre";	
	public static final String  HECTARE 	= "Hectare";	

	// LENGTH UNIT OPTIONS:
	public static final String  KILOMETRE 	= "Kilometre";
	public static final String  METRE 		= "Metre";
	public static final String  CENTIMETRE 	= "Centimetre";
	public static final String  MILLIMETRE 	= "Millimetre";
	public static final String  MICROMETRE 	= "Micrometre";
	public static final String  NANOMETRE 	= "Nanometre";
	public static final String  MILE 		= "Mile";
	public static final String  YARD 		= "Yard";
	public static final String  FOOT 		= "Foot";
	public static final String  INCH 		= "Inch";
	public static final String  NAUT_MILE 	= "Nautical Mile";	

	// MASS UNIT OPTIONS:
	public static final String  GRAM 		= "Gram";
	public static final String  TONNE 		= "Tonne";
	public static final String  KILOGRAM 	= "Kilogram";
	public static final String  STONE 		= "Stone";
	public static final String  POUND		= "Pound";
	public static final String  MILLIGRAM	= "Miligram";
	public static final String  MICROGRAM	= "Microgram";
	public static final String  IMP_TON 	= "Imperial Ton";
	public static final String  US_TON 		= "US Ton";
	public static final String  OUNCE		= "Ounce";

	// TEMPERATURE UNIT OPTIONS:
	public static final String  CELSIUS		= "Celsius";
	public static final String  FAHRENHEIT	= "Fahrenheit";
	public static final String  KELVIN 		= "Kelvin";	
	
	// UNIT ARRAYS:
	public static final String[] UNIT_TYPE 		= { AREA, LENGTH, MASS, TEMPERATURE };	
	public static final String[] UNIT_AREA 		= { KILO_SQ, METRE_SQ, FOOT_SQ, MILE_SQ, YARD_SQ, INCH_SQ, ACRE, HECTARE };
	public static final String[] UNIT_LENGTH	= { KILOMETRE, METRE, CENTIMETRE, MILLIMETRE, MICROMETRE, NANOMETRE, MILE, YARD, FOOT, INCH, NAUT_MILE };
	public static final String[] UNIT_MASS 		= { GRAM, TONNE, KILOGRAM, STONE, POUND, MILLIGRAM, MICROGRAM, IMP_TON, US_TON, OUNCE };
	public static final String[] UNIT_TEMPERATURE 	= { CELSIUS, FAHRENHEIT, KELVIN };	

	
	/**
	 * @name 	Converter
	 * @desc 	Constants class constructor.
	 * 
	 */
	private Constants() {}	
}
