package br.com.maddytec.virtual_threads.service;

import lombok.extern.log4j.Log4j2;

import java.time.Duration;
import java.util.UUID;

@Log4j2
public class Processor {

    public Runnable executar(UUID transactionId) {
        return () -> {
            log.info("Thread: {} | Process executing | transactionId {} ", Thread.currentThread(), transactionId);
            try {
                Thread.sleep(Duration.ofSeconds(3));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            log.info("Thread: {} | Process completed | transactionId: {}", Thread.currentThread(), transactionId);
        };
    }
}
