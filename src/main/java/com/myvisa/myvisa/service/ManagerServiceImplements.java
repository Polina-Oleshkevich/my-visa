package com.myvisa.myvisa.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myvisa.myvisa.dto.ManagerDto;
import com.myvisa.myvisa.exceptions.CenterServiceException;
import com.myvisa.myvisa.models.Manager;
import com.myvisa.myvisa.repos.ManagerRepository;
import com.myvisa.myvisa.util.Converter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.engine.spi.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ManagerServiceImplements  implements ManagerService{
    private final ManagerRepository managerRepository;
    private final ObjectMapper objectMapper;
    private static final String EXC_MESSAGE = "Manager with id %d is not found";

    @Override
    public ManagerDto create(ManagerDto managerDto) {
        if (managerDto == null){
            throw new CenterServiceException("Manager is null");
        }

        Long id = managerDto.getId();
        if (id != null && managerRepository.findById(id).isPresent()) {
            throw new CenterServiceException(String.format("Manager with id %d already exists", id));
        }

        Manager manager = objectMapper.convertValue(managerDto, Manager.class);
        manager.setStatus(String.valueOf(Status.CREATE));
        Manager save = managerRepository.save(manager);
        return objectMapper.convertValue(save, ManagerDto.class);
    }

    @Override
    public ManagerDto read(Long id) {
        Manager manager = managerRepository.findById(id).orElseThrow(() ->
                new CenterServiceException(String.format(EXC_MESSAGE, id)));
        return objectMapper.convertValue(manager, ManagerDto.class);
    }

    @Override
    public ManagerDto update(ManagerDto managerDto) {
        Long id = managerDto.getId();
        if (id == null) {
            throw new CenterServiceException("id is null");
        }
        read(id);
        Manager manager = objectMapper.convertValue(managerDto, Manager.class);
        manager.setStatus(String.valueOf(Status.UPDATE));
        Manager save = managerRepository.save(manager);
        return objectMapper.convertValue(save, ManagerDto.class);
    }

    @Override
    public ManagerDto delete(Long id) {
        Manager manager = objectMapper.convertValue(read(id), Manager.class);
        manager.setStatus(String.valueOf(Status.DELETED));
        managerRepository.save(manager);
        return objectMapper.convertValue(manager, ManagerDto.class);
    }

    @Override
    public List<ManagerDto> readAll() {
        return managerRepository.findAll().stream()
                .map(assignment -> objectMapper.convertValue(assignment, ManagerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<String> createManager(ManagerDto managerDto) {
        if (managerDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Manager is not created! Body is null");
        }

        ManagerDto manager = create(managerDto);
        String dto = Converter.getString(manager, objectMapper);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @Override
    public ResponseEntity<String> readManager(Long id) {
        if (id == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Manager is not found! Id is null");
        }

        ManagerDto manager = read(id);
        String dto = Converter.getString(manager, objectMapper);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateManager(ManagerDto managerDto) {
        if (managerDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Manager is not updated! Body is null");
        }

        ManagerDto manager = update(managerDto);
        String dto = Converter.getString(manager, objectMapper);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @Override
    public ResponseEntity<String> deleteManager(Long id) {
        if (id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Manager is not deleted! Id is null");
        }

        ManagerDto manager = delete(id);
        String dto = Converter.getString(manager, objectMapper);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @Override
    public ResponseEntity<List<ManagerDto>> getAllManagers() {
        return ResponseEntity.ok(readAll());
    }
}
