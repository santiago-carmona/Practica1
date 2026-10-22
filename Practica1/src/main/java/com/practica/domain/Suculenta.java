/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.*;
/**
 *
 * @author santi
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "suculenta")
public class Suculenta implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_suculenta")
    private Integer idSuculenta;
    
    @Column(name = "nombre_comun", nullable = false, length = 60)
    @NotBlank(message = "El nombre común no puede estar vacio")
    @Size(max = 60, message = "El nombre común no puede tener más de 60 caracteres")
    private String nombreComun;
    
    @Column(name = "nombre_cientifico", nullable = false, length = 100)
    @NotBlank(message = "El nombre cientifico no puede estar vacio")
    @Size(max = 100, message = "El nombre cientifico no puede tener más de 100 caracteres")
    private String nombreCientifico;
    
    @Column(length = 60)
    @Size(max = 60, message = "La familia no puede tener más de 60 caracteres")
    private String familia;
    
    @Column(name = "color_Principal", length = 30)
    @Size(max = 30, message = "El color no puede tener más de 30 caracteres")
    private String colorPrincipal;
    
    @Column(name = "altura_cm")
    @NotNull(message = "La altura no puede estar vacia")
    @Min(value = 1, message = "La altura debe ser mayor o igual a 1 cm")
    private Integer alturaCm;
    
    @Column(name = "precio_estimado", precision = 10, scale = 2)
    @NotNull(message = "El precio estimado no puede estar vacio")
    @DecimalMin(value = "0.01", message = "El precio estimado debe ser mayor a 0")
    private BigDecimal precioEstimado;
    
    @Column(name = "nivel_riego", length = 20)
    @NotBlank(message = "El nivel de riego no puede estar vacio")
    private String nivelRiego;
    
    @Column(name = "ruta_imagen", length = 1024)
    @Size(max = 1024, message = "La ruta de la imagen no puede tener más de 1024 caracteres")
    private String rutaImagen;
    
    @Column(nullable = false)
    private boolean activo = true;
}
