/*
 * Copyright © 2019-2020 ArkoiSystems (https://www.arkoisystems.com/) All Rights Reserved.
 * Created ArkoiUtils on May 19, 2020
 * Author timo aka. єхcsє#5543
 */
package com.arkoisystems.utils.tuple;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@Getter
public class Tuple
{
    
    @NotNull
    private final Object[] objects;
    
    @SuppressWarnings("unchecked")
    public <T> T get(final Class<T> clazz, final int index) {
        if (index >= this.objects.length - 1)
            throw new ArrayIndexOutOfBoundsException();
        
        final Object object = this.getObjects()[index];
        if (object.getClass() != clazz)
            throw new NullPointerException("Wrong types");
        return (T) object;
    }
    
    @NotNull
    public static Tuple with(final Object... objects) {
        return new Tuple(objects);
    }
    
}
