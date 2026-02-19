package com.bloste_software.infraestructure.repository;

import com.bloste_software.infraestructure.repository.jpa.CenterJpaRepository;
import java.util.List;
import java.util.stream.Collectors;

import com.bloste_software.presentation.dtos.CenterDTO;
import com.bloste_software.domain.repository.CenterRepository;

public class CenterRepositoryImpl implements CenterRepository {
    private final CenterJpaRepository jpaRepository;

    public CenterRepositoryImpl(CenterJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    // Devuelve todos los usuarios
    private List<CenterDTO> getAllCenters(){
        return jpaRepository.findAll()
                .stream()
                .map(CenterDTO::convertToDTO)
                .collect(Collectors.toList());
    };

    // Guardar centro
    void save(CenterDTO center);

    // Buscar por id
    CenterDTO findById(Long id);

    // Eliminar por id
    void deleteById(Long id);

    // Editar por id
    void editById(Long id);

    // Verificar si existe
    boolean existsById(Long id);
    

}