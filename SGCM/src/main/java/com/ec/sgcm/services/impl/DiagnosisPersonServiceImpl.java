package com.ec.sgcm.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.sgcm.model.CategoriesCIE;
import com.ec.sgcm.model.DiagnosisPerson;
import com.ec.sgcm.model.Persons;
import com.ec.sgcm.model.dto.DiagnosisPersonsIDDTO;
import com.ec.sgcm.repository.CategorieCIERepo;
import com.ec.sgcm.repository.DiagnosisPersonRepo;
import com.ec.sgcm.repository.PersonRepo;
import com.ec.sgcm.services.DiagnosisPersonService;
import com.ec.sgcm.services.mappers.DiagnosisMapper;

@Service
public class DiagnosisPersonServiceImpl implements DiagnosisPersonService {

    @Autowired
    DiagnosisPersonRepo diagnosisPersonRepo;

    @Autowired
    CategorieCIERepo categorieCIERepo;

    @Autowired
    private PersonRepo personRepo;

    @Override
    public DiagnosisPerson createNewDiagnosisPerson(DiagnosisPerson diagnosisPerson) {
        return diagnosisPersonRepo.save(diagnosisPerson);
    }

    @Override
    public DiagnosisPerson updateDiagnosisPerson(DiagnosisPersonsIDDTO diagnosisPerson) {
        DiagnosisPerson finDiagnosis = diagnosisPersonRepo
                .findByIdPerson(diagnosisPerson.getDiagnosisPerson().getPerson());
        finDiagnosis.setDiagnosisCIE(diagnosisPerson.getDiagnosisPerson().getDiagnosisCIE());
        return diagnosisPersonRepo.save(finDiagnosis);
    }

    @Override
    public List<DiagnosisPerson> getAllDiagnosisPerson() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllDiagnosisPerson'");
    }

    @Override
    public DiagnosisPersonsIDDTO getDiagnosisPersonByPersonId(Long idPerson) {
        Persons person = personRepo.findById(
                idPerson)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró la persona con el ID: " + idPerson));
        // Buscar el diagnóstico asociado a la persona
        DiagnosisPerson diagnosisPerson = diagnosisPersonRepo.findByIdPerson(person);

        if (diagnosisPerson == null) {
            throw new IllegalArgumentException("No se encontró diagnóstico para la persona con ID: " + idPerson);
        }

        // Obtener la categoría del diagnóstico
        CategoriesCIE category = diagnosisPerson.getDiagnosisCIE().getCategory();

        // Mapear y devolver el DTO
        return DiagnosisMapper.DiagnosistoDTOCategory(diagnosisPerson, category);
    }

    @Override
    public DiagnosisPersonsIDDTO getDiagnosisPersonByPersonIdwithCategory(Long idPerson) {
        // Buscar la persona por su ID
        Persons person = personRepo.findById(idPerson)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró la persona con el ID: " + idPerson));

        // Buscar el diagnóstico asociado a la persona
        DiagnosisPerson diagnosisPerson = diagnosisPersonRepo.findByIdPerson(person);

        if (diagnosisPerson == null) {
            throw new IllegalArgumentException("No se encontró diagnóstico para la persona con ID: " + idPerson);
        }

        // Obtener la categoría del diagnóstico
        CategoriesCIE category = diagnosisPerson.getDiagnosisCIE().getCategory();

        // Mapear y devolver el DTO
        return DiagnosisMapper.DiagnosistoDTOCategory(diagnosisPerson, category);
    }

    @Override
    public void deleteDiagnosisPerson(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteDiagnosisPerson'");
    }

}
