package com.cicero.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cicero.os.domain.Cliente;
import com.cicero.os.domain.OS;
import com.cicero.os.domain.Tecnico;
import com.cicero.os.domain.enums.Prioridade;
import com.cicero.os.domain.enums.Status;
import com.cicero.os.repositories.ClienteRepository;
import com.cicero.os.repositories.OSRepository;
import com.cicero.os.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private OSRepository osRepository;

	public void instanciaDB() {
		Tecnico t1 = new Tecnico(null, "Cicero Calisto", "704.225.320-53", "(11) 98731-0367");
		Tecnico t2 = new Tecnico(null, "Lionel Messi", "424.803.768-85", "(11) 95647-0727");
		Cliente c1 = new Cliente(null, "Betina Campos", "065.141.650-79", "(11) 93534-1259");
		
		OS os1 = new OS(null, Prioridade.ALTA, "Teste create OS", Status.ANDAMENTO, t1, c1);

		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1, t2));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
	}

}
