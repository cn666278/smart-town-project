delete
from checkpoints;
insert into checkpoints (name, img, description, contact, latitude, longitude, address)
values ('Cardiff Castle',
        'https://www.visitcardiff.com/app/uploads/2019/06/Cardiff-Castle-2.jpg',
        'Cardiff Castle (Welsh: Castell Caerdydd) is a medieval castle and Victorian Gothic revival mansion located in the city centre of Cardiff, Wales.',
        'https://www.cardiffcastle.com',
        '55.3781° N',
        '3.4360° W',
        'Castle St, Cardiff CF10 3RB');

insert into checkpoints (name, img, description, contact, latitude, longitude, address)
values ('National Museum Cardiff',
        'https://dynamic-media-cdn.tripadvisor.com/media/photo-o/12/46/de/c6/spring-sunshine.jpg',
        'Witness one of Europe''s finest art collections. Five hundred years of magnificent paintings, drawings, sculpture, silver and ceramics from Wales and across the world, including one of Europe''s best collections of Impressionist art.',
        'https://museum.wales/cardiff/',
        '51.4857° N',
        '3.1768° W',
        'Cardiff CF10 3NP');

delete
from users;
insert into users (name, password, profile_img, account, email, badge)
values ('admin1',
        '$2a$10$SZiL1xIvb4AmAQHlHdpGXumenQGUF16.vPbK2qjxQCWuL1SftZ2aO',
        'https://cn.i.cdn.ti-platform.com/cnapac/content/701/showpage/we-bare-bears/sa/showicon.png',
        001,
        'admin@cardiff.ac.uk',
        'dragon hero');
insert into users (name, password, profile_img, account, email, badge)
values ('user1',
        '$2a$10$MvdjfEjMRuuSaTx8sCBEHepupbp8rcmJTzuF6oxuyFYtCY5KzVjLC',
        'https://cn.i.cdn.ti-platform.com/cnapac/content/701/showpage/we-bare-bears/sa/showicon.png',
        123,
        'user@cardiff.ac.uk',
        'dragon hero');

delete from roles;
insert into roles (role_id, name)
values (1, 'ADMIN');
insert into roles (role_id, name)
values (2, 'USER');

delete from users_roles;
insert into users_roles (user_id, role_id)
values (1, 1);
insert into users_roles (user_id, role_id)
values (1, 2);
insert into users_roles (user_id, role_id)
values (2, 2);