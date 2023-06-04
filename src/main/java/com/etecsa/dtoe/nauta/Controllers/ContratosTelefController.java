package com.etecsa.dtoe.nauta.Controllers;

import com.etecsa.dtoe.nauta.models.entity.ContratosTelef;
import com.etecsa.dtoe.nauta.services.ContratoServicio;
import com.etecsa.dtoe.nauta.util.paginacion.PageRender;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.*;


@Controller
public class ContratosTelefController {

    @Autowired
    private ContratoServicio contratoServicio;

    @RequestMapping("/contratos")
    public String verPaginaInicio(Model model) {
        List<ContratosTelef> listaContratosTelef = contratoServicio.listAll();
        model.addAttribute("listaContratosTelef", listaContratosTelef);
        return "contratos";
    }


    // Esta parte muestra el listado total de los servicios de la DB por paginas
    @GetMapping("/listar")
    public String listarContratos(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 10);
        Page<ContratosTelef> contratosTelefs = contratoServicio.findAll(pageRequest);
        PageRender<ContratosTelef> pageRender = new PageRender<>("/listar", contratosTelefs);
        model.addAttribute("titulo", "Listado de Contratos");
        model.addAttribute("contratosTelefs", contratosTelefs);
        model.addAttribute("page", pageRender);

        return "listar";
    }

    /* Esta parte muestra el listado total de los servicios de la DB por paginas
    Es para la Oferta por servicio
     */
    @GetMapping("/listaserv")
    public String listarServicios(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 10);
        Page<ContratosTelef> contratosTelefs = contratoServicio.findAll(pageRequest);
        PageRender<ContratosTelef> pageRender = new PageRender<>("/listaserv", contratosTelefs);
        model.addAttribute("titulo", "Oferta por servicio");
        model.addAttribute("contratosTelefs", contratosTelefs);
        model.addAttribute("page", pageRender);

        return "listaserv";
    }

    // Listado para la busqueda por planta y sitio
    @GetMapping("/listaplants")
    public String listarPlantaSitio(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 10, Sort.by("id"));
        //para la busqueda con select
        List<String> valorPlanta = contratoServicio.findPlanta();
        List<String> valorSitio = contratoServicio.findSitio();
        model.addAttribute("valorPlanta", valorPlanta);
        model.addAttribute("valorSitio", valorSitio);

        Page<ContratosTelef> contratosTelefs = contratoServicio.findAll(pageRequest);
        PageRender<ContratosTelef> pageRender = new PageRender<>("/listaplants", contratosTelefs);
        model.addAttribute("titulo", "Oferta por Planta y Sitio");
        model.addAttribute("contratosTelefs", contratosTelefs);
        model.addAttribute("page", pageRender);

        return "listaplants";
    }

    /* Probando otras funcionalidades sobre el listado con paginacion
     * Este solo muestra en la tabla los valores que tiene el campo Solicitado por como no vacio
     */
    @GetMapping("/listado")
    public String listadoContratos(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 10, Sort.by("id"));
