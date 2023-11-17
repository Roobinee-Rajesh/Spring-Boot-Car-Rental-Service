package com.restapi.request.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.time.LocalDateTime;

@Component
@Getter
@Setter
public class CarRequest {
    @NotEmpty
    private String  start_date;

    @NotEmpty
    private String  end_date;
}
