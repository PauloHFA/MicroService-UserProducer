package com.ms.user.service;

import com.ms.user.models.UserModel;
import com.ms.user.producers.EmailProducer;
import com.ms.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    final UserRepository userRepository;
    final EmailProducer userProducer;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository, EmailProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    @Transactional
    public UserModel save(UserModel userModel){
        try {
            logger.info("Iniciando save - User: {}", userModel.getEmail());

            // 1. Salvando no banco
            logger.info("Salvando no PostgreSQL...");
            userModel = userRepository.save(userModel);
            logger.info("Usuário salvo com ID: {}", userModel.getUserId());

            // 2. Publicando no RabbitMQ
            logger.info("Publicando mensagem no RabbitMQ...");
            userProducer.publishMessageEmail(userModel);
            logger.info("Mensagem publicada com sucesso!");

            return userModel;

        } catch (Exception e) {
            logger.error("ERRO no save: {}", e.getMessage(), e);
            throw e;
        }
    }
}