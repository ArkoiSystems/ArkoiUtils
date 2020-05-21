/*
 * Copyright © 2019-2020 ArkoiSystems (https://www.arkoisystems.com/) All Rights Reserved.
 * Created ArkoiUtils on May 21, 2020
 * Author timo aka. єхcsє#5543
 */
package com.arkoisystems.utils.general;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtils
{
    
    private FileUtils() { }
    
    @NotNull
    public static List<File> getAllFiles(
            final @NotNull File directory,
            final @NotNull String extension
    ) {
        final List<File> files = new ArrayList<>();
        for (final File file : directory.listFiles()) {
            if (file.isDirectory()) files.addAll(getAllFiles(file, extension));
            else if (file.getName().endsWith(extension)) files.add(file);
        }
        return files;
    }
    
}
