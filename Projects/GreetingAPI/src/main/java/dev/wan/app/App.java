package dev.wan.app;

import io.javalin.Javalin;

public class App {

    private static int httpRequestCounter;
    public static void main(String[] args) {
        Javalin app = Javalin.create();

        app.get("/hello", (ctx)->{
            ctx.result("Hello!!! Total requests: "+httpRequestCounter++);
        });
        app.get("/hola", (ctx)->{
            ctx.result("Hola!!! Total requests: "+httpRequestCounter++);
        });

        app.start();
    }
}
