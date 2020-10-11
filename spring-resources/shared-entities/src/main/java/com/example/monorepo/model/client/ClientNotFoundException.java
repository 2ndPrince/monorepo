package com.example.monorepo.model.client;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(String guid) {
      log.error(guid);
    }
}
