package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Random;

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

    public Flux<String> nameFluxUFilterFlatMap(int len) {
        return Flux.fromIterable(List.of("Abhi", "Gupta"))
                .map(String::toUpperCase) //method reference
                .flatMap(s-> Flux.fromArray(s.split("")))
                .log();
        //  .map(s -> s.toUpperCase()) //lambda
    }

    public Flux<String> nameFluxUFilterFlatMap_async(int len) {
        return Flux.fromIterable(List.of("Abhi", "Gupta"))
                .map(String::toUpperCase) //method reference
              //  .map(s -> s.toUpperCase()) //lambda
                .flatMap(s-> Flux.fromArray(s.split("")).delayElements(Duration.ofMillis(2000)))
                .log();

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

        fluxAndMonoGeneratorService.nameFluxUFilterFlatMap(4)
                .subscribe(name -> {
                    System.out.println("FlatMapped Flux Name is: " + name);
                });

    }


}
