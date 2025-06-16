package com.lorenzodev.concessionaria.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.lorenzodev.concessionaria.models.enums.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @NotBlank(message = "Nome é obrigatório")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    @Column(name = "email", nullable = false)
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    @Builder.Default
    private UserRole role = UserRole.CUSTOMER;

    @NotBlank(message = "O telefone é obrigatório")
    @Pattern(regexp = "^\\+?[1-9][0-9]{10,14}$", message = "Formato de telefone inválido")
    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private Boolean isActive = true;

    @OneToMany(mappedBy = "createdBy")
    private List<Vehicle> vehicles;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}