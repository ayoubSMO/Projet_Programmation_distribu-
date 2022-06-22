package org.sid.customerservice.Repositories;

import org.sid.customerservice.Model.Bill;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BILLING-SERVICE")
public interface BillingRestClient {

    @GetMapping(path = "/bills/c/{id}")
    public void deleteBillsByCustomerID(@PathVariable Long id);

    @GetMapping(path = "/bills")
    public PagedModel<Bill> getBills();
}
