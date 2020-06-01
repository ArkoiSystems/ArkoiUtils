package com.arkoisystems.utils.option

import spock.lang.Specification

/*
 * Copyright © 2019-2020 ArkoiSystems (https://www.arkoisystems.com/) All Rights Reserved.
 * Created ArkoiUtils on May 26, 2020
 * Author єхcsє#5543 aka timo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

class OptionsSpec extends Specification {
    
    def "test options"() {
        given:
        def options = new Options()
        options.addOption(Option.builder()
                .shortName("i")
                .longName("input")
                .description("input file or directory which is getting compiled.")
                .build())
        options.addOption(Option.builder()
                .shortName("o")
                .longName("output")
                .description("output path for the compiler.")
                .build())
        
        expect:
        options.getOptions().size() == 2
    }
    
}
