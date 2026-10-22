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
    const titulo = document.getElementById('suculentaModalTitulo');
    const id = document.getElementById('suculentaId');
    const nombreComun = document.getElementById('suculentaNombreComun');
    const nombreCientifico = document.getElementById('suculentaNombreCientifico');
    const familia = document.getElementById('suculentaFamilia');
    const colorPrincipal = document.getElementById('suculentaColorPrincipal');
    const alturaCm = document.getElementById('suculentaAlturaCm');
    const precioEstimado = document.getElementById('suculentaPrecioEstimado');
    const nivelRiego = document.getElementById('suculentaNivelRiego');
    const rutaImagen = document.getElementById('suculentaRutaImagen');
    const activo = document.getElementById('suculentaActivo');
    const preview = document.getElementById('suculentaPreview');
    
    function limpiarPreview(){
        preview.removeAttribute('src');
        preview.classList.add('d-none');
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
       const modo = button.getAttribute('data-modo');
       //Limpia información de una apertura anterior
       form.reset();
       id.value = '';
       limpiarPreview();
       titulo.textContent = button.getAttribute('data-titulo') || '';
       header.classList.remove('bg-info', 'bg-warning', 'text-white');
       if(modo == 'editar'){
           id.value = button.getAttribute('data-id') || '';
           nombreComun.value = button.getAttribute('data-nombrecomun') || '';
           nombreCientifico.value = button.getAttribute('data-nombrecientifico') || '';
           familia.value = button.getAttribute('data-familia') || '';
           colorPrincipal.value = button.getAttribute('data-colorprincipal') || '';
           alturaCm.value = button.getAttribute('data-alturacm') || '';
           precioEstimado.value = button.getAttribute('data-precioestimado') || '';
           nivelRiego.value = button.getAttribute('data-nivelriego') || '';
           rutaImagen.value = button.getAttribute('data-imagen') || '';
           activo.checked = button.getAttribute('data-activo') === 'true';
           mostrarPreview(rutaImagen.value);
           header.classList.add('bg-warning');
       }else{
           // Suculenta nueva inicia activo
           activo.checked = true;
           header.classList.add('bg-info', 'text-white');
       }
    });
});