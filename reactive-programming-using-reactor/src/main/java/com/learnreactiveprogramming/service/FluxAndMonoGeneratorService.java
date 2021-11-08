package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoGeneratorService {

    public Flux<String> nameFlux() {
        return Flux.fromIterable(List.of("Abhi", "Gupta")).log();
    }

    public Flux<String> nameFluxUFilter() {
        return Flux.fromIterable(List.of("Abhi", "Gupta"))
                .map(String::toUpperCase) //method reference
                //  .map(s -> s.toUpperCase()) //lambda
                .log();
    }

    public Flux<String> nameFluxUFilterAppend(int len) {
        return Flux.fromIterable(List.of("Abhi", "Gupta"))
                .map(String::toUpperCase) //method reference
                .filter(s-> s.length()>len)
                .map(s-> s.length() +"-"+s);
                //  .map(s -> s.toUpperCase()) //lambda
    }

    public Flux<String> nameFluxUFilterlength(int len) {
        return Flux.fromIterable(List.of("Abhi", "Gupta"))
                .map(String::toUpperCase) //method reference
                //  .map(s -> s.toUpperCase()) //lambda
                .filter(s-> s.length()>len)
                .log();
    }

    public Flux<String> nameFluxUFilter_Immutability() {
        var name_immutable = Flux.fromIterable(List.of("Abhi", "Gupta"));
        name_immutable.map(String::toUpperCase);
        return name_immutable;
    }

    public Mono<String> MononameFlux() {
        return Mono.just("Vicky").log();
    }


    public static void main(String[] args) {

        FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();
        //  System.out.println(fluxAndMonoGeneratorService.nameFlux().toString());
        fluxAndMonoGeneratorService.nameFlux()
                .subscribe(name -> {
                    System.out.println("Flux Name is: " + name);
                });

        fluxAndMonoGeneratorService.nameFluxUFilter()
                .subscribe(name -> {
                    System.out.println("Flux Name is: " + name);
                });

        fluxAndMonoGeneratorService.MononameFlux()
                .subscribe(name -> {
                    System.out.println("Mono Flux Name is: " + name);
                });

    }


}
