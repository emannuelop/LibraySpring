package br.unitins.libray.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.unitins.libray.repository.UsuarioRepository;
import br.unitins.libray.dto.UsuarioDTO;
import br.unitins.libray.model.Cargo;
import br.unitins.libray.model.Usuario;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    //Criar novo usuario
    public Usuario salvarUsuario (UsuarioDTO usuario) {
        Usuario usuarioNovo = new Usuario();

        usuarioNovo.setLogin(usuario.login());
        usuarioNovo.setSenha(usuario.senha());
        usuarioNovo.setCargo(Cargo.valueOf(usuario.idCargo()));
        return usuarioRepository.save(usuarioNovo);
    }

    //Buscar todos os usuarios
    public List<Usuario> BuscarTodosUsuarios() {
        return usuarioRepository.findAll();
    }
    
    public Usuario buscarUsuario(Long id) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();
            return usuario;
        }
        throw new RuntimeException("Usuario não encontrado com ID: " + id);
    }

    public Usuario atualizarUsuario(Long id, UsuarioDTO usuarioAtualizado) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();
            usuario.setLogin(usuarioAtualizado.login());
            usuario.setSenha(usuarioAtualizado.senha());
            usuario.setCargo(Cargo.valueOf(usuarioAtualizado.idCargo()));
            return usuarioRepository.save(usuario);
        }
        throw new RuntimeException("Usuario não encontrado com ID: " + id);
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public boolean login(String login, String senha) {
        Optional<Usuario> usuario = usuarioRepository.findByLoginAndSenha(login, senha);
        return usuario.isPresent();
    }
    
}
