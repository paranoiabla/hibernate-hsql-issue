package demo.model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author Petar Tahchiev
 * @since 0.6
 */
@Cacheable
@Entity(name = CreditCardPaymentModel.NAME)
public class CreditCardPaymentModel extends PaymentModel {

    public final static String NAME = "creditcard_payment_info";
}
