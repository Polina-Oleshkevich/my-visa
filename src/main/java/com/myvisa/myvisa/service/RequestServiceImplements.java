package com.myvisa.myvisa.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.myvisa.myvisa.dto.RequestDto;
import com.myvisa.myvisa.exceptions.CenterServiceException;
import com.myvisa.myvisa.models.Request;
import com.myvisa.myvisa.repos.RequestRepository;
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
public class RequestServiceImplements implements RequestService{
    private final RequestRepository requestRepository;
    private final ObjectMapper objectMapper;
    private static final String EXC_MESSAGE = "Request with id %d is not found";
    @Override
    public RequestDto create(RequestDto requestDto) {
        if (requestDto == null) {
            throw new CenterServiceException("Request is null");
        }

        Long id = requestDto.getId();
        if (id != null && requestRepository.findById(id).isPresent()) {
            throw new CenterServiceException(String.format("Request with id %d already exists", id));
        }

        Request request = objectMapper.convertValue(requestDto, Request.class);
        request.setStatus(String.valueOf(Status.LOADING));
        Request save = requestRepository.save(request);
        return objectMapper.convertValue(save, RequestDto.class);
    }

    @Override
    public RequestDto read(Long id) {
        Request request = requestRepository.findById(id).orElseThrow(() ->
                new CenterServiceException(String.format(EXC_MESSAGE, id)));
        return objectMapper.convertValue(request, RequestDto.class);
    }

    @Override
    public RequestDto update(RequestDto requestDto) {
        Long id = requestDto.getId();
        if (id == null) {
            throw new CenterServiceException("id is null");
        }

        read(id);

        Request request = objectMapper.convertValue(requestDto, Request.class);
        request.setStatus(String.valueOf(Status.READ_ONLY));
        Request save = requestRepository.save(request);
        return objectMapper.convertValue(save, RequestDto.class);
    }

    @Override
    public RequestDto delete(Long id) {
        Request request = objectMapper.convertValue(read(id), Request.class);
        request.setStatus(String.valueOf(Status.DELETED));
        Request save = requestRepository.save(request);
        return objectMapper.convertValue(save, RequestDto.class);
    }

    @Override
    public List<RequestDto> readAll() {
        return requestRepository.findAll().stream()
                .map(request -> objectMapper.convertValue(request, RequestDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<String> createRequest(RequestDto requestDto) {
        if (requestDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Request is not created! Body is null");
        }

        RequestDto request = create(requestDto);
        String dto = Converter.getString(request, objectMapper);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @Override
    public ResponseEntity<String> readRequest(Long id) {
        if (id == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Request is not found! Id is null");
        }

        RequestDto request = read(id);
        String dto = Converter.getString(request, objectMapper);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateRequest(RequestDto requestDto) {
        if (requestDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Request is not updated! Body is null");
        }

        RequestDto request = update(requestDto);
        String dto = Converter.getString(request, objectMapper);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @Override
    public ResponseEntity<String> deleteRequest(Long id) {
        if (id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Request assignment is not deleted! Id is null");
        }

        RequestDto request = delete(id);
        String dto = Converter.getString(request, objectMapper);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @Override
    public ResponseEntity<List<RequestDto>> getAllRequests() {
        return ResponseEntity.ok(readAll());
    }
}
