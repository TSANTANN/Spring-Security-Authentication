package br.com.nalli.data.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name="permission")
public class Permission implements GrantedAuthority, Serializable {

    private static final long serialVersionUID = 1L;

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="id")
  private Long id;

 @Column(name="description")
  private String description;
    @Override
    public String getAuthority() {
        return null;
    }
}
