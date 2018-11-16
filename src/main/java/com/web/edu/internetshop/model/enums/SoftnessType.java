package com.web.edu.internetshop.model.enums;

/**
 * The specific type of mattresses.
 */
public enum SoftnessType {

    SOFT( "Soft" ),
    MODERATELY_SOFT( "Moderately soft" ),
    MIDDLE( "Middle" ),
    MODERATELY_HARD( "Moderately hard" ),
    HARD( "Hard" );

    /**
     * User friendly name of the mattress.
     */
    final String name;

    SoftnessType( final String aName ) {
        name = aName;
    }

    public String toString() {
        return name;
    }
}
