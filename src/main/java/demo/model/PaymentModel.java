package demo.model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Petar Tahchiev
 * @since 0.6
 */
@Cacheable
@Entity(name = PaymentModel.NAME)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = PaymentModel.NAME, uniqueConstraints = {
    @UniqueConstraint(columnNames = {
        "pk",
        "id"
    })
}, indexes = {
    @Index(columnList = "id")
})
public class PaymentModel extends AbstractEntityModel {

	public final static String NAME = "payment_info";

    @ManyToOne(optional = true, targetEntity = CustomerModel.class, fetch = FetchType.LAZY)
    @JoinColumn(unique = false, nullable = true, foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT), referencedColumnName = "pk", updatable = true, insertable = true, name = "user_pk")
    private CustomerModel customer;
}
