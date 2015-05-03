package demo.model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Petar Tahchiev
 * @since 0.6
 */
@Cacheable
@Entity(name = PrincipalModel.NAME)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = PrincipalModel.NAME, uniqueConstraints = {
    @UniqueConstraint(columnNames = {
        "pk",
        "id"
    })
}, indexes = {
    @Index(columnList = "id")
})
public class PrincipalModel extends AbstractEntityModel {
	    public final static String NAME = "principal";
}
