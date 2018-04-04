INSERT INTO roles (role_name, enabled, deleted)
VALUES
    ('USER', TRUE , FALSE),
    ('CLIENT', TRUE , FALSE),
    ('ADMIN', TRUE , FALSE),
    ('SUPER_ADMIN', TRUE , FALSE);


INSERT INTO users (id, created_at, deleted, email, enabled, expires, firstname, last_login, lastname, modified_at, password, role_id)
 VALUES
 (1, '2018-01-01', false, 'gregobinna2@gmail.com', true, 0, 'admin', '2018-01-01', 'admin', '2018-01-01', '18a9c8d441dbb0bed50ea270bf5ed47810153da28ab16fcb1f57c2f19a2afcad302427ea325f729e', 3);