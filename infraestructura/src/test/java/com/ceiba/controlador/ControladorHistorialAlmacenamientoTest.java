package com.ceiba.controlador;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ceiba.comando.ComandoContenedor;
import com.ceiba.testdatabuilder.ComandoContenedorTestBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControladorHistorialAlmacenamientoTest {
	private static final String CODIGO = "TR0978";
	private static final String CODIGO2 = "PO0712";

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void metodoCrearHistorialAlmacenamient() throws Exception{
		
		//Arrange
		ComandoContenedor comandoContenedor = new ComandoContenedorTestBuilder().build();
		
		//Act //Assert
		mockMvc.perform(MockMvcRequestBuilders
			.post("/api/bodega/registrarHistorial")
			.content(asJsonString(comandoContenedor)).contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
	}
	
	@Test
	public void metodoListarHistorialAlmacenamiento() throws Exception {
		//Arrange
		ComandoContenedor comandoContenedor = new ComandoContenedorTestBuilder().conCodigo(CODIGO).build();
		
		//Act //Assert
		mockMvc.perform(MockMvcRequestBuilders
				.post("/api/bodega/registrarHistorial")
				.content(asJsonString(comandoContenedor)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
				
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/api/bodega/obtenerContenedores")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(jsonPath("$").exists())
				.andExpect(jsonPath("$[1].contenedor.codigo", is(CODIGO)));
	}

	@Test
	public void metodoSalidaContenedor() throws Exception{
		//Arrange
		ComandoContenedor comandoContenedor2 = new ComandoContenedorTestBuilder().conCodigo(CODIGO2).build();
		
		//Act //Assert
		mockMvc.perform(MockMvcRequestBuilders
				.post("/api/bodega/registrarHistorial")
				.content(asJsonString(comandoContenedor2)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		
		mockMvc.perform(MockMvcRequestBuilders
				.put("/api/bodega/SalidaContenedor/" + CODIGO2)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	public static String asJsonString(final Object object) throws Exception {
		try {
			return new ObjectMapper().writeValueAsString(object);
		}catch (DataAccessException e) {
			throw new Exception(e);
		}
	}

}
