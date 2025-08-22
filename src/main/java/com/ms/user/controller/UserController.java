package com.ms.user.controller;

import com.ms.user.dtos.EmailDto;
import com.ms.user.models.UserModel;
import com.ms.user.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("✅ Microserviço User está funcionando via Ngrok!");
    }

    @PostMapping("/users")
    public ResponseEntity<?> SaveUser(@RequestBody @Valid EmailDto emailDto){
        try {
            logger.info("Recebendo requisição para: {}", emailDto.getEmail());

            var userModel = new UserModel();
            userModel.setName(emailDto.getName());
            userModel.setEmail(emailDto.getEmail());
            userModel.setText(emailDto.getText());

            UserModel savedUser = userService.save(userModel);
            logger.info("Usuário criado com sucesso: {}", savedUser.getUserId());

            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);

        } catch (Exception e) {
            logger.error("ERRO no controller: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro detalhado: " + e.getMessage());
        }
    }
}