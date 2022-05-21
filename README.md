## MapStruct

Starting with Basic Sprint boot dependencies

springboot-starter
springboot-starter-test
mapStruct
lombok

Each time the mapper class is saved (@Mapper), mapStrut generates the source code in target directory

To work with lombok in the pom file the plugin is like this

    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.5.1</version>
        <configuration>
            <source>11</source>
            <target>11</target>
            <annotationProcessorPaths>
                <path>
                    <groupId>org.mapstruct</groupId>
                    <artifactId>mapstruct-processor</artifactId>
                    <version>${org.mapstruct.version}</version>
                </path>
                <path>
                    <groupId>org.projectlombok</groupId>
                    <artifactId>lombok</artifactId>
                    <version>1.18.12</version>
                </path>
            </annotationProcessorPaths>
        </configuration>
    </plugin>

