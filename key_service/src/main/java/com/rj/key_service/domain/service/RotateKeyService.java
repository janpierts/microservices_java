package com.rj.key_service.domain.service;

import org.springframework.stereotype.Service;
import com.rj.key_service.domain.ports.in.RotateKeyUseCase;
import com.rj.key_service.domain.ports.out.Keys_RepositoryPort;

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
