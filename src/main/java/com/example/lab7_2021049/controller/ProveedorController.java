package com.example.lab7_2021049.controller;

import com.example.lab7_2021049.entity.Proveedor;
import com.example.lab7_2021049.service.ProveedorService;
import com.example.lab7_2021049.service.ProveedorServiceImpl;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    private final ProveedorService service;

    public ProveedorController(ProveedorService service) {
        this.service = service;
    }

    @PostMapping
    public Proveedor registrar(@Validated @RequestBody Proveedor p) {
        return service.crearProveedor(p);
    }

    @GetMapping
    public List<Map<String, Object>> listar() {
        return service.listarProveedores().stream().map(p -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", p.getId());
            map.put("razonSocial", p.getRazonSocial());
            map.put("nombreComercial", p.getNombreComercial());
            map.put("ruc", p.getRuc());
            map.put("telefono", p.getTelefono());
            map.put("correoElectronico", p.getCorreoElectronico());
            map.put("pais", p.getPais());
            map.put("estado", p.getEstado() ? "Activo" : "Inactivo");
            return map;
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Map<String, Object> obtener(@PathVariable Long id) {
        Proveedor p = service.obtenerProveedor(id);
        Map<String, Object> map = new HashMap<>();
        map.put("id", p.getId());
        map.put("razonSocial", p.getRazonSocial());
        map.put("nombreComercial", p.getNombreComercial());
        map.put("ruc", p.getRuc());
        map.put("telefono", p.getTelefono());
        map.put("correoElectronico", p.getCorreoElectronico());
        map.put("pais", p.getPais());
        map.put("estado", p.getEstado() ? "Activo" : "Inactivo");
        return map;
    }

    @PutMapping("/{id}")
    public Proveedor actualizar(@PathVariable Long id, @RequestBody Proveedor p) {
        return service.actualizarProveedor(id, p);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminarProveedor(id);
    }
}
