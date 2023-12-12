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
insert into users (username, password, profile_img, account, email, badge)
values ('admin1',
        '$2a$10$AIuHeSPZqM1Zr66XH8a5WOti7NrSb00tqRhEeKBig8qOx.5C79rcq',
        'https://cn.i.cdn.ti-platform.com/cnapac/content/701/showpage/we-bare-bears/sa/showicon.png',
        001,
        'admin@cardiff.ac.uk',
        'dragon hero');
insert into users (username, password, profile_img, account, email, badge)
values ('user1',
        '$2a$10$o5LRNO84QaTX62LzsF2AbuJL8qiU/CLpVMB7l4LKIAP8hxx0IfITu',
        'https://cn.i.cdn.ti-platform.com/cnapac/content/701/showpage/we-bare-bears/sa/showicon.png',
        123,
        'user@cardiff.ac.uk',
        'dragon hero');
insert into users (username, password, profile_img, account, email, badge)
values ('user2',
        '$2a$10$o5LRNO84QaTX62LzsF2AbuJL8qiU/CLpVMB7l4LKIAP8hxx0IfITu',
        'https://cn.i.cdn.ti-platform.com/cnapac/content/701/showpage/we-bare-bears/sa/showicon.png',
        123,
        '1@qq.com',
        'dragon hero');
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

DELETE FROM towns;
INSERT INTO towns (id, name, detail, image)
VALUES (1, 'Cardiff', 'The capital city of Wales, located in the south of the country and is the largest city in Wales.', 'https://i2.100024.xyz/2023/12/12/gzjfs9.webp'),
       (2, 'Swansea', 'A coastal city in South Wales, located on the Gower Peninsula.', 'https://i2.100024.xyz/2023/12/12/gzitdu.webp'),
       (3, 'Newport', 'A city in South East Wales, located on the River Usk.', 'https://i2.100024.xyz/2023/12/12/gzift8.webp'),
       (4, 'Wrexham', 'A town in North Wales, located near the border with England.', 'https://i2.100024.xyz/2023/12/12/gzhgi4.webp'),
       (5, 'Aberystwyth', 'A historic market town, administrative centre and holiday resort within Ceredigion, West Wales.', 'https://i2.100024.xyz/2023/12/12/gzgzo6.webp'),
       (6, 'Bangor', 'A city in North West Wales, located on the coast of the Menai Strait.', 'https://i2.100024.xyz/2023/12/12/gzgmju.webp'),
       (7, 'Caernarfon', 'A royal town, community and port in Gwynedd, Wales.', 'https://i2.100024.xyz/2023/12/12/gz7ft8.webp'),
       (8, 'Llandudno', 'A seaside resort, town and community in Conwy County Borough, Wales.', 'https://i2.100024.xyz/2023/12/12/gz6zwi.webp'),
       (9, 'Porthmadog', 'A small coastal town and community in the Eifionydd area of Gwynedd, Wales.', 'https://i2.100024.xyz/2023/12/12/gz6vrx.webp'),
       (10, 'Aberaeron', 'A seaside resort town in Ceredigion, Wales.', 'https://i2.100024.xyz/2023/12/12/gz6mcp.webp');
