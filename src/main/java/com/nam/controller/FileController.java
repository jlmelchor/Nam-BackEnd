package com.nam.controller;

import com.nam.data.model.TFile;
import com.nam.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public TFile addFile(
            @RequestParam("file") MultipartFile file
    ){
        return fileService.addFile(file);
    }

}