// para la busqieda con select
        List<String> valoresUnicos = contratoServicio.findDistinctSolicitado();
        model.addAttribute("valoresUnicos", valoresUnicos);

        Page<ContratosTelef> contratosTelefs = contratoServicio.findBySolicitadoIsNotNull(pageRequest);
        PageRender<ContratosTelef> pageRender = new PageRender<>("/listado", contratosTelefs);
        model.addAttribute("titulo", "Oferta por solicitante");
        model.addAttribute("contratosTelefs", contratosTelefs);
        model.addAttribute("page", pageRender);

        return "listado";
    }

    // Pagina HOME
    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("titulo", "Comercializacion de servicio Nauta Hogar");
        return "home";
    }

    // Pagina Login
    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("titulo", "Login");
        return "login";
    }

    // Metodo para Crear nuevo servicio
    @RequestMapping("/nuevo")
    public String mostrarFormularioNuevoServicio(Model model) {
        ContratosTelef contratosTelef = new ContratosTelef();
        model.addAttribute("contratosTelef", contratosTelef);
        model.addAttribute("titulo", "Crear nuevo servicio");
        return "nuevo_servicio";
    }

    //Metodo Guardar
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardarContrato(@ModelAttribute("contratosTelef") ContratosTelef contratosTelef) {
        contratoServicio.save(contratosTelef);
        return "redirect:/buscar";
    }

    @RequestMapping(value = "/guardar1", method = RequestMethod.POST)
    public String guardarContrato1(@ModelAttribute("contratosTelef") ContratosTelef contratosTelef) {
        contratoServicio.save(contratosTelef);
        return "redirect:/listado";
    }

    @RequestMapping(value = "/guardar2", method = RequestMethod.POST)
    public String guardarContrato2(@ModelAttribute("contratosTelef") ContratosTelef contratosTelef) {
        contratoServicio.save(contratosTelef);
        return "redirect:/listaserv";
    }

    @RequestMapping(value = "/guardar3", method = RequestMethod.POST)
    public String guardarContrato3(@ModelAttribute("contratosTelef") ContratosTelef contratosTelef) {
        contratoServicio.save(contratosTelef);
        return "redirect:/listaplants";
    }


    // Metodo Solicitar
    @GetMapping("/solicitar/{id}")
    public String mostrarFormularioEditarServicio(@PathVariable(name = "id") Long id, Model model) {
        ContratosTelef contratosTelef = contratoServicio.get(id);
        model.addAttribute("contratosTelef", contratosTelef);
        model.addAttribute("titulo", "Solicitar Nauta");
        return "solicitar";
    }

    // Metodo Ofertar
    @GetMapping("/ofertar1/{id}")
    public String mostrarFormularioOfertarServicio1(@PathVariable(name = "id") Long id, Model model) {
        ContratosTelef contratosTelef = contratoServicio.get(id);
        model.addAttribute("contratosTelef", contratosTelef);
        model.addAttribute("titulo", "Ofertar Nauta");
        return "ofertar1";
    }

    @GetMapping("/ofertar2/{id}")
    public String mostrarFormularioOfertarServicio2(@PathVariable(name = "id") Long id, Model model) {
        ContratosTelef contratosTelef = contratoServicio.get(id);
        model.addAttribute("contratosTelef", contratosTelef);
        model.addAttribute("titulo", "Ofertar Nauta");
        return "ofertar2";
    }

    @GetMapping("/ofertar3/{id}")
    public String mostrarFormularioOfertarServicio3(@PathVariable(name = "id") Long id, Model model) {
        ContratosTelef contratosTelef = contratoServicio.get(id);
        model.addAttribute("contratosTelef", contratosTelef);
        model.addAttribute("titulo", "Ofertar Nauta");
        return "ofertar3";
    }


    // Metodo Eliminar
    @RequestMapping("/eliminar/{id}")
    public String eliminarServicio(@PathVariable(name = "id") Long id) {
        contratoServicio.delete(id);
        return "redirect:/listar";
    }

    // Metodo Buscar dentro de Introducir demanda
    @RequestMapping("/buscar")
    public String buscar(Model model, @Param("servicio") String servicio) {
        model.addAttribute("ContratosTelef", contratoServicio.findByServicio(servicio));
        model.addAttribute("titulo", "Demanda inicial de servicio");
        return "buscar";
    }

    // Metodo Buscar dentro de Oferta por servicio
    @RequestMapping("/buscarservicio")
    public String buscarservicio(@RequestParam(name = "servicio", defaultValue = "") String servicio,
                                 @PageableDefault(size = 10, sort = "id") Pageable pageable,
                                 Model model) {
        Page<ContratosTelef> contratosTelefs = contratoServicio.findByServicio(servicio, pageable);
        PageRender<ContratosTelef> pageRender = new PageRender<>("/buscarservicio?servicio=" + servicio, contratosTelefs);
        model.addAttribute("titulo", "Oferta por servicio");
        model.addAttribute("contratosTelefs", contratosTelefs);
        model.addAttribute("page", pageRender);
        return "listaserv";
    }


    // Metodo para Buscar por solicitado
    @GetMapping("/buscasolicitado")
    public String buscasolicitado(@RequestParam(name = "solicitado", defaultValue = "todos") String solicitado,
                                  @PageableDefault(size = 10, sort = "id") Pageable pageable,
                                  Model model) {
        // Obtener los valores únicos de la columna solicitado
        List<String> valoresUnicos = contratoServicio.findDistinctSolicitado();

        Page<ContratosTelef> contratosTelefs;
        if (solicitado.equals("todos")) {
            contratosTelefs = contratoServicio.findBySolicitadoIsNotNull(pageable);
            ;
        } else {
            contratosTelefs = contratoServicio.findBySolicitado(solicitado, pageable);
        }

        PageRender<ContratosTelef> pageRender = new PageRender<>("/buscasolicitado?solicitado=" + solicitado, contratosTelefs);
        model.addAttribute("titulo", "Oferta por solicitante");
        model.addAttribute("contratosTelefs", contratosTelefs);
        model.addAttribute("page", pageRender);
        model.addAttribute("valoresUnicos", valoresUnicos);
        return "listado";
    }

    // Metodo para Buscar por Planta y Sitio

    @GetMapping("/buscaplantaandsitio")
    public String buscaplantaandsitio(@RequestParam(name = "planta", defaultValue = "") String nombpta,
                                   @RequestParam(name = "sitio", defaultValue = "") String sitio,
                                   @PageableDefault(size = 10, sort = "id") Pageable pageable,
                                   Model model) {

        List<String> valorPlanta = contratoServicio.findPlanta();
        List<String> valorSitio = contratoServicio.findSitio();

        Page<ContratosTelef> contratosTelefs = contratoServicio.findByNombptaAndSitio(nombpta, sitio, pageable);
        PageRender<ContratosTelef> pageRender = new PageRender<>("/buscaplantaandsitio?planta=" + nombpta + "&sitio=" + sitio, contratosTelefs);
        model.addAttribute("titulo", "Oferta por Planta y Sitio");
        model.addAttribute("contratosTelefs", contratosTelefs);
        model.addAttribute("page", pageRender);
        model.addAttribute("valorPlanta", valorPlanta);
        model.addAttribute("valorSitio", valorSitio);
        return "listaplants";
    }
