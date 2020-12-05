package br.com.uff.vendasys.service.impl;

import br.com.uff.vendasys.domain.entity.Privilege;
import br.com.uff.vendasys.domain.entity.Role;
import br.com.uff.vendasys.domain.entity.Usuario;
import br.com.uff.vendasys.domain.repository.RoleRepository;
import br.com.uff.vendasys.domain.repository.UsuarioRepository;
import br.com.uff.vendasys.service.UserDetailService;
import br.com.uff.vendasys.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails buscarUsuarioPorEmail(String email) {
        Usuario usuario = usuarioRepository.buscarPorEmail(email);

        if (Objects.isNull(usuario)) {
            return new User(
                    " ", " ", true, true, true, true,
                    getAuthorities(Arrays.asList(roleRepository.findByName("ROLE_USER"))));
        }

        return new User(
                usuario.getEmail(), usuario.getSenha(), usuario.isAtivo(),
                true, true,true, getAuthorities(usuario.getRoles()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<String> getPrivileges(Collection<Role> roles) {
        List<String> privileges = new ArrayList<>();
        List<Privilege> collection = new ArrayList<>();
        for (Role role : roles) {
            collection.addAll(role.getPrivileges());
        }
        for (Privilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
}
