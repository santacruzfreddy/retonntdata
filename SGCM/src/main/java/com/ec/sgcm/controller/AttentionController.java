package com.ec.sgcm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ec.sgcm.model.Attentions;
import com.ec.sgcm.model.dto.AnnualAttentionDTO;
import com.ec.sgcm.services.AttentionService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/atentionRest")
@CrossOrigin(origins = { "*" })
public class AttentionController {

    @Autowired
    AttentionService attentionService;

    @PostMapping("/createNewAtention")
    @ResponseBody
    public ResponseEntity<Attentions> createNewAtention(@RequestBody Attentions antecedents) {
        return ResponseEntity.ok().body(attentionService.createNewAttentio(antecedents));
    }

    @GetMapping("/getAllAttentiononYear")
    public ResponseEntity<AnnualAttentionDTO> getAllAttentiononYear() {
        return ResponseEntity.ok().body(attentionService.getAllAttentiononYear());
    }

    @GetMapping("/annualAttendanceToMonth")
    public ResponseEntity<?> annualAttendanceToMonth() {
        return ResponseEntity.ok().body(attentionService.annualAttendanceToMonth());
    }

}
