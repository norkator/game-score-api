/* Create tables */
CREATE TABLE game
(
    id          BIGINT UNIQUE,
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
    id        BIGINT,
    gameId    BIGINT UNIQUE,
    clientUid VARCHAR UNIQUE,
    score     BIGINT,
    updatedAt TIMESTAMP DEFAULT now(),
    createdAt TIMESTAMP DEFAULT now()
);

CREATE TABLE achievement
(
    id                BIGINT,
    gameId            BIGINT UNIQUE,
    clientUid         VARCHAR UNIQUE,
    achievementTypeId BIGINT UNIQUE,
    updatedAt         TIMESTAMP DEFAULT now(),
    createdAt         TIMESTAMP DEFAULT now()
);

CREATE TABLE achievementType
(
    id          BIGINT UNIQUE,
    name        VARCHAR,
    description TEXT
);


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
