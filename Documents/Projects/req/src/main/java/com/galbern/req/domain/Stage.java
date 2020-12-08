package com.galbern.req.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
//import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

//@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@Entity
@Table(name = "STAGES")
@DynamicUpdate
@DynamicInsert
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal budget;
    private Boolean isActive;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Project project;



    @OneToMany(mappedBy = "stage", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Requisition> requisitions;


    // 1-M handling

    public void addRequisition(Requisition requisition) {
        requisitions.add(requisition);
        requisition.setStage(this);
    }

    public void removeRequisition(Requisition requisition) {
        requisitions.remove(requisition);
        requisition.setStage(null);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stage stage = (Stage) o;
        return Objects.equals(id, stage.id) &&
                Objects.equals(name, stage.name) &&
                Objects.equals(budget, stage.budget) &&
                Objects.equals(isActive, stage.isActive) &&
                Objects.equals(project, stage.project) &&
                Objects.equals(requisitions, stage.requisitions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isActive, project, requisitions);
    }
}