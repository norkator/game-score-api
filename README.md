# Game score api

Work in progress!

Spring based score api for generic games. I use this for Spring and Kotlin learning. Requirement for this project is to
be as simple as possible with as less code as possible. Final implementation most likely uses basic authentication for
clients to post and get results which is security wise bad, but PR's could bring more security schemas like OAuth or
something else.


Table of contents
=================

* [Stack](#stack)
* [Environment](#environment)
* [Installing](#installing)
* [Development](#development)
    * [Todo list](#todo-list)

Stack
============

* Spring
    * Booted using https://start.spring.io/ with
      this [configuration](https://start.spring.io/#!type=gradle-project&language=kotlin&platformVersion=2.6.2&packaging=jar&jvmVersion=11&groupId=com.nitramite&artifactId=game-score-api&name=game-score-api&description=Generic%20game%20score%20api&packageName=com.nitramite.game-score-api&dependencies=flyway,data-jpa,web,postgresql)
      .
* Kotlin.
* PostgreSQL.

Structure
============
Sketch of planned database structure.

![game-score-api-drawio](./doc/game-score-api.drawio.png)


Environment
============
You need to have Postgresql server installed. This app needs it as data store.


Installing
============
Run standalone or use docker via `docker-compose up`.

1. Create psql database called `game-scores`.
2. Rename `docker-compose.yml_tpl` to `docker-compose.yml`
3. Set `environment` variable values:

```
  - DATABASE_URL=
  - DATABASE_USERNAME=
  - DATABASE_PASSWORD=
  - BASIC_AUTH_USERNAME=
  - BASIC_AUTH_PASSWORD=
```

4. Run `docker-compose up`.
5. Open [http://localhost:8080/](http://localhost:8080/).


Development
============
Notes and stuff for development.

Todo list
-------

- [x] Implement skeleton structure.
- [x] Create score controller.
- [x] Create score model.
- [x] Create score entity.
- [x] Create score repository.
- [x] Create score service.
- [x] Learn migrations.
    - [x] Create score entity and other tables.
- [ ] Learn and create tests.
    - [x] Add a skeleton of actions builds pipeline.
    - [ ] Add tests testing controllers.
- [x] Docker configurations.
- [ ] Create build pipeline.
    - [x] Github container registry image via actions.
- [ ] Craft fully functional game score api.
    - [ ] Planning.
- [ ] Some simple authentication system.
    - [x] Planning /Basic auth?
- [ ] Documentations and drawings.
    - [x] Database structure drawing.
    - [x] Getting started.
  