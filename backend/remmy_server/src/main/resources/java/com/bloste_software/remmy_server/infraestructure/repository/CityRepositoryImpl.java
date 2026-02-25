package com.bloste_software.remmy_server.infraestructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.bloste_software.remmy_server.domain.models.entities.location.City;
import com.bloste_software.remmy_server.domain.models.entities.location.Province;
import com.bloste_software.remmy_server.domain.repository.CityRepository;
import com.bloste_software.remmy_server.infraestructure.repository.jpa.CityJpaRepository;
import com.bloste_software.remmy_server.presentation.dtos.CityDTO;

@Service
public class CityRepositoryImpl implements CityRepository {
    private final CityJpaRepository jpaRepository;
    public CityRepositoryImpl(CityJpaRepository jpaRepository) { this.jpaRepository = jpaRepository; }
    @Override public List<CityDTO> getAll() { return jpaRepository.findAll().stream().map(CityDTO::convertToDTO).collect(Collectors.toList()); }
    @Override public void save(CityDTO dto) { jpaRepository.save(dto.toEntity()); }
    @Override public void saveEntity(City entity) { jpaRepository.save(entity); }
    @Override public boolean existsById(Long id) { return jpaRepository.existsById(id); }
    @Override public CityDTO getById(Long id) { return jpaRepository.findById(id).map(CityDTO::convertToDTO).orElse(null); }
    @Override public void deleteById(Long id) { jpaRepository.deleteById(id); }
    @Override public void updateById(Long id, CityDTO dto) {
        City entity = jpaRepository.findById(id).orElseThrow(() -> new RuntimeException("City not found"));
        if (dto.getName() != null) entity.setName(dto.getName());
        if (dto.getINE() != null) entity.setINE(dto.getINE());
        if (dto.getProvinceId() != null) {
            Province province = new Province(); province.setId(dto.getProvinceId()); entity.setProvince(province);
        }
        jpaRepository.save(entity);
    }
    @Override public Optional<City> findById(Long id) { return jpaRepository.findById(id); }
}
