package com.profibay.api.repo;

import com.profibay.api.model.MasterReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterReviewRepo  extends JpaRepository<MasterReview, Integer> {
}
