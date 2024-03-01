package be.epicode.buildWeek5.services;

import be.epicode.buildWeek5.config.MailgunSender;
import be.epicode.buildWeek5.entities.Cliente;
import be.epicode.buildWeek5.exceptions.NotFoundException;
import be.epicode.buildWeek5.payloads.ClientiDTO;
import be.epicode.buildWeek5.repositories.ClientiDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class ClientiService {
    @Autowired
    private ClientiDAO clientiDAO;
    @Autowired
    private MailgunSender mailgunSender;
Random random = new Random();
    public Page<Cliente> getClienti(int pageNumber, int size, String orderBy) {
        if (size > 100) size = 100;
        Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(orderBy));
        return this.clientiDAO.findAll(pageable);
    }

    public List<Cliente> getClientiList(){
        return this.clientiDAO.findAll();
    }

//    public Page<Customer> getCustomersStartingwithLastName(int pageNumber, int size, String orderBy) {
//        if (size > 100) size = 100;
//        Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(orderBy));
//        return this.customerDAO.findAll(pageable);
//    }

    public Cliente saveCliente(ClientiDTO body) {
//       int random1 = new Random().nextInt(ClientType.values().length);
        Cliente cliente = new Cliente(body.ragioneSociale(),body.partitaIva(),body.email(),body.dataInserimento(),
                body.dataUltimoContatto(),body.fatturatoAnnuale(),body.pec(),body.telefono(),body.emailContatto(),
                body.nomeContatto(),body.cognomeContatto(),body.telefonoContatto(),body.logoAziendale(),
                body.tipoCliente(),body.indirizzoSedeOperativa(),body.indirizzoSedeLegale());

        Cliente savedCliente = clientiDAO.save(cliente);
        mailgunSender.sendRegistrationEmail(cliente);
        return savedCliente;
    }
    public Cliente findById(UUID clienteId) {
        return this.clientiDAO.findById(clienteId).orElseThrow(() -> new NotFoundException(clienteId));
    }

//public Customer findByLastname(String lastname) {
//        return this.customerDAO.findByLastName(lastname).orElseThrow(() -> new NotFoundLastnameException(lastname));
//}

    public Cliente findByIdAndUpdate(UUID clienteId, Cliente updatingCliente) {
        Cliente cliente = findById(clienteId);
        cliente.setEmail(updatingCliente.getEmail());
        cliente.setFatturatoAnnuale(updatingCliente.getFatturatoAnnuale());
        cliente.setRagioneSociale(updatingCliente.getRagioneSociale());
        cliente.setDataUltimoContatto(updatingCliente.getDataUltimoContatto());
        cliente.setPartitaIva(updatingCliente.getPartitaIva());
        cliente.setPec(updatingCliente.getPec());
        cliente.setTelefono(updatingCliente.getTelefono());
        cliente.setDataInserimento(updatingCliente.getDataInserimento());
        return this.clientiDAO.save(cliente);
    }

    public void findByIdAndDelete(UUID clienteId) {
        Cliente cliente = findById(clienteId);
        this.clientiDAO.delete(cliente);
    }

}
