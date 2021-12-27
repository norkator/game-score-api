/* Create tables */
CREATE TABLE game
(
    id          BIGINT UNIQUE NOT NULL
        CONSTRAINT game_pk
            PRIMARY KEY,
    name        VARCHAR,
    description TEXT,
    enabled     BOOLEAN DEFAULT true
);

CREATE TABLE client
(
    clientUid VARCHAR UNIQUE,
    updatedAt TIMESTAMP DEFAULT now(),
    createdAt TIMESTAMP DEFAULT now()
);

CREATE TABLE score
(
    id        BIGINT NOT NULL
        CONSTRAINT score_pk
            PRIMARY KEY,
    gameId    BIGINT UNIQUE,
    clientUid VARCHAR UNIQUE,
    score     BIGINT,
    updatedAt TIMESTAMP DEFAULT now(),
    createdAt TIMESTAMP DEFAULT now()
);

CREATE TABLE achievement
(
    id                BIGINT NOT NULL
        CONSTRAINT achievement_pk
            PRIMARY KEY,
    gameId            BIGINT UNIQUE,
    clientUid         VARCHAR UNIQUE,
    achievementTypeId BIGINT UNIQUE,
    updatedAt         TIMESTAMP DEFAULT now(),
    createdAt         TIMESTAMP DEFAULT now()
);

CREATE TABLE achievementType
(
    id          BIGINT UNIQUE NOT NULL
        CONSTRAINT achievementType_pk
            PRIMARY KEY,
    name        VARCHAR,
    description TEXT
);


/* Add sequences */
create sequence game_id_seq;
alter table game alter column id set default nextval('public.game_id_seq');
alter sequence game_id_seq owned by game.id;

create sequence score_id_seq;
alter table score alter column id set default nextval('public.score_id_seq');
alter sequence score_id_seq owned by score.id;


/* Create constraints */
alter table public.score
    add constraint score_game_id_fk
        foreign key (gameid) references public.game (id);

alter table public.score
    add constraint score_client_clientuid_fk
        foreign key (clientuid) references public.client (clientuid);

alter table public.achievement
    add constraint achievement_game_id_fk
        foreign key (gameid) references public.game (id);

alter table public.achievement
    add constraint achievement_client_clientuid_fk
        foreign key (clientuid) references public.client (clientuid);

alter table public.achievement
    add constraint achievement_achievementtype_id_fk
        foreign key (achievementtypeid) references public.achievementtype (id);
