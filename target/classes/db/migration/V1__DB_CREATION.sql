create table categories (
    id uuid,
    name varchar(255) not null unique,
    primary key (id)
);

create table companies (
    id uuid,
    name varchar(255) not null unique,
    description text not null,
    logo bytea not null,
    type varchar(255) not null,
    primary key (id)
);

create table users(
    id uuid,
    name varchar(255) not null unique,
    password varchar(255) not null,
    role varchar(255) not null,
    primary key (id)
);

create table announcements (
    id uuid,
    title varchar(255) not null,
    description text not null,
    location varchar(255) not null,
    price money,
    start_time timestamp not null,
    registration_link varchar(255),
    image bytea not null,
    organization_id uuid not null,
    reviewer_id uuid not null,
    primary key (id)
);

create table announcement_categories(
    announcement_id uuid not null,
    category_id uuid not null
);

alter table announcements add constraint constraints1 foreign key (organization_id) references companies;
alter table announcements add constraint constraints2 foreign key (reviewer_id) references users;
alter table announcement_categories add constraint constraints3 foreign key (announcement_id) references announcements;
alter table announcement_categories add constraint constraints4 foreign key (category_id) references categories;

