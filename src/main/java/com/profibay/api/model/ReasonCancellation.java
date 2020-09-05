package com.profibay.api.model;


import com.profibay.api.model.enums.ReasonCancellationEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@NoArgsConstructor

@Entity (name = "reason_cancellation")
public class ReasonCancellation extends BaseModel {

@Column (name = "reason_cancellation")
    private ReasonCancellationEnum reasonCancellation;
}
