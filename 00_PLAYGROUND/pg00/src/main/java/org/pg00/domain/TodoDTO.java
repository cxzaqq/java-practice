package org.pg00.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@ToString
public class TodoDTO {

    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.util.Date dueDate;
}
