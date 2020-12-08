package com.galbern.req.domain;


import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

//@EqualsAndHashCode(callSuper = false)
//@Data
//@NoArgsConstructor
@Entity
@Table(name = "PROJECTS")
@DynamicUpdate
@DynamicInsert
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean isActive;

//    @OneToOne(mappedBy ="project", cascade=CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//    @JsonBackReference
//    private Customer customer;

    @OneToMany(mappedBy="project", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Stage> stages;
//
//    @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id")
//    private Address address;

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }

    public Set<Stage> getStages() {
        return stages;
    }

    public void setStages(Set<Stage> stages) {
        this.stages = stages;
    }

//    public Address getAddress() {
//        return address;
//    }

//    public void setAddress(Address address) {
//        this.address = address;
//    }

    // 1-M handling remove() and add() --- equals and hashcode on child [M-1] side

//    public void removeCustomer(Customer customer) {
//      this.customer = null;
//      customer.setProject(null);
//    }
//
//    public void addCustomer(Customer customer) {
//        this.customer = customer;
//    }

    public void removeStage(Stage stage){
        stages.remove(stage);
        stage.setProject(null);
    }

}
