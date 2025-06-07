package com.example.lab7_2021049.service;

import com.example.lab7_2021049.entity.Proveedor;

import java.util.List;

public interface ProveedorService {
    Proveedor crearProveedor(Proveedor p);
    Proveedor obtenerProveedor(Long id);
    List<Proveedor> listarProveedores();
    Proveedor actualizarProveedor(Long id, Proveedor p);
    void eliminarProveedor(Long id);
}
