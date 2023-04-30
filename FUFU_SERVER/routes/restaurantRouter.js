const express = require('express');
const restaurantController = require('../controllers/restaurantController');
const restaurantRouter = express.Router();

restaurantRouter.get('/index/:userId', restaurantController().index);

module.exports = restaurantRouter;