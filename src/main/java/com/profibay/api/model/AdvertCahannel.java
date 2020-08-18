package com.profibay.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity (name = "advert_channel") // Название таблицы

@Data
@NoArgsConstructor
public class AdvertCahannel extends BaseModel {

    @Column(name = "advert_channel_name")
    private String advertChannelName;

}
