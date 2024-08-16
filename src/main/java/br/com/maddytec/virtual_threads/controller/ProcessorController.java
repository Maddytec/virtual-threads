package br.com.maddytec.virtual_threads.controller;

import br.com.maddytec.virtual_threads.service.Processor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Log4j2
@RestController
@RequestMapping
public class ProcessorController {

    @GetMapping
    public void get() {
        long startTime = System.currentTimeMillis();
        new Processor().executar(UUID.randomUUID()).run();
        log.info(Duration.ofMillis(System.currentTimeMillis() - startTime).toSeconds() + " seconds");
    }

    @GetMapping("/pool")
    public void threadPool() {
        long startTime = System.currentTimeMillis();

        try (ExecutorService executorService = Executors.newFixedThreadPool(100)) {
            for (int i = 0; i < 1000; i++) {
                var processo = new Processor().executar(UUID.randomUUID());
                executorService.submit(processo);
            }
        }

        log.info(Duration.ofMillis(System.currentTimeMillis() - startTime).toSeconds() + " seconds");
    }

    @GetMapping("/virtual")
    public void virtualThreads() {
        long startTime = System.currentTimeMillis();

        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 1000; i++) {
                var process = new Processor().executar(UUID.randomUUID());
                executorService.submit(process);
            }
        }

        log.info(Duration.ofMillis(System.currentTimeMillis() - startTime).toSeconds() + " seconds");

    }

}
