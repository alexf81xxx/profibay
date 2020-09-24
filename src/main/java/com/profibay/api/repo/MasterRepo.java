package com.profibay.api.repo;

import com.profibay.api.model.Master;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterRepo extends JpaRepository <Master, Integer> {

    Master findByPhone1 (String phone1);
}
