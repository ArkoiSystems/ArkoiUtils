/*
 * Copyright © 2019-2020 ArkoiSystems (https://www.arkoisystems.com/) All Rights Reserved.
 * Created ArkoiUtils on May 18, 2020
 * Author timo aka. єхcsє#5543
 */
package com.arkoisystems.utils.printer;

import com.arkoisystems.utils.printer.annotations.Printable;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TreePrinter
{
    
    public static void printTree(
            final @NotNull PrintStream printStream,
            final @NotNull String indents,
            final @NotNull Object object
    ) {
        printTree(printStream, indents, null, object);
    }
    
    @SneakyThrows
    public static void printTree(
            final @NotNull PrintStream printStream,
            final @NotNull String indents,
            final @Nullable Printable objectPrintable,
            final @NotNull Object object
    ) {
        final List<Object> fieldValues = new ArrayList<>();
        final List<Printable> annotations = new ArrayList<>();
        
        for (final Field field : object.getClass().getDeclaredFields()) {
            final Printable annotation = field.getAnnotation(Printable.class);
            if (annotation == null)
                continue;
            
            final boolean accessible = field.isAccessible();
            field.setAccessible(true);
            final Object fieldValue = field.get(object);
            field.setAccessible(accessible);
            
            annotations.add(annotation);
            fieldValues.add(fieldValue);
        }
        
        printStream.printf(
                "%s: ", objectPrintable == null || objectPrintable.name().isEmpty() ?
                        object.getClass().getSimpleName() :
                        objectPrintable.name()
        );
        
        if (fieldValues.size() != 0) {
            printStream.println();
            
            for (int index = 0; index < fieldValues.size(); index++) {
                final Printable fieldPrintable = annotations.get(index);
                final Object fieldValue = fieldValues.get(index);
                
                if (index == fieldValues.size() - 1) {
                    printStream.printf(
                            "%s└── ",
                            indents
                    );
                    printTree(printStream, indents + "    ", fieldPrintable, fieldValue);
                } else {
                    printStream.printf(
                            "%s├── ",
                            indents
                    );
                    printTree(printStream, indents + "│   ", fieldPrintable, fieldValue);
                    printStream.printf("%s│%n", indents);
                }
            }
            
        } else printObject(printStream, indents, object);
    }
    
    public static void printObject(
            final @NotNull PrintStream printStream,
            final @NotNull String indents,
            final @NotNull Object object
    ) {
        if (object instanceof List) {
            printStream.println();
            
            final List<?> list = (List<?>) object;
            for (int index = 0; index < list.size(); index++) {
                final Object listObject = list.get(index);
                
                if (index == list.size() - 1) {
                    printStream.printf(
                            "%s└── ",
                            indents
                    );
                    printTree(printStream, indents + "    ", null, listObject);
                } else {
                    printStream.printf(
                            "%s├── ",
                            indents
                    );
                    printTree(printStream, indents + "│   ", null, listObject);
                    printStream.printf("%s│%n", indents);
                }
            }
        } else {
            printStream.println(object.toString());
        }
    }
    
}
