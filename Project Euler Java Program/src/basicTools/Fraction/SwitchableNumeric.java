package basicTools.Fraction;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SwitchableNumeric {


	Number value;

	SwitchableNumeric(String value, NumericTypes type) {

		switch(type) {
		case INTEGER : 
			this.value = new Integer(value);
			this.value = (Integer) this.value;
			break;
		case LONG :
			this.value = new Long(value);
			this.value = (Long) this.value;
			break;
		case DOUBLE: 
			this.value = new Double(value);
			this.value = (Double) this.value;
			break;
		case BIG_INTEGER :
			this.value = new BigInteger(value);
			this.value = (BigInteger) this.value;
			break;
		case BIG_DECIMAL :
			this.value = new BigDecimal(value);
			this.value = (BigDecimal) this.value;
			break;
		}

	}

}
