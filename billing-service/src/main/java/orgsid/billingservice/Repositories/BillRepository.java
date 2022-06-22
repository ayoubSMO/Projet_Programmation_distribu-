package orgsid.billingservice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.GetMapping;
import orgsid.billingservice.Entities.Bill;

import java.util.Collection;
import java.util.List;

@RepositoryRestResource
public interface BillRepository extends JpaRepository<Bill, Long> {
    public Collection<Bill> getBillsByCustomerID(Long customerID);
//    public Bill findBillById(Long id);
}
