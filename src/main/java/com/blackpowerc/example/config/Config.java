package com.blackpowerc.example.config;

import java.lang.annotation.*;

/**
 * L'élément annoté doit être un {@code int} ou un {@code String}.
 * @author jordy jordy.fatigba@theopentrade.com
 */
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Config
{
    /**
     * Le nom de la variable de configuration
     * @return String
     */
    String ref() default  "";

    /**
     * La valeur par défaut à utiliser.
     * @return String
     */
    String defaultValue() default "";
}
