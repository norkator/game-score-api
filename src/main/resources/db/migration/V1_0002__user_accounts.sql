/* Create tables */
create table "user"
(
    id       BIGINT UNIQUE NOT NULL
        CONSTRAINT user_pk
            PRIMARY KEY,
    username VARCHAR,
    password VARCHAR,
    enabled  BOOLEAN DEFAULT true
);


/* Add sequences */
create sequence user_id_seq;
alter table "user"
    alter column id set default nextval('public.user_id_seq');
alter sequence user_id_seq owned by "user".id;


/* Alter existing tables */
alter table game
    add "userid" BIGINT;


/* Create constraints */
alter table game
    add constraint game_user_id_fk
        foreign key (userid) references "user" (id);

