package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoGeneratorService {

    public Flux<String> nameFlux() {
        return Flux.fromIterable(List.of("Abhi", "Gupta")).log();
    }

    public Mono<String> MononameFlux () {
        return Mono.just("Vicky").log();
    }

    public static void main(String[] args) {

        FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();
        //  System.out.println(fluxAndMonoGeneratorService.nameFlux().toString());
        fluxAndMonoGeneratorService.nameFlux()
                .subscribe(name -> {
                    System.out.println("Flux Name is: " + name);
                });
        fluxAndMonoGeneratorService.MononameFlux()
                .subscribe(name -> {
                    System.out.println("Mono Flux Name is: " + name);
                });

    }


}
