package org.example.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinhVienServiceTest {
    private SinhVienService sinhVienService;
    private SinhVien sinhVien;
    @BeforeEach
    void setUp() {
        sinhVienService  = new SinhVienService();
        sinhVien = new SinhVien("SV001","Nguyen Van A" ,20,7.5f,3,"CNTT");

    }
    @Test
    void ValidInput(){
        sinhVienService.suaSinhVien(sinhVien,"Nguyen Thi B" ,22,8.0f,5,"Maketting");
        assertEquals("Nguyen Thi B",sinhVien.ten);
        assertEquals(22,sinhVien.tuoi);
        assertEquals(8.0f,sinhVien.diemTrungBinh);
        assertEquals(5,sinhVien.kyHoc);
        assertEquals("Maketting",sinhVien.chuyenNganh);
    }

    @Test
    void TenRong(){
//        Exception exception = assertThrows(IllegalArgumentException.class, () ->(sinhVienService.suaSinhVien(sinhVien,"Nguyen Thi B" ,22,8.0f,5,"Maketting")));
    }
}