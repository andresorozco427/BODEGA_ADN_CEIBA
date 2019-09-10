package com.ceiba.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.comando.ComandoContenedor;
import com.ceiba.comando.manejador.ManejadorCrearHistorialDeAlmacenamiento;
import com.ceiba.comando.manejador.ManejadorSalidaContenedor;
import com.ceiba.consulta.manejador.ManejadorConsultaAlmacenamiento;
import com.ceiba.modelo.HistorialAlmacenamiento;
import com.ceiba.modelo.SalidaHistorialAlmacenamiento;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/bodega")
public class ControladorHistorialAlmacenamiento {

	private final ManejadorCrearHistorialDeAlmacenamiento manejadorCrearHistorialDeAlmacenamiento;
	private final ManejadorSalidaContenedor manejadorSalidaContenedor;
	private final ManejadorConsultaAlmacenamiento manejadorConsultasContenedor;
	@Autowired
	public ControladorHistorialAlmacenamiento(
			ManejadorCrearHistorialDeAlmacenamiento manejadorCrearHistorialDeAlmacenamiento,
			ManejadorSalidaContenedor manejadorSalidaContenedor,
			ManejadorConsultaAlmacenamiento manejadorConsultasContenedor) {
		this.manejadorCrearHistorialDeAlmacenamiento = manejadorCrearHistorialDeAlmacenamiento;
		this.manejadorSalidaContenedor = manejadorSalidaContenedor;
		this.manejadorConsultasContenedor = manejadorConsultasContenedor;
	}

	@PostMapping("/registrarHistorial")
	public void crearHistorialParqueadero(@RequestBody ComandoContenedor comandoContenedor) {
		this.manejadorCrearHistorialDeAlmacenamiento.ejecutar(comandoContenedor);
	}

	@GetMapping("/obtenerContenedores")
	public List<HistorialAlmacenamiento> consultarContenedoresAlmacenados() {
		return this.manejadorConsultasContenedor.listarContenedoresAlmacenados();
	}

	@PutMapping("/SalidaContenedor/{codigo}")
	public SalidaHistorialAlmacenamiento salidaContenedor(@PathVariable String codigo) {
		HistorialAlmacenamiento historialAlmacenamiento;
		historialAlmacenamiento = this.manejadorConsultasContenedor.consultarHistorialAlmacenamiento(codigo);
		return this.manejadorSalidaContenedor.retirarAlmacenamientoContenedor(historialAlmacenamiento);
	}
}
