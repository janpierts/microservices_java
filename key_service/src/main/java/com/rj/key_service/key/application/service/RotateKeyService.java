package com.rj.key_service.key.application.service;

import org.springframework.stereotype.Service;

import com.rj.key_service.key.application.ports.in.RotateKeyUseCase;
import com.rj.key_service.key.application.ports.out.Keys_RepositoryPort;

@Service
public class RotateKeyService implements RotateKeyUseCase {

    private final Keys_RepositoryPort keysRepositoryPort;
    public RotateKeyService(Keys_RepositoryPort keysRepositoryPort) {
        this.keysRepositoryPort = keysRepositoryPort;
    }

    @Override
    public void execute() {
        keysRepositoryPort.SetKey();
        System.out.println("Ejecutando lógica de rotación de llaves...");
    }
}
