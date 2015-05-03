package demo.model;

import java.util.Collection;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Petar Tahchiev
 * @since 0.6
 */

@Cacheable
@Entity(name = UserModel.NAME)
public class UserModel extends PrincipalModel {

    public final static String NAME = "user";
}
