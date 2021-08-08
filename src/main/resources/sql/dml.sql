INSERT INTO role(name)
VALUES ('ROLE_ADMIN'),
       ('ROLE_USER');

INSERT INTO users(email, password, first_name, last_name)
VALUES ('super@gmail.com', '$2a$10$k76mGQbBf7I3qeQ5oexzcOSpOuQFiRNpdUoeSGprJou2JIglkl.YW', 'Super', 'Super');

INSERT INTO users_roles(id_user, id_role)
VALUES ((SELECT id FROM users where email = 'super@gmail.com'), (SELECT id FROM role where name = 'ROLE_ADMIN'));

INSERT INTO producer (name)
VALUES ('Mild By Nature'),
       ('Nature''s Gate'),
       ('Life-flo'),
       ('Giovanni'),
       ('Artnaturals');

INSERT INTO product (name, price, id_producer)
VALUES ('Pomegranate Mint Balancing Conditioner', 223.37, (SELECT id FROM producer where name = 'Mild By Nature')),
       ('Thickening B-Complex Biotin Shampoo', 223.37, (SELECT id FROM producer where name = 'Mild By Nature')),
       ('Exfoliating Bar Soap', 83.76, (SELECT id FROM producer where name = 'Mild By Nature')),
       ('Argan Oil Hand Cream', 83.76, (SELECT id FROM producer where name = 'Mild By Nature')),
       ('Mango Turmeric Soap Bar', 83.76, (SELECT id FROM producer where name = 'Mild By Nature')),
       ('On The Go Hand Cleanser', 58.63, (SELECT id FROM producer where name = 'Mild By Nature')),
       ('Pycnogenol Serum', 279.22, (SELECT id FROM producer where name = 'Mild By Nature')),
       ('Orange Bergamot Body Butter', 167.53, (SELECT id FROM producer where name = 'Mild By Nature')),
       ('Herbal Shampoo for Normal Hair', 279.22, (SELECT id FROM producer where name = 'Mild By Nature')),
       ('Bamboo Conditioner for Thin Hair', 279.22, (SELECT id FROM producer where name = 'Nature''s Gate')),
       ('Sunflower Shampoo for Color-Treated Hair', 279.22, (SELECT id FROM producer where name = 'Nature''s Gate')),
       ('Sea Buckthorn Conditioner for Oily Hair', 279.22, (SELECT id FROM producer where name = 'Nature''s Gate')),
       ('Sea Buckthorn Shampoo for Oily Hair', 279.22, (SELECT id FROM producer where name = 'Nature''s Gate')),
       ('Pure Rosehip Seed Oil', 162.22, (SELECT id FROM producer where name = 'Life-flo')),
       ('Advanced Revitalization Cream', 458.47, (SELECT id FROM producer where name = 'Life-flo')),
       ('Pure Magnesium Oil', 224.49, (SELECT id FROM producer where name = 'Life-flo')),
       ('Pure Magnesium Flakes', 195.73, (SELECT id FROM producer where name = 'Life-flo')),
       ('Magnesium Soap', 109.73, (SELECT id FROM producer where name = 'Life-flo')),
       ('Magnesium Oil Night Spray', 271.68, (SELECT id FROM producer where name = 'Life-flo')),
       ('Smooth As Silk, Deeper Moisture Conditioner', 199.92, (SELECT id FROM producer where name = 'Giovanni')),
       ('Anti-Frizz Hair Serum', 199.92, (SELECT id FROM producer where name = 'Giovanni')),
       ('Hydrating-Clarifying Shampoo', 199.92, (SELECT id FROM producer where name = 'Giovanni')),
       ('Styling Gel, Strong Hold', 199.92, (SELECT id FROM producer where name = 'Giovanni')),
       ('Argan Oil and Aloe Hair Mask', 369.12, (SELECT id FROM producer where name = 'Artnaturals')),
       ('Serum Trio Set', 696.92, (SELECT id FROM producer where name = 'Artnaturals')),
       ('Argan Oil and Aloe Shampoo', 406.26, (SELECT id FROM producer where name = 'Artnaturals')),
       ('Lavender Oil', 95.26, (SELECT id FROM producer where name = 'Artnaturals')),
       ('Argan Oil Thermal Shield', 375.27, (SELECT id FROM producer where name = 'Artnaturals'));




