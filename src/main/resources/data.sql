insert into restaurant (name, address, city, state, zip_code) values ('Bom Prato','Rua Principal','Jundiai','SP','00000000');
insert into restaurant (name, address, city, state, zip_code) values ('Grande Sabor','Rua Secundaria','Campo Limpo','SP','00000000');
insert into restaurant (name, address, city, state, zip_code) values ('Melhor Sabor','Rua Secundaria','Campo Limpo','SP','00000000');

insert into restaurant_evaluation (restaurant_id, evaluation, comment) values (1,5,'A comida estava deliciosa');
insert into restaurant_evaluation (restaurant_id, evaluation, comment) values (1,4,'A comida estava muito gostosa');

insert into meal (restaurant_id, name, cost, ingredients) values (1,'Da casa',15.45,'Arroz, feijão, bife e batata frita');
insert into meal (restaurant_id, name, cost, ingredients) values (1,'Especial',20.00,'Tudo que aguentar comer');

insert into meal_evaluation (meal_id, evaluation, comment) values (1,5,'Muito bom');
insert into meal_evaluation (meal_id, evaluation, comment) values (1,4,'Estava delicioso');


insert into meal_eval (meal_id, evaluation, comment) values (1,1,'Nao gostei');
insert into meal_eval (meal_id, evaluation, comment) values (2,1,'Nao gostei');
insert into meal_eval (meal_id, evaluation, comment) values (2,2,'Nao gostei');

insert into restaurant_eval (restaurant_id, evaluation, comment) values (1,2,'Nao gostei');
insert into restaurant_eval (restaurant_id, evaluation, comment) values (1,1,'Nao gostei');
insert into restaurant_eval (restaurant_id, evaluation, comment) values (2,2,'Nao gostei');