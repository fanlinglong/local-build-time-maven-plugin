# local-build-time-maven-plugin
解决Maven自带时间戳差8小时问题的maven小插件。具体情况是${maven.build.timestamp}能获取时间，但是时区是UTC，又无法设置时区。
期望得到你的star，thank you very much.

Solve the problem that Maven has a timestamp difference of 8 hours. Specifically, ${maven.build.timestamp} can get the time, but the time zone is UTC, and the time zone cannot be set.


### 简单用法Simple usage
```java
<build>
    <plugins>
        <plugin>
            <groupId>tech.fanlinglong.common</groupId>
            <artifactId>local-build-time-maven-plugin</artifactId>
            <version>LATEST</version>
            <executions>
                <execution>
                    <goals>
                        <goal>timestamp-property</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
        <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-jar-plugin</artifactId>
        <version>3.3.0</version>
        <configuration>
            <archive>
                <manifestEntries>
                    <Build-Time>${local.build.timestamp}</Build-Time>
                </manifestEntries>
            </archive>
        </configuration>
        </plugin>
    </plugins>
</build>

```

### 进阶用法Advanced usage
```java
<build>
    <plugins>
        <plugin>
            <groupId>tech.fanlinglong.common</groupId>
            <artifactId>local-build-time-maven-plugin</artifactId>
            <version>LATEST</version>
            <executions>
                <execution>
                    <goals>
                        <goal>timestamp-property</goal>
                    </goals>
                </execution>
            </executions>
            <!--如需自定义配置，支持配置变量名称、格式、时区You can customize the configuration-->
            <configuration>
                <!--自定义变量名称-->
                <propertyName>build.datetime</propertyName>
                <!--自定义格式-->
                <pattern>yyyy-MM-dd HH:mm</pattern>
                <!--自定义时区-->
                <zoneId>UTC+8</zoneId>
            </configuration>
        </plugin>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-jar-plugin</artifactId>
            <version>3.3.0</version>
            <configuration>
                <archive>
                    <manifestEntries>
                        <Build-Time>${build.datetime}</Build-Time>
                    </manifestEntries>
                </archive>
            </configuration>
        </plugin>
    </plugins>
</build>

```
