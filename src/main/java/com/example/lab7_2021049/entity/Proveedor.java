package com.example.lab7_2021049.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.processing.Pattern;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "razonSocial", nullable = false, length = 100)
    private String razonSocial;

    @Column(name = "nombreComercial", nullable = false, length = 100)
    private String nombreComercial;

    @Pattern(regexp = "\\d{11}")
    @Column(unique = true)
    private String ruc;

    @Pattern(regexp = "\\d+")
    private String telefono;

    @Email
    private String correoElectronico;

    @URL
    private String sitioWeb;

    @Size(max = 150)
    private String direccionFisica;

    @Pattern(regexp = "^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$")
    private String pais;

    @Pattern(regexp = "^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$")
    private String representanteLegal;

    @Pattern(regexp = "\\d+")
    private String dniRepresentanteLegal;

    @Pattern(regexp = "Nacional|Internacional")
    private String tipoProveedor;

    @Pattern(regexp = "Servicios|Productos|Tecnología|Otros")
    private String categoria;

    @DecimalMin("0.0")
    private Double facturacionAnualDolares;

    private LocalDateTime fechaRegistro;
    private LocalDateTime ultimaActualizacion;
    private Boolean estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public String getDireccionFisica() {
        return direccionFisica;
    }

    public void setDireccionFisica(String direccionFisica) {
        this.direccionFisica = direccionFisica;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public String getDniRepresentanteLegal() {
        return dniRepresentanteLegal;
    }

    public void setDniRepresentanteLegal(String dniRepresentanteLegal) {
        this.dniRepresentanteLegal = dniRepresentanteLegal;
    }

    public String getTipoProveedor() {
        return tipoProveedor;
    }

    public void setTipoProveedor(String tipoProveedor) {
        this.tipoProveedor = tipoProveedor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getFacturacionAnualDolares() {
        return facturacionAnualDolares;
    }

    public void setFacturacionAnualDolares(Double facturacionAnualDolares) {
        this.facturacionAnualDolares = facturacionAnualDolares;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDateTime getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(LocalDateTime ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}

