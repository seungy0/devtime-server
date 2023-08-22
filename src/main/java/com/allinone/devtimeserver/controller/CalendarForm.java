package com.allinone.devtimeserver.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class CalendarForm {
    Long id;
    Long memberId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "Yyyy-mm-dd HH:mm:ss")
    Date Date;
    Long projectId;
    String language;
}
