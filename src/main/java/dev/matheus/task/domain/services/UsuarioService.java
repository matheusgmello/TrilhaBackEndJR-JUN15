package dev.matheus.task.domain.services;

import dev.matheus.task.domain.dtos.UsuarioRequestDTO;
import dev.matheus.task.domain.dtos.UsuarioResponseDTO;
import dev.matheus.task.domain.entities.Usuario;
import dev.matheus.task.domain.repositories.UsuarioRepository;
import dev.matheus.task.exceptions.RecordNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioService {
    private final UsuarioRepository repository;

    public List<UsuarioResponseDTO> findAll() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    public void delete(Long id) {
        if (id == 0) {
            throw new IllegalArgumentException("Tente novamente com outro ID, não é permitido ID 0");
        }
        validaDelete(id);
        log.info("Deletando usuário com ID: " + id);
        repository.deleteById(id);
    }

    public UsuarioResponseDTO update(Long id, UsuarioRequestDTO userRequest) {
        if (id == 0) {
            throw new IllegalArgumentException("Não é permitido ID 0, tente novamente com outro ID");
        }

        // Passa o ID junto com o objeto de requisição para validação
        validaUsuario(id, userRequest);

        String encryptedPassword = new BCryptPasswordEncoder().encode(userRequest.senha());

        Usuario usuario = repository.findById(id).map(recordFound -> {
            recordFound.setUsuario(userRequest.usuario());
            recordFound.setSenha(encryptedPassword);
            return repository.save(recordFound);
        }).orElseThrow(() -> new RecordNotFoundException("Nenhum usuário encontrado com o ID: " + id));

        log.info("Atualizando usuário com ID: " + id);
        return this.toDto(usuario);
    }

    private void validaUsuario(Long id, UsuarioRequestDTO objDTO) {
        Usuario existingUser = repository.findByUsuario(objDTO.usuario());
    
        if (existingUser != null) {
            log.info("Usuário encontrado: ID existente = " + existingUser.getIdUsuario() + ", ID atualização = " + id);
            if (!existingUser.getIdUsuario().equals(id)) {
                log.info("ID do usuário encontrado é diferente do ID de atualização. Lançando exceção.");
                throw new DataIntegrityViolationException("Usuário já cadastrado no sistema!");
            } else {
                log.info("ID do usuário encontrado é o mesmo do ID de atualização. Permitir atualização.");
            }
        } else {
            log.info("Nenhum usuário encontrado com o nome: " + objDTO.usuario());
        }
    }

    private void validaDelete(Long id) {
        Optional<Usuario> usuario = repository.findById(id);
        if (usuario.isPresent() && usuario.get().getUsuario().equalsIgnoreCase("admin")) {
            throw new DataIntegrityViolationException("Usuário com a permissão admin não pode ser deletado");
        } else if (usuario.isEmpty()) {
            throw new RecordNotFoundException("Nenhum usuário encontrado com o ID: " + id);
        }
    }

    private UsuarioResponseDTO toDto(Usuario usuario) {
        return new UsuarioResponseDTO(usuario.getIdUsuario(), usuario.getUsuario(), usuario.getSenha());
    }
}