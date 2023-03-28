
DELETE FROM msvc_kitchen.recipes;
INSERT INTO msvc_kitchen.recipes(id_recipe,name,time_to_cook) VALUES (1,'Ensalada de tomate y queso',20);
INSERT INTO msvc_kitchen.recipes(id_recipe,name,time_to_cook) VALUES (2,'Milanesa de carne con puré',50);
INSERT INTO msvc_kitchen.recipes(id_recipe,name,time_to_cook) VALUES (3,'Arroz con pollo',40);
INSERT INTO msvc_kitchen.recipes(id_recipe,name,time_to_cook) VALUES (4,'Hamburguesa con queso y ketchup',30);
INSERT INTO msvc_kitchen.recipes(id_recipe,name,time_to_cook) VALUES (5,'Tortilla de papa',25);
INSERT INTO msvc_kitchen.recipes(id_recipe,name,time_to_cook) VALUES (6,'Pollo asado con limon',35);

DELETE FROM msvc_kitchen.recipe_ingredients;
INSERT INTO msvc_kitchen.recipe_ingredients(id,ingredient_id,quantity,recipe_id,ingredient_name) VALUES (1,1,2,1,'tomato');
INSERT INTO msvc_kitchen.recipe_ingredients(id,ingredient_id,quantity,recipe_id,ingredient_name) VALUES (2,6,1,1,'lettuce');
INSERT INTO msvc_kitchen.recipe_ingredients(id,ingredient_id,quantity,recipe_id,ingredient_name) VALUES (3,7,1,1,'onion');
INSERT INTO msvc_kitchen.recipe_ingredients(id,ingredient_id,quantity,recipe_id,ingredient_name) VALUES (4,8,1,1,'cheese');
INSERT INTO msvc_kitchen.recipe_ingredients(id,ingredient_id,quantity,recipe_id,ingredient_name) VALUES (5,2,1,1,'lemon');
INSERT INTO msvc_kitchen.recipe_ingredients(id,ingredient_id,quantity,recipe_id,ingredient_name) VALUES (6,3,2,2,'potato');
INSERT INTO msvc_kitchen.recipe_ingredients(id,ingredient_id,quantity,recipe_id,ingredient_name) VALUES (7,7,1,2,'onion');
INSERT INTO msvc_kitchen.recipe_ingredients(id,ingredient_id,quantity,recipe_id,ingredient_name) VALUES (8,9,1,2,'meat');
INSERT INTO msvc_kitchen.recipe_ingredients(id,ingredient_id,quantity,recipe_id,ingredient_name) VALUES (9,4,1,3,'rice');
INSERT INTO msvc_kitchen.recipe_ingredients(id,ingredient_id,quantity,recipe_id,ingredient_name) VALUES (10,10,1,3,'chicken');
INSERT INTO msvc_kitchen.recipe_ingredients(id,ingredient_id,quantity,recipe_id,ingredient_name) VALUES (11,1,2,3,'tomato');
INSERT INTO msvc_kitchen.recipe_ingredients(id,ingredient_id,quantity,recipe_id,ingredient_name) VALUES (12,7,1,3,'onion');
INSERT INTO msvc_kitchen.recipe_ingredients(id,ingredient_id,quantity,recipe_id,ingredient_name) VALUES (13,9,1,4,'meat');
INSERT INTO msvc_kitchen.recipe_ingredients(id,ingredient_id,quantity,recipe_id,ingredient_name) VALUES (14,5,1,4,'ketchup');
INSERT INTO msvc_kitchen.recipe_ingredients(id,ingredient_id,quantity,recipe_id,ingredient_name) VALUES (15,7,1,4,'onion');
INSERT INTO msvc_kitchen.recipe_ingredients(id,ingredient_id,quantity,recipe_id,ingredient_name) VALUES (16,8,1,4,'cheese');
INSERT INTO msvc_kitchen.recipe_ingredients(id,ingredient_id,quantity,recipe_id,ingredient_name) VALUES (17,3,2,5,'potato');
INSERT INTO msvc_kitchen.recipe_ingredients(id,ingredient_id,quantity,recipe_id,ingredient_name) VALUES (18,7,3,5,'onion');
INSERT INTO msvc_kitchen.recipe_ingredients(id,ingredient_id,quantity,recipe_id,ingredient_name) VALUES (19,8,1,5,'cheese');
INSERT INTO msvc_kitchen.recipe_ingredients(id,ingredient_id,quantity,recipe_id,ingredient_name) VALUES (20,10,2,6,'chicken');
INSERT INTO msvc_kitchen.recipe_ingredients(id,ingredient_id,quantity,recipe_id,ingredient_name) VALUES (21,2,2,6,'lemon');
INSERT INTO msvc_kitchen.recipe_ingredients(id,ingredient_id,quantity,recipe_id,ingredient_name) VALUES (22,7,2,6,'onion');


