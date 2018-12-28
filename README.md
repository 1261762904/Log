# Log

logInfo文件 只用了log4j

slf4j_log4j文件 Log4j和slf4j整合使用

slf4j只是一个日志标准，并不是日志系统的具体实现

1. 提供日志接口
2. 提供获取具体日志对象的方法

所以需要配合具体实现的日志一起使用

slf4j-simple、logback都是slf4j的具体实现，而log4j不是，所以有专门的一层桥接slf4j-log4j12来实现slf4j。
