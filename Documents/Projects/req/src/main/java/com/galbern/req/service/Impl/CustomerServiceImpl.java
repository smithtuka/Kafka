package com.galbern.req.service.Impl;

import com.galbern.req.dao.CustomerDao;
import com.galbern.req.domain.Customer;
import com.galbern.req.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @PersistenceContext
    @Autowired
    private EntityManager entityManager;

    @Override
    public Customer addCustomer(Customer c){
      return customerDao.save(c);
    }

    @Override
    public Set<Customer> getCustomers() {
        TypedQuery<Customer> query = entityManager.createQuery(
                "SELECT c FROM Customer c ", Customer.class); //LEFT JOIN c.address
        return query.getResultStream().collect(Collectors.toSet());
    }

    @Override
    public Customer findCustomerById(Long id) {

        EntityGraph<Customer> entityGraph = entityManager.createEntityGraph(Customer.class);
        entityGraph.addAttributeNodes("address", "project");
        TypedQuery<Customer> query = entityManager.createQuery(
                "SELECT c FROM Customer c  where c.id = :id ", Customer.class)
                .setParameter("id", id)
                .setHint("javax.persistence.fetchgraph", entityGraph);
        var customer = Optional.ofNullable(query.getSingleResult());

        return customer.orElse(null);
    }

    @Override
    public Customer editCustomer(Long id) {
        return null;
    }

    @Override
    public Customer deleteCustomer(Long id) {
        return null;
    }



}