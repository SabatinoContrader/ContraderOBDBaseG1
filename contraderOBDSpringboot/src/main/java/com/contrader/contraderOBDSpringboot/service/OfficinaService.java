package com.contrader.contraderOBDSpringboot.service;

import com.contrader.contraderOBDSpringboot.dao.OfficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OfficinaService {

    private OfficinaRepository officinaRepository;

    @Autowired
    public OfficinaService(OfficinaRepository officinaRepository) {
        this.officinaRepository = officinaRepository;
    }

    public long countAll () {

    return this.officinaRepository.count();
    }
}
