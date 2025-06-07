package com.example.lab7_2021049.service;

import com.example.lab7_2021049.entity.Proveedor;
import com.example.lab7_2021049.exceptions.ResourceNotFoundException;
import com.example.lab7_2021049.repository.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepository repo;

    public ProveedorServiceImpl(ProveedorRepository repo) {
        this.repo = repo;
    }

    @Override
    public Proveedor crearProveedor(Proveedor p) {
        if (repo.existsByRuc(p.getRuc()))
            throw new IllegalArgumentException("Ya existe un proveedor con ese RUC");

        p.setEstado(true);
        p.setFechaRegistro(LocalDateTime.now());
        p.setUltimaActualizacion(null);
        return repo.save(p);
    }

    @Override
    public Proveedor obtenerProveedor(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado"));
    }

    @Override
    public List<Proveedor> listarProveedores() {
        return repo.findAll();
    }

    @Override
    public Proveedor actualizarProveedor(Long id, Proveedor p) {
        Proveedor actual = obtenerProveedor(id);

        if (p.getTelefono() != null) actual.setTelefono(p.getTelefono());
        if (p.getCorreoElectronico() != null) actual.setCorreoElectronico(p.getCorreoElectronico());
        if (p.getFacturacionAnualDolares() != null) actual.setFacturacionAnualDolares(p.getFacturacionAnualDolares());
        if (p.getCategoria() != null) actual.setCategoria(p.getCategoria());

        actual.setUltimaActualizacion(LocalDateTime.now());
        return repo.save(actual);
    }

    @Override
    public void eliminarProveedor(Long id) {
        Proveedor proveedor = obtenerProveedor(id);
        proveedor.setEstado(false);
        repo.save(proveedor);
    }
}

