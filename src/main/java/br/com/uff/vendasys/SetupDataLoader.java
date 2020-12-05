package br.com.uff.vendasys;

import br.com.uff.vendasys.domain.entity.Privilege;
import br.com.uff.vendasys.domain.entity.Role;
import br.com.uff.vendasys.domain.entity.Usuario;
import br.com.uff.vendasys.domain.enums.TipoUsuario;
import br.com.uff.vendasys.domain.repository.PrivilegeRepository;
import br.com.uff.vendasys.domain.repository.RoleRepository;
import br.com.uff.vendasys.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    boolean setupFeito = false;

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (setupFeito) return;

        Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);

        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        Usuario usuario = new Usuario();
        usuario.setNome("Gerente Lucas");
        usuario.setSenha(passwordEncoder.encode("admin123"));
        usuario.setEmail("lucas@id.uff.br");
        usuario.setRoles(Arrays.asList(adminRole));
        usuario.setTipoUsuarioEnum(TipoUsuario.GERENTE);
        usuario.setAtivo(true);
        usuarioRepository.save(usuario);

        setupFeito = true;
    }

    /**
     * Cria um novo {@link Privilege}, se nao existir uma com o nome passado
     * @param name nome do privilege a ser criado
     * @return
     */
    @Transactional
    Privilege createPrivilegeIfNotFound(String name) {
        Privilege privilege = privilegeRepository.findbyName(name);
        if (Objects.isNull(privilege)) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    /**
     * Cria uma nova {@link Role}, setando seus privilegios, se nao existir uma com o nome passado
     * @param name nome da role a ser criada
     * @param privileges {@code Collection} de privilegios a serem atribuidos a role
     * @return
     */
    @Transactional
    Role createRoleIfNotFound(String name, Collection<Privilege> privileges) {
        Role role = roleRepository.findByName(name);
        if (Objects.isNull(role)) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }
}
