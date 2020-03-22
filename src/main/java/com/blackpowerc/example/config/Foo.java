package com.blackpowerc.example.config;

import javax.inject.Inject;

/**
 * Classe d'example pour illustrer l'injection des variables de configuration dans un bean.
 * @author jordy jordy.fatigba@theopentrade.com
 */
public class Foo
{
    @Inject
    @Configuration
    @Config(ref = "port")
    private String bar ;

    @Inject
    @Configuration
    @Config(ref = "fizz")
    private int fizz ;

    private String buzz ;

    public String getBar() {
        return this.bar ;
    }

    public String getBuzz() {
        return buzz;
    }

    public int getFizz() {
        return fizz;
    }

    @Inject
    public void setBuzz(@Configuration @Config(ref = "buzz", defaultValue = "buzzy") String buzz) {
        this.buzz = buzz;
    }
}
