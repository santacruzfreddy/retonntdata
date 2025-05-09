package com.ec.sgcm.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.sgcm.model.Attentions;
import com.ec.sgcm.model.dto.AnnualAttentionDTO;
import com.ec.sgcm.model.dto.AttentionWithMonth;
import com.ec.sgcm.repository.AttentionRepo;
import com.ec.sgcm.services.AttentionService;

@Service
public class AttentionServiceImpl implements AttentionService {

    @Autowired
    AttentionRepo attentionRepo;

    @Override
    public Attentions createNewAttentio(Attentions attention) {
        attention.setDateAttention(LocalDate.now());
        return attentionRepo.save(attention);
    }

    @Override
    public AnnualAttentionDTO getAllAttentiononYear() {
        LocalDate startOfYear = LocalDate.of(LocalDate.now().getYear(), 1, 1);
        LocalDate endOfYear = LocalDate.of(LocalDate.now().getYear(), 12, 31);

        AnnualAttentionDTO attentions = new AnnualAttentionDTO();
        attentions.setAnnualAttentions(attentionRepo.getAllAttentionOnYear(startOfYear, endOfYear).size());
        attentions.setYear(LocalDate.now().getYear());
        return attentions;

    }

    public List<AttentionWithMonth> annualAttendanceToMonth() {
        List<Object[]> results = attentionRepo.getAnnualAttendancesGroupedByMonthNative();
        List<AttentionWithMonth> attentions = new ArrayList<>();

        for (Object[] row : results) {
            AttentionWithMonth dto = new AttentionWithMonth();
            dto.setMonth(((String) row[0]).trim()); // Elimina espacios extra del mes
            dto.setYear(((Number) row[1]).intValue());
            dto.setTotalAttention(((Number) row[2]).intValue());
            attentions.add(dto);
        }

        return attentions;
    }

}
