package com.myvisa.myvisa.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myvisa.myvisa.dto.VisaDto;
import com.myvisa.myvisa.exceptions.CenterServiceException;
import com.myvisa.myvisa.models.Visa;
import com.myvisa.myvisa.repos.VisaRepository;
import com.myvisa.myvisa.util.Converter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.myvisa.myvisa.models.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class VisaServiceImplements implements VisaService{

    private final VisaRepository visaRepository;
    private final ObjectMapper objectMapper;
    private static final String EXC_MESSAGE = "Visa with id %d is not found";

    @Override
    public VisaDto create(VisaDto visaDto) {
        if (visaDto == null) {
            throw new CenterServiceException("Visa is null");
        }

        Long id = visaDto.getId();
        if (id != null && visaRepository.findById(id).isPresent()) {
            throw new CenterServiceException(String.format("Visa with id %d already exists", id));
        }

        Visa visa = objectMapper.convertValue(visaDto, Visa.class);
        visa.setStatus(String.valueOf(Status.CREATED));
        Visa save = visaRepository.save(visa);
        return objectMapper.convertValue(save, VisaDto.class);
    }

    @Override
    public VisaDto read(Long id) {
        Visa visa = visaRepository.findById(id).orElseThrow(() ->
                new CenterServiceException(String.format(EXC_MESSAGE, id)));
        return objectMapper.convertValue(visa, VisaDto.class);
    }

    @Override
    public VisaDto update(VisaDto visaDto) {
        Long id = visaDto.getId();
        if (id == null) {
            throw new CenterServiceException("id is null");
        }

        read(id);

        Visa visa = objectMapper.convertValue(visaDto, Visa.class);
        visa.setStatus(String.valueOf(Status.UPDATED));
        Visa save = visaRepository.save(visa);
        return objectMapper.convertValue(save, VisaDto.class);
    }

    @Override
    public VisaDto delete(Long id) {
        Visa visa = objectMapper.convertValue(read(id), Visa.class);
        visa.setStatus(String.valueOf(Status.DELETED));
        Visa save = visaRepository.save(visa);
        return objectMapper.convertValue(save, VisaDto.class);
    }

    @Override
    public List<VisaDto> readAll() {
        return visaRepository.findAll().stream()
                .map(visa -> objectMapper.convertValue(visa, VisaDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<String> createVisa(VisaDto visaDto) {
        if (visaDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Visa is not created! Body is null");
        }

        VisaDto visa = create(visaDto);
        String dto = Converter.getString(visa, objectMapper);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @Override
    public ResponseEntity<String> readVisa(Long id) {
        if (id == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Visa is not found! Id is null");
        }

        VisaDto visa = read(id);
        String dto = Converter.getString(visa, objectMapper);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateVisa(VisaDto visaDto) {
        if (visaDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Visa is not updated! Body is null");
        }

        VisaDto visa = update(visaDto);
        String dto = Converter.getString(visa, objectMapper);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @Override
    public ResponseEntity<String> deleteVisa(Long id) {
        if (id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Visa assignment is not deleted! Id is null");
        }

        VisaDto visa = delete(id);
        String dto = Converter.getString(visa, objectMapper);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @Override
    public ResponseEntity<List<VisaDto>> getAllVisas() {
        return ResponseEntity.ok(readAll());
    }
}
