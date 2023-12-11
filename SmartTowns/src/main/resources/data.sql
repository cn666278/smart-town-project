delete
from checkpoint;
insert into checkpoint(name, image, description, contact, latitude, longitude, address)
values ('Cardiff Castle',
        'https://www.visitcardiff.com/app/uploads/2019/06/Cardiff-Castle-2.jpg',
        'Cardiff Castle (Welsh: Castell Caerdydd) is a medieval castle and Victorian Gothic revival mansion located in the city centre of Cardiff, Wales.',
        'https://www.cardiffcastle.com',
        '55.3781° N',
        '3.4360° W',
        'Castle St, Cardiff CF10 3RB');

insert into checkpoint(name, image, description, contact, latitude, longitude, address)
values ('National Museum Cardiff',
        'https://dynamic-media-cdn.tripadvisor.com/media/photo-o/12/46/de/c6/spring-sunshine.jpg',
        'Witness one of Europe''s finest art collections. Five hundred years of magnificent paintings, drawings, sculpture, silver and ceramics from Wales and across the world, including one of Europe''s best collections of Impressionist art.',
        'https://museum.wales/cardiff/',
        '51.4857° N',
        '3.1768° W',
        'Cardiff CF10 3NP');
insert into checkpoint(name, image, description, contact, latitude, longitude, address)
values ('Cardiff Bay',
        'https://www.visitcardiff.com/app/uploads/2019/06/Cardiff-Bay-2.jpg',
        'Cardiff Bay (Welsh: Bae Caerdydd) is the area of water created by the Cardiff Barrage in south Cardiff, the capital of Wales.',
        'https://www.visitcardiff.com/explore/cardiff-bay/',
        '51.4647° N',
        '3.1633° W',
        'Cardiff CF10 4PA');
insert into checkpoint(name, image, description, contact, latitude, longitude, address)
values ('Principality Stadium',
        'https://www.visitcardiff.com/app/uploads/2019/06/Principality-Stadium-2.jpg',
        'The Principality Stadium (Welsh: Stadiwm Principality), known as the Millennium Stadium from 1999 until 2015, is the national stadium of Wales.',
        'https://www.principalitystadium.wales/',
        '51.4782° N',
        '3.1828° W',
        'Westgate St, Cardiff CF10 1NS');
insert into checkpoint(name, image, description, contact, latitude, longitude, address)
values ('Cardiff Bay Barrage',
        'https://www.visitcardiff.com/app/uploads/2019/06/Cardiff-Bay-Barrage-2.jpg',
        'The Cardiff Bay Barrage (Welsh: Dynesfa Bae Caerdydd) is a major civil engineering project in South Cardiff, Wales.',
        'https://www.cardiffharbour.com/',
        '51.4532° N',
        '3.1667° W',
        'Cardiff CF10 4LY');
insert into checkpoint(name, image, description, contact, latitude, longitude, address)
values ('St Fagans National Museum of History',
        'https://www.visitcardiff.com/app/uploads/2019/06/St-Fagans-National-Museum-of-History-2.jpg',
        'St Fagans National Museum of History (Welsh: Sain Ffagan: Amgueddfa Werin Cymru), commonly referred to as St Fagans after the village where it is located, is an open-air museum in Cardiff chronicling the historical lifestyle, culture, and architecture of the Welsh people.',
        'https://museum.wales/stfagans/',
        '51.4861° N',
        '3.2733° W',
        'Cardiff CF5 6XB');
insert into checkpoint(name, image, description, contact, latitude, longitude, address)
values ('Wales Millennium Centre',
        'https://www.visitcardiff.com/app/uploads/2019/06/Wales-Millennium-Centre-2.jpg',
        'Wales Millennium Centre (Welsh: Canolfan Mileniwm Cymru) is an arts centre located in the Cardiff Bay area of Cardiff, Wales.',
        'https://www.wmc.org.uk/',
        '51.4647° N',
        '3.1633° W',
        'Bute Pl, Cardiff CF10 5AL');
insert into checkpoint(name, image, description, contact, latitude, longitude, address)
values ('Cardiff Bay Wetlands Reserve',
        'https://www.visitcardiff.com/app/uploads/2019/06/Cardiff-Bay-Wetlands-Reserve-2.jpg',
        'Cardiff Bay Wetlands Reserve is a wetlands reserve in Cardiff, Wales. It is managed by the Wildlife Trust of South and West Wales.',
        'https://www.welshwildlife.org/nature-reserve/cardiff-bay-wetland-reserve/',
        '51.4532° N',
        '3.1667° W',
        'Cardiff CF10 4LY');
insert into checkpoint(name, image, description, contact, latitude, longitude, address)
values ('Cardiff Bay Barrage',
        'https://www.visitcardiff.com/app/uploads/2019/06/Cardiff-Bay-Barrage-2.jpg',
        'The Cardiff Bay Barrage (Welsh: Dynesfa Bae Caerdydd) is a major civil engineering project in South Cardiff, Wales.',
        'https://www.cardiffharbour.com/',
        '51.4532° N',
        '3.1667° W',
        'Cardiff CF10 4LY');
