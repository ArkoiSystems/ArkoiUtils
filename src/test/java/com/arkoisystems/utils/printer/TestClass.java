/*
 * Copyright © 2019-2020 ArkoiSystems (https://www.arkoisystems.com/) All Rights Reserved.
 * Created ArkoiUtils on June 01, 2020
 * Author timo aka. єхcsє#5543
 */
package com.arkoisystems.utils.printer;

import com.arkoisystems.utils.printer.annotations.Printable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@Getter
public abstract class TestClass
{
    
    @Printable(name = "test")
    @NotNull
    private final String test;
    
}
