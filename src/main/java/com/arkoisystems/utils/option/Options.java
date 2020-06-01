/*
 * Copyright © 2019-2020 ArkoiSystems (https://www.arkoisystems.com/) All Rights Reserved.
 * Created ArkoiUtils on May 26, 2020
 * Author timo aka. єхcsє#5543
 */
package com.arkoisystems.utils.option;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Options
{
    
    @NotNull
    private final List<Option> options;
    
    public Options() {
        this.options = new ArrayList<>();
    }
    
    @NotNull
    public Options addOption(final @NotNull Option option) {
        this.options.add(option);
        return this;
    }
    
}
