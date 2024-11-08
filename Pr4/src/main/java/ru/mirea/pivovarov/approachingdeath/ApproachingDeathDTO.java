package ru.mirea.pivovarov.approachingdeath;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApproachingDeathDTO {
    @JsonProperty("discovery_date")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime discoveryDate;

    public LocalDateTime getDate() {
        return discoveryDate;
    }
}
