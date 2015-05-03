package demo.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Petar Tahchiev
 * @since 0.6
 */
@MappedSuperclass
public class AbstractEntityModel {
    @Id
    @Column(name = "pk", nullable = false, unique = true)
    private Long pk;

    @Column
    private String id;

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }

    public String getId() {
    	return this.id;
    }

    public void setId(String id) {
    	this.id = id;
    }
}
