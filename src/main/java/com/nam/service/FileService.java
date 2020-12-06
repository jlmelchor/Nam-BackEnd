package com.nam.service;

import com.nam.data.model.TFile;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    TFile addFile (MultipartFile file);
}
