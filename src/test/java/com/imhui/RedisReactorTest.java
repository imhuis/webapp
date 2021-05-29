package com.imhui;

import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class RedisReactorTest {

    public void test(){

        Mono mono = new Mono() {
            @Override
            public void subscribe(CoreSubscriber coreSubscriber) {

            }
        };

        Flux flux = new Flux() {
            @Override
            public void subscribe(CoreSubscriber coreSubscriber) {

            }
        };
    }
}
