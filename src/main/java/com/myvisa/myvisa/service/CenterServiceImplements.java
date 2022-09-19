package com.myvisa.myvisa.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myvisa.myvisa.dto.CenterDto;
import com.myvisa.myvisa.exceptions.CenterServiceException;
import com.myvisa.myvisa.models.Center;
import com.myvisa.myvisa.repos.CenterRepository;
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
public class CenterServiceImplements implements CenterService{
    private final CenterRepository centerRepository;
    private final ObjectMapper objectMapper;
    private static final String EXC_MESSAGE = "Center with id %d is not found";

    @Override
    public CenterDto create(CenterDto centerDto) {
        if (centerDto == null) {
            throw new CenterServiceException("Center is null");
        }

        Long id = centerDto.getId();
        if (id != null && centerRepository.findById(id).isPresent()) {
            throw new CenterServiceException(String.format("Center with id %d already exists", id));
        }

        Center center = objectMapper.convertValue(centerDto, Center.class);
        center.setStatus(String.valueOf(Status.LOADING));
        Center save = centerRepository.save(center);
        return objectMapper.convertValue(save, CenterDto.class);
    }

    @Override
    public CenterDto read(Long id) {
        Center branch = centerRepository.findById(id).orElseThrow(() ->
                new CenterServiceException(String.format(EXC_MESSAGE, id)));
        return objectMapper.convertValue(branch, CenterDto.class);
    }

    @Override
    public CenterDto update(CenterDto centerDto) {
        Long id = centerDto.getId();
        if (id == null) {
            throw new CenterServiceException("id is null");
        }

        read(id);

        Center center = objectMapper.convertValue(centerDto, Center.class);
        center.setStatus(String.valueOf(Status.READ_ONLY));
        Center save = centerRepository.save(center);
        return objectMapper.convertValue(save, CenterDto.class);
    }

    @Override
    public CenterDto delete(Long id) {
        Center center = objectMapper.convertValue(read(id), Center.class);
        center.setStatus(String.valueOf(Status.DELETED));
        centerRepository.save(center);
        return objectMapper.convertValue(center, CenterDto.class);
    }

    @Override
    public List<CenterDto> readAll() {
        return centerRepository.findAll().stream()
                .map(center -> objectMapper.convertValue(center, CenterDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<String> createCenter(CenterDto centerDto) {
        if (centerDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Center is not created! Body is null");
        }

        CenterDto center = create(centerDto);
        String dto = Converter.getString(center, objectMapper);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @Override
    public ResponseEntity<String> readCenter(Long id) {
        if (id == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Center is not found! Id is null");
        }

        CenterDto center = read(id);
        String dto = Converter.getString(center, objectMapper);

        return new ResponseEntity<>(dto, HttpStatus.OK);    }

    @Override
    public ResponseEntity<String> updateCenter(CenterDto centerDto) {
        return null;
    }

    @Override
    public ResponseEntity<String> updateBranch(CenterDto centerDto) {
        if (centerDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Branch is not updated! Body is null");
        }

        CenterDto center = update(centerDto);
        String dto = Converter.getString(center, objectMapper);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @Override
    public ResponseEntity<String> deleteCenter(Long id) {
        if (id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Center assignment is not deleted! Id is null");
        }

        CenterDto center = delete(id);
        String dto = Converter.getString(center, objectMapper);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @Override
    public ResponseEntity<List<CenterDto>> getAllCenters() {
        return ResponseEntity.ok(readAll());
    }

}
