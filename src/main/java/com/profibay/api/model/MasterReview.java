package com.profibay.api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "master_review")

@Data
@NoArgsConstructor
public class MasterReview extends BaseModel {

    @Column(name="review")
    private String review;

    @ManyToOne
    @JoinColumn(name = "master_id")
    @JsonIgnore
    private Master master;



}
