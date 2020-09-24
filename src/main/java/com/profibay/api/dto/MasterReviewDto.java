package com.profibay.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.profibay.api.model.Master;
import com.profibay.api.model.MasterReview;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Data
@NoArgsConstructor

public class MasterReviewDto { // Принимаем данные типа MasterReviewDto

    private String review;
    private String masterPhone1;

    public MasterReview toMasterReview() { // Преобразую
        MasterReview masterReview = new MasterReview();
        masterReview.setReview(review);
        return masterReview;
    }
}
