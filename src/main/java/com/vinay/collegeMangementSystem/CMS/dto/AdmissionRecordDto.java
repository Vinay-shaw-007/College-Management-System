package com.vinay.collegeMangementSystem.CMS.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdmissionRecordDto {

    private Long id;

    private Integer fees;

    private StudentDto student;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdmissionRecordDto that = (AdmissionRecordDto) o;
        return Objects.equals(id, that.id) && Objects.equals(fees, that.fees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fees);
    }
}
