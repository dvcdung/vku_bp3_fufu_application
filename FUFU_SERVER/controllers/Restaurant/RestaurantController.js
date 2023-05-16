const restaurantModel = require("../../model/Restaurant");

const restaurantController = () => {
    const resController = {};

    resController.index = async (req, res) => {
        res.status(200);
        res.send(await restaurantModel().getRestaurant(req.params.userId));
    }

    return resController;
}

module.exports = restaurantController;