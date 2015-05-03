package demo.model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Petar Tahchiev
 * @since 0.6
 */

@Cacheable
@Entity(name = CustomerModel.NAME)
public class CustomerModel extends UserModel {
	public final static String NAME = "customer";
}
