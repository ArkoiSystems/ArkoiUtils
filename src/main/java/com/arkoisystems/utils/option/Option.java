/*
 * Copyright © 2019-2020 ArkoiSystems (https://www.arkoisystems.com/) All Rights Reserved.
 * Created ArkoiUtils on May 26, 2020
 * Author timo aka. єхcsє#5543
 */
package com.arkoisystems.utils.option;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Builder
@Getter
public class Option
{
    
    @NotNull
    private final String shortName, description;
    
    private final boolean required, hasArgument;
    
    @Nullable
    private final String longName;
    
}
