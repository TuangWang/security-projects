## 项目说明

## security-core
核心代码。引入各种依赖

## security-app
依赖security-core
负责移动app的安全

## security-web
依赖 security-core
负责浏览器web的安全设置

## security-demo
实例。提供被保护的数据部分

## Gradle

- Gradle 有一个初始化流程，这个时候 settings.gradle 会执行。
- 在配置阶段，每个 Project 都会被解析，其内部的任务也会被添加到一个有向 图里，用于解决执行过程中的依赖关系。
- 然后才是执行阶段。你在 gradle xxx 中指定什么任务，gradle 就会将这个 xxx 任务链上的所有任务全部按依赖顺序执行一遍!

show project structure
```sh
./gradlew projects
```

查看项目任务信息
```sh
./gradlew security-web:tasks
```

* gradle task-name 执行任务
* gradle properites 用来查看所有属性信息