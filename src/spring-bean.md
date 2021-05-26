
## spring bean依赖注入常见错误
* 对于 Bean 的名字，如果没有显式指明，就应该是类名，不过首字母应该小写
* 对于内部类的引用需要加类名

@Value注入
[ConfigurationPropertySourcesPropertySource {name='configurationProperties'}, 
StubPropertySource {name='servletConfigInitParams'}, ServletContextPropertySource {name='servletContextInitParams'}, PropertiesPropertySource {name='systemProperties'}, OriginAwareSystemEnvironmentPropertySource {name='systemEnvironment'}, RandomValuePropertySource {name='random'},
OriginTrackedMapPropertySource {name='applicationConfig: classpath:/application.properties]'},
MapPropertySource {name='devtools'}]

集合的收集装配和直接装配不能同时生效