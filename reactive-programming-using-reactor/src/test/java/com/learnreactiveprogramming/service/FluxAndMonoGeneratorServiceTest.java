package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class FluxAndMonoGeneratorServiceTest {

    FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();

    @Test
    void nameFluxTest() {
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

    @Test
    void nameFluxMap() {
        StepVerifier.create(fluxAndMonoGeneratorService.nameFluxUFilter())
                .expectNext("ABHI", "GUPTA")
                .verifyComplete();
        StepVerifier.create(fluxAndMonoGeneratorService.nameFlux())
                .expectNext("Abhi")
                .expectNextCount(1) //since one already expectedabove
                .verifyComplete();
    }


    @Test
    void nameFluxUFilter_Immutability() {

        StepVerifier.create(fluxAndMonoGeneratorService.nameFluxUFilter_Immutability())
                .expectNext("Abhi", "Gupta")
                .verifyComplete();
    }

    @Test
    void nameFluxUFilterlength() {
        StepVerifier.create(fluxAndMonoGeneratorService.nameFluxUFilterlength(4))
                .expectNext("GUPTA")
                .verifyComplete();
    }

    @Test
    void nameFluxUFilterAppend() {
        StepVerifier.create(fluxAndMonoGeneratorService.nameFluxUFilterAppend(4))
                .expectNext("5-GUPTA")
                .verifyComplete();
    }
}