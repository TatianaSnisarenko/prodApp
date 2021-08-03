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
VALUES ('Pomegranate Mint Balancing Conditioner', 223.37, '621163b8-92e6-41c6-a393-75b1dfbc3a01'),
       ('Thickening B-Complex Biotin Shampoo', 223.37, '621163b8-92e6-41c6-a393-75b1dfbc3a01'),
       ('Exfoliating Bar Soap', 83.76, '621163b8-92e6-41c6-a393-75b1dfbc3a01'),
       ('Argan Oil Hand Cream', 83.76, '621163b8-92e6-41c6-a393-75b1dfbc3a01'),
       ('Mango Turmeric Soap Bar', 83.76, '621163b8-92e6-41c6-a393-75b1dfbc3a01'),
       ('On The Go Hand Cleanser', 58.63, '621163b8-92e6-41c6-a393-75b1dfbc3a01'),
       ('Pycnogenol Serum', 279.22, '621163b8-92e6-41c6-a393-75b1dfbc3a01'),
       ('Orange Bergamot Body Butter', 167.53, '621163b8-92e6-41c6-a393-75b1dfbc3a01'),
       ('Herbal Shampoo for Normal Hair', 279.22, '8fe2f2b0-a539-4490-a52e-f4017f2e7a19'),
       ('Bamboo Conditioner for Thin Hair', 279.22, '8fe2f2b0-a539-4490-a52e-f4017f2e7a19'),
       ('Sunflower Shampoo for Color-Treated Hair', 279.22, '8fe2f2b0-a539-4490-a52e-f4017f2e7a19'),
       ('Sea Buckthorn Conditioner for Oily Hair', 279.22, '8fe2f2b0-a539-4490-a52e-f4017f2e7a19'),
       ('Sea Buckthorn Shampoo for Oily Hair', 279.22, '8fe2f2b0-a539-4490-a52e-f4017f2e7a19'),
       ('Pure Rosehip Seed Oil', 162.22, 'f5866448-0c39-4861-8240-8c63faf205bc'),
       ('Advanced Revitalization Cream', 458.47, 'f5866448-0c39-4861-8240-8c63faf205bc'),
       ('Pure Magnesium Oil', 224.49, 'f5866448-0c39-4861-8240-8c63faf205bc'),
       ('Pure Magnesium Flakes', 195.73, 'f5866448-0c39-4861-8240-8c63faf205bc'),
       ('Magnesium Soap', 109.73, 'f5866448-0c39-4861-8240-8c63faf205bc'),
       ('Magnesium Oil Night Spray', 271.68, 'f5866448-0c39-4861-8240-8c63faf205bc'),
       ('Smooth As Silk, Deeper Moisture Conditioner', 199.92, '2a280c52-1785-4683-9989-0e4e752ab390'),
       ('Anti-Frizz Hair Serum', 199.92, '2a280c52-1785-4683-9989-0e4e752ab390'),
       ('Hydrating-Clarifying Shampoo', 199.92, '2a280c52-1785-4683-9989-0e4e752ab390'),
       ('Styling Gel, Strong Hold', 199.92, '2a280c52-1785-4683-9989-0e4e752ab390'),
       ('Argan Oil and Aloe Hair Mask', 369.12, 'a8c5da80-f4d7-41b7-a68c-fd44a02301a6'),
       ('Serum Trio Set', 696.92, 'a8c5da80-f4d7-41b7-a68c-fd44a02301a6'),
       ('Argan Oil and Aloe Shampoo', 406.26, 'a8c5da80-f4d7-41b7-a68c-fd44a02301a6'),
       ('Lavender Oil', 95.26, 'a8c5da80-f4d7-41b7-a68c-fd44a02301a6'),
       ('Argan Oil Thermal Shield', 375.27, 'a8c5da80-f4d7-41b7-a68c-fd44a02301a6');




