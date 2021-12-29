/* Create tables */
create table users
(
    id       BIGINT UNIQUE NOT NULL
        CONSTRAINT users_pk
            PRIMARY KEY,
    username VARCHAR,
    password VARCHAR,
    role     VARCHAR,
    enabled  BOOLEAN DEFAULT true
);

/* Unique index */
create unique index users_username_uindex
    on users (username);


/* Add sequences */
create sequence users_id_seq;
alter table users
    alter column id set default nextval('public.users_id_seq');
alter sequence users_id_seq owned by users.id;


/* Alter existing tables */
alter table game
    add "userid" BIGINT;


/* Create constraints */
alter table game
    add constraint game_users_id_fk
        foreign key (userid) references users (id);
