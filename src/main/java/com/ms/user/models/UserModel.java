package com.ms.user.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@Getter
@Setter
@Entity
@Table(name = "TB_USERS")
public class UserModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    private String name;
    private String email;
    private String text;
}