/*
    @RequestMapping("/editar/{id}")
    public ModelAndView mostrarFormularioEditarServicio(@PathVariable(name = "id") Long id) {
        ModelAndView model = new ModelAndView("editar_servicio");
        ContratosTelef contratosTelef = contratoServicio.get(id);
        model.addObject("contratosTelef", contratosTelef);
        return model;
    }

 */

/*   Debajo estoy probando una variante mas corta

    @GetMapping("/buscasolicitado")
    public String buscasolicitado(@RequestParam(name = "page", defaultValue = "0") int page,
                                   @RequestParam(name = "solicitado", defaultValue = "") String solicitado,
                                   Model model) {
        Pageable pageRequest = PageRequest.of(page, 10, Sort.by("id"));
        Page<ContratosTelef> contratosTelefs = contratoServicio.findBySolicitado(solicitado, pageRequest);
        PageRender<ContratosTelef> pageRender = new PageRender<>("/buscasolicitado?solicitado=" + solicitado, contratosTelefs);
        model.addAttribute("titulo", "Oferta por solicitante");
        model.addAttribute("contratosTelefs", contratosTelefs);
        model.addAttribute("page", pageRender);
        return "listado";
    }
*/

/*
    @RequestMapping("/prueba")
    public String listar(Model model, @Param("servicio") String servicio) {
        model.addAttribute("ContratosTelef", contratoServicio.findByServicio(servicio));
        model.addAttribute("titulo", "Muestra en lista");
        return "prueba";
    }

    // En el video esto es mas grande, despues lo podemos agrandar
    @PostMapping("/form/guardar")
    public String guardarContrato(@Valid ContratosTelef contratosTelef, BindingResult result, Model model, RedirectAttributes flash) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Registro de Contratos");
            return "form";
        }
        String messaje = (contratosTelef.getServicio() != null) ? "La demanda se ha realizado con exito" : "No se pudo realizar";
        contratoServicio.save(contratosTelef);
        return "redirect:/buscar";
    }


    // llamar al formulario
    @GetMapping("/form")
    public String mostrarFormularioRegistro(Map<String, Object> model) {
        ContratosTelef contratosTelef = new ContratosTelef();
        model.put("contratosTelef", contratosTelef);
        model.put("titulo", "Registrar Contrato");
        return "form";
    }


// Editar
    /*
    @GetMapping("/form/{servicio}")
    public String editarContrato(@PathVariable(value = "servicio") String servicio, Map<String, Object> model){
        ContratosTelef contratosTelef = new ContratosTelef();
        contratosTelef = contratoServicio.findByServicio(servicio);
        model.put("contratosTelef", contratosTelef);
        model.put("titulo", "Realizar demanda de servicio Nauta");
        return "form";
    }

     */

    //   @RequestMapping("/form/{servicio}")
    //  public String editarContrato(Model model, @Param("servicio") String servicio){
    //    model.addAttribute("contratosTelef", contratoServicio.findByServicio(servicio));
    //   model.addAttribute("titulo", "Demanda de Servicio Nauta");
    //  return "form";
    // }

//    @GetMapping("/form/{servicio}")
//    public String editar(@PathVariable(value = "servicio") String servicio, Model model) {
//        ContratosTelef contratosTelef = contratoServicio.findByServicio(servicio);
//        model.addAttribute("contratosTelef", contratosTelef);
//        return "form";
//    }

// Eliminar
//        @GetMapping("/eliminar/{servicio}")
//        public String eliminarContrato (@PathVariable(value = "servicio") String servicio){
//            contratoServicio.delete(servicio);
//            return "redirect:/buscar";
//        }


}
