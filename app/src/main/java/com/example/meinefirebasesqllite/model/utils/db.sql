create table user (
_id INTEGER primary key autoincrement,
 fname Text,
 lanem Text,
 yob INTEGER
)

CREATE TABLE login(
_id integer primary key autoincrement,
username Text,
password Text,
user_id integer,
FOREIGN KEY(user_id) REFERENCES usert(_id)
)