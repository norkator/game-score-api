# Game score api

Work in progress!

Spring based score api for generic games. I use this for Spring and Kotlin learning. Requirement for this project is to
be as simple as possible with as less code as possible. Final implementation most likely uses basic authentication for
clients to post and get results which is security wise bad, but PR's could bring more security schemas like OAuth or
something else.

-------------------------

### Todo list

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
    - [ ] Github container registry image via actions.
- [ ] Craft fully functional game score api.
    - [ ] Planning.
- [ ] Some simple authentication system.
    - [ ] Planning /Basic auth?
- [ ] Documentations and drawings.
    - [x] Database structure drawing.
    - [ ] Getting started.

-------------------------


Table of contents
=================

* [Stack](#stack)
* [Environment](#environment)
* [Installing](#installing)

Stack
============

* Spring
    * Booted using https://start.spring.io/ with
      this [configuration](https://start.spring.io/#!type=gradle-project&language=kotlin&platformVersion=2.6.2&packaging=jar&jvmVersion=11&groupId=com.nitramite&artifactId=game-score-api&name=game-score-api&description=Generic%20game%20score%20api&packageName=com.nitramite.game-score-api&dependencies=flyway,data-jpa,web,postgresql)
      .
* Kotlin
* PostgreSQL

Structure
============
Sketch of planned database structure.

![game-score-api-drawio](./doc/game-score-api.drawio.png)


Environment
============
todo...


Installing
============
todo...