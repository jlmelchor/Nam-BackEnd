package com.nam.service;

import com.nam.data.model.TFile;
import com.nam.data.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileRepository fileRepository;

    @Override
    public TFile addFile(MultipartFile file) {
        String name = file.getOriginalFilename();
        try {
            TFile tFile = new TFile(name, file.getContentType(), file.getBytes());
            return fileRepository.save(tFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
