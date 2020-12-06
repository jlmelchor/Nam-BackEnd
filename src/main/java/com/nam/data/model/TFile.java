package com.nam.data.model;

import javax.persistence.*;

@Entity
@Table(name = "TFILE")
public class TFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TFILE_ID", nullable = false)
    private long tFileId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "TYPE", nullable = false)
    private String type;

    @Lob
    private byte[] data;

    public TFile() {
    }

    public TFile(String name, String contentType, byte[] bytes) {
    }

    public long getTFileId() {
        return tFileId;
    }

    public void setTFileId(long fileId) {
        this.tFileId = fileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
