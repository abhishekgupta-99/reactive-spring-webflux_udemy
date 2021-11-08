package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class FluxAndMonoGeneratorServiceTest {

    FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();

    @Test
    void name() {
        StepVerifier.create(fluxAndMonoGeneratorService.nameFlux())
                .expectNext("Abhi", "Gupta")
                .verifyComplete();
        StepVerifier.create(fluxAndMonoGeneratorService.nameFlux())
                .expectNext("Abhi")
                .expectNextCount(1) //since one already expectedabove
                .verifyComplete();

        StepVerifier.create(fluxAndMonoGeneratorService.nameFlux())
                .expectNextCount(2)
                .verifyComplete();


        StepVerifier.create(fluxAndMonoGeneratorService.nameFlux())
                .expectNextCount(3) //2 correct count
                .expectError();
    }
}