# local-build-time-maven-plugin
解决Maven自带时间戳差8小时问题的maven小插件。具体情况是${maven.build.timestamp}能获取时间，但是时区是UTC，又无法设置时区。  

Solve the problem that Maven has a timestamp difference of 8 hours. Specifically, ${maven.build.timestamp} can get the time, but the time zone is UTC, and the time zone cannot be set.
