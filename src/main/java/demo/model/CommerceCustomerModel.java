package demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;


@Entity(name = "commerce_customer")
public class CommerceCustomerModel extends CustomerModel {

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, targetEntity = PaymentModel.class, cascade = { CascadeType.ALL })
    private Collection<PaymentModel> paymentInfos;

}