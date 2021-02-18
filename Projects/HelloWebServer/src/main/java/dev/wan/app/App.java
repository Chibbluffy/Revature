package dev.wan.app;

import com.google.gson.Gson;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class App {
    public static void main(String[] args) {

        // Create is a factory method, it does not need 'new'
        Javalin app = Javalin.create();

        // Handler functions (lambda)
        // context object represents all the info from that http request
        // some additional methods for generating responses
        Handler helloLambda = (Context ctx) -> {
            ctx.result("Hello world.");
        };
        // Dont have to specify Context ctx, this is optional
        Handler holaLambda = (ctx) -> {
            ctx.result("Hola");
        };


        // define a uri path, lambda to execute when an http request is sent to this path
        app.get("/hello", helloLambda);
        app.get("/hola", holaLambda);


        Handler greetLambda = (ctx) -> {
            String name = ctx.pathParam("name");
            ctx.result("Hi " + name);
        };
        // taking in dynamic information via the uri path
        app.get("/greet/:name", greetLambda);


        Handler addLambda = (ctx) -> {
            double num1 = Double.parseDouble(ctx.pathParam("num1"));
            double num2 = Double.parseDouble(ctx.pathParam("num2"));
            double num3 = num1 + num2;
            ctx.result(Double.toString(num3));
        };
        app.get("/add/:num1/:num2", addLambda);


        Handler personLambda = (ctx) -> {
            String body = ctx.body();
            // can be any string, but usually is JSON
            Gson gson = new Gson();
            Person person = gson.fromJson(body, Person.class);

            ctx.result("Hi is this correct? "+body);
        };
        app.post("/person", personLambda);
        app.start();
    }
}