insert into checkpoint(name, image, description, contact, latitude, longitude, address)
values ('Cardiff Bay Barrage',
        'https://www.visitcardiff.com/app/uploads/2019/06/Cardiff-Bay-Barrage-2.jpg',
        'The Cardiff Bay Barrage (Welsh: Dynesfa Bae Caerdydd) is a major civil engineering project in South Cardiff, Wales.',
        'https://www.cardiffharbour.com/',
        '51.4532° N',
        '3.1667° W',
        'Cardiff CF10 4LY');
insert into checkpoint(name, image, description, contact, latitude, longitude, address)
values ('Cardiff Bay Barrage',
        'https://www.visitcardiff.com/app/uploads/2019/06/Cardiff-Bay-Barrage-2.jpg',
        'The Cardiff Bay Barrage (Welsh: Dynesfa Bae Caerdydd) is a major civil engineering project in South Cardiff, Wales.',
        'https://www.cardiffharbour.com/',
        '51.4532° N',
        '3.1667° W',
        'Cardiff CF10 4LY');
insert into checkpoint(name, image, description, contact, latitude, longitude, address)
values ('Cardiff Bay Barrage',
        'https://www.visitcardiff.com/app/uploads/2019/06/Cardiff-Bay-Barrage-2.jpg',
        'The Cardiff Bay Barrage (Welsh: Dynesfa Bae Caerdydd) is a major civil engineering project in South Cardiff, Wales.',
        'https://www.cardiffharbour.com/',
        '51.4532° N',
        '3.1667° W',
        'Cardiff CF10 4LY');
delete
from users;
insert into users (name, password, profile_img, account, email, badge)
values ('admin1',
        '$2a$10$AIuHeSPZqM1Zr66XH8a5WOti7NrSb00tqRhEeKBig8qOx.5C79rcq',
        'https://cn.i.cdn.ti-platform.com/cnapac/content/701/showpage/we-bare-bears/sa/showicon.png',
        001,
        'admin@cardiff.ac.uk',
        'dragon hero');
insert into users (name, password, profile_img, account, email, badge)
values ('user1',
        '$2a$10$o5LRNO84QaTX62LzsF2AbuJL8qiU/CLpVMB7l4LKIAP8hxx0IfITu',
        'https://cn.i.cdn.ti-platform.com/cnapac/content/701/showpage/we-bare-bears/sa/showicon.png',
        123,
        'user@cardiff.ac.uk',
        'dragon hero');
    insert into users (name, password, profile_img, account, email, badge)
    values ('user2',
            '$2a$10$o5LRNO84QaTX62LzsF2AbuJL8qiU/CLpVMB7l4LKIAP8hxx0IfITu',
            'https://cn.i.cdn.ti-platform.com/cnapac/content/701/showpage/we-bare-bears/sa/showicon.png',
            124,
            '1@qq.com',
            'dragon hero');
delete
from trail;
insert into trail (name,image,details)
values ('Cardiff Castle',
        'https://www.visitcardiff.com/app/uploads/2019/06/Cardiff-Castle-2.jpg',
        'Cardiff Castle (Welsh: Castell Caerdydd) is a medieval castle and Victorian Gothic revival mansion located in the city centre of Cardiff, Wales.');
insert into trail (name,image,details)
values ('National Museum Cardiff',
        'https://dynamic-media-cdn.tripadvisor.com/media/photo-o/12/46/de/c6/spring-sunshine.jpg',
        'Witness one of Europe''s finest art collections. Five hundred years of magnificent paintings, drawings, sculpture, silver and ceramics from Wales and across the world, including one of Europe''s best collections of Impressionist art.');
insert into trail (name,image,details)
values ('Cardiff Bay',
        'https://www.visitcardiff.com/app/uploads/2019/06/Cardiff-Bay-2.jpg',
        'Cardiff Bay (Welsh: Bae Caerdydd) is the area of water created by the Cardiff Barrage in south Cardiff, the capital of Wales.');
delete
from roles;
insert into roles (name)
values ('ADMIN');
insert into roles (name)
values ('USER');

delete
from users_roles;
insert into users_roles (user_id, role_id)
values (1, 1);
insert into users_roles (user_id, role_id)
values (1, 2);
insert into users_roles (user_id, role_id)
values (2, 2);

delete from user_checkpoint;
INSERT INTO `user_checkpoint` VALUES (1, 1, 3);
INSERT INTO `user_checkpoint` VALUES (2, 1, 4);
INSERT INTO `user_checkpoint` VALUES (3, 1, 5);
INSERT INTO `user_checkpoint` VALUES (4, 1, 6);
INSERT INTO `user_checkpoint` VALUES (5, 1, 7);
INSERT INTO `user_checkpoint` VALUES (6, 1, 8);
INSERT INTO `user_checkpoint` VALUES (7, 2, 3);
INSERT INTO `user_checkpoint` VALUES (8, 2, 4);
INSERT INTO `user_checkpoint` VALUES (9, 2, 5);
INSERT INTO `user_checkpoint` VALUES (10, 2, 6);
INSERT INTO `user_checkpoint` VALUES (11, 3, 3);
INSERT INTO `user_checkpoint` VALUES (12, 3, 4);
INSERT INTO `user_checkpoint` VALUES (13, 3, 5);
INSERT INTO `user_checkpoint` VALUES (14, 3, 6);