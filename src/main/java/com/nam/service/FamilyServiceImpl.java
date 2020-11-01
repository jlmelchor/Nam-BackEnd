package com.nam.service;

import com.nam.data.model.Family;
import com.nam.data.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyServiceImpl implements FamilyService {

    @Autowired
    FamilyRepository familyRepository;

    @Override
    public List<Family> getAllFamilies() {
        return familyRepository.findAll();
    }

}
