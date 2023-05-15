const express = require('express');
const menuController = require('../controllers/Restaurant/MenuController');
const restaurantController = require('../controllers/Restaurant/RestaurantController');
const restaurantRouter = express.Router();

restaurantRouter.get('/:resId', restaurantController().index);
restaurantRouter.get('/menu/item/:resId', menuController().index);
restaurantRouter.post('/menu/item/add', menuController().create);
restaurantRouter.delete('/menu/item/delete/:itemId', menuController().delete);
restaurantRouter.post('/menu/item/update', menuController().update);


module.exports = restaurantRouter;