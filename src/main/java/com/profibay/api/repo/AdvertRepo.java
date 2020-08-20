package com.profibay.api.repo;

import com.profibay.api.model.AdvertCahannel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertRepo extends JpaRepository<AdvertCahannel, Long> {
}
