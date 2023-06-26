package br.estrategia.application;

import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

  @RequestMapping("/api/ola")
  public String index() {
    return "Greetings from Spring Boot!";
  }

  @PreAuthorize("isAuthenticated()")
  @RequestMapping("/api/autenticado")
  public String token() {
    return "token";
  }

  @PreAuthorize("hasAuthority('default')")
  @RequestMapping("/api/certo")
  public String teste2() {
    return "teste precisa do default";
  }

  @PreAuthorize("hasAuthority('papel_inexistente')")
  @RequestMapping("/api/erro")
  public String teste_precisa_de_outro_papel2() {
    return "nao_vai_dar_certo";
  }

}