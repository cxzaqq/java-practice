package org.pg00.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class SampleDTOList {

    private List<SampleDTO> list = new ArrayList<>();
}
