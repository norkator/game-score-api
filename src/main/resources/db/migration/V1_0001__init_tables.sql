CREATE TABLE game
(
    id          BIGINT,
    name        VARCHAR,
    description TEXT,
    enabled     BOOLEAN DEFAULT true
);

CREATE TABLE client
(
    clientUid VARCHAR UNIQUE,
    updatedAt DATE DEFAULT now(),
    createdAt DATE DEFAULT now()
);

CREATE TABLE score
(
    id        BIGINT,
    gameId    BIGINT,
    clientUid VARCHAR UNIQUE,
    score     BIGINT,
    updatedAt DATE DEFAULT now(),
    createdAt DATE DEFAULT now()
);

CREATE TABLE achievement
(
    id                BIGINT,
    gameId            BIGINT,
    clientUid         VARCHAR UNIQUE,
    achievementTypeId BIGINT,
    updatedAt         DATE DEFAULT now(),
    createdAt         DATE DEFAULT now()
);

CREATE TABLE achievementType
(
    id          BIGINT,
    name        VARCHAR,
    description TEXT
);
