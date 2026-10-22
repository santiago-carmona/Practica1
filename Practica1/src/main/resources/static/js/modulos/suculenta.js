/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

// Carga los datos de la categoría en el modal Agregar o Editar
document.addEventListener('DOMContentLoaded', function (){
    const modal = document.getElementById('suculentaModal');
    if(!modal){
        return;
    }
    
    const form = document.getElementById('suculentaForm');
    const header = document.getElementById('suculentaModalHeader');
    const titulo = document.getElementById('SuculentaModalTitulo');
    const id = document.getElementById('suculentaId');
    const nombreComun = document.getElementById('suculentaNombreComun');
    const nombreCientifico = document.getElementById('suculentaNombreCientifico');
    const familia = document.getElementById('suculentaFamilia');
    const colorPrincipal = document.getElementById('suculentaColorPrincipal');
    const alturaCm = document.getElementById('suculentaAlturaCm');
    const precioEstimado = document.getElementById('suculentaPrecioEstimado');
    const nivelRiego = document.getElementById('suculentaNivelRiego');
    const rutaImagen = document.getElementById('suculentaImagen');
    const activo = document.getElementById('suculentaActivo');
    const preview = document.getElementById('soculentaPreview');
    
    function limpiarPreview(){
        preview.removeAttribute('src');
        preview.classList('d-none');
    }
    
    function mostrarPreview(ruta){
        if(ruta){
            preview.src = ruta;
            preview.classList.remove('d-none');
        }else{
            limpiarPreview();
        }
    }
    
    rutaImagen.addEventListener('change', function (){
        mostrarPreview(rutaImagen.value);
    });
    
    modal.addEventListener('show.bs.modal', function (event){
       const button = event.relatedTarget;
       if(!button){
           return;
       }
       const modo = button.getAtribute('data-modo');
       //Limpia información de una apertura anterior
       form.reset();
       id.value = '';
       limpiarPreview();
       titulo.textContent = button.getAtribute('data-titulo') || '';
       header.classList.remove('bg-info', 'bg-warning', 'text-white');
       if(modo == 'editar'){
           id.value = button.getAtribute('data-id') || '';
           nombreComun.value = button.getAtribute('data-nombrecomun') || '';
           nombreCientifico.value = button.getAtribute('data-nombrecientifico') || '';
           familia.value = button.getAtribute('data-familia') || '';
           colorPrincipal.value = button.getAtribute('data-colorprincipal') || '';
           alturaCm.value = button.getAtribute('data-alturacm') || '';
           precioEstimado.value = button.getAtribute('data-precioestimado') || '';
           nivelRiego.value = button.getAtribute('data-nivelriego') || '';
           rutaImagen.value = button.getAtribute('data-rutaimagen') || '';
           activo.checked = button.getAtribute('data-actuvo') === 'true';
           mostrarPreview(rutaImagen.value);
           header.classList.add('bg-warning');
       }else{
           // Suculenta nueva inicia activo
           activo.checked = true;
           header.classList.add('bg-info', 'text-white');
       }
    });
});