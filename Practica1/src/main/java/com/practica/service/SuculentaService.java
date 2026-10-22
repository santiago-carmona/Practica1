/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.service;

import com.practica.domain.Suculenta;
import com.practica.repository.SuculentaRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author santi
 */
@Service
@RequiredArgsConstructor
public class SuculentaService {
    
    private final SuculentaRepository suculentaRepository;
    
    @Transactional(readOnly = true)
    public List<Suculenta> getSuculentas(boolean activo){
        if(activo){ // solo para activas
            return suculentaRepository.findByActivoTrue();
        }
        return suculentaRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Optional<Suculenta> getSuculenta(Integer idSuculenta){
        return suculentaRepository.findById(idSuculenta);
    }
    
    @Transactional
    public void save(Suculenta suculenta){
        suculentaRepository.save(suculenta);
    }
    
    @Transactional
    public void delete(Integer idSuculenta){
        //Verifica que la suculenta exista antes de eliminarla
        if(!suculentaRepository.existsById(idSuculenta)){
            throw new IllegalArgumentException("La suculenta con ID" + idSuculenta + " no existe");
        }
        try{
            suculentaRepository.deleteById(idSuculenta);
            suculentaRepository.flush();
        }catch (DataIntegrityViolationException e){
            throw new IllegalStateException("No se puede eliminar la suculenta. Porque tiene datos asociados", e);
        }
    }
}
