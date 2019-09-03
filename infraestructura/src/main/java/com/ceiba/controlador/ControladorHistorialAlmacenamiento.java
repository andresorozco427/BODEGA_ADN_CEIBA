package com.ceiba.controlador;

import java.util.List;

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

import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/parquedero")
@Api(tags = {"Controlador almacenamiento de contenedores"})
public class ControladorHistorialAlmacenamiento {

	private final ManejadorCrearHistorialDeAlmacenamiento manejadorCrearHistorialDeAlmacenamiento;
	private final ManejadorSalidaContenedor manejadorSalidaContenedor;
	private final ManejadorConsultaAlmacenamiento manejadorConsultasContenedor;
	

	private ControladorHistorialAlmacenamiento(
			ManejadorCrearHistorialDeAlmacenamiento manejadorCrearHistorialDeAlmacenamiento,
			ManejadorSalidaContenedor manejadorSalidaContenedor,
			ManejadorConsultaAlmacenamiento manejadorConsultasContenedor) {
		this.manejadorCrearHistorialDeAlmacenamiento = manejadorCrearHistorialDeAlmacenamiento;
		this.manejadorSalidaContenedor = manejadorSalidaContenedor;
		this.manejadorConsultasContenedor = manejadorConsultasContenedor;
	}

	@PostMapping("/registrarHistorial")
	public void crearHistorialParqueadero(@RequestBody ComandoContenedor comandoContenedor) {
		this.manejadorCrearHistorialDeAlmacenamiento.ejecutarAlmacenamiento(comandoContenedor);
	}

	@GetMapping("/obtenervehiculos")
	public List<HistorialAlmacenamiento> consultarVehiculosParqueados() {
		return this.manejadorConsultasContenedor.ListarContenedoresAlmacenados();
	}

	@PutMapping("/retirar/{codigo}")
	public SalidaHistorialAlmacenamiento sacarVehiculo(@PathVariable String codigo) {
		HistorialAlmacenamiento historialAlmacenamiento;
		historialAlmacenamiento = this.manejadorConsultasContenedor.consultarHistorialAlmacenamiento(codigo);
		return this.manejadorSalidaContenedor.retirarAlmacenamientoContenedor(historialAlmacenamiento);
	}
}
