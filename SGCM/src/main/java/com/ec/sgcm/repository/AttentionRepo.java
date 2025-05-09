package com.ec.sgcm.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ec.sgcm.model.Attentions;

@Repository
public interface AttentionRepo extends JpaRepository<Attentions, Long> {

        @Query("FROM Attentions a WHERE a.dateAttention BETWEEN :startOfYear AND :endOfYear")
        List<Attentions> getAllAttentionOnYear(@Param("startOfYear") LocalDate startOfYear,
                        @Param("endOfYear") LocalDate endOfYear);

        @Query(value = "SELECT TO_CHAR(date_attention, 'Month') AS month, " +
                        "EXTRACT(YEAR FROM date_attention) AS year, " +
                        "COUNT(*) AS totalAttention " +
                        "FROM attentions " +
                        "GROUP BY year, month " +
                        "ORDER BY year, month", nativeQuery = true)
        List<Object[]> getAnnualAttendancesGroupedByMonthNative();

}
