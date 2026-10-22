/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.repository;

import com.practica.domain.Suculenta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author santi
 */
@Repository
public interface SuculentaRepository extends JpaRepository<Suculenta, Integer>{
    
     //Se crea una consulta derivada para recuperar solo las suculentas activas
    public List<Suculenta> findByActivoTrue();
}
