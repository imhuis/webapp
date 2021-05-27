package com.imhui;

import com.imhui.domain.Coffee;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class WebClientTest {

    @Autowired
    private WebClient webClient;

    /**
     * {@link org.springframework.http.client.reactive.ReactorClientHttpConnector}
     * {@link org.springframework.http.client.reactive.JettyClientHttpConnector}
     */

    @Test
    public void test() throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(2);

        webClient.get()
                .uri("")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Coffee.class)
                .doOnError(c -> System.out.println())
                .doFinally(s -> cdl.countDown())
                .subscribeOn(Schedulers.single())
                .subscribe(c -> System.out.println(c));

        Mono<Coffee> americano = Mono.just(new Coffee("startbucks", BigDecimal.valueOf(20.0), new Date(), new Date()));
        webClient.post()
                .uri("/coffee/")
                .body(americano, Coffee.class)
                .retrieve()
                .bodyToMono(Coffee.class)
                .doFinally(s -> cdl.countDown())
                .subscribeOn(Schedulers.single())
                .subscribe(c -> System.out.println(c));

        cdl.await();

        webClient.get()
                .uri("/coffee/")
                .retrieve()
                .bodyToFlux(Coffee.class)
                .toStream()
                .forEach(c -> System.out.println(c));
    }

}
