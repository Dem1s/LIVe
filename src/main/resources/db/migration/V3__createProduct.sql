INSERT INTO products(id,price,src,title)
VALUES (1, 450, 'https://all-t-shirts.ru/goods_images/ru136649I10008a0f6a388ae73deb14989226bd9ab6a8.jpg','Майка'),
       (2, 500,'https://www-s.mlo.me/upen/v/2018/201805/20180510/201805101610455113205.jpg','Шорты'),
       (3, 900,'https://msk.toomanygifts.ru/upload/resize_cache/iblock/c32/1000_1000_/c328e1fd223908bb60083f5cf616e4f6.jpg','Панама'),
       (4, 2000,'https://smcatalog.ru/upload/iblock/0af/0afd5c72963695c383a0e11a5a6876bf.jpg','Рубашка'),
       (5, 3000,'https://images.babochka.ru/5b24155a29787cc831184d86ba2aa24b4ca6bb15.jpg','Джинсы');
ALTER SEQUENCE product_seq RESTART WITH 6;
