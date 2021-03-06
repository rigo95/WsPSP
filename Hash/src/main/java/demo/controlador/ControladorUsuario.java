package demo.controlador;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import demo.modelo.entidad.Usuario;
import demo.modelo.negocio.GestorUsuario;

@Controller
public class ControladorUsuario {

	@Autowired
	private GestorUsuario gestorUsuario;

	@GetMapping("registrar_usuario")
	private String registrarUsuario() {
		return "registro";
	}

	@GetMapping("loguearse")
	private String login() {
		return "login";
	}

	@PostMapping("registrar")
	private String registrar(@RequestParam("nombre_usuario")
	String nombreUsuario, @RequestParam("pass") String pass,
			Model model) throws NoSuchAlgorithmException {

		String passwordHash = hashPassword(pass);
		
		Usuario u = new Usuario();
		u.setNombre(nombreUsuario);
		u.setPassword(passwordHash);

		

		gestorUsuario.addUsuario(u);

		System.out.println(u);

		return "inicio";
	}

	@PostMapping("login")
	private String loginUsuario(@RequestParam("nombre_usuario")
	String nombreUsuario, @RequestParam("pass") String pass,
			Model model) throws NoSuchAlgorithmException {

		String passwordHash = hashPassword(pass);
		
		Usuario u = new Usuario();
		u.setNombre(nombreUsuario);
		u.setPassword(passwordHash);
		
		boolean validado = gestorUsuario.validarUsuario(u);

		if (validado) {
			return "inicio";

		} else {
			return "errorlogin";
		}
	}

	@GetMapping("salir")
	private String cerrarSesion() {
		return "../static/home";
	}
	
	@GetMapping("volver_login")
	private String volverLogin() {
		return "login";
	}

	private String hashPassword(String password) throws NoSuchAlgorithmException {
		byte[] pass = password.getBytes();

		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(pass);

		byte[] resumen = md.digest();
		String mensaje = new String(resumen);
		return mensaje;
	}

}
