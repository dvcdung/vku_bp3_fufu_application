const RestarantModel = require("../model/Restaurant");

const restaurantController = () => {
    const resController = {};

    resController.index = async (req, res) => {
        res.send(await RestarantModel().getRestaurant(req.params.userId));
    }

    return resController;
}

module.exports = restaurantController;