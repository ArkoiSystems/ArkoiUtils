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
public class Pair<V1, V2>
{
    
    @NotNull
    private final V1 first;
    
    @NotNull
    private final V2 second;
    
}
