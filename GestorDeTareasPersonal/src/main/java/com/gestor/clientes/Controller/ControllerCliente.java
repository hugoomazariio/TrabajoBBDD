package com.gestor.clientes.Controller;
import com.gestor.clientes.entity.Cliente;
import com.gestor.clientes.service.GestorClientes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/Tarea")
public class ControllerCliente {
    GestorClientes ge = new GestorClientes ();
    @GetMapping("/")
    public String crud(Model model){
        String valorfinal="./cliente/listarTarea";
        try {
            model.addAttribute("clientes", ge.listar());
        } catch (SQLException ex) {
            Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
    }
    @GetMapping("/alta")
    public String greetingForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "./cliente/altaTarea";
    }
    @PostMapping("/alta") //El post hace que los datos no se vean
    public String greetingSubmit(@ModelAttribute Cliente cliente, Model model) {
        String valorfinal="redirect:/cliente/";
        try {
            ge.alta(cliente);
            try {
                model.addAttribute("clientes", ge.listar());
            } catch (SQLException ex) {
                Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
                valorfinal="error";
            }
        } catch (SQLException ex) {
            valorfinal="error";
        }
        return valorfinal;
    }
    @GetMapping("/eliminar")
    public String SubmitB (@RequestParam("codcliente") int id, Model model){
        String valorfinal="redirect:/cliente/";
        try {
            ge.eliminar(id);
            model.addAttribute("clientes", ge.listar());
        } catch (SQLException ex) {
            valorfinal="error";
        }
        //return new ModelAndView(valorfinal, model.asMap());
        return valorfinal;
    }
    @GetMapping("/modificar")
    public String modificar(@RequestParam ("codcliente") int id,Model model){
        String valorfinal="./cliente/modificarcliente";
        try {
            model.addAttribute("cliente", ge.buscar(id));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
    }
    @PostMapping("/modificar")
    public String modificarBBDD (@ModelAttribute Cliente cliente, Model model){
        String valorfinal="redirect:/cliente/";
        try {
            ge.modificar(cliente);
            model.addAttribute("clientes",ge.listar());
        } catch (SQLException ex) {
            Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
    }
}
