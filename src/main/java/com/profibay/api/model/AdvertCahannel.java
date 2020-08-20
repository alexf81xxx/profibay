package com.profibay.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.profibay.api.repo.AdvertRepo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity(name = "advert_channel") // Название таблицы
public class AdvertCahannel extends BaseModel {


    @Column(name = "advert_channel_name")//  Это для БД
    @JsonProperty("advert_channel_name")//  Это для JSON
    private String advertChannelName;

}
