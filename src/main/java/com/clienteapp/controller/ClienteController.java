package com.clienteapp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clienteapp.entity.Ciudad;
import com.clienteapp.entity.Cliente;
import com.clienteapp.service.CiudadServiceImpl;
import com.clienteapp.service.ClienteServiceImpl;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	private ClienteServiceImpl clienteService;
	private CiudadServiceImpl ciudadService;

	public ClienteController(ClienteServiceImpl clienteService, CiudadServiceImpl ciudadService) {
		this.clienteService = clienteService;
		this.ciudadService = ciudadService;
	}

	@GetMapping("/all")
	public String listarClientes(Model model) {

		List<Cliente> clientes = clienteService.getAll();

		model.addAttribute("titulo", "Lista de Clientes");
		model.addAttribute("clientes", clientes);
		return "/views/customer/listar";
	}

	@GetMapping("/create")
	public String crear(Model model) {
		model.addAttribute("titulo", "Nuevo Cliente");
		model.addAttribute("cliente", new Cliente());
		return "/views/customer/formCrear";
	}

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		Optional<Cliente> cliente = clienteService.findById(id);

		if (cliente.isPresent()) {
			model.addAttribute("cliente", cliente);
		}
		model.addAttribute("titulo", "Editar Cliente");
		return "/views/customer/formCrear";
	}

	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Long id, Model model) {
		clienteService.delete(id);
		return "redirect:/clientes/all";
	}

	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute Cliente cliente, BindingResult result, Model model, RedirectAttributes atributte) {
		
		if(result.hasErrors()) {
			System.out.println("Existieron errores en el formulario");
			model.addAttribute("titulo","Nuevo Cliente");
			//model.addAttribute("clente", cliente);
			return "/views/customer/formCrear";
		}
		
		clienteService.save(cliente);
		atributte.addFlashAttribute("success", "Cliente guardado con exito");
		return "redirect:/clientes/all";
		
	}
	
	@ModelAttribute("ciudades")
	public List<Ciudad> getCiudades(){
		return ciudadService.getAll();
		
	}

}
