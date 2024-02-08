package com.example.Solutioerp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.Solutioerp.model.Clients;
import com.example.Solutioerp.repository.ClientsRepository;

import io.micrometer.common.util.StringUtils;

@Service
public class ClientsService {

    @Autowired
    private ClientsRepository clientsRepository;

    /**
     * Metodo para retornar uma lista de clientes
     * 
     * @return lista de Clientes
     */
    public List<Clients> obterTodos() {
        // Criar regras
        return clientsRepository.findAll();
    }

    /**
     * Metodo que retorna o cliente encontrado pelo seu ID
     * 
     * @param id do cliente que será localizado
     * @return Retorna um cliente cado seja encontrado.
     */
    public Optional<Clients> obterPorId(Integer id) {
        if (id != null) {
            return clientsRepository.findById(id);
        } else {
            return Optional.empty();
        }
    }

    /**
     * Metodo para adicionar um cliente na lista
     * 
     * @param clients que será adicionado
     * @return retorna o cliente que foi adicionado a lista
     */
    public Clients adicionar(Clients clients) {
        // Verificar se o cliente não é nulo
        if (clients == null) {
            throw new IllegalArgumentException("O objeto cliente não pode ser nulo");
        }

        // Verificar campos obrigatórios
        if (StringUtils.isEmpty(clients.getName())) {
            throw new IllegalArgumentException("O nome do cliente é obrigatório");
        }

        if (StringUtils.isEmpty(clients.getTypeClient())) {
            throw new IllegalArgumentException("O tipo do cliente é obrigatório");
        }

        if (StringUtils.isEmpty(clients.getTaxIdentificationNumber())) {
            throw new IllegalArgumentException("A identificação fiscal do cliente é obrigatória");
        }

        // Verificar regras de negócio adicionais (exemplo: limite de crédito positivo)
        if (clients.getCreditLimit() != null && clients.getCreditLimit() < 0) {
            throw new IllegalArgumentException("O limite de crédito deve ser um valor positivo");
        }

        // Outras verificações podem ser adicionadas conforme necessário

        // Salvar o cliente no banco de dados
        return clientsRepository.save(clients);
    }

    /**
     * Metodo para deletar o cliente por ID
     * 
     * @param id do usuario a ser deletado
     */
    public void deletar(Integer id) {
        // Validar o ID fornecido
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido fornecido para exclusão");
        }

        try {
            // Tente excluir o cliente com o ID fornecido
            clientsRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            // Lidar com o caso em que o cliente com o ID fornecido não existe
            throw new IllegalArgumentException("Cliente com o ID fornecido não encontrado", ex);
        } catch (Exception ex) {
            // Lidar com outras exceções que podem ocorrer durante a exclusão
            throw new RuntimeException("Erro ao excluir o cliente", ex);
        }
    }

    public Clients atualizar(Integer id, Clients clients) {
        // Verificar se o ID é válido
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido fornecido para atualização");
        }

        // Verificar se o cliente com o ID fornecido existe no banco de dados
        Optional<Clients> existingClientOptional = clientsRepository.findById(id);
        if (!existingClientOptional.isPresent()) {
            throw new IllegalArgumentException("Cliente com o ID fornecido não encontrado");
        }

        Clients existingClient = existingClientOptional.get();

        // Atualizar todos os campos do cliente com os novos valores do JSON
        existingClient.setName(clients.getName());
        existingClient.setFantasy(clients.getFantasy());
        existingClient.setTypeClient(clients.getTypeClient());
        existingClient.setTaxIdentificationNumber(clients.getTaxIdentificationNumber());
        existingClient.setCpf(clients.getCpf());
        existingClient.setCnpj(clients.getCnpj());
        existingClient.setClientSince(clients.getClientSince());
        existingClient.setCep(clients.getCep());
        existingClient.setState(clients.getState());
        existingClient.setCity(clients.getCity());
        existingClient.setNeighborhood(clients.getNeighborhood());
        existingClient.setAdress(clients.getAdress());
        existingClient.setNumber(clients.getNumber());
        existingClient.setComplement(clients.getComplement());
        existingClient.setTelephone(clients.getTelephone());
        existingClient.setCellNumber(clients.getCellNumber());
        existingClient.setEmail(clients.getEmail());
        existingClient.setEmailNFe(clients.getEmailNFe());
        existingClient.setCreditLimit(clients.getCreditLimit());
        existingClient.setConditionPayment(clients.getConditionPayment());
        existingClient.setObservation(clients.getObservation());

        // Salvar as alterações do cliente atualizado no banco de dados
        return clientsRepository.save(existingClient);
    }

}
