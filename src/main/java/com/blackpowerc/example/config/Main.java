package com.blackpowerc.example.config;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class Main
{
    public static void main(String[] args)
    {
        SeContainerInitializer seContainerInitializer = SeContainerInitializer.newInstance()
                .disableDiscovery()
                .addPackages(Main.class.getPackage()) ;

        try (SeContainer seContainer = seContainerInitializer.initialize())
        {
            Foo foo = seContainer.select(Foo.class).get() ;
            System.out.println(foo.getBar());
            System.out.println(foo.getFizz());
            System.out.println(foo.getBuzz());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
