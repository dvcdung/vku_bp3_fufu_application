<?php
if (!empty($_POST["phone"]) && !empty($_POST["pass"])) {
    $phone = $_POST["phone"]; // post email
    $pass = $_POST["pass"]; // post password
    $rs = array();
    $con = mysqli_connect("localhost", "root", "", "fufu_db");
    if ($con) {
        $sql = "SELECT * FROM user WHERE userPhone = '$phone'";
        $res = mysqli_query($con, $sql);
        if (mysqli_num_rows($res) != 0) {
            $row = mysqli_fetch_assoc($res);
            if ($phone == $row['userPhone'] && password_verify($pass, $row['userPass'])) {
                $sqlUpdate = "UPDATE user SET userStatus = 1 WHERE userPhone = '$phone'";
                if (mysqli_query($con, $sqlUpdate)) {
                    $rs = array("status" => "success", 
                                "email" => $row['userEmail'], 
                                "phone" => $row['userPhone'],
                                "name" => $row['userFullName'],
                                "address" => $row['userAddress'],
                                "gender" => $row['userGender'],
                                "dob" => $row['userDob'],
                                "bio" => $row['userBio'],
                                "userStatus" => $row['userStatus']);
                } else $rs = array("status" => "failed", "message" => "ko");
            } else $rs = array("status" => "failed", "message" => "Email or Password incorrect");
        } else $rs = array("status" => "failed", "message" => "Email or Password incorrect");
    } else $rs = array("status" => "failed", "message" => "Couldn't connect to server");
} else $rs = array("status" => "failed", "message" => "All fields are required");

echo json_encode($rs, JSON_PRETTY_PRINT);

?>