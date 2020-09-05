package com.profibay.api.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.profibay.api.model.ReasonCancellation;
import com.profibay.api.model.enums.ReasonCancellationEnum;
import com.profibay.api.model.enums.Statuses;
import com.profibay.api.repo.ReasonCancellationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/api/v1/reason_cancellation")

public class ReasonCancellationController  {

    public final ReasonCancellationRepo reasonCancellationRepo;

    @Autowired
    public ReasonCancellationController(ReasonCancellationRepo reasonCancellationRepo) {
        this.reasonCancellationRepo = reasonCancellationRepo;
    }

@PostMapping("add/many")
@JsonProperty("Reason")
    public ResponseEntity addReasonCancellation(@RequestBody List<ReasonCancellation> reasonCancellation)
{

    List<ReasonCancellation> reasonCancellations2 = new ArrayList<>();

    reasonCancellation
            .forEach(reason ->
                    {
                        reason.setCreated(LocalDateTime.now());
                        reason.setUpdated(LocalDateTime.now());
                        reason.setStatus(Statuses.ACTIVE);
                        reason.setReasonCancellation(ReasonCancellationEnum.DEPARTURE_OF_THE_HANDYMAN);
                        reasonCancellations2.add(reasonCancellationRepo.save(reason));
                    }
                    );

    return ResponseEntity.ok(reasonCancellation);
}

}
