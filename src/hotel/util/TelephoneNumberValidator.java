package hotel.util;

public class TelephoneNumberValidator
	implements Validator {

	// --------------------------------------------------
	// Constructor(s)
	
	// --------------------------------------------------
	// Accessor(s)
	
	@Override
	public ValidationError validate() {
		return null;
	}
	
	// --------------------------------------------------
	// Mutators(s)
	
	public TelephoneNumberValidator value(String str) {
		value = str;
		return this;
	}
	
	// --------------------------------------------------
	// Method(s)
	
	// --------------------------------------------------
	// Attribute(s)

	public String value;
}
