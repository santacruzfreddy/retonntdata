package com.ec.sgcm.services;

import java.util.List;

import com.ec.sgcm.model.Attentions;
import com.ec.sgcm.model.dto.AnnualAttentionDTO;
import com.ec.sgcm.model.dto.AttentionWithMonth;

public interface AttentionService {

    public Attentions createNewAttentio(Attentions attention);

    public AnnualAttentionDTO getAllAttentiononYear();

    public List<AttentionWithMonth> annualAttendanceToMonth();
}
