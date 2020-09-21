USE jdr_toilet;

##### init t_toilet_user #####
INSERT INTO t_toilet_user(name, sex, age, type)
  VALUE ('小明', 0, 33, 0),
  ('小花', 1, 18, 0),
  ('小华', 0, 12, 0),
  ('小军', 1, 58, 0),
  ('路人甲', 0, 33, 1),
  ('路人已', 1, 33, 1),
  ('路人丙', 1, 33, 2),
  ('路人丁', 0, 33, 2);
##### init t_toilet_user #####

##### init t_toilet_toilet #####
INSERT INTO t_toilet_toilet(type, floor, admin)
  VALUE (0, 1, 8),
  (0, 2, 8),
  (1, 1, 7),
  (1, 2, 7);
##### init t_toilet_toilet #####

##### init t_toilet_pit #####
# 各类型坑位，一楼二楼各两个坑
INSERT INTO t_toilet_pit(type, parent_toilet)
  VALUE (0, 1),
  (1, 1),
  (2, 1),
  (3, 1),
  (4, 1),
  (5, 1),
  (0, 1),
  (1, 1),
  (2, 1),
  (3, 1),
  (4, 1),
  (5, 1),
  (0, 2),
  (1, 2),
  (2, 2),
  (3, 2),
  (4, 2),
  (5, 2),
  (0, 2),
  (1, 2),
  (2, 2),
  (3, 2),
  (4, 2),
  (5, 2);
##### init t_toilet_pit #####

##### init t_toilet_paper_towel #####
INSERT INTO t_toilet_paper_towel(type, remaining_quantity, price)
  VALUE (0, 500, 2.5),
  (1, 500, 4.5);
##### init t_toilet_paper_towel #####

##### init t_toilet_wash_basin #####
INSERT INTO t_toilet_wash_basin(type)
  VALUE (0),
  (0),
  (1),
  (1);
##### init t_toilet_wash_basin #####