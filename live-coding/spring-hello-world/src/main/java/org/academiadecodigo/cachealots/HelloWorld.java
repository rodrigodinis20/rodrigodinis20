package org.academiadecodigo.cachealots;

public class HelloWorld {

    private String name;

    public HelloWorld() {
    }

    public HelloWorld(String name) {
        this.name = name;
    }

    public void sayHello(){
        System.out.println("Hello World from " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
