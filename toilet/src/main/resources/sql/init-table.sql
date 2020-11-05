USE jdr_toilet;

##### init t_toilet_user #####
INSERT INTO t_toilet_user(name, sex, mobile, type, status)
  VALUE ('小明', 0, '15200001111', 0, 0),
  ('小花', 1, '15200002222', 0, 0),
  ('小华', 0, '15200003333', 0, 0),
  ('小军', 1, '15200004444', 0, 0),
  ('路人甲', 0, '15200005555', 1, 0),
  ('路人已', 1, '15200006666', 1, 0),
  ('路人丙', 1, '15200007777', 2, 0),
  ('路人丁', 0, '15200008888', 2, 0);
##### init t_toilet_user #####

##### init t_toilet_toilet #####
INSERT INTO t_toilet_toilet(name, type, floor, admin_user_id, status, location)
  VALUE ('厕所1号', 0, 1, 8, 0, '120.51:30.41'),
  ('厕所2号', 0, 2, 8, 0, '120.61:30.44'),
  ('厕所3号', 1, 1, 7, 0, '120.71:30.46'),
  ('厕所4号', 1, 2, 7, 0, '120.81:30.49');
##### init t_toilet_toilet #####

##### init t_toilet_pit #####
# 各厕所蹲式、马桶2个（女厕所个4个），便池4个（女厕所无便池）
INSERT INTO t_toilet_pit(type, parent_toilet_id, status)
  VALUE (0, 1, 0),
  (0, 1, 0),
  (1, 1, 0),
  (1, 1, 0),
  (2, 1, 0),
  (2, 1, 0),
  (2, 1, 0),
  (2, 1, 0),
  (0, 2, 0),
  (0, 2, 0),
  (1, 2, 0),
  (1, 2, 0),
  (2, 2, 0),
  (2, 2, 0),
  (2, 2, 0),
  (2, 2, 0),
  (0, 3, 0),
  (0, 3, 0),
  (0, 3, 0),
  (0, 3, 0),
  (1, 3, 0),
  (1, 3, 0),
  (1, 3, 0),
  (1, 3, 0),
  (0, 4, 0),
  (0, 4, 0),
  (0, 4, 0),
  (0, 4, 0),
  (1, 4, 0),
  (1, 4, 0),
  (1, 4, 0),
  (1, 4, 0);
##### init t_toilet_pit #####

##### init t_toilet_wash_basin #####
INSERT INTO t_toilet_wash_basin(parent_toilet_id, status)
  VALUE (1, 0),
  (1, 0),
  (2, 0),
  (2, 0),
  (3, 0),
  (3, 0),
  (4, 0),
  (4, 0);
##### init t_toilet_wash_basin #####

##### init t_toilet_product #####
INSERT INTO t_toilet_product(name, price, stock, product_category_id)
  VALUE ('我是1号抽纸', 5, 100, 2),
  ('我是2号抽纸', 8, 100, 2),
  ('我是1号卷纸', 2.5, 100, 2),
  ('我是2号抽纸', 3, 100, 2);
##### init t_toilet_product #####

##### init t_toilet_category #####
INSERT INTO t_toilet_category(name, parent_category_id)
  VALUE ('基础产品', -1),
  ('抽纸', 1),
  ('卷纸', 1);
##### init t_toilet_category #####